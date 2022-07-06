package ethercode_clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import jaco.mp3.player.MP3Player;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class play_sound extends JFrame {

	private JPanel Sound_alarm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					play_sound frame = new play_sound();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
set_alarm x = new set_alarm();
public String aud1 = x.aud;
			
	MP3Player sound1 = new MP3Player(new File(aud1));
	public play_sound() {
		sound1.play();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		Sound_alarm = new JPanel();
		Sound_alarm.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Sound_alarm);
		Sound_alarm.setLayout(null);
		Sound_alarm.setBackground(new Color(221, 160, 221));

		JButton stop_alarm = new JButton("Stop");
		stop_alarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound1.stop();
			}
		});
		stop_alarm.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		stop_alarm.setBounds(148, 157, 138, 54);
		stop_alarm.setBackground(Color.RED);
		stop_alarm.setForeground(Color.WHITE);
		stop_alarm.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		Sound_alarm.add(stop_alarm);
		
		JLabel lblNewLabel = new JLabel("Time is up!");
		lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 30));
		lblNewLabel.setBounds(107, 50, 338, 76);
		Sound_alarm.add(lblNewLabel);
	}
}
