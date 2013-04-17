package controllers;

import play.*;
import models.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.announcement.*;

@Security.Authenticated(Secured.class)
public class Announcements extends Controller{

	public static Form<Announcement> announcementForm=form(Announcement.class);
	static Long courseId;
	
	
	public static Result index() {
		courseId=Long.parseLong(session("course"));
		if(Secured.isTutorOf(courseId)){
		return ok(
				index.render(
						courseId,
						Announcement.findAnnouncementsByCourse(courseId),
						announcementForm,
						User.find.byId(request().username())
						)
				);
		}
		else{
			return forbidden();
		}
    }

	
public static Result newAnnouncement() {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		Form<Announcement> filledForm=form(Announcement.class).bindFromRequest();
		Course course=Course.find.byId(courseId);
		Announcement.create(filledForm.get().title, filledForm.get().content,course);
		return ok(
				index.render(
						courseId,
						Announcement.findAnnouncementsByCourse(courseId),
						announcementForm,
						User.find.byId(request().username())
						)
				);
	}else{
		return forbidden();
	}
}


public static Result announcementPage(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
			return ok(
					item.render(
							Announcement.find.byId(id),
							announcementForm,
							User.find.byId(request().username())
							)
					);
	}else{
		return forbidden();
	}
}

public static Result updateAnnouncement(Long id) {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		
	Form<Announcement> filledForm=form(Announcement.class).bindFromRequest();
	Announcement.update(id, filledForm.get().title, filledForm.get().content);
	return ok(
			index.render(
					courseId,
					Announcement.findAnnouncementsByCourse(courseId),
					announcementForm,
					User.find.byId(request().username())
					)
			);
	}else{
		return forbidden();
	}
}

public static Result deleteAnnouncement(Long id) {
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
	Announcement.delete(id);
	return ok(
			index.render(
					courseId,
					Announcement.findAnnouncementsByCourse(courseId),
					announcementForm,
					User.find.byId(request().username())
					)
			);
}else{
	return forbidden();
}
}


}
