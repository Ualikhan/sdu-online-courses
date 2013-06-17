package models;

public class Enums {

	public enum Gender{
		Male,
		Female
	}
	
	public enum RoleTypes{
		Administrator,
		Tutor,
		Student
	}
	
	public enum ResourceTypes{
		VIDEO,
		SLIDE,
		BOOK,
		AUDIO,
		TRANSCRIPT
		}
	
	public enum AnswerTypes{
		QE,
		QA,
		SCT,
		MCT
		}
	
	public enum SubmissionTypes{
		SAVED,
		SUBMITTED,
		CHECKED
		}
	public enum PostTypes{
		THREAD,
		REPLY
		}
}
