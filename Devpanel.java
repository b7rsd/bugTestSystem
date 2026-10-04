import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Devpanel extends JPanel {
    DefaultTableModel model;
    BugService bugService = new BugService();
    UserService userService = new UserService();
    FileHandler fileHandler = new FileHandler();
    User develeper;
    public Devpanel(JFrame frame,User user) {
        Border first = BorderFactory.createLineBorder(Color.black, 5);
        Border sec = BorderFactory.createEmptyBorder(15, 10, 10, 10);
        Border comp = BorderFactory.createCompoundBorder(sec, first);
        frame.getJMenuBar().getMenu(0).getItem(0).setEnabled(true);
        develeper = user;
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
        scrollPane.setBounds(100, 50, 1000, 400);

        JPanel panel = new JPanel();
        panel.setBounds(100, 500, 1000, 200);
        panel.setLayout(null);

        Border statusbordar = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "update bug status",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.PLAIN, 14),
                Color.black);

        panel.setBorder(statusbordar);

        JLabel newStatus = new JLabel("new status");

        newStatus.setFont(new Font("Arial", Font.PLAIN, 14));

        newStatus.setBounds(200, 50, 100, 50);

        JComboBox<Bug.BugStatus> bugstatusJComboBox = new JComboBox<>(Bug.BugStatus.values());
        bugstatusJComboBox.setBounds(300, 50, 150, 50);

        JButton updateButton = new JButton("update status");
        updateButton.setBounds(600, 50, 150, 50);

        updateButton.setBackground(new Color(0x1E88E5));

        updateButton.setFocusable(false);

        updateButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showOptionDialog(null, "plese select a row",
                        " no user selected", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
            } else {
                Bug bug = bugService.GetBugByID(table.getValueAt(row, 0).toString());

                bug.setStatus(bugstatusJComboBox.getSelectedItem().toString());

                bugService.refreshBugs();
                bugstatusJComboBox.setSelectedIndex(0);
                refreshtable();
            }
        });

        panel.add(updateButton);

        panel.add(bugstatusJComboBox);

        panel.add(newStatus);

        this.add(panel);
        this.add(scrollPane);

    }

    void loadtable() {
        List<Bug> bugs = bugService.getBugsByDeveloper(develeper.getfullName());
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
