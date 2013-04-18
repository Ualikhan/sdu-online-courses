package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import models.Enums.ResourceTypes;

import play.data.Form;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class LectureResource extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	public String title;
	
	@Column(columnDefinition="TEXT")
	public String file_url;
	
	@Enumerated(EnumType.STRING)
	public ResourceTypes resourceType;
	
	@ManyToOne
	public Lecture lecture;
	
	public LectureResource(String title,String file_url,ResourceTypes resourceType,Lecture lecture){
		this.title=title;
		this.file_url=file_url;
		this.resourceType=resourceType;
		this.lecture=lecture;
	}
	
	public static Finder<Long,LectureResource> find=new Finder<Long, LectureResource>(Long.class, LectureResource.class);
	
	public static List<LectureResource> findLectureResourcesByLecture(Long lectureId){
		return find.where().eq("lecture.id", lectureId).findList();
	}
	
	public static LectureResource create(String title,String file_url,ResourceTypes resourceType,Lecture lecture){
		LectureResource an=new LectureResource(title, file_url,resourceType, lecture);
		an.save();
		return an;
	}
	
	public static void delete(Long id){
		LectureResource an=LectureResource.find.byId(id);
		an.delete();
	}

	public static void update(Long id2, String title2, String file_url2) {
		LectureResource an=LectureResource.find.byId(id2);
		an.title=title2;
		an.file_url=file_url2;
		an.update();
	}

	public static List<LectureResource> findByLecture(Long id2) {
		return find.where().eq("lecture.id", id2).orderBy("resourceType").findList();
	}

}
