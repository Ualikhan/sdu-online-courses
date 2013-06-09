package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import models.*;
import models.Enums.SubmissionTypes;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.submission.*;
import java.util.HashSet;

@Security.Authenticated(Secured.class)
public class StudentSubmissions extends Controller{	

static Long courseId;

public static Result unchecked() {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		Assignment lastAssignment=Assignment.findLastAssignmentByCourse(courseId);
		if(lastAssignment!=null){
			return ok(index.render(
					User.find.where().eq("email", request().username()).findUnique(),
					Course.find.byId(courseId),
					Assignment.findAssignmentsByCourse(courseId),
					StudentSubmission.findUncheckedSubmissionsByAssignment(lastAssignment.id),
					"SUBMITTED",
					lastAssignment.id
					)
			);
		}
		else{
			return ok(index.render(
					User.find.where().eq("email", request().username()).findUnique(),
					Course.find.byId(courseId),
					Assignment.findAssignmentsByCourse(courseId),
					null,
					"SUBMITTED",
					null
					)
			);
		}
	}
	else{
		return forbidden();
	}
}

public static Result checked() {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		Assignment lastAssignment=Assignment.findLastAssignmentByCourse(courseId);
		if(lastAssignment!=null){
			return ok(index.render(
					User.find.where().eq("email", request().username()).findUnique(),
					Course.find.byId(courseId),
					Assignment.findAssignmentsByCourse(courseId),
					StudentSubmission.findCheckedSubmissionsByAssignment(lastAssignment.id),
					"CHECKED",
					lastAssignment.id
					)
			);
		}
		else{
			return ok(index.render(
					User.find.where().eq("email", request().username()).findUnique(),
					Course.find.byId(courseId),
					Assignment.findAssignmentsByCourse(courseId),
					null,
					"SUBMITTED",
					null
					)
			);
		}
	}
	else{
		return forbidden();
	}
}

public static Result results() {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		Assignment lastAssignment=Assignment.findLastAssignmentByCourse(courseId);
		
		List<GradeByAssignment> studentGrades=new ArrayList<GradeByAssignment>();
		List<Assignment> assignments=Assignment.findAssignmentsByCourse(courseId);
		List<SqlRow> rows = Ebean
	             .createSqlQuery("SELECT s.student_email AS email, a.id as id, " +
	             		"(s.grade * a.assignment_weight /100) AS grade FROM  `student_submission` s," +
	             		" assignment a WHERE s.assignment_id = a.id and a.course_id="+courseId+"  GROUP BY s.student_email, a.id " +
	             		"UNION SELECT s.student_email as email,0,SUM( s.grade * a.assignment_weight /100 )" +
	             		" as grade FROM  `student_submission` s, assignment a WHERE s.assignment_id = a.id and a.course_id="+courseId+" " +
	             		"GROUP BY s.student_email ORDER BY grade DESC").findList();
		
		
		
		for (SqlRow row : rows){
			   User u=User.find.byId(row.getString("email"));
			   
	           Long a=row.getLong("id");
	           double g=row.getDouble("grade");
	           GradeByAssignment gba=new GradeByAssignment(u,a,g);
	           studentGrades.add(gba);
			}
		GradeByAssignmentComparator gbacomparator=new GradeByAssignmentComparator();
		Collections.sort(studentGrades, gbacomparator);
		

		for(int i=0;i<studentGrades.size();i++){
			
			Logger.debug(studentGrades.get(i).student.name);
		}
		
		/*
		List<Map<User,List<Map<Long,Double>>>> GResults=new ArrayList<Map<User,List<Map<Long,Double>>>>();
		Map<User,List<Map<Long,Double>>> studentGradesResults=new HashMap<User,List<Map<Long,Double>>>();
		
		
		for(int i=0;i<studentGrades.size();i++){
			
			User u=studentGrades.get(i).student;
			if(!studentGradesResults.containsKey(u)){
				studentGradesResults.put(u, new ArrayList<Map<Long,Double>>());
				
			}
			Map<Long,Double> newM=new HashMap<Long, Double>();
			newM.put(studentGrades.get(i).assignmentId,studentGrades.get(i).grade);
			studentGradesResults.get(u).add(newM);
			
		}
			    @for(submission<-submissions){
		   @for((a, value) <- submission){
		    <tr>
		    <td>@a.name</td>
		    @for(cn <- 1 to assignments.size){
		    <td>
		    @for(subvalue <- value){
		     @for((assignmentId, grade) <- subvalue){
		     @if(assignmentId==assignments.get(cn-1).id){
		     @grade
		     }
	           } 
	           }
	        </td>
	           }
	           <td>
	           
	            @for((assignmentId, grade) <- value.get(value.size()-1)){
	            @grade
	            }
	           </td>            
		    </tr>
		    }
		    
		  }
		  
		GResults.add(studentGradesResults);
		*/
		
	return ok(results.render(
			User.find.where().eq("email", request().username()).findUnique(),
			Course.find.byId(courseId),
			assignments,
			studentGrades
			)
	);
	}
	else{
		return forbidden();
	}
}

