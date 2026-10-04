import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Adminpanelusers extends JPanel {
    DefaultTableModel model;
    BugService bugService = new BugService();
    UserService userService = new UserService();
    FileHandler fileHandler = new FileHandler();

    Adminpanelusers(JFrame frame) {

        frame.getJMenuBar().getMenu(0).getItem(0).setEnabled(true);

        Border first = BorderFactory.createLineBorder(Color.black, 5);
        Border sec = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border comp = BorderFactory.createCompoundBorder(sec, first);

        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBorder(comp);

        String[] columns = { "userId", "fullName", "email", "role" };
        model = new DefaultTableModel(columns, 0);
        loadtable();
        JTable table = new JTable(model);
        table.setDefaultEditor(Object.class, null);
        table.setRowHeight(30);

        JLabel userid = new JLabel("UserID");
        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");
        JLabel fullname = new JLabel("Fullname");
        JLabel email = new JLabel("Email");

        userid.setFont(new Font("Arial", Font.PLAIN, 14));
        username.setFont(new Font("Arial", Font.PLAIN, 14));
        password.setFont(new Font("Arial", Font.PLAIN, 14));
        fullname.setFont(new Font("Arial", Font.PLAIN, 14));
        email.setFont(new Font("Arial", Font.PLAIN, 14));

        userid.setBounds(50, 30, 150, 50);
        username.setBounds(280, 30, 150, 50);
        password.setBounds(510, 30, 150, 50);
        fullname.setBounds(740, 30, 150, 50);
        email.setBounds(970, 30, 150, 50);

        JTextField useridTextField = new JTextField();
        JTextField usernameTextField = new JTextField();
        JTextField passwordTextField = new JTextField();
        JTextField fullnameTextField = new JTextField();
        JTextField emailTextField = new JTextField();

        useridTextField.setBounds(50, 80, 150, 50);
        usernameTextField.setBounds(280, 80, 150, 50);
        passwordTextField.setBounds(510, 80, 150, 50);
        fullnameTextField.setBounds(740, 80, 150, 50);
        emailTextField.setBounds(970, 80, 150, 50);

        JLabel role = new JLabel("role");
        role.setFont(new Font("Arial", Font.PLAIN, 14));
        role.setBounds(50, 150, 150, 50);
        String[] rols = { User.ROLE_ADMIN, User.ROLE_PM, User.ROLE_TESTER, User.ROLE_DEV };
        JComboBox box = new JComboBox<>(rols);
        box.setEditable(false);
        box.setBounds(50, 200, 150, 50);
        box.setFocusable(false);
        box.setSelectedIndex(0);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 300, 800, 400);

        JButton add = new JButton("Add");
        JButton delet = new JButton("Delet");
        JButton edit = new JButton("Edit");
        JButton save = new JButton("Save");
        JButton back = new JButton("view bugs");

        add.setBounds(280, 200, 150, 50);
        delet.setBounds(510, 200, 150, 50);
        edit.setBounds(740, 200, 150, 50);
        save.setBounds(970, 200, 150, 50);
        back.setBounds(950, 650, 200, 50);

        add.setBackground(new Color(0x4CAF50));
        delet.setBackground(new Color(0xE53935));
        edit.setBackground(new Color(0x1E88E5));
        save.setBackground(new Color(0x1565C0));
        back.setBackground(Color.gray);

        add.setFocusable(false);
        delet.setFocusable(false);
        edit.setFocusable(false);
        save.setFocusable(false);
        back.setFocusable(false);

        add.addActionListener(e -> {
            // check if the user have a valid username and password by a method in userservice
            int res = userService.checkUser(usernameTextField.getText().trim(), passwordTextField.getText().trim());
            
            switch (res) {
                case 4:
                    // if the TextField not empty it will continu else will show error massege
                    if (userService.IsNotEmptyuser(useridTextField.getText().trim(), fullnameTextField.getText().trim(),
                            emailTextField.getText().trim())) {
                                // check the email and the name 
                              int check =   userService.CheckEmail_andFullname(fullnameTextField.getText().trim(),emailTextField.getText().trim());
                       switch (check) {
                        case 4:
                              User user = new User(useridTextField.getText().trim(), usernameTextField.getText().trim(),
                                passwordTextField.getText().trim(),
                                fullnameTextField.getText().trim(), emailTextField.getText().trim());
                        user.setrole(box.getSelectedItem().toString());
                        userService.addUser(user);
                        refreshtable();

                        useridTextField.setText(null);
                        usernameTextField.setText(null);
                        passwordTextField.setText(null);
                        fullnameTextField.setText(null);
                        emailTextField.setText(null);
                        box.setSelectedIndex(0);
                            break;
                        case 2:
                            JOptionPane.showOptionDialog(null, "please enter your name by english Characters", "wrong name", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE, null, null, 0);
                            break;
                        case 1:
                             JOptionPane.showOptionDialog(null, "please enter your an email", "wrong email", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE, null, null, 0);
                            break;
                        case -1:
                             JOptionPane.showOptionDialog(null, "please enter your name and your email correct", "wrong name & email", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE, null, null, 0);
                            break;
                       
                        default:
                            break;
                       }
                    } else {
                       JOptionPane.showOptionDialog(null, "wrong vules", "Invalid inputs", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE, null, null, 0);
                    }
                    break;
                case 2:
                    JOptionPane.showOptionDialog(null, "the username is invalid", "Invalid Username",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, 0);
                    break;
                case 1:
                    JOptionPane.showOptionDialog(null, "the password is invalid", "Invalid Password",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, 0);
                    break;
                case -1:
                    JOptionPane.showOptionDialog(null, "the username and password are invalid",
                            "Invalid Username & Password", JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, 0);
                    break;

                default:
                    break;
            }
        });

        delet.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showOptionDialog(null, "plese select a row",
                        " no user selected", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
            } else {
                userService.delUser(userService.getUserById(table.getValueAt(row, 0).toString()));
                
                refreshtable();
            }
        });

        edit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showOptionDialog(null, "plese select a row",
                        " no user selected", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
            } else {
                User user = userService.getUserById(table.getValueAt(row, 0).toString());
                useridTextField.setEditable(false);
                useridTextField.setText(user.getuserId());
                usernameTextField.setText(user.getusername());
                passwordTextField.setText(user.getpassword());
                fullnameTextField.setText(user.getfullName());
                emailTextField.setText(user.getemail());
                box.setSelectedItem(user.getrole());

            }
        });

        save.addActionListener(e -> {

            int res = userService.checkUser(usernameTextField.getText().trim(), passwordTextField.getText().trim());
            
            switch (res) {
                case 4:
                    if (!(userService.IsNotEmptyuser(useridTextField.getText().trim(), fullnameTextField.getText().trim(),
                            emailTextField.getText().trim()))) {
                        JOptionPane.showOptionDialog(null, "wrong vules", "Invalid inputs", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE, null, null, 0);
                    } else {
                        
            User user = userService.getUserById(useridTextField.getText());
            user.setusername(usernameTextField.getText());
            user.setpassword(passwordTextField.getText());
            user.setfullName(fullnameTextField.getText());
            user.setemail(emailTextField.getText());
            user.setrole(box.getSelectedItem().toString());

            
            userService.refreshUser();

            useridTextField.setText(null);
            usernameTextField.setText(null);
            passwordTextField.setText(null);
            fullnameTextField.setText(null);
            emailTextField.setText(null);
            box.setSelectedIndex(0);

            useridTextField.setEditable(true);

            refreshtable();
                    }
                    break;
                case 2:
                    JOptionPane.showOptionDialog(null, "the username is invalid", "Invalid Username",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, 0);
                    break;
                case 1:
                    JOptionPane.showOptionDialog(null, "the password is invalid", "Invalid Password",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, 0);
                    break;
                case -1:
                    JOptionPane.showOptionDialog(null, "the username and password are invalid",
                            "Invalid Username & Password", JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, 0);
                    break;

                default:
                    break;
      }  });

        back.addActionListener(e -> {
            Adminpanelbugs bugspanel = new Adminpanelbugs(frame);
            frame.setContentPane(bugspanel);
            frame.revalidate();
            frame.repaint();
        });

        this.add(useridTextField);
        this.add(usernameTextField);
        this.add(passwordTextField);
        this.add(fullnameTextField);
        this.add(emailTextField);

        this.add(userid);
        this.add(username);
        this.add(password);
        this.add(fullname);
        this.add(email);

        this.add(role);
        this.add(box);

        this.add(add);
        this.add(delet);
        this.add(edit);
        this.add(save);
        this.add(back);

        this.add(scrollPane);
    }

    void loadtable() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            String[] temp = { user.getuserId(), user.getfullName(), user.getemail(), user.getrole() };

            model.addRow(temp);
        }
    }

    void refreshtable() {
        model.setRowCount(0);
        loadtable();
    }

}