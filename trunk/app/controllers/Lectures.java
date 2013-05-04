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
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				Lecture.findLecturesByCourse(courseId)
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
		Lecture lecture=new Lecture(filledForm.get().title, filledForm.get().content,course);
		lecture.keyConcepts=filledForm.get().keyConcepts;
		lecture.reading=filledForm.get().reading;
		lecture.assignment=filledForm.get().assignment;
		lecture.additionalResources=filledForm.get().additionalResources;
		lecture.save();
		return ok(
				index.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						Lecture.findLecturesByCourse(courseId)
						)
				);
	}else{
		return forbidden();
	}
}


public static Result lecturePage(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Lecture lastLecture=Lecture.findLastLectureByCourse(courseId);
		if(lastLecture!=null){
			return ok(
					item.render(
							User.find.where().eq("email", request().username()).findUnique(),
							Course.find.byId(courseId),
							Lecture.findLecturesByCourse(courseId),
							lastLecture,
							LectureResource.findVideosByLecture(lastLecture.id),
							LectureResource.findSlidesByLecture(lastLecture.id)
							)
					);
		}
		else{
			return redirect(routes.Lectures.index());
		}
	}
	else if(Secured.isStudentOf(id)){
		Lecture lastLecture=Lecture.findLastLectureByCourse(courseId);
		if(lastLecture!=null){
		return ok(views.html.lecture.student.item.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				Lecture.findLecturesByCourse(courseId),
				lastLecture,
				LectureResource.findByLecture(lastLecture.id)
				)
				);
		}
		else{
		return ok(views.html.lecture.student.index.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(id),
				Lecture.findLecturesByCourse(id)
				));
		}
	}
	else{
		return forbidden();
	}
}

public static Result getLecture(Long id) {
courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		return ok(item.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				Lecture.findLecturesByCourse(courseId),
				Lecture.find.byId(id),
				LectureResource.findVideosByLecture(id),
				LectureResource.findSlidesByLecture(id)
				)
				);
	}
	else if(Secured.isStudentOf(courseId)){
		return ok(views.html.lecture.student.item.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				Lecture.findLecturesByCourse(courseId),
				Lecture.find.byId(id),
				LectureResource.findByLecture(id)
				)
				);
	}else{
		return forbidden();
	}
}

public static Result addVideo(Long lectureId)  throws IOException{
	courseId=Long.parseLong(session("course"));
	Lecture l=Lecture.find.ref(lectureId);
	
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		LectureResource video=null;
		String projectRoot = Play.application().path().getAbsolutePath();
	   
		 MultipartFormData body = request().body().asMultipartFormData();
	     FilePart myVideo = body.getFile("videoFile");
	     if (myVideo != null) {
	       String fileName = myVideo.getFilename();
	       String contentType = myVideo.getContentType(); 
	       File file = myVideo.getFile();
	       if(file.length()>0){
	       String extension = "";

	       int i = fileName.lastIndexOf('.');
	       if (i > 0) {
	           extension = fileName.substring(i+1);
	       }
	       File uniqueFile = File.createTempFile("video", "."+extension, new File(projectRoot+"\\public\\uploadVideos"));
	       
	       FileUtils.copyFile(file,uniqueFile);
	       video=LectureResource.create(filledForm.get("title"), uniqueFile.getName(), ResourceTypes.VIDEO, l);
	       }
	       else{
	    	   if(filledForm.get("videoUrl").length()>0)
	    		   video=LectureResource.create(filledForm.get("title"),  filledForm.get("videoUrl"), ResourceTypes.VIDEO, l);
	       }
	     }
	     else{
	    	   if(filledForm.get("videoUrl").length()>0)
	    		   video=LectureResource.create(filledForm.get("title"),  filledForm.get("videoUrl"), ResourceTypes.VIDEO, l);
	       }
		return ok("OK");
	}
	else{
		return forbidden();
	}
}

public static Result upload(){
	 MultipartFormData body = request().body().asMultipartFormData();
	 FilePart file = body.getFiles().get(0);
    Logger.debug("Uploaded file name " + file.getFilename() + 
      " by user ");
    return ok("OK");
}

public static Result addSlide(Long lectureId)  throws IOException{
	courseId=Long.parseLong(session("course"));
	Lecture l=Lecture.find.ref(lectureId);
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		LectureResource video=null;
		String projectRoot = Play.application().path().getAbsolutePath();
	   
		 MultipartFormData body = request().body().asMultipartFormData();
		 FilePart mySlide = body.getFile("slideFile");
	     if (mySlide != null) {
	    	 
	       String fileName = mySlide.getFilename();
	       String contentType = mySlide.getContentType(); 
	       File file = mySlide.getFile();
	       if(file.length()>0){
	       Logger.debug("fileName: "+fileName);
	       String extension = "";

	       int i = fileName.lastIndexOf('.');
	       if (i > 0) {
	           extension = fileName.substring(i+1);
	       }
	       File uniqueFile = File.createTempFile("slide", "."+extension, new File(projectRoot+"\\public\\uploadSlides"));
	       
	       FileUtils.copyFile(file,uniqueFile);
	       video=LectureResource.create(filledForm.get("title"), uniqueFile.getName(), ResourceTypes.SLIDE, l);
	       }
	       else{
	    	   if(filledForm.get("slideUrl").length()>0)
	        	 video=LectureResource.create(filledForm.get("title"),  filledForm.get("slideUrl"), ResourceTypes.SLIDE, l);
	         }
	     }
	     return ok("OK");
	}
	else{
		return forbidden();
	}
}

public static Result removeResource(Long resourceId,Long lectureId){
	LectureResource.delete(resourceId);
	return redirect(routes.Lectures.getLecture(lectureId));
}

public static Result updateLecture(Long id)  throws IOException{
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		
	DynamicForm filledForm=form().bindFromRequest();
	Lecture l=Lecture.find.ref(id);
	l.title=filledForm.get("title");
	l.content=filledForm.get("content");
	l.update();
	return redirect(routes.Lectures.index());
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
					User.find.where().eq("email", request().username()).findUnique(),
					Course.find.byId(courseId),
					Lecture.findLecturesByCourse(courseId)
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
    Lecture lect=Lecture.find.byId(id);
    lect.title=val;
    lect.update();
	return ok(lect.title);
}

public static Result updateContent() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Lecture lect=Lecture.find.byId(id);
    lect.content=val;
    lect.update();
	return ok(lect.content);
}

public static Result updateKeyConcepts() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Lecture lect=Lecture.find.byId(id);
    lect.keyConcepts=val;
    lect.update();
	return ok(lect.keyConcepts);
}

public static Result updateReading() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Lecture lect=Lecture.find.byId(id);
    lect.reading=val;
    lect.update();
	return ok(lect.reading);
}

public static Result updateAssignment() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Lecture lect=Lecture.find.byId(id);
    lect.assignment=val;
    lect.update();
	return ok(lect.assignment);
}


public static Result updateAdditionalResources() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    Lecture lect=Lecture.find.byId(id);
    lect.additionalResources=val;
    lect.update();
	return ok(lect.additionalResources);
}

public static Result updateResourceTitle() {
    DynamicForm bform=form().bindFromRequest();
    Long id=Long.parseLong(bform.get("id"));
    String val=bform.get("value");
    LectureResource lect=LectureResource.find.byId(id);
    lect.title=val;
    lect.update();
	return ok(lect.title);
}

}
