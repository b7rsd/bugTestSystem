import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class OTPpoanel extends JPanel {

    OTPpoanel(JFrame frame) {

        AdminOTP adminOTP = new AdminOTP();

        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);

        JLabel OTP = new JLabel("OTP");
        OTP.setBounds(300, 100, 200, 50);

        JTextField OTPtext = new JTextField();

        OTPtext.setBounds(300, 150, 200, 50);

        JButton sumbitOTP = new JButton("submit");
        sumbitOTP.setBounds(300, 400, 200, 50);

        sumbitOTP.addActionListener(e -> {

            if (adminOTP.getOTP().equals(OTPtext.getText())) {
                Adminpanelbugs bugspanel = new Adminpanelbugs(frame);
                frame.setContentPane(bugspanel);
                frame.revalidate();
                frame.repaint();
            } else {
                JOptionPane.showOptionDialog(null, "OTP Wrong", "OTP",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
            }

        });

        this.add(OTP);
        this.add(OTPtext);
        this.add(sumbitOTP);

    }

}
