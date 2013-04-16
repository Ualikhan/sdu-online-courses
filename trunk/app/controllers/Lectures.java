package controllers;

import play.*;
import models.*;
import play.mvc.*;
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
							lectureForm,
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



public static Result updateLecture(Long id) {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		
	Form<Lecture> filledForm=form(Lecture.class).bindFromRequest();
	Lecture l=Lecture.find.ref(id);
	l.title=filledForm.get().title;
	l.content=filledForm.get().content;
	l.video=filledForm.get().video;
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
