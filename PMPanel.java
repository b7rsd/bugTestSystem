import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class PMPanel extends JPanel {
    DefaultTableModel model;
    BugService bugService = new BugService();
    UserService userService = new UserService();
    FileHandler fileHandler = new FileHandler();

    public PMPanel(JFrame frame) {
       Border first = BorderFactory.createLineBorder(Color.black, 5);
        Border sec = BorderFactory.createEmptyBorder(15, 10, 10, 10);
        Border comp = BorderFactory.createCompoundBorder(sec, first);
        frame.getJMenuBar().getMenu(0).getItem(0).setEnabled(true);

        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBorder(comp);

        String[] columns = { "BugID", "BugName", "BugType", "ProjectName", "TesterName", "Developer", "Status","DateOpended" };
        model = new DefaultTableModel(columns, 0);
        loadtable();
        JTable table = new JTable(model);
        table.setDefaultEditor(Object.class, null);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 150, 1000, 500);

        JButton report = new JButton("bugs report");
        report.setBounds(100, 50, 150, 50);
        report.setBackground(Color.gray);
        report.setFocusable(false);

        report.addActionListener(e -> {
                JOptionPane.showOptionDialog(null, bugService.bugReport(), "Report", JOptionPane.YES_OPTION
                , JOptionPane.INFORMATION_MESSAGE, null, null, 0);
            });


        this.add(report);
        this.add(scrollPane);
    }

    void loadtable() {
        List<Bug> bugs = bugService.getAllBugs();
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
