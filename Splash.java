
package UniversityManagementSystem;

import java.awt.Image;
import javax.swing.ImageIcon; 
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements Runnable {
   Thread t;

   Splash() {
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icrons/maxresdefault.jpg"));
      Image i2 = i1.getImage().getScaledInstance(1000, 700, 1);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      this.add(image);
      this.t = new Thread(this);
      this.t.start();
      this.setVisible(true);
      int x = 1;

      for(int i = 2; i <= 600; ++x) {
         this.setLocation(600 - (i + x) / 2, 350 - i / 2);
         this.setSize(i + 3 * x, i + x / 2);

         try {
            Thread.sleep(10L);
         } catch (Exception var8) {
         }

         i += 4;
      }

   }

   public void run() {
      try {
         Thread.sleep(7000L);
         this.setVisible(false);
         new login();
      } catch (Exception var2) {
      }

   }

   public static void main(String[] args) {
      new Splash();
   }
}   