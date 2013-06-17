package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

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
	
	public static Result profile(String email){
		
		User ownUser=User.find.where().eq("email", request().username()).findUnique();
		User user=User.find.where().eq("email", email).findUnique();
		int threadNum=Post.findUserThreadsNum(user);
		int repliesNum=Post.findUserRepliesNum(user);
		int votesNum=Post.findUserVotesNum(user);
		
		return ok(
				views.html.user.profile.render(
					ownUser,
					user,
	       		    StudentSubmission.findSubmissionsOfUser(user),
	       		    threadNum,
	       		    repliesNum,
	       		    votesNum
	       		   )
	       		);
	}
	
public static Result editProfile(){
		
		User ownUser=User.find.where().eq("email", request().username()).findUnique();
		
		return ok(
				views.html.user.editprofile.render(
					ownUser
	       		   )
	       		);
	}

public static Result editPassword(){
	
	User ownUser=User.find.where().eq("email", request().username()).findUnique();
	
	return ok(
			views.html.user.editpassword.render(
				ownUser
       		   )
       		);
}
	
	public static Result upload() throws IOException{
		
		 MultipartFormData body = request().body().asMultipartFormData();
	     FilePart picture = body.getFile("photo");
	     if (picture != null) {
	       String fileName = picture.getFilename();
	       String contentType = picture.getContentType(); 
	       File file = picture.getFile();
	       String projectRoot = Play.application().path().getAbsolutePath();
	       Logger.debug("path: "+projectRoot);
	       File uniqueFile = File.createTempFile("user", ".png", new File(projectRoot+"\\public\\uploadImages"));
	       BufferedImage image = ImageIO.read(file);
	       
	       BufferedImage thumbnail = 
	     		  Scalr.resize(image, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
	     	               150, 150, Scalr.OP_ANTIALIAS);
	       ImageIO.write(thumbnail, "png",uniqueFile);
	       
	       User user=User.find.ref(request().username());
	       user.photo=uniqueFile.getName();
	       user.update();
	       
	       return redirect(routes.Users.profile(request().username())); 
	       
	     }
    	 else {
    	    flash("error", "Missing file");
    	    return redirect(routes.Application.index());    
    	  }
    	}  
 
    
    public static Result editUser() {
    	Form<User> loginForm = form(User.class).bindFromRequest();
        
        User user= User.find.byId(request().username());
        user.name=loginForm.get().name;
        user.age=loginForm.get().age;
        user.gender=loginForm.get().gender;
        user.address=loginForm.get().address;
        user.company=loginForm.get().company;
        user.position=loginForm.get().position;
        
        user.update();		
        
        return redirect(routes.Users.profile(request().username())); 
	       
        }
    
    public static Result changePassword() {
    	Form<Application.Register> passwordForm = form(Application.Register.class).bindFromRequest();
    	User user= User.find.where().eq("email", request().username()).findUnique();
    	Form<User> loginForm = form(User.class);
        
    	if(passwordForm.hasErrors()){
    		
    		 return redirect(routes.Users.profile(request().username())); 
  	                   
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
