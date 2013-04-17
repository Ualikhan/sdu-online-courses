package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.apache.commons.io.FileUtils;
import play.*;
import models.*;
import models.Enums.ResourceTypes;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.*;
import static play.data.Form.*;
import views.html.lecture.*;

@Security.Authenticated(Secured.class)
public class Lectures extends Controller{

	public static Form<Lecture> lectureForm=form(Lecture.class);
	static Long courseId;
	
	
	public static Result index() {
		courseId=Long.parseLong(session("course"));
		if(Secured.isTutorOf(courseId)){
		return ok(index.render(
				courseId,
				Lecture.findLecturesByCourse(courseId),
				lectureForm,
				User.find.byId(request().username())
				)
		);
		}
		else{
			return forbidden();
		}
    }

	
public static Result newLecture() {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Form<Lecture> filledForm=form(Lecture.class).bindFromRequest();
		Course course=Course.find.byId(courseId);
		Lecture.create(filledForm.get().title, filledForm.get().content,course);
		return ok(
				index.render(
						courseId,
						Lecture.findLecturesByCourse(courseId),
						lectureForm,
						User.find.byId(request().username())
						)
				);
	}else{
		return forbidden();
	}
}


public static Result lecturePage(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
			return ok(
					item.render(Lecture.find.byId(id),
							VideoResource.findByLecture(id),
							User.find.byId(request().username())
							)
					);
	}
	else if(Secured.isStudentOf(id)){
		return ok(views.html.lecture.student.index.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(id),
				Lecture.findLecturesByCourse(id)
				));
	}
	else{
		return forbidden();
	}
}

public static Result getLecture(Long id) {
	
		return ok(views.html.lecture.student.item.render(
				Lecture.find.byId(id)
				)
				);
	
}



public static Result updateLecture(Long id)  throws IOException{
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		
	Form<Lecture> filledForm=form(Lecture.class).bindFromRequest();
	Lecture l=Lecture.find.ref(id);
	l.title=filledForm.get().title;
	l.content=filledForm.get().content;
	VideoResource video=null;
	String projectRoot = Play.application().path().getAbsolutePath();
   
	 MultipartFormData body = request().body().asMultipartFormData();
     FilePart myVideo = body.getFile("video");
     if (myVideo != null) {
       String fileName = myVideo.getFilename();
       String contentType = myVideo.getContentType(); 
       File file = myVideo.getFile();
       
       File uniqueFile = File.createTempFile("video", ".wmv", new File(projectRoot+"\\public\\uploadVideos"));
       
       FileUtils.copyFile(file,uniqueFile);
       video=VideoResource.create(uniqueFile.getName(),uniqueFile.getName(), "", ResourceTypes.VIDEO, l);
      
     }
     
     
     FilePart mySlide = body.getFile("slide");
     if (mySlide != null) {
       String fileName = mySlide.getFilename();
       String contentType = mySlide.getContentType(); 
       File file = mySlide.getFile();
       
       Logger.debug("fileName: "+fileName);
       String extension = "";

       int i = fileName.lastIndexOf('.');
       if (i > 0) {
           extension = fileName.substring(i+1);
       }
       File uniqueFile = File.createTempFile("slide", "."+extension, new File(projectRoot+"\\public\\uploadSlides"));
       
       FileUtils.copyFile(file,uniqueFile);
       video=VideoResource.create(uniqueFile.getName(),uniqueFile.getName(), "", ResourceTypes.SLIDE, l);
      
     }
     
	
	l.update();
	return ok(
			index.render(
					courseId,
					Lecture.findLecturesByCourse(courseId),
					lectureForm,
					User.find.byId(request().username())
					)
				);
	}else{
		return forbidden();
	}
}

public static Result deleteLecture(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
	Lecture.delete(id);
	return ok(
			index.render(
					courseId,
					Lecture.findLecturesByCourse(courseId),
					lectureForm,
					User.find.byId(request().username())
			)
	);
}else{
	return forbidden();
}
}


}
