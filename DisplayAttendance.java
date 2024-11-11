package UniversityManagementSystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class DisplayAttendance extends JFrame {

    JTable table;

    DisplayAttendance() {
        setTitle("Student Attendance");
        setSize(700, 400);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 660, 300);
        add(scrollPane);

        model.addColumn("ID");
        model.addColumn("Roll Number");
        model.addColumn("Date");
        model.addColumn("Status");

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM attendance");

            while (rs.next()) {
                String id = rs.getString("id");
                String rollno = rs.getString("rollno");
                String date = rs.getString("date");
                String status = rs.getString("status");

                model.addRow(new Object[]{id, rollno, date, status});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DisplayAttendance();
    }
}

