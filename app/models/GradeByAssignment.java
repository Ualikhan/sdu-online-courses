package models;

import java.util.Comparator;

public class GradeByAssignment{
public User student;
public Long assignmentId;
public double grade;

public GradeByAssignment(User a,Long b,double c) {
	this.student=a;
	this.assignmentId=b;
	this.grade=c;
}


public double getGrade() {
	return grade;
}
}

