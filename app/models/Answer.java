package models;

import java.util.List;

import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Answer extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(columnDefinition="TEXT")
	public String answerContent;

	public boolean isTrueAnswer;
	
	@ManyToOne
	public Question question;
	
	public static Finder<Long,Answer> find=new Finder<Long, Answer>(Long.class, Answer.class);
	
	public static List<Answer> findAll(){
		return Answer.find.all();
	}
	
	public static void delete(Long id){
		Answer an=Answer.find.byId(id);
		an.delete();
	}

	public static void deleteAllAnswersFromQuestion(Long id){
		List<Answer> ans=Answer.find.where().eq("question.id", id).findList();
		for(Answer an:ans){
		an.delete();
		}
	}

}
