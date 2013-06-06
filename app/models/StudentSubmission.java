package models;

import java.util.List;

import javax.persistence.*;

import models.Enums.AnswerTypes;
import models.Enums.ResourceTypes;
import models.Enums.SubmissionTypes;

import play.db.ebean.*;

@Entity
public class StudentSubmission extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@ManyToOne
	public User student;
	
	public int grade;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('SAVED','SUBMITTED','CHECKED')")
	public SubmissionTypes submissionType;
	
	@ManyToOne
	public Assignment assignment;

	public static Finder<Long,StudentSubmission> find=new Finder<Long, StudentSubmission>(Long.class, StudentSubmission.class);
		
	public static List<StudentSubmission> findAll(){
		return find.all();
	}
	
	public static void delete(Long id){
		StudentSubmission an=StudentSubmission.find.byId(id);
		an.delete();
	}

	public static List<StudentSubmission> findUncheckedSubmissionsByAssignment(Long id2) {
		return find.where().eq("assignment.id", id2).eq("submissionType", "SUBMITTED").findList();
	}

	public static List<StudentSubmission> findUncheckedSubmissions() {
		return find.where().eq("submissionType", "SUBMITTED").findList();
	}

	public static List<StudentSubmission> findCheckedSubmissions() {
		return find.where().eq("submissionType", "CHECKED").findList();
	}

	public static List<StudentSubmission> findCheckedSubmissionsByAssignment(Long id2) {
		return find.where().eq("assignment.id", id2).eq("submissionType", "CHECKED").orderBy("grade desc").findList();
	}

	public static StudentSubmission isStudentSubmitedAssignment(String email,Long assignmentId) {
		return find.where().eq("student.email", email).eq("assignment.id", assignmentId).findUnique();
	}

}
