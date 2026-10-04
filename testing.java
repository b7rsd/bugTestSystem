
import javax.swing.*;




public class testing {
   static BugService bugService = new BugService();
   UserService userService = new UserService();
   FileHandler fileHandler = new FileHandler();
   
 public static void main(String[] args) {
  

   JFrame frame = new JFrame("new table");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(1200,800);
  
   Bug.BugLevel.Major.toString();
   
JMenuBar bar = new JMenuBar();
       JMenu menu = new JMenu("Settings");
       JMenuItem logout = new JMenuItem("Logout");
       logout.setEnabled(false);
      

       menu.add(logout);
        bar.add(menu);


frame.setJMenuBar(bar);

// frame.setContentPane(new Testerpanel(frame));

frame.setVisible(true);
 }

}