import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JLabel;

public class smenu extends JFrame {

	private int masaNo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane sp;
	private DefaultTableModel model;
	private Connection conn;
	private JLabel toplamtutarbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					smenu frame = new smenu(0);
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
	public void baglantiAc() {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/kafe_db", "root", "1234");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void siparisleriGetir() {

		try {
			String sql = "SELECT urun_ad, fiyat, adet FROM siparisler WHERE masa_no= ?";
			PreparedStatement pr = conn.prepareStatement(sql); // sql için sorgu ifadesi hazırlıyor verilen sql
																// sorgusunu veritabanına hazırlar parametreli güvenli
																// sorgu

			pr.setInt(1, masaNo); // ANLAMADIM
			ResultSet rs = pr.executeQuery(); // exucuteQuery SELECT için kullanılır ResultSet ise sorguda dönen
												// değişkenleri saklar.

			while (rs.next()) { // sorgudaki tüm satırları döndürüyor
				String ad = rs.getString("urun_ad");
				int fiyat = rs.getInt("fiyat");
				int adet = rs.getInt("adet");
				int tutar = fiyat * adet;
				model.addRow(new Object[] { ad, fiyat, adet, tutar }); // ANLAMADIM.
			}

			rs.close();
			pr.close();
		} catch (SQLException e) { // ssql sorgusu çalışırken hata olursa buraya yazdırıyor.
			e.printStackTrace();
		} // hata varsa konsola yazdırıyor
	}

