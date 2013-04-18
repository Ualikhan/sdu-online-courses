package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import models.Enums.ResourceTypes;

import play.data.validation.Constraints;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class VideoResource extends Model{

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    @Constraints.Required
	public Long id;
	
	public String title;
	
	@Column(columnDefinition="TEXT")
	public String file_path;
	
	@Column(columnDefinition="TEXT")
	public String file_url;
	
	@Enumerated(EnumType.STRING)
	public ResourceTypes resourceType;
	
	@ManyToOne
	public Lecture lecture;
	
	public VideoResource(String title,String path,String url,ResourceTypes resourceType,Lecture lecture){
		this.title=title;
		this.file_path=path;
		this.file_url=url;
		this.resourceType=resourceType;
		this.lecture=lecture;
	}
	
	public static Finder<Long,VideoResource> find=new Finder<Long, VideoResource>(Long.class, VideoResource.class);
	
	
	public static VideoResource create(String title,String path,String url,ResourceTypes resourceType,Lecture lecture){
		VideoResource an=new VideoResource(title, path, url,resourceType,lecture);
		an.save();
		return an;
	}
	
	public static void delete(Long id){
		VideoResource an=VideoResource.find.byId(id);
		an.delete();
	}

	public static void update(Long id2, String title2, String path2,String url,ResourceTypes resourceType) {
		VideoResource an=VideoResource.find.byId(id2);
		an.title=title2;
		an.file_path=path2;
		an.file_url=url;
		an.resourceType=resourceType;
		an.update();
	}
	
	public static List<VideoResource> findByLecture(Long lectureId){
		return find.where().eq("lecture.id",lectureId).findList();
	}
	
}
