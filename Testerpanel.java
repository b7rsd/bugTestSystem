import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import java.awt.*;
import java.io.File;

public class Testerpanel extends JPanel {
    BugService bugService = new BugService();
    UserService userService = new UserService();
    FileHandler fileHandler = new FileHandler();
    DefaultTableModel model;
    File file;
    User tester;
    public Testerpanel(JFrame frame,User user) {
        Border first = BorderFactory.createLineBorder(Color.black, 5);
        Border sec = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border comp = BorderFactory.createCompoundBorder(sec, first);
        frame.getJMenuBar().getMenu(0).getItem(0).setEnabled(true);
        tester = user;
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBorder(comp);

        String[] columns = { "BugID", "BugName", "BugType", "ProjectName", "TesterName", "Developer", "Status",
                "DateOpended" };
        model = new DefaultTableModel(columns, 0);
        loadtable();
        JTable table = new JTable(model);
        table.setDefaultEditor(Object.class, null);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 300, 840, 400);
        this.add(scrollPane);

        JLabel bugID = new JLabel("bugID");
        JLabel bugName = new JLabel("bugName");
        JLabel bugType = new JLabel("bugType");
        JLabel level = new JLabel("level");
        JLabel priority = new JLabel("priority");
        JLabel dateOpend = new JLabel("dateOpend");
        JLabel assignedTo = new JLabel("assignedTo");
        JLabel tester = new JLabel("tester");
        JLabel status = new JLabel("status");
        JLabel projectName = new JLabel("projectName");
        JLabel screenshotPath = new JLabel("screenshot");

        bugID.setBounds(50, 30, 150, 50);
        bugName.setBounds(280, 30, 150, 50);
        bugType.setBounds(740, 150, 150, 50);
        level.setBounds(280, 150, 150, 50);
        priority.setBounds(510, 150, 150, 50);

        dateOpend.setBounds(970, 250, 150, 50);
        assignedTo.setBounds(740, 30, 150, 50);
        status.setBounds(970, 150, 150, 50);
        projectName.setBounds(510, 30, 150, 50);
        tester.setBounds(970, 30, 150, 50);
        screenshotPath.setBounds(50, 150, 150, 50);

        bugID.setFont(new Font("Arial", Font.PLAIN, 14));
        bugName.setFont(new Font("Arial", Font.PLAIN, 14));
        bugType.setFont(new Font("Arial", Font.PLAIN, 14));
        level.setFont(new Font("Arial", Font.PLAIN, 14));
        priority.setFont(new Font("Arial", Font.PLAIN, 14));
        dateOpend.setFont(new Font("Arial", Font.PLAIN, 14));
        assignedTo.setFont(new Font("Arial", Font.PLAIN, 14));
        status.setFont(new Font("Arial", Font.PLAIN, 14));
        projectName.setFont(new Font("Arial", Font.PLAIN, 14));
        screenshotPath.setFont(new Font("Arial", Font.PLAIN, 14));

        JTextField bugIDJTextField = new JTextField();
        JTextField bugNameJTextField = new JTextField();
        JTextField projectNameJTextField = new JTextField();
        JTextField dateOpendJTextField = new JTextField();
        JTextField testernameJTextField = new JTextField();
        dateOpendJTextField.setEditable(false);
        testernameJTextField.setText(this.tester.getfullName());
        testernameJTextField.setEditable(false);

        bugIDJTextField.setBounds(50, 80, 150, 50);
        bugNameJTextField.setBounds(280, 80, 150, 50);
        projectNameJTextField.setBounds(510, 80, 150, 50);
        dateOpendJTextField.setBounds(970, 300, 150, 50);
        testernameJTextField.setBounds(970, 80, 150, 50);


