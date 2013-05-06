package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SubmissionItem {

	public String name;
	
	public String value;

	@ManyToOne
	public SubmissionForm submissionForm;
}
