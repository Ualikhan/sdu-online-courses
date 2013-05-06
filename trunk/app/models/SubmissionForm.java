package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity
public class SubmissionForm extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	public String title;
	
	public static Finder<Long,SubmissionForm> find=new Finder<Long, SubmissionForm>(Long.class, SubmissionForm.class);
		
	public static void delete(Long id){
		SubmissionForm an=SubmissionForm.find.byId(id);
		an.delete();
	}


}
