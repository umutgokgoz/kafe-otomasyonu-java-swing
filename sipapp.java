import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import javax.swing.JLayeredPane;
import java.awt.Color;

public class sipapp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sipapp frame = new sipapp();
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

	public sipapp() {
		setType(Type.NORMAL);
		setTitle("Masalar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}


		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 46, 1069, 466);
		contentPane.add(panel_1);

		JButton btnNewButton_1 = new JButton("MASA 1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(1);
				dispose();
				menu.setVisible(true);
			}
		});
		panel_1.setLayout(new GridLayout(4, 5, 7, 7));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_4 = new JButton("MASA 2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				smenu menu = new smenu(2);
				menu.setVisible(true);

			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_3 = new JButton("MASA 3");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(3);
				menu.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_8 = new JButton("MASA 4");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(4);
				menu.setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_8);

		JButton btnNewButton_7 = new JButton("MASA 5");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(5);
				menu.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_7);

		JButton btnNewButton_6 = new JButton("MASA 6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(6);
				menu.setVisible(true);
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_6);

		JButton btnNewButton_5 = new JButton("MASA 7");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(7);
				menu.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_5);

		JButton btnNewButton_9 = new JButton("MASA 8");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(8);
				menu.setVisible(true);
			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_9);

		JButton btnNewButton_2 = new JButton("MASA 9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(9);
				menu.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_2);

		JButton btnNewButton = new JButton("MASA 10");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(10);
				menu.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton);

		JButton btnNewButton_10 = new JButton("MASA 11");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(11);
				menu.setVisible(true);
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_10);

		JButton btnNewButton_14 = new JButton("MASA 12");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(12);
				menu.setVisible(true);
			}
		});
		btnNewButton_14.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_14);

		JButton btnMasa = new JButton("MASA 13");
		btnMasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(13);
				menu.setVisible(true);
			}
		});
		btnMasa.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa);

		JButton btnNewButton_13 = new JButton("MASA 14");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(14);
				menu.setVisible(true);
			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_13);

		JButton btnNewButton_12 = new JButton("MASA 15");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(15);
				menu.setVisible(true);
			}
		});
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_12);

		JButton btnNewButton_11 = new JButton("MASA 16");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(16);
				menu.setVisible(true);
			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnNewButton_11);

		JButton btnMasa_1 = new JButton("MASA 17");
		btnMasa_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(17);
				menu.setVisible(true);
			}
		});
		btnMasa_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa_1);

		JButton btnMasa_2 = new JButton("MASA 18");
		btnMasa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(18);
				menu.setVisible(true);
			}
		});
		btnMasa_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa_2);

		JButton btnMasa_3 = new JButton("MASA 19");
		btnMasa_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(19);
				menu.setVisible(true);
			}
		});
		btnMasa_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa_3);

		JButton btnMasa_4 = new JButton("MASA 20");
		btnMasa_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smenu menu = new smenu(20);
				menu.setVisible(true);
			}
		});
		btnMasa_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnMasa_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 1, 1069, 34);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_15 = new JButton("Admin Giriş");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login loginPanel= new Login();
				loginPanel.setVisible(true);
				
			}
		});
		btnNewButton_15.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_15.setBounds(0, 0, 148, 34);
		panel.add(btnNewButton_15);
		
		JButton btnNewButton_15_1 = new JButton("Çıkış");
		btnNewButton_15_1.setForeground(new Color(255, 0, 0));
		btnNewButton_15_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_15_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_15_1.setBounds(921, 0, 148, 34);
		panel.add(btnNewButton_15_1);

	}
}
