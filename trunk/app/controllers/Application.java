package controllers;

import java.io.File;

import models.Course;
import models.Role;
import models.User;
import play.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.*;
import static play.data.Form.*;
import views.html.*;
import views.html.helper.*;

public class Application extends Controller {
  
	public static class Login{
		public String email;
		public String password;
		
		public String validate() {
		    if (User.authenticate(email, password) == null) {
		      return "Invalid user or password";
		    }
		    return null;
		}
	}
	
	
	public static class Register{
		public String name;
		public String email;
		public String password;
		public String password2;
		
		
		public String validate() {
		    if (!password.equals(password2)) {
		      return "Invalid password repeated";
		    }
		    return null;
		}
	}
	
	public static Result index() {
		if(session("email")!=null)
        return ok(
        		index.render(
        				Course.findAll(),
        				User.find.byId(session("email"))
        				)
        				);
		else
			 return ok(
		        		index.render(
		        				Course.findAll(),
		        				null
		        				)
		        				);
		
	}
    
    public static Result login() {
    	if(session("email")==null)
        return ok(login.render(form(Login.class)));
    	else
    		return redirect(routes.Application.index());
    }
    
    public static Result list() {
        return ok(list.render(User.findAll()));
    }
    
    public static Result registerForm() {
        return ok(register.render(form(Register.class)));
    }
    
    public static Result register() {
    	Form<Register> regForm = form(Register.class).bindFromRequest();
        if(regForm.hasErrors()){
        	return ok(register.render(form(Register.class)));
    	}
    	else{
    		User.create(regForm.get().name,regForm.get().email,regForm.get().password,Role.find.where().eq("name", "Student").findUnique());
    		return redirect(routes.Application.login());
    	}
    }
    
    public static Result authenticate() {
    	Form<Login> loginForm = form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()){
        	return redirect(routes.Application.login());
    	}
    	else{
    		session().clear();
    		session("email",loginForm.get().email);
    		String role=User.find.byId(loginForm.get().email).role.name.name();
    		session("role",role);
    		return redirect(routes.Application.index());
    	}
    }
    
    public static Result logout(){
		session().clear();
		flash("success","You've been logged out");
		return redirect(
				routes.Application.login()
				);
	}
    
    public static Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(
            Routes.javascriptRouter("myJsRoutes",
            		controllers.routes.javascript.Lectures.getLecture(),
            		controllers.routes.javascript.CourseInformations.getCourseInformation()
            )
        );
    }
    
  
}