	public void siparisKaydet(int masaNo) {
		try { // sql de hataya neden olabilecek kodları buraya yazarız

			String silSQL = "DELETE FROM siparisler WHERE masa_no=?";
			PreparedStatement silSmt = conn.prepareStatement(silSQL);
			silSmt.setInt(1, masaNo);
			silSmt.executeUpdate(); // sorguyu veritabanında çalıştırır

			for (int i = 0; i < model.getRowCount(); i++) {
				String ad = (String) model.getValueAt(i, 0);
				int fiyat = (int) model.getValueAt(i, 1);
				int adet = (int) model.getValueAt(i, 2);

				String sql = "INSERT INTO siparisler(masa_no,urun_ad,fiyat,adet)VALUES (?,?,?,?)";
				PreparedStatement pr = conn.prepareStatement(sql);

				pr.setInt(1, masaNo);
				pr.setString(2, ad);
				pr.setInt(3, fiyat);
				pr.setInt(4, adet); // bunlar yukardaki tane soru işareti yerine geçer.
				pr.executeUpdate();
			}
			System.out.println("Siparişler kaydedildi.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void toplamTutarGuncelle() { // tam anlaşılmadı
		int toplam = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			int tutar = (int) model.getValueAt(i, 3); // 3. sütun = tutar
			toplam += tutar;
		}
		toplamtutarbtn.setText(String.valueOf(toplam) + " ₺");
	}

	public void urunEkle(String urun, int fiyat) { // tam anlaşılmadı

		boolean bulundu = false;

		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0).equals(urun)) {
				int miktar = (int) model.getValueAt(i, 2);
				miktar++;
				model.setValueAt(miktar, i, 2);

				int mevcutFiyat = (int) model.getValueAt(i, 1);
				int tutar = mevcutFiyat * miktar;
				model.setValueAt(tutar, i, 3);

				System.out.println("Güncellenen ürün: " + urun + " Miktar: " + miktar + " Tutar: " + tutar); // <--
																												// kontrol
																												// için

				bulundu = true;
				break;
			}

		}
		if (!bulundu) {
			model.addRow(new Object[] { urun, fiyat, 1, fiyat });
			System.out.println("Yeni ürün eklendi: " + urun + " Fiyat: " + fiyat);

		}
		toplamTutarGuncelle();
	}

	private void urunCikar() {
		int seciliSatir = table.getSelectedRow();
		if (seciliSatir == -1) {
			JOptionPane.showMessageDialog(null, "Lütfen çıkarılacak bir ürün seçin.");
			return;
		}

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int adet = Integer.parseInt(model.getValueAt(seciliSatir, 2).toString()); // 2. sütun: adet
		int fiyat = Integer.parseInt(model.getValueAt(seciliSatir, 1).toString()); // 1. sütun: birim fiyat

		if (adet > 1) {
			model.setValueAt(adet - 1, seciliSatir, 2); // adet azalt
			model.setValueAt((adet - 1) * fiyat, seciliSatir, 3); // toplam güncelle
		} else {
			model.removeRow(seciliSatir); // adet 1 ise satırı sil
		}

		toplamTutarGuncelle(); // toplamı güncelle
	}

	public void veritabaniSiparisYukle(int masaNo) {
		try {
			// JTable içeriğini temizle
			model.setRowCount(0);

			String sql = "SELECT urun_ad, fiyat, adet FROM siparisler WHERE masa_no = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, masaNo);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				String ad = rs.getString("urun_ad");
				int fiyat = rs.getInt("fiyat");
				int adet = rs.getInt("adet");
				int tutar = fiyat * adet;
				model.addRow(new Object[] { ad, fiyat, adet, tutar });
			}
			toplamTutarGuncelle();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	////////////////////////////////////////////////////////////////////////////////////
	public void urunButonlariniYukle(String kategori, JPanel urunPanel) {
		urunPanel.removeAll(); // önceki butonları temizle

		try {
			String sql = "SELECT ad, fiyat FROM urunler WHERE kategori = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, kategori);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				String urunAd = rs.getString("ad");
				int fiyat = rs.getInt("fiyat");

				JButton urunBtn = new JButton(urunAd);
				urunBtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
				urunBtn.addActionListener(e -> urunEkle(urunAd, fiyat));

				urunPanel.add(urunBtn);
			}

			urunPanel.revalidate();
			urunPanel.repaint();

			rs.close();
			pr.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public smenu(int masaNo) {
		this.masaNo = masaNo;
		setTitle("Cafe Sipariş");
		setType(Type.NORMAL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Font butonFont = new Font("Tahoma", Font.PLAIN, 25);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 478, 301, 34);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Toplam Tutar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 169, 34);

		toplamtutarbtn = new JLabel("0 TL");
		toplamtutarbtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		toplamtutarbtn.setBounds(171, 0, 130, 34);
		panel_2.add(toplamtutarbtn);
		panel_2.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 33, 301, 447);
		contentPane.add(panel);

		String[] info1 = { "Ürün", "Fiyat", "Miktar", "Tutar" };
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		model = new DefaultTableModel(info1, 0);
		table = new JTable(model);

		baglantiAc();
		veritabaniSiparisYukle(masaNo);

		sp = new JScrollPane(table);
		panel.add(sp);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(305, 31, 764, 85);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 20, 20));

		JPanel uruns = new JPanel();
		uruns.setVisible(false);
		uruns.setLayout(new GridLayout(4, 3, 10, 10));
		uruns.setBounds(305, 127, 754, 329);
		contentPane.add(uruns);

		JButton btnIecekler = new JButton("İçecekler");
		btnIecekler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				uruns.setVisible(true);
				urunButonlariniYukle("İçecekler", uruns);

				uruns.revalidate();
				uruns.repaint();

			}
		});

		btnIecekler.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnIecekler);

		JButton btnTatlılar = new JButton("Tatlılar");
		btnTatlılar.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnTatlılar);
		btnTatlılar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				uruns.setVisible(true);
				urunButonlariniYukle("Tatlılar", uruns);

				uruns.revalidate();
				uruns.repaint();

			}
		});
		JButton atıstırmabtn = new JButton("Atıştırmalıklar / Aperatifler");
		atıstırmabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				uruns.setVisible(true);
				urunButonlariniYukle("Atıştırmalık/Aperatifler", uruns);

			}
		});
		atıstırmabtn.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(atıstırmabtn);

		JButton btnKahvaltlklar = new JButton("Kahvaltılıklar");
		btnKahvaltlklar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				uruns.setVisible(true);
				urunButonlariniYukle("Kahvaltılıklar", uruns);

				uruns.revalidate();
				uruns.repaint();

			}
		});

		btnKahvaltlklar.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_1.add(btnKahvaltlklar);

		JButton backbtn = new JButton("Geri");

		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				new sipapp().setVisible(true);
			}
		});
		backbtn.setBounds(0, 0, 94, 34);
		contentPane.add(backbtn);

		JButton kaydetbtn = new JButton("Kaydet");
		kaydetbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (conn == null) {
					JOptionPane.showMessageDialog(smenu.this, "Veritabanı bağlantısı yok!");
					return;
				}
				siparisKaydet(masaNo);
				JOptionPane.showMessageDialog(smenu.this, "Sipariş başarıyla kaydedildi!");
			}
		});

		kaydetbtn.setBounds(207, 0, 94, 34);
		contentPane.add(kaydetbtn);

		JButton cıkarbtn = new JButton("Çıkar");
		cıkarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urunCikar();
			}
		});
		cıkarbtn.setBounds(92, 0, 115, 34);
		contentPane.add(cıkarbtn);

		JButton btnNewButton = new JButton("Ödendi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "DELETE FROM siparisler WHERE masa_no = ?";
					PreparedStatement pr = conn.prepareStatement(sql);
					pr.setInt(1, masaNo);
					int deleted = pr.executeUpdate();
					pr.close();

					if (deleted > 0) {
						JOptionPane.showMessageDialog(null, "Siparişler başarıyla ödendi ve silindi.");
					} else {
						JOptionPane.showMessageDialog(null, "Bu masada sipariş bulunmamaktadır.");
					}

					// Tabloyu temizle
					model.setRowCount(0);
					toplamtutarbtn.setText("0 TL");
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Veritabanı hatası: " + ex.getMessage());
				}
			}
		});
		btnNewButton.setBounds(946, 478, 89, 23);
		contentPane.add(btnNewButton);

	}
}
