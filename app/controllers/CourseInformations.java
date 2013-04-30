package controllers;

import java.util.Date;

import play.*;
import models.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.courseinformation.*;

@Security.Authenticated(Secured.class)
public class CourseInformations extends Controller{

	public static Form<CourseInformation> courseInformationForm=form(CourseInformation.class);
	static Long courseId;
	
	
	public static Result index() {
		courseId=Long.parseLong(session("course"));
		if(Secured.isTutorOf(courseId)){
		return ok(
				index.render(
						courseId,
						CourseInformation.findCourseInformationsByCourse(courseId),
						courseInformationForm,
						User.find.byId(request().username())
						)
				);
		}
		else{
			return forbidden();
		}
    }

	public static Result addCourseInformation() {
		courseId=Long.parseLong(session("course"));
		
		if(Secured.isTutorOf(courseId)){
			Form<CourseInformation> filledForm=form(CourseInformation.class).bindFromRequest();
			Course course=Course.find.byId(courseId);
			return ok(
					addcourseinformation.render(
							User.find.where().eq("email", request().username()).findUnique(),
							Course.find.byId(courseId),
							CourseInformation.findCourseInformationsByCourse(courseId)
							
							)
					);
		}else{
			return forbidden();
		}
	}
	
public static Result saveCourseInformation() {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Form<CourseInformation> filledForm=form(CourseInformation.class).bindFromRequest();
		Course course=Course.find.byId(courseId);
		CourseInformation.create(filledForm.get().title, filledForm.get().content,course);
		return ok(
				addcourseinformation.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						CourseInformation.findCourseInformationsByCourse(courseId)
						
						)
				);
	}else{
		return forbidden();
	}
}


public static Result courseInformationPage(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
			return ok(
					item.render(
							CourseInformation.find.byId(id)
							)
					);
	}
	
	else{
		return forbidden();
	}
}

public static Result getCourseInformation(Long id){
	courseId=CourseInformation.find.ref(id).course.id;
	
	if(Secured.isTutorOf(courseId)){
		return ok(
				item.render(
						CourseInformation.find.byId(id)
						)
				);
	}
	else if(Secured.isStudentOf(courseId)){
	return ok(views.html.courseinformation.student.item.render(
			CourseInformation.find.byId(id)
			)
			);
}else{
	return forbidden();
}
}

public static Result updateCourseInformation(Long id) {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		
	Form<CourseInformation> filledForm=form(CourseInformation.class).bindFromRequest();
	filledForm.get().update(id);
	return ok(
			index.render(
					courseId,
					CourseInformation.findCourseInformationsByCourse(courseId),
					courseInformationForm,
					User.find.byId(request().username())
					)
			);
	}else{
		return forbidden();
	}
}

public static Result deleteCourseInformation(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
	CourseInformation.delete(id);
	return ok(
			addcourseinformation.render(
					User.find.where().eq("email", request().username()).findUnique(),
					Course.find.byId(courseId),
					CourseInformation.findCourseInformationsByCourse(courseId)
					
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
    CourseInformation lect=CourseInformation.find.byId(id);
    lect.title=val;
    lect.update();
	return ok(lect.title);
}
public static Result updateContent(String annId) {
    Long id=Long.parseLong(annId);
    DynamicForm bform=form().bindFromRequest();
    String val=bform.get("value");
    CourseInformation lect=CourseInformation.find.byId(id);
    lect.content=val;
    lect.update();
	return ok(lect.content);
}
}
