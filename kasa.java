import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class kasa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kasa frame = new kasa();
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
	public kasa() {
		setTitle("Kasa Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 65, 1069, 436);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 10, 10));
		
		JButton btnNewButton_1 = new JButton("MASA 1");
		btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				dispose(); 
				kasaodeme odemeE= new kasaodeme(1);
				odemeE.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("MASA 2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				kasaodeme odemeE= new kasaodeme(2);
				odemeE.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("MASA 3");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(3);
				odemeE.setVisible(true);
		
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_8 = new JButton("MASA 4");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(4);
				odemeE.setVisible(true);
			
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("MASA 5");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(5);
				odemeE.setVisible(true);}
		}
		);
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("MASA 6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(6);
				odemeE.setVisible(true);
				
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("MASA 7");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(7);
				odemeE.setVisible(true);
				
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_9 = new JButton("MASA 8");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(8);
				odemeE.setVisible(true);

			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_2 = new JButton("MASA 9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(9);
				odemeE.setVisible(true);

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("MASA 10");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(10);
				odemeE.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_10 = new JButton("MASA 11");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(11);
				odemeE.setVisible(true);
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_14 = new JButton("MASA 12");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(12);
				odemeE.setVisible(true);

			}
		});
		btnNewButton_14.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_14);
		
		JButton btnMasa = new JButton("MASA 13");
		btnMasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(13);
				odemeE.setVisible(true);

			}
		});
		btnMasa.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa);
		
		JButton btnNewButton_13 = new JButton("MASA 14");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(14);
				odemeE.setVisible(true);

			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_13);
		
		JButton btnNewButton_12 = new JButton("MASA 15");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(15);
				odemeE.setVisible(true);
				
			}
		});
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_12);
		
		JButton btnNewButton_11 = new JButton("MASA 16");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(16);
				odemeE.setVisible(true);

			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_11);
		
		JButton btnMasa_1 = new JButton("MASA 17");
		btnMasa_1.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(17);
				odemeE.setVisible(true);

				
			}
		});
		btnMasa_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa_1);
		
		JButton btnMasa_2 = new JButton("MASA 18");
		btnMasa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(18);
				odemeE.setVisible(true);

			}
		});
		btnMasa_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa_2);
		
		JButton btnMasa_3 = new JButton("MASA 19");
		btnMasa_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(19);
				odemeE.setVisible(true);


			}
		});
		btnMasa_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa_3);
		
		JButton btnMasa_4 = new JButton("MASA 20");
		btnMasa_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kasaodeme odemeE= new kasaodeme(20);
				odemeE.setVisible(true);

			}
		});
		btnMasa_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa_4);
		
		JButton geri_btn = new JButton("Geri");
		geri_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new sipapp().setVisible(true);
			}
		});
		geri_btn.setFont(new Font("Tahoma", Font.BOLD, 21));
		geri_btn.setBounds(0, 11, 102, 36);
		contentPane.add(geri_btn);

	}
}
