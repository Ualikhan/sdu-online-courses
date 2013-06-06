package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.Assignment;
import models.Question;
import models.Course;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.submissionform.*;

@Security.Authenticated(Secured.class)
public class SubmissionForms extends Controller{	

static Long courseId;
	
public static Result newSubmissionForm() throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		Course course=Course.find.byId(courseId);
		
		Assignment assigment=Assignment.find.byId(Long.parseLong(filledForm.get("id")));
		assigment.submissionFormCreated=true;
		assigment.assignmentWeight=Integer.parseInt(filledForm.get("weight"));
		assigment.update();
		
		return ok(
				index.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						assigment,
						Question.findBySubmissionForm(assigment.id)
						)
				);
	}else{
		return forbidden();
	}
}


public static Result updateSubmissionForm() throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		Course course=Course.find.byId(courseId);
		
		Assignment assigment=Assignment.find.byId(Long.parseLong(filledForm.get("id")));
		
		return ok(
				index.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						assigment,
						Question.findBySubmissionForm(assigment.id)
						)
				);
	}else{
		return forbidden();
	}
}

public static Result newStudentSubmission(Long id) throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isStudentOf(courseId)){
		Assignment assigment=Assignment.find.byId(id);
		
		return ok(
				studentsubmission.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						assigment,
						Question.findBySubmissionForm(id)
						)
				);
	}else{
		return forbidden();
	}
}

}
