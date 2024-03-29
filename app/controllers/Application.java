package controllers;

import java.io.File;
import com.typesafe.plugin.*;
import java.util.HashMap;
import java.util.Map;

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
	
	private static Map<String, Object> map = new HashMap<String, Object>();

	// setter
	public static void setValue(String key, Object value) {
	    map.put(key, value);
	}

	// general getter would work well with String, also numeric types (only for displaying purposes! - not for calculations or comparisons!)
	public static Object getValue(String key) {
	    return map.get(key);
	}

	public static Boolean isFalse(String key) {
	    return Boolean.valueOf(map.get(key).toString());
	}

	public static Boolean getBoolean(String key) {
	    return Boolean.valueOf(map.get(key).toString());
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
    		String messageContent="Please go to <a href='http://localhost:9000"+routes.Application.confirm(regForm.get().email)+"'>here</a> to confirm your account";
    		
    		MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
    		mail.setSubject("SDU Online Courses");
    		mail.addRecipient(regForm.get().name+" <noreply@email.com>",regForm.get().email);
    		mail.addFrom(request().username()+"<noreply@email.com>");
    		//sends html
    		mail.sendHtml("<html>"+messageContent+"</html>" );
    		 		Logger.debug("mesg: "+messageContent);
    		
    		 		return ok(
    		 				registerSuccess.render(
    		 						)
    		 				);
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
    
    public static Result confirm(String email) {
    	User u=User.find.ref(email);
    	u.active=true;
    	u.update();
    	return redirect(
				routes.Application.login()
				);
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
            		

            		controllers.routes.javascript.Courses.updateTitle(),
            		controllers.routes.javascript.Courses.updateContent(),
            		
            		controllers.routes.javascript.Lectures.getLecture(),
            		controllers.routes.javascript.Lectures.updateTitle(),
            		controllers.routes.javascript.Lectures.updateContent(),
            		controllers.routes.javascript.Lectures.updateKeyConcepts(),
            		controllers.routes.javascript.Lectures.updateReading(),
            		controllers.routes.javascript.Lectures.updateAssignment(),
            		controllers.routes.javascript.Lectures.updateAdditionalResources(),
            		controllers.routes.javascript.Lectures.addVideo(),
            		controllers.routes.javascript.Lectures.addSlide(),
            		
            		controllers.routes.javascript.Lectures.updateResourceTitle(),
            		
            		
            		controllers.routes.javascript.Assignments.getAssignment(),
            		controllers.routes.javascript.Assignments.updateTitle(),
            		controllers.routes.javascript.Assignments.updateDescription(),
            		controllers.routes.javascript.Assignments.updateActionItems(),
            		controllers.routes.javascript.Assignments.updateStartDate(),
            		controllers.routes.javascript.Assignments.updateDeadline(),
            		
            		controllers.routes.javascript.Questions.newQuestion(),
            		controllers.routes.javascript.Questions.updateQuestion(),
            		controllers.routes.javascript.Answers.newAnswer(),
            		controllers.routes.javascript.Answers.updateAnswer(),
            		
            		
            		controllers.routes.javascript.CourseInformations.getCourseInformation(),
            		controllers.routes.javascript.CourseInformations.updateTitle(),
            		controllers.routes.javascript.CourseInformations.updateContent(),
            		
            		controllers.routes.javascript.CourseDescriptions.updateTitle(),
            		controllers.routes.javascript.CourseDescriptions.updateContent(),
            		
            		controllers.routes.javascript.Announcements.updateTitle(),
            		controllers.routes.javascript.Announcements.updateContent()
            		
            		
            )
        );
    }
    
  
}
