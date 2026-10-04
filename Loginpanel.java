import javax.swing.*;
import java.awt.*;
public class Loginpanel extends JPanel{
    JPasswordField passtext;
    JTextField usertext;
    Loginpanel(JFrame frame){
            
            UserService userService = new UserService();
            
        
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);


        JLabel loginlable = new JLabel("Login");
        loginlable.setBounds(500,0,100,50);
        loginlable.setFont(new Font("MV Boli", Font.PLAIN, 40));


        JLabel username = new JLabel("Username");
        username.setBounds(450,100,200,50);

        JLabel password = new JLabel("password");

        password.setBounds(450,250,200,50);



         usertext = new JTextField();

        usertext.setBounds(450,150,200,50);

         passtext = new JPasswordField();

        passtext.setBounds(450,300,200,50);

        Button sumbit = new Button("submit");
        sumbit.setBounds(450,400,200,50);

        



        sumbit.addActionListener(e -> {
            
            User user = userService.login(usertext.getText(), passtext.getText());
           if (user != null) {
            String role = user.getrole();
            switch (role) {
                case User.ROLE_ADMIN:
                    showpanel(new OTPpoanel(frame),frame);
                    emtpyText();
                    break;
                case User.ROLE_PM:
                    showpanel(new PMPanel(frame),frame);
                    emtpyText();
                    break;
                case User.ROLE_TESTER:
                   showpanel(new Testerpanel(frame,user),frame);
                   emtpyText();
                    break;
                case User.ROLE_DEV:
                    showpanel(new Devpanel(frame,user),frame);
                    emtpyText();
                    break;
                default:
                    break;
            }
         
           }


        });
        this.add(loginlable);
        this.add(username);
        this.add(usertext);
        this.add(password);
        this.add(passtext);
        this.add(sumbit);
    }

    void showpanel(JPanel panel,JFrame fram){
 ;
                    fram.setContentPane(panel);
                    fram.revalidate();
                    fram.repaint();
    }

    private void emtpyText(){
        usertext.setText(null);
        passtext.setText(null);
    }

}
