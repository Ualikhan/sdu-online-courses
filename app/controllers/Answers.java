package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import models.Assignment;
import models.Answer;
import models.Course;
import models.Enums.SubmissionTypes;
import models.Question;
import models.StudentSubmission;
import models.SubmissionItem;
import models.User;
import models.Enums.AnswerTypes;
import play.Logger;
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
		int questionWeight=Integer.parseInt(filledForm.get("questionWeight"));
		question.questionWeight=questionWeight;
		question.update();
		
		if(question.answerType.name().equals("QE")){
			Answer answer=new Answer();	
			answer.answerContent=filledForm.get("answer"+question.id);
			answer.question=question;
			
			answer.save();
		}
		else if(question.answerType.name().equals("QA")){
			Answer answer=new Answer();	
			answer.answerContent=filledForm.get("answer"+question.id);
			answer.question=question;
			
			answer.save();
		}
		else if(question.answerType.name().equals("SCT")){
			for(int i=1;i<=question.numOfAnswers;i++){
			Answer answer=new Answer();	
			answer.answerContent=filledForm.get("answer"+i);
			if(filledForm.get("answerTrue"+question.id).equals(""+i))
			answer.isTrueAnswer=i;
			else 
				answer.isTrueAnswer=-1;
			answer.question=question;
			
			answer.save();
			}
			}
		else if(question.answerType.name().equals("MCT")){
		for(int i=1;i<=question.numOfAnswers;i++){
		Answer answer=new Answer();	
		answer.answerContent=filledForm.get("answer"+i);
		if(filledForm.get("answerTrue"+i).equals("1"))
		answer.isTrueAnswer=i;
		else 
			answer.isTrueAnswer=-1;
		answer.question=question;
		
		answer.save();
		}
		}
		
		return ok(""+question.id
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
		
		int questionWeight=Integer.parseInt(filledForm.get("questionWeight"));
		question.questionWeight=questionWeight;
		question.update();
		
		if(question.answerType.name().equals("QE")){
			Answer answer=question.answers.get(0);
			answer.answerContent=filledForm.get("answer"+question.id);
			answer.update();
		}
		else if(question.answerType.name().equals("QA")){
			Answer answer=question.answers.get(0);
			answer.answerContent=filledForm.get("answer"+question.id);
			answer.update();
		}
		else if(question.answerType.name().equals("SCT")){
			for(int i=1;i<=question.answers.size();i++){
				Answer answer=question.answers.get(i-1);	
			answer.answerContent=filledForm.get("answer"+i);
			if(filledForm.get("answerTrue"+question.id).equals(""+i))
			answer.isTrueAnswer=i;
			else 
				answer.isTrueAnswer=-1;
			
			answer.update();
			}
			}
		else if(question.answerType.name().equals("MCT")){
		for(int i=1;i<=question.answers.size();i++){
			Answer answer=question.answers.get(i-1);	
		answer.answerContent=filledForm.get("answer"+i);
		if(filledForm.get("answerTrue"+i).equals("1"))
		answer.isTrueAnswer=i;
		else 
			answer.isTrueAnswer=-1;
		
		answer.update();
		}
		}
		
		return ok(
				questionId+""
				);
	}else{
		return forbidden();
	}
}


public static Result saveStudentAnswers(Long sfId) throws ParseException{
	courseId=Long.parseLong(session("course"));
	
	
	if(Secured.isStudentOf(courseId)){
		StudentSubmission studentSubmission=new StudentSubmission();
		studentSubmission.student=User.find.where().eq("email", request().username()).findUnique();
		studentSubmission.assignment=Assignment.find.ref(sfId);
		studentSubmission.submissionType=SubmissionTypes.SUBMITTED;
		studentSubmission.save();
		List<Question> questions=Question.findBySubmissionForm(sfId);
		for(Question question : questions){
		
		DynamicForm filledForm=form().bindFromRequest();
		if(question.answerType.name().equals("QE")){
			SubmissionItem submissionItem=new SubmissionItem();
			submissionItem.question=question;
			submissionItem.answer=filledForm.get("question"+question.id);
			submissionItem.grade=0;
			if(question.answers.size()>0)
			if(filledForm.get("question"+question.id).equals(question.answers.get(0).answerContent))
				submissionItem.grade=question.questionWeight;
			submissionItem.studentSubmission=studentSubmission;
			submissionItem.save();
		}
		else if(question.answerType.name().equals("QA")){
			SubmissionItem submissionItem=new SubmissionItem();
			submissionItem.question=question;
			submissionItem.answer=filledForm.get("question"+question.id);
			if(question.answers.size()>0)
			if(filledForm.get("question"+question.id).equals(question.answers.get(0).answerContent))
				submissionItem.grade=question.questionWeight;
			submissionItem.studentSubmission=studentSubmission;
			submissionItem.save();
		}
		else if(question.answerType.name().equals("SCT")){
			String answer="";
			
			for(int i=1;i<=question.answers.size();i++){
				if(filledForm.get("question"+question.id+"answerTrue").equals(""+i))
					answer+=""+i;
			}
			SubmissionItem submissionItem=new SubmissionItem();
			submissionItem.question=question;
			submissionItem.answer=answer;
			List<Answer> trueAnswers=Answer.findTrueAnswersByQuestion(question.id);
			String compareAnswer=trueAnswers.get(0).isTrueAnswer+"";
			if(answer.equals(compareAnswer))
				submissionItem.grade=question.questionWeight;
			submissionItem.studentSubmission=studentSubmission;
			submissionItem.save();
			}
		else if(question.answerType.name().equals("MCT")){
			String answer="";
			
		for(int i=1;i<=question.answers.size();i++){
			if(filledForm.get("question"+question.id+"answerTrue"+i).equals("1"))
				if(answer.length()>0)
					answer+=","+i;
					else
						answer+=""+i;
		}
		SubmissionItem submissionItem=new SubmissionItem();
		submissionItem.question=question;
		submissionItem.answer=answer;
		List<Answer> trueAnswers=Answer.findTrueAnswersByQuestion(question.id);
		String compareAnswer="";
		for(int i=0;i<trueAnswers.size();i++)
			if(compareAnswer.length()>0)
				compareAnswer+=","+trueAnswers.get(i).isTrueAnswer;
			else
				compareAnswer+=""+trueAnswers.get(i).isTrueAnswer;
		if(answer.equals(compareAnswer))
			submissionItem.grade=question.questionWeight;
		submissionItem.studentSubmission=studentSubmission;
		
		submissionItem.save();
		}
	}
		
		return redirect(routes.Assignments.getAssignment(sfId));
	}else{
		return forbidden();
	}
}

}
