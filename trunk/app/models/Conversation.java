package models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import models.Enums.PostTypes;
import models.Enums.ResourceTypes;
import play.db.ebean.Model;

@Entity
public class Conversation extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	public String title;	
	
	@Column(columnDefinition="TEXT")
	public String description;
	
	public Date sendedDate;
	
	@ManyToOne
	public User fromUser;
		
	@ManyToOne
	public User toUser;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('THREAD','REPLY')")
	public PostTypes conversationType;
	
	@ManyToOne
	public Conversation repliedTo;
	
	@ManyToOne
	public Course course;
	
	public static Finder<Long,Conversation> find=new Finder<Long, Conversation>(Long.class, Conversation.class);
	
	public static List<Conversation> findAll(){
		return find.all();
	}
	
	

	public static List<Conversation> findByCourse(Long id) {
		return find.where().eq("course.id",id).findList();
	}



	public static List<Conversation> findInbox(User u) {
		return find.where().eq("toUser",u).orderBy("sendedDate desc").findList();
	}


	public static  List<Conversation> findSent(User user) {
		return find.where().eq("fromUser",user).orderBy("sendedDate desc").findList();
	}



	public static List<Conversation> findRepliesByThread(Long id) {
		return find.where().eq("conversationType","REPLY").eq("repliedTo.id",id).orderBy("sendedDate desc").findList();
	}
}