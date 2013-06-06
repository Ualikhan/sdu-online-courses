package controllers;

import play.*;
import models.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

@Security.Authenticated(Secured.class)
public class CourseDescriptions extends Controller{

	public static Form<CourseDescription> courseDescriptionForm=form(CourseDescription.class);
	static Long courseId;
	

	
public static Result newCourseDescription() {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Form<CourseDescription> filledForm=form(CourseDescription.class).bindFromRequest();
		Course course=Course.find.byId(courseId);
		CourseDescription.create(filledForm.get().title, filledForm.get().content,course);
		return ok(
				views.html.course.description.tutor.render(
						Course.find.byId(courseId),
						CourseDescription.findCourseDescriptionsByCourse(courseId),
						"OWNER",
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
			views.html.course.description.tutor.render(
					Course.find.byId(courseId),
					CourseDescription.findCourseDescriptionsByCourse(courseId),
					"OWNER",
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