public static Result getCheckedByAssignment(Long id) {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
	return ok(index.render(
			User.find.where().eq("email", request().username()).findUnique(),
			Course.find.byId(courseId),
			Assignment.findAssignmentsByCourse(courseId),
			StudentSubmission.findCheckedSubmissionsByAssignment(id),
			"CHECKED",
			id
			
			)
	);
	}
	else{
		return forbidden();
	}
}

public static Result getUncheckedByAssignment(Long id) {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
	return ok(index.render(
			User.find.where().eq("email", request().username()).findUnique(),
			Course.find.byId(courseId),
			Assignment.findAssignmentsByCourse(courseId),
			StudentSubmission.findUncheckedSubmissionsByAssignment(id),
			"SUBMITTED",
			id
			)
	);
	}
	else{
		return forbidden();
	}
}

public static Result getSubmission(Long id,String submissionType) {
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
	return ok(item.render(
			User.find.where().eq("email", request().username()).findUnique(),
			Course.find.byId(courseId),
			StudentSubmission.find.ref(id),
			SubmissionItem.findSubmissionsBySS(id),
			submissionType
			)
	);
	}
	else if(Secured.isStudentOf(courseId)){
		return ok(views.html.assignment.student.submissionResult.render(
				User.find.where().eq("email", request().username()).findUnique(),
				Course.find.byId(courseId),
				StudentSubmission.find.ref(id),
				SubmissionItem.findSubmissionsBySS(id),
				submissionType
				)
		);
		}
	else{
		return forbidden();
	}
}

public static Result confirmStudentSubmission(){
	courseId=Long.parseLong(session("course"));
	if(Secured.isTutorOf(courseId)){
		
		DynamicForm filledForm=form().bindFromRequest();
		StudentSubmission ss=StudentSubmission.find.byId(Long.parseLong(filledForm.get("submissionID")));
		List<SubmissionItem> items=SubmissionItem.findSubmissionsBySS(ss.id);
		for(int i=0;i<items.size();i++){
			if(filledForm.get("grade"+items.get(i).id)!=null)
				items.get(i).grade=Integer.parseInt(filledForm.get("grade"+items.get(i).id));
				items.get(i).update();
				
		}
		ss.submissionType=SubmissionTypes.CHECKED;
		ss.grade=Integer.parseInt(filledForm.get("totalGrade"));
		ss.update();
		
		String submissionType=filledForm.get("submissionType");
		if(submissionType.equals("CHECKED")){
		return redirect(routes.StudentSubmissions.getCheckedByAssignment(ss.assignment.id));
		}
		else{
			return redirect(routes.StudentSubmissions.getUncheckedByAssignment(ss.assignment.id));
		}
	}
	else{
		return forbidden();
	}
}

	
}
	