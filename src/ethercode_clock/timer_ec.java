package ethercode_clock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class timer_ec extends JFrame {
	
	static int milis;
	static int secs;
	static int mins;
	static int hours;
	static boolean state = true; 

	private JPanel timer;
	private JButton start_timer;
	private JTextField sethour;
	private JTextField setmin;
	private JTextField setsec;
	private JButton btnNewButton;
	public static String aud = "alarmsounds\\loud.mp3";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timer_ec frame = new timer_ec();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public timer_ec() {
		setTitle("CountOVerse Timer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		timer = new JPanel();
		timer.setBackground(new Color(238, 232, 170));
		timer.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		setContentPane(timer);
		timer.setLayout(null);
		
		sethour = new JTextField();
		sethour.setText("Hours");
		sethour.setBorder(new LineBorder(new Color(255, 215, 0), 3));
		sethour.setFont(new Font("Tahoma", Font.ITALIC, 20));
		sethour.setBounds(66, 67, 60, 27);
		timer.add(sethour);
		sethour.setVisible(false);
		sethour.setColumns(10);
		
		setmin = new JTextField();
		setmin.setText("Mins");
		setmin.setBorder(new LineBorder(new Color(255, 215, 0), 3));
		setmin.setFont(new Font("Tahoma", Font.ITALIC, 20));
		setmin.setColumns(10);
		setmin.setBounds(137, 67, 60, 27);
		setmin.setVisible(false);
		timer.add(setmin);
		
		setsec = new JTextField();
		setsec.setText("Secs");
		setsec.setBorder(new LineBorder(new Color(255, 215, 0), 3));
		setsec.setFont(new Font("Tahoma", Font.ITALIC, 20));
		setsec.setColumns(10);
		setsec.setBounds(207, 67, 50, 27);
		setsec.setVisible(false);
		timer.add(setsec);
		

		
		JLabel lhour = new JLabel("00 :");
		lhour.setFont(new Font("Arial Black", Font.BOLD, 25));
		lhour.setBounds(87, 26, 60, 50);
		timer.add(lhour);
		
		JLabel lmin = new JLabel("00 :");
		lmin.setFont(new Font("Arial Black", Font.BOLD, 25));
		lmin.setBounds(148, 26, 58, 50);
		timer.add(lmin);
		
		JLabel lsec = new JLabel("00");
		lsec.setFont(new Font("Arial Black", Font.BOLD, 25));
		lsec.setBounds(207, 26, 60, 50);
		timer.add(lsec);
		
		start_timer = new JButton("Start");
		start_timer.setForeground(new Color(255, 255, 255));
		start_timer.setBackground(new Color(255, 105, 180));
		start_timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hours = Integer.parseInt(sethour.getText());
				mins = Integer.parseInt(setmin.getText());
				secs = Integer.parseInt(setsec.getText());
				state = true;
				Thread timer = new Thread()
				{
					public void run() {
						for(;;) {
							if(state==true){
								try
								{
									sleep(1);
									if(milis>600&&secs>0) {
										milis=0;
										secs--;
									}
									if(secs<0&&mins>0) {
										milis=0;
										secs=60;
										mins--;
									}
									if(mins<0&&hours>0) {
										milis=0;
										secs=0;
										mins=60;
										hours--;
									}
									milis++;
									lsec.setText(""+secs);
									lmin.setText(mins+" : ");
									lhour.setText(hours+" : ");
									if(hours==0&&mins==0&&secs==0) {
										play_sound sound = new play_sound();
										sound.aud1 = "alarmsounds\\energy.mp3";
										sound.setVisible(true);
										break;
									}
								}
								catch(Exception e) {
								}
							}
							else {
								break;
							}
							
						}
					}
				};
				timer.start();
			}
		});
		start_timer.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(245, 255, 250)));
		start_timer.setFont(new Font("Bell MT", Font.BOLD, 25));
		start_timer.setBounds(216, 104, 118, 38);
		timer.add(start_timer);
		
		
		JButton reset_timer = new JButton("Reset");
		reset_timer.setForeground(new Color(255, 255, 255));
		reset_timer.setBackground(new Color(30, 144, 255));
		reset_timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state =false;
				hours = 0;
				mins = 0;
				secs =0;
				milis =0;
				 
				lhour.setText("00 :");
				lmin.setText("00 :");
				lsec.setText("00");
			}
		});
		reset_timer.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 255, 255)));
		reset_timer.setFont(new Font("Bell MT", Font.BOLD, 25));
		reset_timer.setBounds(325, 44, 101, 50);
		timer.add(reset_timer);
		

		btnNewButton = new JButton("SetTime");
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sethour.setVisible(true);
				setmin.setVisible(true);
				setsec.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD, 22));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setBounds(66, 105, 118, 38);
		timer.add(btnNewButton);
	}
}
