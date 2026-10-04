import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import java.awt.*;

public class Adminpanelbugs extends JPanel {
    DefaultTableModel model;
    BugService bugService = new BugService();
    UserService userService = new UserService();
    FileHandler fileHandler = new FileHandler();

    Adminpanelbugs(JFrame frame) {
        Border first = BorderFactory.createLineBorder(Color.black, 5);
        Border sec = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border comp = BorderFactory.createCompoundBorder(sec, first);
        frame.getJMenuBar().getMenu(0).getItem(0).setEnabled(true);

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
        JButton button = new JButton("add-del Users");
        button.setBounds(100, 30, 200, 50);
        button.setBackground(Color.gray);
        button.setFocusable(false);

        button.addActionListener(e -> {

            Adminpanelusers userspanel = new Adminpanelusers(frame);
            frame.setContentPane(userspanel);
            frame.revalidate();
            frame.repaint();
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 100, 700, 600);
        this.add(button);
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
