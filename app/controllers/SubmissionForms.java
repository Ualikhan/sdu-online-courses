package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.Assignment;
import models.SubmissionForm;
import models.Course;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.assignment.*;

@Security.Authenticated(Secured.class)
public class SubmissionForms extends Controller{	

static Long courseId;	
	
public static Result newSubmissionForm() throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		Course course=Course.find.byId(courseId);
		SubmissionForm submissionForm=new SubmissionForm();	
		submissionForm.save();
		Assignment assigment=Assignment.find.byId(Long.parseLong(filledForm.get("id")));
		assigment.submissionForm=submissionForm;
		assigment.update();
		
		return ok(
				submissionFormCreate.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						submissionForm
						)
				);
	}else{
		return forbidden();
	}
}

public static Result updateSubmissionForm() throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		Course course=Course.find.byId(courseId);
		
		Assignment assigment=Assignment.find.byId(Long.parseLong(filledForm.get("id")));
		SubmissionForm submissionForm=assigment.submissionForm;
		
		return ok(
				submissionFormCreate.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						submissionForm
						)
				);
	}else{
		return forbidden();
	}
}

}
