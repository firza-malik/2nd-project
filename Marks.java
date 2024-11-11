package UniversityManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {

    String rollno;
    JButton cancel;

    Marks(String rollno) {
        this.rollno = rollno;

        setSize(500, 700);
        setLocation(400, 150);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        // Load and display image
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icrons/download (1).jpg"));
            Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(50, 20, 400, 300);
            add(image);
        } catch (Exception e) {
            System.out.println("Image not found: " + e.getMessage());
        }

        JLabel heading = new JLabel("Quaid-e-Awam University");
        heading.setBounds(100, 330, 300, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(100, 360, 300, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number: " + rollno);
        lblrollno.setBounds(60, 400, 300, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 430, 300, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(60, 470, 400, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(60, 500, 400, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(60, 530, 400, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(60, 560, 400, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(60, 590, 400, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);

        try {
            Conn c = new Conn();

            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '" + rollno + "'");
            if (rs1.next()) {
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }

            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '" + rollno + "'");
            if (rs2.next()) {
                sub1.setText(sub1.getText() + " ------------ " + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + " ------------ " + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + " ------------ " + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + " ------------ " + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + " ------------ " + rs2.getString("marks5"));
                lblsemester.setText("Semester: " + rs2.getString("semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(180, 650, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Marks("");
    }
}
