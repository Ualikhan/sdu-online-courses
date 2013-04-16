package controllers;

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

	
public static Result newCourseInformation() {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Form<CourseInformation> filledForm=form(CourseInformation.class).bindFromRequest();
		Course course=Course.find.byId(courseId);
		CourseInformation.create(filledForm.get().title, filledForm.get().content,course);
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


public static Result courseInformationPage(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
			return ok(
					item.render(
							CourseInformation.find.byId(id),
							courseInformationForm,
							User.find.byId(request().username())
							)
					);
	}else{
		return forbidden();
	}
}

public static Result getCourseInformation(Long id){
	return ok(views.html.courseinformation.student.item.render(
			CourseInformation.find.byId(id)
			)
			);
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


}
