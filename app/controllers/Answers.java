package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.Assignment;
import models.Answer;
import models.Course;
import models.Question;
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
public class Answers extends Controller{	

static Long courseId;	
	
public static Result newAnswer() throws ParseException{
	courseId=Long.parseLong(session("course"));
	Question question=null;
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		if(filledForm.get("questionId")!=null && filledForm.get("questionId").length()>0)
			question=Question.find.ref(Long.parseLong(filledForm.get("questionId")));
		
		if(question.answerType.name().equals("QA")){
			Answer answer=new Answer();	
			answer.answerContent=filledForm.get("answer"+question.id);
			answer.save();
		}
		else if(question.answerType.name().equals("SCT")){
			for(int i=1;i<=question.numOfAnswers;i++){
			Answer answer=new Answer();	
			answer.answerContent=filledForm.get("answer"+i);
			if(filledForm.get("answerTrue"+question.id).equals(""+i))
			answer.isTrueAnswer=true;
			else 
				answer.isTrueAnswer=false;
			answer.question=question;
			
			answer.save();
			}
			}
		else if(question.answerType.name().equals("MCT")){
		for(int i=1;i<=question.numOfAnswers;i++){
		Answer answer=new Answer();	
		answer.answerContent=filledForm.get("answer"+i);
		if(filledForm.get("answerTrue"+i).equals("1"))
		answer.isTrueAnswer=true;
		else 
			answer.isTrueAnswer=false;
		answer.question=question;
		
		answer.save();
		}
		}
		
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

public static Result updateAnswer(Long questionId) throws ParseException{
	courseId=Long.parseLong(session("course"));
	Question question=Question.find.ref(questionId);
	
	if(Secured.isTutorOf(courseId)){
		DynamicForm filledForm=form().bindFromRequest();
		
		if(question.answerType.name().equals("QA")){
			Answer answer=question.answers.get(0);
			answer.answerContent=filledForm.get("answer"+question.id);
			answer.update();
		}
		else if(question.answerType.name().equals("SCT")){
			for(int i=1;i<=question.answers.size();i++){
				Answer answer=question.answers.get(i-1);	
			answer.answerContent=filledForm.get("answer"+i);
			if(filledForm.get("answerTrue"+question.id).equals(""+i))
			answer.isTrueAnswer=true;
			else 
				answer.isTrueAnswer=false;
			
			answer.update();
			}
			}
		else if(question.answerType.name().equals("MCT")){
		for(int i=1;i<=question.answers.size();i++){
			Answer answer=question.answers.get(i-1);	
		answer.answerContent=filledForm.get("answer"+i);
		if(filledForm.get("answerTrue"+i).equals("1"))
		answer.isTrueAnswer=true;
		else 
			answer.isTrueAnswer=false;
		
		answer.update();
		}
		}
		
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
