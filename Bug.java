import java.security.Security;

public class Bug {

    private String bugID;
    private String bugName;
    private String bugType;
    private String priority;
    private String level;
    private String projectName;
    private String testerName;
    private String assignedTo;
    private String status;
    private String dateOpended;
    private String screenshotPath;
    public Bug(String bugID,String bugName,String bugType,String priority,String level,String projectName,String testerName,
        String assignedTo,String status,String dateOpended,String screenshotPath
    ){
        this.bugID            = bugID           ;
        this.bugName          = bugName         ;
        this.bugType          = bugType         ;
        this.priority         = priority        ;
        this.level            = level           ;
        this.projectName      = projectName     ;
        this.testerName       = testerName      ;
        this.assignedTo       = assignedTo      ;
        this.status           = status          ;
        this.dateOpended      = dateOpended     ;
        this.screenshotPath   = screenshotPath  ;
        
    }
public String getbugID(){return bugID ;}
public String getbugName(){return bugName ;}
public String getbugType(){return  bugType;}
public String getpriority(){return priority ;}
public String getlevel(){return level ;}
public String getprojectName(){return  projectName;}
public String gettesterName(){return testerName ;}
public String getassignedTo(){return assignedTo ;}
public String getstatus(){return status;}
public String getdateOpended(){return dateOpended ;}
public String getscreenshotPath(){return screenshotPath ;}

public void setbugID(String bugID){this.bugID = bugID ;
    
 }

public void setbugName(String bugName){this.bugName =  bugName ;}
public void setbugType(String bugType){this.bugType =   bugType;}
public void setpriority(String priority){this.priority = priority ;}
public void setlevel(String level){this.level = level ;}
public void setprojectName(String projectName){this.projectName =   projectName;}
public void settesterName(String testerName){this.testerName =  testerName ;}
public void setAssignedTo(String AssignedTo) {this.assignedTo = AssignedTo;}
public void setStatus(String status) {this.status = status;}
public void setdateOpended(String dateOpended) {this.dateOpended = dateOpended;}
public void setScreenshotPath(String screenshotPath) {this.screenshotPath = screenshotPath;}


public String toFileString(){

    return bugID + "," + bugName + "," + bugType + "," + priority + "," +level + "," +projectName+ "," +testerName+ "," +assignedTo+ "," +status+ "," +dateOpended+ "," +screenshotPath;
}

@Override
public String toString(){
    return bugName;
}



static public enum BugType{
Performance_Issue,Security_Issue,Improvement,
}
static public enum BugLevel{
Minor,Major,Critical
}
static public enum BugPriority{
Low,Medium,High
}
static public enum BugStatus{
New,Open,In_Progress,In_Review,Closed
}



}
