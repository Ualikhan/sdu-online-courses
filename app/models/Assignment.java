package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Assignment extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	public String title;
	
	@Column(columnDefinition="TEXT")
	public String description;
	
	@Column(columnDefinition="TEXT")
	public String actionItems;
	
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date startDate;
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date deadline;	
	
	public int assignmentWeight;

	public boolean submissionFormCreated;
	
	@ManyToOne
	public Course course;
	
	
	

	public static Finder<Long,Assignment> find=new Finder<Long, Assignment>(Long.class, Assignment.class);
	
	public static List<Assignment> findAssignmentsByCourse(Long courseId){
		return find.where().eq("course.id", courseId).findList();
	}
	
	public static Assignment findLastAssignmentByCourse(Long courseId){
		return find.where().eq("course.id",courseId).orderBy("id desc").setMaxRows(1).findUnique();
	}
	
	
	public static void delete(Long id){
		Assignment an=Assignment.find.byId(id);
		an.delete();
	}
	
	public static Assignment findBySubmissionForm(Long subId){
		return find.where().eq("submissionForm.id",subId).findUnique();
	}


}
