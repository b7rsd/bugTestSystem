import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String USERS_FILE= "users.txt";
    private String BUGS_FILE = "bugs.txt";



public void saveAllUsers(List<User> allusers){


try(FileWriter write = new FileWriter(USERS_FILE,false)){
    for(User user : allusers){
        String aboutUser = user.toFileString();
        write.write(aboutUser + "\n");
}     
    } catch (Exception e) {System.out.println("error");}

}


public List<User> loadAllUsere(){
List<User> userlist = new ArrayList<>();

try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
    String line;
    while ((line = reader.readLine()) != null) {
        String[] userinfo = line.split(",",-1); 
        User user = new User(userinfo[0],userinfo[1],userinfo[2],userinfo[3],userinfo[4]); 
        user.setrole(userinfo[5]);       
        userlist.add(user);
    }

} catch (Exception e) {System.out.println("error");}

return userlist;
}





public void saveAllBugs(List<Bug> allbugs){

try(FileWriter write = new FileWriter(BUGS_FILE,false)){
    for(Bug bug : allbugs){
        String aboutBug = bug.toFileString();
        write.write(aboutBug + "\n");
}     
    } catch (Exception e) {System.out.println("error");}

}


public List<Bug> loadAllBugs(){
List<Bug> buglist = new ArrayList<>();

try (BufferedReader reader = new BufferedReader(new FileReader(BUGS_FILE))) {
    String line;
    while ((line = reader.readLine()) != null) {
        String[] buginfo = line.split(",",-1); 
        Bug bug = new Bug(buginfo[0],buginfo[1],buginfo[2],buginfo[3],buginfo[4],buginfo[5],buginfo[6],buginfo[7],buginfo[8],buginfo[9],buginfo[10]);    
        buglist.add(bug);
    }

} catch (Exception e) {System.out.println("error");}

return buglist;
}








}
