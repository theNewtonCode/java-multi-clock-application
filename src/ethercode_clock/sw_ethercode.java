package ethercode_clock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class sw_ethercode extends JFrame {
	
	static int milis;
	static int secs;
	static int mins;
	static int hours;
	static boolean state = true; 

	private JPanel timer;
	private JButton stop_timer;
	private JButton start_timer;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sw_ethercode frame = new sw_ethercode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public sw_ethercode() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CountOverse StopWatch");
		setBounds(100, 100, 450, 200);
		timer = new JPanel();
		timer.setBackground(new Color(147, 112, 219));
		timer.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.RED));
		setContentPane(timer);
		timer.setLayout(null);
		
		JLabel lhour = new JLabel("00 :");
		lhour.setFont(new Font("Arial Black", Font.BOLD, 38));
		lhour.setBounds(46, 10, 80, 66);
		timer.add(lhour);
		
		JLabel lmin = new JLabel("00 :");
		lmin.setFont(new Font("Arial Black", Font.BOLD, 38));
		lmin.setBounds(137, 10, 80, 66);
		timer.add(lmin);
		
		JLabel lsec = new JLabel("00");
		lsec.setFont(new Font("Arial Black", Font.BOLD, 38));
		lsec.setBounds(227, 10, 80, 66);
		timer.add(lsec);
		
		start_timer = new JButton("Start");
		start_timer.setForeground(new Color(255, 255, 255));
		start_timer.setBackground(new Color(0, 255, 0));
		start_timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = true;
				Thread timer = new Thread()
				{
					public void run() {
						for(;;) {
							if(state==true){
								try
								{
									sleep(1);
									if(milis>700) {
										milis=0;
										secs++;
									}
									if(secs>60) {
										milis=0;
										secs=0;
										mins++;
									}
									if(mins>60) {
										milis=0;
										secs=0;
										mins=0;
										hours++;
									}
									milis++;
									lsec.setText(""+secs);
									lmin.setText(mins+" :");
									lhour.setText(hours+" :");
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
		start_timer.setBounds(154, 96, 118, 38);
		timer.add(start_timer);
		
		stop_timer = new JButton("Stop");
		stop_timer.setForeground(new Color(255, 255, 255));
		stop_timer.setBackground(new Color(255, 0, 0));
		stop_timer.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		stop_timer.setFont(new Font("Bell MT", Font.BOLD, 25));
		stop_timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
			}
		});
		stop_timer.setBounds(300, 96, 118, 38);
		timer.add(stop_timer);
		
		
		JButton reset_timer = new JButton("Reset");
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
		reset_timer.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.CYAN));
		reset_timer.setFont(new Font("Bell MT", Font.BOLD, 25));
		reset_timer.setBounds(317, 26, 101, 50);
		timer.add(reset_timer);
	}
}
