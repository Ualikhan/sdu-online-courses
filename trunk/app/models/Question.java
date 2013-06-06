package models;

import java.util.List;
import javax.persistence.*;
import models.Enums.AnswerTypes;
import play.db.ebean.*;

@Entity
public class Question extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(columnDefinition="TEXT")
	public String questionContent;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('QE','QA','SCT','MCT')")
	public AnswerTypes answerType;
	
	public int numOfAnswers;
	public int numOfRightAnswers;
	
	public int questionWeight;
	
	@OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL)
    public List<Answer> answers;
	
	@ManyToOne
	public Assignment assignment;
	
	public static Finder<Long,Question> find=new Finder<Long, Question>(Long.class, Question.class);
	
	public static List<Question> findAll(){
		return Question.find.all();
	}
	
	public static void delete(Long id){
		Question an=Question.find.byId(id);
		an.delete();
	}

	public static List<Question> findBySubmissionForm(Long id) {
		// TODO Auto-generated method stub
		return Question.find.where().eq("assignment.id", id).findList();
	}


}
