public class Admin extends User{

    public Admin(String userId,String username,String password,String fullName,String email){
        super(userId, username, password, fullName, email);
        super.setrole(User.ROLE_ADMIN);
       
    }
}
