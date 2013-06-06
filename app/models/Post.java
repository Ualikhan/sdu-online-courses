package models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Post{

	@Id
	public Long id;
	
	public String title;	
	
	@Column(columnDefinition="TEXT")
	public String description;
	
	public Date postedDate;
	
	public int votes;
	
	@ManyToOne
	public User author;
	
	@ManyToOne
	public ForumType forumType;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('THREAD','REPLY')")
	public String postType;
	
	@OneToOne
	public Post repliedTo;
	
	@ManyToOne
	public Course course;
	public static Finder<Long,Post> find=new Finder<Long, Post>(Long.class, Post.class);
	
}
