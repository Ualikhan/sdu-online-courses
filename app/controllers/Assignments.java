package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.apache.commons.io.FileUtils;
import play.*;
import models.*;
import models.Enums.ResourceTypes;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.*;
import static play.data.Form.*;
import views.html.assignment.*;

@Security.Authenticated(Secured.class)
public class Assignments extends Controller{

	public static Form<Assignment> assignmentForm=form(Assignment.class);
	static Long courseId;
	
	
	public static Result index() {
		courseId=Long.parseLong(session("course"));
		if(Secured.isTutorOf(courseId)){
		return ok(index.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				Assignment.findAssignmentsByCourse(courseId)
				)
		);
		}
		else{
			return forbidden();
		}
    }

	
public static Result newAssignment() throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Form<Assignment> filledForm=form(Assignment.class).bindFromRequest();
		Course course=Course.find.byId(courseId);
		Assignment assignment=new Assignment();
		assignment.title=filledForm.get().title;
		assignment.description=filledForm.get().description;		
		assignment.actionItems=filledForm.get().actionItems;
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
   	 sdf2.setLenient(false);
       Logger.debug("startDate:"+filledForm.get().startDate);
       Logger.debug("deadline:"+filledForm.get().deadline);
      	
   	
   	
		assignment.startDate=sdf2.parse(sdf2.format(filledForm.get().startDate));
		assignment.deadline=sdf2.parse(sdf2.format(filledForm.get().deadline));
		assignment.course=course;
		assignment.save();
		return ok(
				index.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						Assignment.findAssignmentsByCourse(courseId)
						)
				);
	}else{
		return forbidden();
	}
}


public static Result assignmentPage(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Assignment lastAssignment=Assignment.findLastAssignmentByCourse(courseId);
		if(lastAssignment!=null){
			return ok(
					item.render(
							User.find.where().eq("email", request().username()).findUnique(),
							Course.find.byId(courseId),
							Assignment.findAssignmentsByCourse(courseId),
							lastAssignment
							)
					);
		}
		else{
			return redirect(routes.Assignments.index());
		}
	}
	else if(Secured.isStudentOf(id)){
		Assignment lastAssignment=Assignment.findLastAssignmentByCourse(courseId);
		User student=User.find.where().eq("email", request().username()).findUnique();
		String submissionType="";
		if(lastAssignment!=null){
			StudentSubmission ss=StudentSubmission.isStudentSubmitedAssignment(student.email, lastAssignment.id);
			if(ss==null)
				submissionType="NONE";
			else 
				submissionType=ss.submissionType.name();
		return ok(views.html.assignment.student.item.render(
				student,
				Course.find.byId(courseId),
				Assignment.findAssignmentsByCourse(courseId),
				lastAssignment,
				ss,
				submissionType
				)
				);
		}
	else{
		return ok(views.html.assignment.student.index.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(id),
				Assignment.findAssignmentsByCourse(id)
				));
	}
	}
	else{
		return forbidden();
	}
}

public static Result getAssignment(Long id) {
courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		return ok(item.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				Assignment.findAssignmentsByCourse(courseId),
				Assignment.find.byId(id)
				)
				);
	}
	else if(Secured.isStudentOf(courseId)){
		String submissionType="";
		User student=User.find.where().eq("email", request().username()).findUnique();
		StudentSubmission ss=StudentSubmission.isStudentSubmitedAssignment(student.email, id);
		if(ss==null)
			submissionType="NONE";
		else 
			submissionType=ss.submissionType.name();
		return ok(views.html.assignment.student.item.render(
				student,
				Course.find.byId(courseId),
				Assignment.findAssignmentsByCourse(courseId),
				Assignment.find.byId(id),
				ss,
				submissionType
				)
				);
	}else{
		return forbidden();
	}
}



public static Result deleteAssignment(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
	Assignment.delete(id);
	return ok(
			index.render(
					User.find.where().eq("email", request().username()).findUnique(),
					Course.find.byId(courseId),
					Assignment.findAssignmentsByCourse(courseId)
			)
	);
}else{
	return forbidden();
}
}


public static Result updateTitle() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Assignment lect=Assignment.find.byId(id);
    lect.title=val;
    lect.update();
	return ok(lect.title);
}

public static Result updateStartDate() throws ParseException{
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Assignment lect=Assignment.find.byId(id);
    SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
  	 sdf2.setLenient(false);
      
  	lect.startDate=sdf2.parse(bform.get("startDate"));
	lect.update();
	return ok(sdf2.format(lect.startDate));
}

public static Result updateDeadline() throws ParseException{
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Assignment lect=Assignment.find.byId(id);
    SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
  	 sdf2.setLenient(false);
  	 lect.deadline=sdf2.parse(bform.get("deadline"));
    lect.update();
	return ok(sdf2.format(lect.deadline));
}

public static Result updateDescription() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Assignment lect=Assignment.find.byId(id);
    lect.description=val;
    lect.update();
	return ok(lect.description);
}

public static Result updateActionItems() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Assignment lect=Assignment.find.byId(id);
    lect.actionItems=val;
    lect.update();
	return ok(lect.actionItems);
}


}
