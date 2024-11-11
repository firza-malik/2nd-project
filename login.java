package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{

    JButton login,cancel;
    
    JTextField tfusername,tfpassword;

    login() {
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        JLabel lb1username=new JLabel("Username");
        lb1username.setBounds(40, 20, 100, 20);
        add(lb1username);

        tfusername=new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);       
        
        JLabel lb1password=new JLabel("Password");
        lb1password.setBounds(40, 70, 100, 20);
        add(lb1password);

        tfpassword=new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);

        login=new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.orange);
        login.addActionListener(this);
        login.setFont(new Font("Arial",Font.BOLD, 15));
        add(login);       
        
        cancel=new JButton("Cancel");
        cancel.setBounds(190, 140, 120, 30);
        cancel.setBackground(Color.ORANGE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Arial",Font.BOLD, 15 ));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icrons/download.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 20, 200, 200);
        add(image);



        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
    
            // Correct SQL query with placeholders
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            try {
                Conn c = new Conn();
                // Use PreparedStatement to prevent SQL injection
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
    
                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }



    public static void main(String[] args) {
        new login();
    }
}
