package controllers;

import models.Course;
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
	
	

}
