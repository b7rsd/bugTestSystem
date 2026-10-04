import java.util.ArrayList;
import java.util.List;

public class BugService {
  private  List<Bug> bugs = new ArrayList<>();
   private FileHandler fileHandler = new FileHandler();

public BugService(){
   bugs = fileHandler.loadAllBugs();
}


public void addBug(Bug bug){
    bugs.add(bug);
    fileHandler.saveAllBugs(bugs);

}

public List<Bug> getAllBugs(){
    return bugs;
}

 public List<Bug> getBugsByTester(String tastername){
    List<Bug> testerbugs = new ArrayList<>();

    for(Bug bug :bugs){
        if (bug.gettesterName().equals(tastername)) {
            testerbugs.add(bug);
        }
        else continue;
    }
    return testerbugs;
 }

 public List<Bug> getBugsByDeveloper(String developername){
    List<Bug> developerBugs = new ArrayList<>();

    for(Bug bug :bugs){
        if (bug.getassignedTo().equals(developername)) {
            developerBugs.add(bug);
        }
        else continue;
    }
    return developerBugs;
 }

public void assignBug(String bugname,String developername){
    for(Bug bug :bugs){
        if (bug.getbugName().equals(bugname)) {
            bug.setAssignedTo(developername);
            break;
        }
}

}

 public void closeBug(String bugname){
for(Bug bug :bugs){
        if (bug.getbugName().equals(bugname)) {
            bug.setStatus("closed");
            break;
        }
        else continue;
    }
 }

public Bug findBugByName(String bugname){
for(Bug bug :bugs){
        if (bug.getbugName().equals(bugname)) {
            return bug;
        }
        else continue;
    }
return null;
}

public void attachScreenshot(String bugname,String screenshotpath){
    for(Bug bug :bugs){
        if (bug.getbugName().equals(bugname)) {
           bug.setScreenshotPath(screenshotpath);
        }
        else continue;
    }
}

public void updateBugStatus(String bugname,String statu){


    for(Bug bug :bugs){
        if (bug.getbugName().equals(bugname)) {
            bug.setStatus(statu);
        }
        else continue;
    }
}

public Bug GetBugByID(String ID){
    for(Bug bug : bugs){
        if (bug.getbugID().equals(ID)) {
            return bug;
        }
    }
    return null;

}


public String bugReport(){
    int closed = 0;
    int open = 0;
    for(Bug bug : bugs){
        if (bug.getstatus().equals(Bug.BugStatus.Closed.toString())) {
            closed++;
        }else open++;


    }
    return "you have: " + closed + " closed bugs and there is: " + open + " open bugs";
}

public void refreshBugs(){
        fileHandler.saveAllBugs(bugs);
}
public boolean IsNotEmptyBug(String BugID, String bugName, String projectName) {
    return BugID != null && !BugID.trim().isEmpty()
        && bugName != null && !bugName.trim().isEmpty()
        && projectName != null && !projectName.trim().isEmpty();
}

}
