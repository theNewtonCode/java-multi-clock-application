package ethercode_clock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class set_alarm extends JFrame {

	private JPanel contentPane;
	private JTextField sethh;
	private JTextField setss;
	private JTextField setmm;
	private JLabel current_disp;
	private JButton start_alarm;
	private JRadioButton am_sel, pm_sel ;
	private int thour;
	private int tmin;
	private int tsec;
	private boolean state;
	private int mili;
	private int hh;
	private int mm;
	private int ss;
	private byte m;
	private JButton setaudio;
	private JRadioButton a1;
	private JRadioButton a2;
	private JRadioButton a3;
	public static String aud = "alarmsounds\\energy.mp3";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					set_alarm frame = new set_alarm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public set_alarm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CountOVerse Alarm");
		setBounds(100, 100, 650, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("Let's wake you UP!");
		heading.setBorder(null);
		heading.setForeground(new Color(0, 0, 51));
		heading.setBackground(Color.CYAN);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 28));
		heading.setBounds(-14, 10, 664, 48);
		contentPane.add(heading);
		
		JButton set_alarm = new JButton("set ALARM");
		set_alarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setmm.setVisible(true);
				sethh.setVisible(true);
				setss.setVisible(true);
				start_alarm.setVisible(true);
				am_sel.setVisible(true);
				pm_sel.setVisible(true);
			}
		});
		set_alarm.setForeground(new Color(255, 255, 255));
		set_alarm.setBackground(new Color(255, 0, 0));
		set_alarm.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		set_alarm.setFont(new Font("Albertus Extra Bold", Font.PLAIN, 20));
		set_alarm.setBounds(260, 68, 159, 52);
		contentPane.add(set_alarm);
		
		sethh = new JTextField();
		sethh.setForeground(new Color(139, 0, 0));
		sethh.setHorizontalAlignment(SwingConstants.CENTER);
		sethh.setFont(new Font("Arial Black", Font.BOLD, 30));
		sethh.setText("HH");
		sethh.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, null, null, null));
		sethh.setBounds(32, 142, 159, 48);
		contentPane.add(sethh);
		sethh.setColumns(10);
		sethh.setVisible(false);
		
		setss = new JTextField();
		setss.setForeground(new Color(139, 0, 0));
		setss.setFont(new Font("Arial Black", Font.BOLD, 30));
		setss.setHorizontalAlignment(SwingConstants.CENTER);
		setss.setText("SS");
		setss.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, null, null, null));
		setss.setBounds(370, 142, 159, 48);
		contentPane.add(setss);
		setss.setColumns(10);
		setss.setVisible(false);
		
		setmm = new JTextField();
		setmm.setForeground(new Color(139, 0, 0));
		setmm.setFont(new Font("Arial Black", Font.PLAIN, 30));
		setmm.setText("MM");
		setmm.setHorizontalAlignment(SwingConstants.CENTER);
		setmm.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, null, null, null));
		setmm.setBounds(201, 142, 159, 48);
		contentPane.add(setmm);
		setmm.setColumns(10);
		setmm.setVisible(false);
		
		start_alarm = new JButton("Let's Start");
		start_alarm.setForeground(new Color(255, 255, 255));
		start_alarm.setBackground(new Color(255, 105, 180));
		start_alarm.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		start_alarm.setFont(new Font("Albertus Extra Bold", Font.PLAIN, 20));
		start_alarm.setBounds(260, 291, 135, 48);
		contentPane.add(start_alarm);
		start_alarm.setVisible(false);
		
		presentTime x = new presentTime();
		hh = x.hour;
		mm = x.min;
		ss = x.sec;
		
		current_disp = new JLabel();
		current_disp.setHorizontalAlignment(SwingConstants.CENTER);
		if(x.am_pm.equals("AM"))
		current_disp.setText("current: "+hh+":"+mm+" AM");
		if(x.am_pm.equals("PM")) {
			hh = hh+12;
			current_disp.setText("current: "+hh+":"+mm+" PM");
		}
		current_disp.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		current_disp.setBackground(new Color(255, 105, 180));
		current_disp.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
		current_disp.setForeground(new Color(0, 0, 0));
		current_disp.setBounds(150, 229, 339, 45);
		contentPane.add(current_disp);
		
		am_sel = new JRadioButton("AM");
		am_sel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(am_sel.isSelected()) {
					pm_sel.setSelected(false);
					m = 1;
				}

			}
		});
		am_sel.setBackground(new Color(0, 191, 255));
		am_sel.setFont(new Font("Tahoma", Font.BOLD, 13));
		am_sel.setBounds(545, 142, 71, 18);
		contentPane.add(am_sel);
		am_sel.setVisible(false);

		
		pm_sel = new JRadioButton("PM");
		pm_sel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pm_sel.isSelected()) {
					am_sel.setSelected(false);
					m = 0;
				}

			}
		});
		pm_sel.setBackground(new Color(0, 191, 255));
		pm_sel.setFont(new Font("Tahoma", Font.BOLD, 13));
		pm_sel.setBounds(545, 172, 71, 18);
		contentPane.add(pm_sel);
		
		setaudio = new JButton("Tunes");
		setaudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a1.setVisible(true);
				a2.setVisible(true);
				a3.setVisible(true);
			}
		});
		setaudio.setForeground(Color.MAGENTA);
		setaudio.setFont(new Font("Albertus Extra Bold", Font.BOLD | Font.ITALIC, 24));
		setaudio.setBounds(26, 64, 128, 68);
		contentPane.add(setaudio);
		
		a1 = new JRadioButton("Energetic");
		a1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(a1.isSelected()) {
					aud = "alarmsounds\\energy.mp3";
					a2.setSelected(false);
					a3.setSelected(false);
				}

			}
		});
		a1.setBounds(150, 64, 103, 21);
		contentPane.add(a1);
		
		a2 = new JRadioButton("Slow Loud");
		a2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(a2.isSelected()) {
					aud = "alarmsounds\\loud.mp3";
					a1.setSelected(false);
					a3.setSelected(false);
				}

			}
		});
		a2.setBounds(150, 87, 103, 21);
		contentPane.add(a2);
		
		a3 = new JRadioButton("Joyful Vibe");
		a3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(a3.isSelected()) {
					aud = "alarmsounds\\flower.mp3";
					a2.setSelected(false);
					a1.setSelected(false);
				}

			}
		});
		a3.setBounds(150, 110, 103, 21);
		contentPane.add(a3);
		
		a1.setVisible(false);
		a2.setVisible(false);
		a3.setVisible(false);
		
		pm_sel.setVisible(false);


		start_alarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = true;
				thour = Byte.parseByte(sethh.getText());
				tmin  = Byte.parseByte(setmm.getText());
				tsec = Byte.parseByte(setss.getText());
				presentTime y = new presentTime();
				hh = y.hour;
				mm = y.min;
				ss = y.sec;
				int u1, m1;
				if(y.am_pm.equals("PM"))
				hh = hh+12;
	
				u1 = thour;
				m1 = tmin;
				if(thour<hh) {
					u1=thour+12;
				}
				if(tmin<mm) {
					m1=tmin+60;
					u1=thour-1;}
				
					u1-=hh;
					m1-=mm;
					
				if(m==1) {
				JOptionPane.showMessageDialog(null, "You have "+u1+" hours & "+m1+" mins left");
				}
				if(m==0) {
					if(thour<hh) {
				JOptionPane.showMessageDialog(null, "You have "+(u1+12)+" hours & "+(m1)+" mins left");
					}
					else
				JOptionPane.showMessageDialog(null, "You have "+(u1)+" hours & "+(m1)+" mins left");
			}
				Thread alarm = new Thread()
				{
					public void run() {

						for(;;) {
							if(state==true){
								try
								{
									sleep(1);
									if(mili>900) {
										mili=0;
										ss++;
									}
									if(ss>59) {
										mili=0;
										ss=0;
										mm++;
									}
									if(mm>59) {
										mili=0;
										ss=0;
										mm=0;
										hh++;
									}
									mili++;
									current_disp.setText("current: "+hh+":"+mm+":"+ss);
									
									if(m==1&&hh==thour && mm==tmin) {
										play_sound wake = new play_sound();
										wake.setVisible(true);
										break;
									}
									if(m==0&& hh==thour&& mm==tmin) {
										play_sound wake = new play_sound();
										wake.setVisible(true);
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
				alarm.start();
			}
		});
		
		
	}
}
