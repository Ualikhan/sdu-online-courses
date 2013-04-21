package controllers;

import play.*;
import models.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.coursedescription.*;

@Security.Authenticated(Secured.class)
public class CourseDescriptions extends Controller{

	public static Form<CourseDescription> courseDescriptionForm=form(CourseDescription.class);
	static Long courseId;
	
	
	public static Result index() {
		courseId=Long.parseLong(session("course"));
		if(Secured.isTutorOf(courseId)){
		return ok(
				index.render(
						courseId,
						CourseDescription.findCourseDescriptionsByCourse(courseId),
						courseDescriptionForm,
						User.find.byId(request().username())
						)
				);
		}
		else{
			return forbidden();
		}
    }

	
public static Result newCourseDescription() {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Form<CourseDescription> filledForm=form(CourseDescription.class).bindFromRequest();
		Course course=Course.find.byId(courseId);
		CourseDescription.create(filledForm.get().title, filledForm.get().content,course);
		return ok(
				index.render(
						courseId,
						CourseDescription.findCourseDescriptionsByCourse(courseId),
						courseDescriptionForm,
						User.find.byId(request().username())
						)
				);
	}else{
		return forbidden();
	}
}


public static Result courseDescriptionPage(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
			return ok(
					item.render(
							CourseDescription.find.byId(id),
							courseDescriptionForm,
							User.find.byId(request().username())
							)
					);
	}else{
		return forbidden();
	}
}

public static Result getCourseDescription(Long id){
	return ok(views.html.coursedescription.student.item.render(
			CourseDescription.find.byId(id)
			)
			);
}

public static Result updateCourseDescription(Long id) {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		
	Form<CourseDescription> filledForm=form(CourseDescription.class).bindFromRequest();
	filledForm.get().update(id);
	return ok(
			index.render(
					courseId,
					CourseDescription.findCourseDescriptionsByCourse(courseId),
					courseDescriptionForm,
					User.find.byId(request().username())
					)
			);
	}else{
		return forbidden();
	}
}

public static Result deleteCourseDescription(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
	CourseDescription.delete(id);
	return ok(
			index.render(
					courseId,
					CourseDescription.findCourseDescriptionsByCourse(courseId),
					courseDescriptionForm,
					User.find.byId(request().username())
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
    CourseDescription lect=CourseDescription.find.byId(id);
    lect.title=val;
    lect.update();
	return ok(lect.title);
}
public static Result updateContent(String annId) {
    Long id=Long.parseLong(annId);
    DynamicForm bform=form().bindFromRequest();
    String val=bform.get("value");
    CourseDescription lect=CourseDescription.find.byId(id);
    lect.content=val;
    lect.update();
	return ok(lect.content);
}

}
