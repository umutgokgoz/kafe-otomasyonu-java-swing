import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textKullanici;
	private JPasswordField passwordField;
	private JButton cıkısBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblifre = new JLabel("Şifre");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblifre.setBounds(335, 209, 149, 40);
		contentPane.add(lblifre);

		JLabel lblKullancAd = new JLabel("Kullanıcı Adı");
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblKullancAd.setBounds(335, 158, 149, 40);
		contentPane.add(lblKullancAd);

		textKullanici = new JTextField();
		textKullanici.setBounds(511, 171, 124, 23);
		contentPane.add(textKullanici);
		textKullanici.setColumns(10);

		JButton btnNewButton = new JButton("Giriş");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kAdi = textKullanici.getText();
				String sifre = passwordField.getText();

				if (kAdi.equals("admin") && sifre.equals("ruhi123")) {

					dispose();
					adminpnl adminp = new adminpnl();
					adminp.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Şifre Hatalı");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(496, 332, 97, 40);
		contentPane.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(511, 222, 124, 23);
		contentPane.add(passwordField);

		cıkısBtn = new JButton("Çıkış");
		cıkısBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				sipapp sA = new sipapp();
				sA.setVisible(true);
			}
		});
		cıkısBtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		cıkısBtn.setBounds(360, 332, 97, 40);
		contentPane.add(cıkısBtn);

	}
}
