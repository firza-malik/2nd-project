package UniversityManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame {
   About() {
      this.setSize(700, 500);
      this.setLocation(400, 150);
      this.getContentPane().setBackground(Color.LIGHT_GRAY);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icrons/images (5).jpeg"));
      Image i2 = i1.getImage().getScaledInstance(200, 200, 1);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(350, 0, 300, 200);
      this.add(image);
      JLabel heading = new JLabel("<html>University<br/>Management System</html>");
      heading.setBounds(70, 20, 300, 130);
      heading.setFont(new Font("Tahoma", 1, 40));
      this.add(heading);
      JLabel name = new JLabel("Developed By: Programmers");
      name.setBounds(70, 220, 550, 40);
      name.setFont(new Font("Tahoma", 1, 30));
      this.add(name);
      JLabel rollno = new JLabel("Roll number: (23AI36),(23AI53),(23AI43),(23AI42)");
      rollno.setBounds(70, 280, 550, 40);
      rollno.setFont(new Font("Tahoma", 1, 15));
      this.add(rollno);
      JLabel contact = new JLabel("Contact: Programmers3@gmail.com");
      contact.setBounds(70, 340, 550, 40);
      contact.setFont(new Font("Tahoma", 0, 20));
      this.add(contact);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
   }

   public static void main(String[] args) {
      new About();
   }
}
