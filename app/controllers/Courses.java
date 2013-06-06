package controllers;

import play.*;
import models.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.course.*;

@Security.Authenticated(Secured.class)
public class Courses extends Controller{

	public static Form<Course> courseForm=form(Course.class);
	
	public static Result index() {
		return ok(
				index.render(
						Course.findTutorCourses(request().username()),
						courseForm,
						User.find.byId(request().username())
						)
				);
    }

	
public static Result newCourse() {
		Form<Course> filledForm=form(Course.class).bindFromRequest();
		User user=User.find.where().eq("email", request().username()).findUnique();
		Course.create(filledForm.get().name, filledForm.get().description,user);
		return ok(
				index.render(
						Course.findTutorCourses(request().username()),
						courseForm,
						User.find.byId(request().username())
						)
				);
		
}

public static Result join(Long course) {
	if(request().username()!=null){
	User user=User.find.byId(request().username());
	user.courses.add(Course.find.byId(course));
	user.update();
	return redirect(routes.Application.index());
	}
	else
		return redirect(routes.Application.login());
}

public static Result coursePage(Long id) {
	if(Secured.isStudentOf(id)){
		session("course",id+"");
		return ok(views.html.course.student.index.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(id),
				Announcement.findAnnouncementsByCourse(id),
				CourseInformation.findCourseInformationsByCourse(id)
				));
		
		
	}else if(Secured.isTutorOf(id)){
		
		session("course",id+"");
			return ok(
					item.render(
							User.find.where().eq("email", request().username()).findUnique(),
							Course.find.byId(id),
							Announcement.findAnnouncementsByCourse(id),
							CourseInformation.findCourseInformationsByCourse(id)
							)
					);
			
	}
		else
			return forbidden();
}

public static Result courseDescription(Long id) {
	String accessString="";
	if(session("email")!=null){
	if(Secured.isStudentOf(id))
		accessString="ENROLLED";
	else if(Secured.isTutorOf(id))
		accessString="OWNER";
	else 
		accessString="SIGNUP";
		
	session("course",id+"");
	
	if(Secured.isTutorOf(id)){
	return ok(
					views.html.course.description.tutor.render(
							Course.find.byId(id),
							CourseDescription.findCourseDescriptionsByCourse(id),
							accessString,
							User.find.byId(request().username())
							)
					);
	}
	else {
		return ok(
				views.html.course.description.student.render(
						Course.find.byId(id),
						CourseDescription.findCourseDescriptionsByCourse(id),
						accessString,
						User.find.byId(request().username())
						)
				);
	}
	}
	else{
			return ok(views.html.course.description.student.render(
					Course.find.byId(id),
					CourseDescription.findCourseDescriptionsByCourse(id),
					"SIGNUP",
					null
					)
			);
	}
}


public static Result updateCourse(Long id) {
	Form<Course> filledForm=form(Course.class).bindFromRequest();
	Course.update(id, filledForm.get().name, filledForm.get().description);
	return ok(
			index.render(
					Course.findTutorCourses(request().username()),
					courseForm,
					User.find.byId(request().username())
					)
			);
		
}

public static Result deleteCourse(Long id) {
	Course.delete(id);
	return ok(
			index.render(
					Course.findTutorCourses(request().username()),
					courseForm,
					User.find.byId(request().username())
					)
				);
		
}

}