        String[] devs = userService.getAllDevelopersName().toArray(new String[0]);
        String[] testers = userService.getAllTestersName().toArray(new String[0]);
        JComboBox<Bug.BugType> bugtypeJComboBox = new JComboBox<>(Bug.BugType.values());
        JComboBox<Bug.BugLevel> buglevelJComboBox = new JComboBox<>(Bug.BugLevel.values());
        JComboBox<Bug.BugPriority> bugpriorityJComboBox = new JComboBox<>(Bug.BugPriority.values());
        JComboBox<Bug.BugStatus> bugstatusJComboBox = new JComboBox<>(Bug.BugStatus.values());
        JComboBox bugdevJComboBox = new JComboBox<>(devs);
       

        bugtypeJComboBox.setBounds(740, 200, 150, 50);
        buglevelJComboBox.setBounds(280, 200, 150, 50);
        bugpriorityJComboBox.setBounds(510, 200, 150, 50);
        bugstatusJComboBox.setBounds(970, 200, 150, 50);
        bugdevJComboBox.setBounds(740, 80, 150, 50);

        bugtypeJComboBox.setBackground(new Color(0xF2F2F2));
        buglevelJComboBox.setBackground(new Color(0xF2F2F2));
        bugpriorityJComboBox.setBackground(new Color(0xF2F2F2));
        bugstatusJComboBox.setBackground(new Color(0xF2F2F2));
        bugdevJComboBox.setBackground(new Color(0xF2F2F2));
        

        bugtypeJComboBox.setFocusable(false);
        buglevelJComboBox.setFocusable(false);
        bugpriorityJComboBox.setFocusable(false);
        bugstatusJComboBox.setFocusable(false);
        bugdevJComboBox.setFocusable(false);
       

        JButton select = new JButton("Select Image");
        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        JButton save = new JButton("Save");
        JButton report = new JButton("bugs report");

        select.setBounds(50, 200, 150, 50);
        add.setBounds(970, 380, 150, 50);
        edit.setBounds(970, 470, 150, 50);
        save.setBounds(970, 560, 150, 50);
        report.setBounds(970, 650, 150, 50);

        select.setBackground(new Color(0xF2F2F2));
        add.setBackground(new Color(0x4CAF50));
        edit.setBackground(new Color(0x1E88E5));
        save.setBackground(new Color(0x1565C0));
        report.setBackground(Color.gray);

        select.setFocusable(false);
        add.setFocusable(false);
        edit.setFocusable(false);
        save.setFocusable(false);
        report.setFocusable(false);

        select.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int res = fileChooser.showOpenDialog(null);

