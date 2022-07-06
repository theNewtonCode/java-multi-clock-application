package ethercode_clock;

import static java.lang.Math.*;
import java.time.LocalTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 
public class analog_clock extends JPanel{
   final float degrees06 = (float) (PI / 30);
   final float degrees30 = degrees06 * 5;
   final float degrees90 = degrees30 * 3;
 
   final int size = 300;
   final int spacing = 10;
   final int diameter = size - 2 * spacing;
   final int cx = diameter / 2 + spacing;
   final int cy = diameter / 2 + spacing;
 
   public analog_clock() {
      setPreferredSize(new Dimension(size, size));
      setBackground(Color.GRAY);
 
      new Timer(1000, (ActionEvent e) -> {
         repaint();
      }).start();
   }
 
   public void paintComponent(Graphics clock_) {
      super.paintComponent(clock_);
      Graphics2D clock = (Graphics2D) clock_;
      clock.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON);
 
      drawFace(clock);
 
      final LocalTime time = LocalTime.now();
      int hour = time.getHour();
      int minute = time.getMinute();
      int second = time.getSecond();
 
      float angle = degrees90 - (degrees06 * second);
      drawHand(clock, angle, diameter / 2 - 30, Color.red);
 
      float minsecs = (minute + second / 60.0F);
      angle = degrees90 - (degrees06 * minsecs);
      drawHand(clock, angle, diameter / 3 + 10, Color.blue);
 
      float hourmins = (hour + minsecs / 60.0F);
      angle = degrees90 - (degrees30 * hourmins);
      drawHand(clock, angle, diameter / 4 + 10, Color.blue);
   }
 
   private void drawFace(Graphics2D clock) {
      clock.setStroke(new BasicStroke(2));
      clock.setColor(Color.white);
      clock.fillOval(spacing, spacing, diameter, diameter);
      clock.setColor(Color.black);
      clock.drawOval(spacing, spacing, diameter, diameter);
   }
 
   private void drawHand(Graphics2D clock, float angle, int radius, Color color) {
      int x = cx + (int) (radius * cos(angle));
      int y = cy - (int) (radius * sin(angle));
      clock.setColor(color);
      clock.drawLine(cx, cy, x, y);
   }
 
   public void clockon() {
      SwingUtilities.invokeLater(() -> {
         JFrame analog = new JFrame("CountOVerse Analog");
         analog.setTitle("EtherCode Analog");
         analog.setResizable(false);
         analog.add(new analog_clock(), BorderLayout.CENTER);
         analog.pack();
         analog.setLocationRelativeTo(null);
         analog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         analog.setVisible(true);
      });
   }
}

