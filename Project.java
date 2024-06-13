package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    Project() {
        setSize(1500, 890);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icrons/quest8.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1450, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        // Object JMenuBar
        JMenuBar mb = new JMenuBar();
        
        // New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
       
        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        mb.add(details);
       
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails .addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails .addActionListener(this);
        details.add(studentDetails);
       
        // Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);
       
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave .addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave .addActionListener(this);
        leave.add(studentLeave);

        // Leave Details
        JMenu leaveDetail = new JMenu("Leave Details");
        leaveDetail.setForeground(Color.BLACK);
        mb.add(leaveDetail);
       
        JMenuItem facultyLeaveDetail = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetail.setBackground(Color.WHITE);
        facultyLeaveDetail .addActionListener(this);
        leaveDetail.add(facultyLeaveDetail);

        JMenuItem studentLeaveDetail = new JMenuItem("Student Leave Details");
        studentLeaveDetail.setBackground(Color.WHITE);
        studentLeaveDetail .addActionListener(this);

        leaveDetail.add(studentLeaveDetail);
        
        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        mb.add(exam);
       
        JMenuItem examinationDetail = new JMenuItem("Examination Results");
        examinationDetail.setBackground(Color.WHITE);
        examinationDetail.addActionListener(this);
        exam.add(examinationDetail);

        JMenuItem enterMark = new JMenuItem("Enter Mark");
        enterMark .addActionListener(this);;
        enterMark.setBackground(Color.WHITE);
        exam.add(enterMark);

        // Update Information
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);
       
        JMenuItem updateFaculty = new JMenuItem("Update Faculty Details");
        updateFaculty.setBackground(Color.WHITE);
        updateFaculty .addActionListener(this);
        updateInfo.add(updateFaculty);

        JMenuItem updateStudent = new JMenuItem("Update Student Details");
        updateStudent.setBackground(Color.WHITE);
        updateStudent .addActionListener(this);
        updateInfo.add(updateStudent);
        
        // Fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        mb.add(fee);
       
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure .addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);
        
        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);
       
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        JMenu About = new JMenu("About");
        About.setForeground(Color.BLACK);
        mb.add(About);
       
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        About.add(ab);

        
        // Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);
       
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
       
        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
          String msg = ae.getActionCommand();
          if(msg.equals("Exit")){
            setVisible(false);
        } else if(msg.equals("Calculator")){
            try {

                Runtime.getRuntime().exec("calc.exe");

            } catch (Exception e) {
                
            }
        }else if (msg.equals("Notepad")){

            try {

                Runtime.getRuntime().exec("notepad.exe");

            } catch (Exception e) {
                
            }

        }else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }else if(msg.equals("New Student Information")){
            new AddStudent();
        }
        else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        }else if(msg.equals("View Student Details")){
            new StudentDetails();
        }else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }else if(msg.equals("Student Leave")){
            new StudentLeave();
        }else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }else if(msg.equals("Enter Mark")){
            new EnterMarks();
        }else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }else if(msg.equals("About")){
            new About();
        }else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }






    }
    public static void main(String[] args) {
        new Project();
        
    }
    

} 

      
