package models;

import java.util.Comparator;

public class GradeByAssignmentComparator implements Comparator<GradeByAssignment> {

    @Override
    public int compare(GradeByAssignment o1, GradeByAssignment o2) {
          double datarate1=o1.getGrade();
          double datarate2=o2.getGrade();

          if(datarate1>datarate2)
              return -1;
          else if(datarate1<datarate2)
              return 1;
          else
              return 0;
    }           
}
