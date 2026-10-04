import java.util.ArrayList;
import java.util.List;

public class UserService {
    private  List<User> users = new ArrayList<>();
   private FileHandler fileHandler =  new FileHandler();



public UserService(){
    users = fileHandler.loadAllUsere();
}


public User login(String username,String password){
for(User user : users){
    if (user.getusername().equals(username) && user.getpassword().equals(password)) {
        return user;
    } else continue;
}

return null;
}

public User getUserByUsername(String username){
    for(User user : users){
    if (user.getusername().equals(username) ) {
        return user;
    } else continue;
}

return null;
}

public void addUser(User user){
    users.add(user);
    fileHandler.saveAllUsers(users);
}
public void delUser(User user){
    users.remove(user);
    fileHandler.saveAllUsers(users);
}
public List<User> getAllUsers(){
    return users;
}
public User getUserById(String userId){
    for(User user : users){
    if (user.getuserId().equals(userId) ) {
        return user;
    } else continue;
}
return null;
}
public List<String> getAllDevelopersName(){
    List<String> temp = new ArrayList<>();
    for(User user : users){
        if (user.getrole().equals(User.ROLE_DEV)) {
            temp.add(user.getfullName());
        }else continue;
    }
    
    return temp;
}
public List<String> getAllTestersName(){
    List<String> temp = new ArrayList<>();
    for(User user : users){
        if (user.getrole().equals(User.ROLE_TESTER)) {
            temp.add(user.getfullName());
        }else continue;
    }
    
    return temp;
}
public void refreshUser() {
    fileHandler.saveAllUsers(users);
}


// 4 mean poth right | 2 mean the pass right | 1 mean the user is right | -1 mean poth wrong
public int checkUser(String username,String password){

    if (username == null || password == null) 
        return -1;

    boolean userok = true;
    boolean passok = true;

    if (username.length() < 3 ||username.length()>20) {
       userok = false;
    }else{
         for(char c : username.toCharArray()){
            if (!Character.isLetter(c)) {
                userok = false;
                break;
            }
        }
    }

 if (password.length() < 8 ) {
       passok = false;
    }else{
         for(char c : password.toCharArray()){
            if (!(Character.isLetterOrDigit(c) || c == '@'||c == '#' || c == '$' || c == '?')) {
                passok = false;
                break;
            }
        }
    }

  if (userok && passok) return 4;
  if (!userok && passok) return 2;
  if (userok && !passok) return 1;

  return -1;
}
   

public boolean IsNotEmptyuser(String userId, String fullName, String email) {
    return userId != null && !userId.isEmpty()
        && fullName != null && !fullName.isEmpty()
        && email != null && !email.isEmpty();
}



//4 mean poth right | 2 mean the email right | 1 mean the name is right | -1 mean poth wrong
public int CheckEmail_andFullname(String fullname , String email){
boolean nameok = true;
boolean emailok = true;

// check the name 
  for(char c : fullname.toCharArray()){
            if (!(Character.isLetter(c)|| c == ' ')) {
                nameok = false;
                break;
            }
        }

//check if email have @ and have letter befor and after it

if (!(email.contains("@") && !email.endsWith("@") && !email.startsWith("@"))) {
    emailok = false;
}
 if (nameok && emailok) return 4;
  if (!nameok && emailok) return 2;
  if (nameok && !emailok) return 1;

  return -1;

}


}
