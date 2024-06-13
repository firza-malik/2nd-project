 package UniversityManagementSystem;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class TeacherLeave extends JFrame implements ActionListener {
   Choice cEmpId;
   Choice ctime;
   JDateChooser dcdate;
   JButton submit;
   JButton cancel;

   TeacherLeave() {
      this.setSize(500, 550);
      this.setLocation(550, 100);
      this.setLayout((LayoutManager)null);
      this.getContentPane().setBackground(Color.WHITE);
      JLabel heading = new JLabel("Apply Leave (Teacher)");
      heading.setBounds(40, 50, 300, 30);
      heading.setFont(new Font("Tahoma", 1, 20));
      this.add(heading);
      JLabel lblrollno = new JLabel("Search by Employee Id");
      lblrollno.setBounds(60, 100, 200, 20);
      lblrollno.setFont(new Font("Tahoma", 0, 18));
      this.add(lblrollno);
      this.cEmpId = new Choice();
      this.cEmpId.setBounds(60, 130, 200, 20);
      this.add(this.cEmpId);

      try {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from teacher");

         while(rs.next()) {
            this.cEmpId.add(rs.getString("EmpId"));
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      JLabel lbldate = new JLabel("Date");
      lbldate.setBounds(60, 180, 200, 20);
      lbldate.setFont(new Font("Tahoma", 0, 18));
      this.add(lbldate);
      this.dcdate = new JDateChooser();
      this.dcdate.setBounds(60, 210, 200, 25);
      this.add(this.dcdate);

      JLabel lbltime = new JLabel("Time Duration");
      lbltime.setBounds(60, 260, 200, 20);
      lbltime.setFont(new Font("Tahoma", 0, 18));
      this.add(lbltime);

      this.ctime = new Choice();
      this.ctime.setBounds(60, 290, 200, 20);
      this.ctime.add("Full Day");
      this.ctime.add("Half Day");
      this.add(this.ctime);

      this.submit = new JButton("Submit");
      this.submit.setBounds(60, 350, 100, 25);
      this.submit.setBackground(Color.BLACK);
      this.submit.setForeground(Color.WHITE);
      this.submit.addActionListener(this);
      this.submit.setFont(new Font("Tahoma", 1, 15));
      this.add(this.submit);

      this.cancel = new JButton("Cancel");
      this.cancel.setBounds(200, 350, 100, 25);
      this.cancel.setBackground(Color.BLACK);
      this.cancel.setForeground(Color.WHITE);
      this.cancel.addActionListener(this);            
      this.cancel.setFont(new Font("Tahoma", 1, 15));
      this.add(this.cancel);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {             
      if (ae.getSource() == this.submit) {
         String rollno = this.cEmpId.getSelectedItem();
         String date = ((JTextField)this.dcdate.getDateEditor().getUiComponent()).getText();
         String duration = this.ctime.getSelectedItem();
         String query = "insert into teacherleave values('" + rollno + "', '" + date + "', '" + duration + "')";

         try {
            Conn c = new Conn();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog((Component)null, "Leave Confirmed");
            this.setVisible(false);
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      } else {
         this.setVisible(false);
      }

   }

   public static void main(String[] args) {
      new TeacherLeave();
   }
}

