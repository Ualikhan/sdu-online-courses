package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import models.Assignment;
import models.Lecture;
import models.LectureResource;
import models.Question;
import models.Course;
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

public static Result index(Long id){
return ok(
		index.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				Assignment.find.ref(id),
				Question.findBySubmissionForm(id)
				)
		);
}
	
public static Result newQuestion(Long assignmentId) throws ParseException{
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
		question.assignment=Assignment.find.ref(assignmentId);
		question.questionWeight=Integer.parseInt(filledForm.get("questionWeight"));
		question.save();
		
		
		return ok(
				index.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						question.assignment,
						Question.findBySubmissionForm(assignmentId)
						)
				);
	}else{
		return forbidden();
	}
}

public static Result getQuestion(Long assignmentId,Long id) {
courseId=Long.parseLong(session("course"));
	
	if(Secured.isTutorOf(courseId)){
		return ok(item.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				Question.findBySubmissionForm(assignmentId),
				Question.find.byId(id)
				)
				);
	}
	else{
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
		question.questionWeight=Integer.parseInt(filledForm.get("questionWeight"));
		
		question.update();
		
		return ok(
				index.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						question.assignment,
						Question.findBySubmissionForm(question.assignment.id)
						)
				);
	}else{
		return forbidden();
	}
}

public static Result deleteQuestion(Long id) {
	courseId=Long.parseLong(session("course"));
	Assignment sf=Assignment.find.byId(id);
	if(Secured.isTutorOf(courseId)){
	Question.delete(id);
	return ok(
			index.render(
					User.find.where().eq("email", request().username()).findUnique(),
					Course.find.byId(courseId),
					sf,
					Question.findBySubmissionForm(sf.id)
					)
			);
}else{
	return forbidden();
}
}

}
