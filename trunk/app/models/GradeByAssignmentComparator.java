package models;

import java.util.Comparator;

public class GradeByAssignmentComparator implements Comparator<GradeByAssignment> {

    @Override
    public int compare(GradeByAssignment o1, GradeByAssignment o2) {
    	 int startComparison = compare(o1.grade, o2.grade);
    	    return startComparison != 0 ? startComparison
    	                                : compare(o1.grade, o2.grade);
    } 
    
    private static int compare(double a, double b) {
        return a < b ? 1
             : a > b ? -1
             : 0;
      }
}
