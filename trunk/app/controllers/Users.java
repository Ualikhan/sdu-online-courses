package controllers;

import java.io.File;

import controllers.Application.Login;

import play.*;
import models.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.*;
import static play.data.Form.*;
import views.html.*;
import views.html.user.*;

@Security.Authenticated(Secured.class)
public class Users extends Controller {
	
	public static Result profile() {
    	  MultipartFormData body = request().body().asMultipartFormData();
    	  FilePart picture = body.getFile("photo");
    	  if (picture != null) {
    	    String fileName = picture.getFilename();
    	    String contentType = picture.getContentType(); 
    	    File file = picture.getFile();
    	    String myUploadPath = Play.application().configuration().getString("myUploadPath");
            file.renameTo(new File(myUploadPath, fileName));
           User user= User.find.where().eq("email", request().username()).findUnique();
           user.photo=fileName;
           user.update();
           Form<User> loginForm = form(User.class);  
           
          return ok(views.html.user.profile.render(user,loginForm));
    	  } else {
    	    flash("error", "Missing file");
    	    return redirect(routes.Application.index());    
    	  }
    	}
    
    public static Result pro() {
    Form<User> loginForm = form(User.class);  
    User user= User.find.where().eq("email", request().username()).findUnique();
    
   return ok(views.html.user.profile.render(user,loginForm));
    }
    
    public static Result upload() {
  
  	      return ok(views.html.user.upload.render());
  	 
  	}
    
    public static Result editUser() {
    	Form<User> loginForm = form(User.class).bindFromRequest();
        
        User user= User.find.byId(request().username());
        user.name=loginForm.get().name;
        user.company=loginForm.get().company;
        user.update();		
       return ok(views.html.user.profile.render(user,loginForm));
        }
    
    public static Result changePassword() {
    	Form<Application.Register> passwordForm = form(Application.Register.class).bindFromRequest();
    	User user= User.find.where().eq("email", request().username()).findUnique();
    	Form<User> loginForm = form(User.class);
        
    	if(passwordForm.hasErrors()){
        	return ok(views.html.user.profile.render(user,loginForm));
            
        }
        else{
    	 user.password=passwordForm.get().password;
        user.update();
        return ok(
        		index.render(
        				Course.findAll(),
        				User.find.byId(request().username())
        				)
        		);
        }
        }
}
