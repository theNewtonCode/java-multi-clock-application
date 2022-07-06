package ethercode_clock;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Home {

	private JFrame Home_win;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.Home_win.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		initialize();
	}

	private void initialize() {
		
		Home_win = new JFrame("Home CountOVerse");
		Home_win.getContentPane().setBackground(Color.DARK_GRAY);
		Home_win.getContentPane().setLayout(null);
		
		JLabel label1_presents = new JLabel("Ethercode presents");
		label1_presents.setFont(new Font("Palatino", Font.BOLD, 15));
		label1_presents.setForeground(Color.WHITE);
		label1_presents.setBounds(190, 58, 149, 24);
		Home_win.getContentPane().add(label1_presents);
		
		JLabel label2_title = new JLabel("count-O-verse");
		label2_title.setBackground(new Color(240, 240, 240));
		label2_title.setFont(new Font("Bookman Old Style", Font.BOLD, 45));
		label2_title.setForeground(new Color(255, 204, 51));
		label2_title.setBounds(189, 60, 354, 73);
		Home_win.getContentPane().add(label2_title);
		
		JButton alarm_button = new JButton("Set Alarm");
		alarm_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set_alarm tm = new set_alarm();
				tm.setVisible(true);
			}
		});
		alarm_button.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		alarm_button.setForeground(Color.WHITE);
		alarm_button.setBackground(new Color(0, 191, 255));
		alarm_button.setBounds(60, 151, 182, 45);
		Home_win.getContentPane().add(alarm_button);
		
		JButton timer_button = new JButton("Timer");
		timer_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer_ec tm = new timer_ec();
				tm.setVisible(true);
			}
		});
		timer_button.setForeground(Color.WHITE);
		timer_button.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		timer_button.setBackground(new Color(0, 191, 255));
		timer_button.setBounds(60, 229, 182, 45);
		Home_win.getContentPane().add(timer_button);
		
		JButton sw_button = new JButton("StopWatch");
		sw_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sw_ethercode sw = new sw_ethercode();
				sw.setVisible(true);
			}
		});
		sw_button.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		sw_button.setBackground(new Color(0, 191, 255));
		sw_button.setForeground(Color.WHITE);
		sw_button.setBounds(60, 309, 182, 45);
		Home_win.getContentPane().add(sw_button);
		
		JButton clock_button = new JButton("Time?");
		clock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analog_clock x = new analog_clock();
		         x.clockon();
			}
		});
		clock_button.setForeground(Color.WHITE);
		clock_button.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		clock_button.setBackground(new Color(0, 191, 255));
		clock_button.setBounds(361, 191, 182, 45);
		
		Home_win.getContentPane().add(clock_button);
		
		JButton theme_button = new JButton("AlterTheme");
		theme_button.setForeground(Color.WHITE);
		theme_button.setBackground(Color.PINK);
		theme_button.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 20));
		theme_button.setBounds(361, 264, 182, 45);
		Home_win.getContentPane().add(theme_button);
		
		JLabel clock_icon = new JLabel("");
		clock_icon.setIcon(new ImageIcon("images\\countoverse_icon.png"));
		clock_icon.setHorizontalAlignment(SwingConstants.CENTER);
		clock_icon.setBounds(95, 41, 94, 92);
		Home_win.getContentPane().add(clock_icon);
		
		JButton theme_1 = new JButton("");
		theme_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(theme_1.isEnabled()) {
					label1_presents.setForeground(Color.WHITE);
					Home_win.getContentPane().setBackground(Color.BLUE);
				}
			}
		});
		theme_1.setBackground(Color.BLUE);
		theme_1.setBounds(396, 330, 33, 24);
		Home_win.getContentPane().add(theme_1);
		
		JButton theme_2 = new JButton("");
		theme_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(theme_2.isEnabled()) {
					label1_presents.setForeground(Color.BLACK);
					Home_win.getContentPane().setBackground(Color.WHITE);
				}
			}
		});
		theme_2.setBackground(Color.WHITE);
		theme_2.setBounds(306, 330, 33, 24);
		Home_win.getContentPane().add(theme_2);
		
		JButton theme_3 = new JButton("");
		theme_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(theme_3.isEnabled()) {
					label1_presents.setForeground(Color.WHITE);
					Home_win.getContentPane().setBackground(Color.BLACK);
				}
			}
		});
		theme_3.setBackground(Color.BLACK);
		theme_3.setBounds(481, 330, 33, 24);
		Home_win.getContentPane().add(theme_3);
		
		JButton theme_4 = new JButton("");
		theme_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(theme_4.isEnabled()) {
					label1_presents.setForeground(Color.WHITE);
					Home_win.getContentPane().setBackground(Color.RED);
				}
			}
		});
		theme_4.setBackground(Color.RED);
		theme_4.setBounds(563, 330, 33, 24);
		
		theme_1.setVisible(false);
		theme_2.setVisible(false);
		theme_3.setVisible(false);
		theme_4.setVisible(false);
		
		theme_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theme_1.setVisible(true);
				theme_2.setVisible(true);
				theme_3.setVisible(true);
				theme_4.setVisible(true);
			}
		});
		
		Home_win.getContentPane().add(theme_4);
		
		presentTime pt = new presentTime();
		
		JLabel show_today = new JLabel("Today: "+pt.today());
		show_today.setForeground(new Color(0, 255, 0));
		show_today.setFont(new Font("Tahoma", Font.BOLD, 15));
		show_today.setBounds(315, 15, 304, 20);
		Home_win.getContentPane().add(show_today);
		Home_win.setResizable(false);
		Home_win.setBounds(100, 100, 650, 450);
		Home_win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
}
