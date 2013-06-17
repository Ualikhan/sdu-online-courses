package models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import models.Enums.PostTypes;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Post extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	public String title;	
	
	@Column(columnDefinition="TEXT")
	public String description;
	
	public Date postedDate;
	
	public int votes;
	
	public Long views;
	
	@ManyToOne
	public User author;
	
	@ManyToOne
	public ForumType forumType;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('THREAD','REPLY')")
	public PostTypes postType;
	
	@ManyToOne
	public Post repliedTo;
	
	@ManyToOne
	public Course course;
	
	public static Finder<Long,Post> find=new Finder<Long, Post>(Long.class, Post.class);
	
	public static List<Post> findAll(){
		return find.all();
	}
	
	public static List<Post> findByForumType(Long courseId,Long id) {
		// TODO Auto-generated method stub
		return find.where().eq("postType", "THREAD").eq("course.id", courseId).eq("forumType.id", id).findList();
				
	}

	public static List<Post> findReplies(Long id) {
		// TODO Auto-generated method stub
		return find.where().eq("postType", "REPLY").eq("repliedTo.id", id).findList();
	}
	
	public static Post create(String title,String desc,Long forumTypeId,User user,Course course) {
		Post p=new Post();
		p.title=title;
		p.description=desc;
		p.forumType=ForumType.find.ref(forumTypeId);
		p.postType=PostTypes.THREAD;
		p.author=user;
		p.course=course;
		p.postedDate=new Date();
		p.views=(long) 0;
		p.save();
		return p;
	}

	public static List<Post> findRepliesByDatePosted(Long id) {
		return find.where().eq("postType", "REPLY").eq("repliedTo.id", id).orderBy("postedDate asc").findList();
	}
	
	public static List<Post> findRepliesByMostRecent(Long id) {
		return find.where().eq("postType", "REPLY").eq("repliedTo.id", id).orderBy("postedDate desc").findList();
	}
	
	public static List<Post> findRepliesByVotes(Long id) {
		return find.where().eq("postType", "REPLY").eq("repliedTo.id", id).orderBy("votes desc").findList();
	}

	public static int findThreasByForumType(Long courseId,Long id) {
		return find.where().eq("course.id", courseId).eq("postType", "THREAD").eq("forumType.id", id).findRowCount();
	}

	public static int findPostsByForumType(Long courseId,Long id) {
		return find.where().eq("course.id", courseId).eq("postType", "REPLY").eq("forumType.id", id).findRowCount();
	}

	public static Post findLastPostByForumType(Long courseId,Long id) {
		return find.where().eq("course.id", courseId).eq("forumType.id", id).orderBy("postedDate desc").setMaxRows(1).findUnique();
	}

	public static int findRepliesCountByThread(Long id) {
		return find.where().eq("postType", "REPLY").eq("repliedTo.id", id).findRowCount();
	}

	public static Post findLastPostByThread(Long id) {
		return find.where().eq("postType", "REPLY").eq("repliedTo.id", id).orderBy("postedDate desc").setMaxRows(1).findUnique();
	}

	public static int findUserThreadsNum(User user) {
		return find.where().eq("postType", "THREAD").eq("author", user).findRowCount();
	}
	
	public static int findUserRepliesNum(User user) {
		return find.where().eq("postType", "REPLY").eq("author", user).findRowCount();
	}
	
	public static int findUserVotesNum(User user) {
		return find.where().eq("postType", "THREAD").eq("author", user).findRowCount();
	}
	
	
}
