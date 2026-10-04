public class PM extends User{
    public PM(String userId,String username,String password,String fullName,String email){
        super(userId, username, password, fullName, email);
        super.setrole(User.ROLE_PM);
    }
}