            if (res == JFileChooser.APPROVE_OPTION) {
                file = new File((fileChooser.getSelectedFile().getAbsolutePath()));
            }

        });

        add.addActionListener(e -> {

            if (file == null) {
                     JOptionPane.showOptionDialog(null, "please select a screenshot", "Screenshot", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE, null, null, 0);
                                return;
            }
            if (!(bugService.IsNotEmptyBug(bugIDJTextField.getText().trim(), bugNameJTextField.getText().trim(), projectNameJTextField.getText().trim()))) {
                 JOptionPane.showOptionDialog(null, "please enter id & name & projectname for the bug", "invalid inputs", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE, null, null, 0);
            }else{

            Bug bug = new Bug(bugIDJTextField.getText().trim(), bugNameJTextField.getText().trim(),
                    bugtypeJComboBox.getSelectedItem().toString(),
                    bugpriorityJComboBox.getSelectedItem().toString(), buglevelJComboBox.getSelectedItem().toString(),
                    projectNameJTextField.getText().trim(),
                    this.tester.getfullName(), bugdevJComboBox.getSelectedItem().toString(),
                    bugstatusJComboBox.getSelectedItem().toString(),
                    java.time.LocalDate.now().toString(), file.getAbsolutePath());

            bugService.addBug(bug);

            bugIDJTextField.setText(null);
            bugNameJTextField.setText(null);
            projectNameJTextField.setText(null);
            bugtypeJComboBox.setSelectedIndex(0);
            buglevelJComboBox.setSelectedIndex(0);
            bugpriorityJComboBox.setSelectedIndex(0);
            bugdevJComboBox.setSelectedIndex(0);
            bugstatusJComboBox.setSelectedIndex(0);
            file = null;

            refreshtable();            }
        });

        edit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showOptionDialog(null, "plese select a row",
                        " no user selected", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
            } else {
                Bug bug = bugService.GetBugByID(table.getValueAt(row, 0).toString());

                bugIDJTextField.setEditable(false);
                bugIDJTextField.setText(bug.getbugID());
                bugNameJTextField.setText(bug.getbugName());
                projectNameJTextField.setText(bug.getprojectName());
                dateOpendJTextField.setText(bug.getdateOpended());
                bugtypeJComboBox.setSelectedItem(bug.getbugType());
                buglevelJComboBox.setSelectedItem(bug.getlevel());
                bugpriorityJComboBox.setSelectedItem(bug.getpriority());
                bugdevJComboBox.setSelectedItem(bug.getassignedTo());
                bugstatusJComboBox.setSelectedItem(bug.getstatus());
                

            }
        });

        save.addActionListener(e -> {
            
            if (file == null) {
                     JOptionPane.showOptionDialog(null, "please select a screenshot", "Screenshot", JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE, null, null, 0);
                                return;
            }
            if (!(bugService.IsNotEmptyBug(bugIDJTextField.getText().trim(), bugNameJTextField.getText().trim(), projectNameJTextField.getText().trim()))) {
                
            }else{
                Bug bug = bugService.GetBugByID(bugIDJTextField.getText());

            bug.setbugName(bugNameJTextField.getText());
            bug.setbugType(bugtypeJComboBox.getSelectedItem().toString());
            bug.setlevel(buglevelJComboBox.getSelectedItem().toString());
            bug.setpriority(bugpriorityJComboBox.getSelectedItem().toString());
            bug.setAssignedTo(bugdevJComboBox.getSelectedItem().toString());
            bug.setStatus(bugstatusJComboBox.getSelectedItem().toString());
            bug.setprojectName(projectNameJTextField.getText());

            bugIDJTextField.setEditable(true);

            bugIDJTextField.setText(null);
            bugNameJTextField.setText(null);
            projectNameJTextField.setText(null);
            dateOpendJTextField.setText(null);
            bugtypeJComboBox.setSelectedIndex(0);
            buglevelJComboBox.setSelectedIndex(0);
            bugpriorityJComboBox.setSelectedIndex(0);
            bugdevJComboBox.setSelectedIndex(0);
            bugstatusJComboBox.setSelectedIndex(0);
            
            
            bugService.refreshBugs();
            refreshtable();
            }

        });

        report.addActionListener(e -> {
            JOptionPane.showOptionDialog(null, bugService.bugReport(), "Report", JOptionPane.YES_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, 0);
        });

        this.add(bugID);
        this.add(bugName);
        this.add(bugType);
        this.add(level);
        this.add(priority);
        this.add(dateOpend);
        this.add(assignedTo);
        this.add(status);
        this.add(projectName);
        this.add(tester);
        this.add(screenshotPath);

        this.add(bugIDJTextField);
        this.add(bugNameJTextField);
        this.add(projectNameJTextField);
        this.add(dateOpendJTextField);

        this.add(select);
        this.add(add);
        this.add(edit);
        this.add(save);
        this.add(report);

        
        this.add(bugtypeJComboBox);
        this.add(buglevelJComboBox);
        this.add(bugpriorityJComboBox);
        this.add(bugstatusJComboBox);
        this.add(bugdevJComboBox);
    }

    void loadtable() {
        List<Bug> bugs = bugService.getBugsByTester(tester.getfullName());
        for (Bug bug : bugs) {
            String[] temp = { bug.getbugID(), bug.getbugName(), bug.getbugType(), bug.getprojectName(),
                    bug.gettesterName(), bug.getassignedTo(), bug.getstatus(), bug.getdateOpended() };

            model.addRow(temp);
        }
    }

    void refreshtable() {
        model.setRowCount(0);
        loadtable();
    }
}