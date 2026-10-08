import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class adminpnl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private DefaultTableModel model;
	private Connection conn;
	private JComboBox combokategori;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpnl frame = new adminpnl();
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
	public adminpnl() {
		setTitle("Admin Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 551);

		String[] info1 = { "Kategori", "Ürün", "Fiyat" };
		model = new DefaultTableModel(info1, 0);
		table = new JTable(model);

		table.setBounds(1, 266, 337, 0);

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 0, 634, 490);

		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/kafe_db", "root", "1234");
		} catch (Exception e) {

		}
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/kafe_db", "root", "1234");

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM urunler");
			while (rs.next()) {
				String ad = rs.getString("ad");
				int fiyat = rs.getInt("fiyat");
				String kategori = rs.getString("kategori");

				model.addRow(new Object[] { kategori, ad, fiyat });

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 405, 460);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(147, 77, 132, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblurun = new JLabel("Ürün:");
		lblurun.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblurun.setBounds(21, 63, 63, 32);
		panel.add(lblurun);

		JLabel lblfiyat = new JLabel("Fiyat:");
		lblfiyat.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblfiyat.setBounds(21, 127, 79, 20);
		panel.add(lblfiyat);

		textField_1 = new JTextField();
		textField_1.setBounds(147, 127, 132, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		combokategori = new JComboBox();

		combokategori.setBounds(147, 20, 116, 22);
		panel.add(combokategori);
		combokategori.addItem("İçecekler");
		combokategori.addItem("Kahvaltılıklar");
		combokategori.addItem("Tatlılar");
		combokategori.addItem("Atıştırmalık/Aperatifler");

		JLabel lblNewLabel = new JLabel("Kategori:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(21, 11, 116, 32);
		panel.add(lblNewLabel);

		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ekkategori = combokategori.getSelectedItem().toString();
				String ekurun = textField.getText();
				String ekfiyat = textField_1.getText();

				try {
					int fiyat = Integer.parseInt(ekfiyat);

					PreparedStatement pr = conn
							.prepareStatement("INSERT INTO urunler(kategori,ad,fiyat)VALUES (?,?,?)");

					pr.setString(1, ekkategori);
					pr.setString(2, ekurun);
					pr.setInt(3, fiyat);
					pr.executeUpdate();

					model.addRow(new Object[] { ekkategori, ekurun, fiyat });
					textField.setText("");
					textField_1.setText("");

				} catch (Exception ex) {
					ex.printStackTrace();

				}

			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnEkle.setBounds(10, 212, 89, 23);
		panel.add(btnEkle);

		JButton btnGuncelle = new JButton("Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {

					JOptionPane.showMessageDialog(null, "Lütfen Güncellemek İstediğiniz Ürünü Seçniz");
					return;
				}

				String eskiKategori = model.getValueAt(selectedRow, 0).toString();
				String eskiUrun = model.getValueAt(selectedRow, 1).toString();
				int eskiFiyat = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());

				String yeniKategori = combokategori.getSelectedItem().toString();
				String yeniUrun = textField.getText();
				int yeniFiyat;

				try {
					yeniFiyat = Integer.parseInt(textField_1.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Fiyat geçerli bir sayı olmalıdır!");
					return;
				}

				try {
					String sql = "UPDATE urunler SET kategori=?, ad=?, fiyat=? WHERE kategori=? AND ad=? AND fiyat=?";
					PreparedStatement pr = conn.prepareStatement(sql);
					pr.setString(1, yeniKategori);
					pr.setString(2, yeniUrun);
					pr.setInt(3, yeniFiyat);
					pr.setString(4, eskiKategori);
					pr.setString(5, eskiUrun);
					pr.setInt(6, eskiFiyat);

					int affected = pr.executeUpdate();

					if (affected > 0) {
						model.setValueAt(yeniKategori, selectedRow, 0);
						model.setValueAt(yeniUrun, selectedRow, 1);
						model.setValueAt(yeniFiyat, selectedRow, 2);

						JOptionPane.showMessageDialog(null, "Ürün başarıyla güncellendi.");
						textField.setText("");
						textField_1.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Güncelleme başarısız oldu!");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Veritabanı hatası!");
				}
			}
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnGuncelle.setBounds(126, 212, 132, 23);
		panel.add(btnGuncelle);

		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Silmek İstediğiniz Ürünü Seçin");
					return;
				}
				String kategori = model.getValueAt(selectedRow, 0).toString();
				String urun = model.getValueAt(selectedRow, 1).toString();
				int fiyat = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());

				try {
					PreparedStatement pr = conn
							.prepareStatement("DELETE from urunler WHERE kategori = ? AND ad= ? AND fiyat = ?");
					pr.setString(1, kategori);
					pr.setString(2, urun);
					pr.setInt(3, fiyat);
					int affectedRows = pr.executeUpdate();

					if (affectedRows > 0) {
						// Tablo satırını sil
						model.removeRow(selectedRow);
						JOptionPane.showMessageDialog(null, "Ürün başarıyla silindi.");
					} else {
						JOptionPane.showMessageDialog(null, "Ürün bulunamadı ya da silinemedi.");
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Silme işlemi sırasında hata oluştu!");
				}
			}
		});

		btnSil.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSil.setBounds(287, 212, 89, 23);
		panel.add(btnSil);

		JLabel gunlbl = new JLabel("Gün Sonu:");
		gunlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		gunlbl.setBounds(23, 417, 114, 32);
		panel.add(gunlbl);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(425, 11, 634, 490);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		panel_1.add(sp);

		JButton geriBtn = new JButton("Geri");
		geriBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				sipapp sA = new sipapp();
				sA.setVisible(true);
			}
		});
		geriBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		geriBtn.setBounds(10, 11, 89, 23);
		contentPane.add(geriBtn);

	}
}
