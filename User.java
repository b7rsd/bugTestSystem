public class User {
        private String userId;
        private String username;
        private String password;
        private String fullName;
        private String email;
        private String role;
        public static final String ROLE_DEV= "developer";
        public static final String ROLE_TESTER = "tester";
        public static final String ROLE_PM = "pm";
        public static final String ROLE_ADMIN = "admin";

    public User(String userId,String username,String password,String fullName,String email){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

public String getuserId(){ return userId;}
public String getusername(){return username;}
public String getpassword(){return password;}
public String getfullName(){return fullName;}
public String getemail(){return email;}
public String getrole(){return role;}


public void setuserId(String UserId){userId = UserId; }
public void setusername(String Username){ username = Username;}
public void setpassword(String Password){ password = Password ;}
public void setfullName(String FullName){ fullName = FullName;}
public void setemail(String Email){ email = Email;}
public void setrole(String Role){ role = Role;}



public String toFileString(){
     
    return userId + "," + username + "," + password + "," +fullName + "," +email + "," + role;
}

@Override
public String toString() {
return "this is: " + fullName + "and he is the: " + role;
}


    
}
