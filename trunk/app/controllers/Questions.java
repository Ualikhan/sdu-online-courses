package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.Assignment;
import models.Question;
import models.Course;
import models.SubmissionForm;
import models.User;
import models.Enums.AnswerTypes;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.submissionform.*;

@Security.Authenticated(Secured.class)
public class Questions extends Controller{	

static Long courseId;	
	
public static Result newQuestion(Long submissionFormId) throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		Question question=new Question();	
		question.questionContent=filledForm.get("questionContent");
		if(filledForm.get("numOfAnswers")!=null && filledForm.get("numOfAnswers").length()>0)
		question.numOfAnswers=Integer.parseInt(filledForm.get("numOfAnswers"));
		else
			question.numOfAnswers=1;
		if(filledForm.get("numOfRightAnswers")!=null && filledForm.get("numOfRightAnswers").length()>0)
		question.numOfRightAnswers=Integer.parseInt(filledForm.get("numOfRightAnswers"));
		else
			question.numOfRightAnswers=1;
		question.answerType=AnswerTypes.valueOf(filledForm.get("answerType"));
		question.submissionForm=SubmissionForm.find.ref(submissionFormId);
		question.save();
		
		
		return ok(
				questioncreate.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						question.submissionForm,
						Question.findBySubmissionForm(submissionFormId)
						)
				);
	}else{
		return forbidden();
	}
}

public static Result updateQuestion(Long questionId) throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		Question question=Question.find.ref(questionId);	
		question.questionContent=filledForm.get("questionContent");
		question.numOfAnswers=Integer.parseInt(filledForm.get("numOfAnswers"));
		question.numOfRightAnswers=Integer.parseInt(filledForm.get("numOfRightAnswers"));
		question.answerType=AnswerTypes.valueOf(filledForm.get("answerType"));
		question.update();
		
		return ok(
				questioncreate.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						question.submissionForm,
						Question.findBySubmissionForm(question.submissionForm.id)
						)
				);
	}else{
		return forbidden();
	}
}

}
