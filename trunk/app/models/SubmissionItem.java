package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class SubmissionItem extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@ManyToOne
	public Question question;
	
	@Column(columnDefinition="TEXT")
	public String answer;
	
	public int grade;
	
	@ManyToOne 
	public StudentSubmission studentSubmission;
	
	public static Finder<Long,SubmissionItem> find=new Finder<Long, SubmissionItem>(Long.class, SubmissionItem.class);
	
	public static List<SubmissionItem> findAll(){
		return find.all();
	}

	public static List<SubmissionItem> findSubmissionsBySS(Long id2) {
		return find.where().eq("studentSubmission.id", id2).findList();
	}
}
