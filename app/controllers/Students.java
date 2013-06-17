package controllers;

import models.Course;
import models.Lecture;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.student.*;

@Security.Authenticated(Secured.class)
public class Students extends Controller{
	
	public static Result index() {
        return ok(
        		index.render(
        				User.findStudentCourses(request().username()),
        				User.find.byId(request().username())
        				)
        				);
		
	}
	
	public static Result getStudents(Long courseId) {
		String userType="";
		if(Secured.isTutorOf(courseId)){
			userType="TUTOR";
		}
		if(Secured.isStudentOf(courseId)){
			userType="STUDENT";
		}
        return ok(
        		studentlist.render(
        				User.find.where().eq("email", request().username()).findUnique(),
        				Course.find.byId(courseId),
        				User.findStudentsByCourse(courseId),
        				userType
        				)
        				);
		
	}

}
