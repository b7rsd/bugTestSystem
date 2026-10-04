import java.awt.*;

import javax.swing.*;

public class LogionForm {


    public static void main(String[] args) {
            BugService bugService = new BugService();
            UserService userService = new UserService();
            FileHandler fileHandler = new FileHandler();
            AdminOTP adminOTP = new AdminOTP();
            fileHandler.loadAllBugs();
            fileHandler.loadAllUsere();
            
        ImageIcon icon = new ImageIcon("bug.png");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.getContentPane().setBackground(Color.white);

        frame.setLayout(null);
        
        frame.setTitle("Bug System Tracker");
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);

        
       Loginpanel login = new Loginpanel(frame);
       JMenuBar bar = new JMenuBar();
       JMenu menu = new JMenu("Settings");
       JMenuItem logout = new JMenuItem("Logout");
       logout.setEnabled(false);
        logout.addActionListener(e -> {
            frame.setContentPane(login);
                    frame.revalidate();
                    frame.repaint();
                    logout.setEnabled(false);
        });

       menu.add(logout);
        bar.add(menu);


frame.setJMenuBar(bar);
frame.setContentPane(login);

        frame.setVisible(true);
    }
}
