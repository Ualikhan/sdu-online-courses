import play.*;
import play.libs.*;
import com.avaje.ebean.Ebean;
import models.*;
import java.util.*;

public class Global extends GlobalSettings {
    @Override
    public void onStart(Application app) {
        // Check if the database is empty
    	if(Ebean.find(User.class).findRowCount() == 0) {
            
            Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");

            // Insert modules first
            Ebean.save(all.get("modules"));
            
         // Insert roles
            Ebean.save(all.get("roles"));
            
            // Insert projects
            Ebean.save(all.get("users"));
            for(Object project: all.get("users")) {
                // Insert the project/user relation
                Ebean.saveManyToManyAssociations(project, "courses");
            }
            
            Ebean.save(all.get("courses"));
            	
            Ebean.save(all.get("forumtypes"));

            
        }
    }
}