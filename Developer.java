public class Developer extends User{
    public Developer(String userId,String username,String password,String fullName,String email){
        super(userId, username, password, fullName, email);
        super.setrole(User.ROLE_DEV);
    }
}
