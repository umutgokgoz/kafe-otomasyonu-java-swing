import java.awt.EventQueue;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class kasaodeme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int masaNo;
	private JTable table;
	private DefaultTableModel model;
	private Connection conn;
	private int toplamTutar = 0;
	private JLabel lblToplamTutar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kasaodeme frame= new kasaodeme(0);
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
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kafe_db","root","1234");
		    
		} catch (SQLException e) {
			
		    e.printStackTrace();
		}
	}
	
public void siparisleriGetir() {
	toplamTutar = 0;
	try {
	String sql = "SELECT urun_ad, fiyat, adet FROM siparisler WHERE masa_no=?";
			PreparedStatement pr =conn.prepareStatement(sql);
			pr.setInt(1, masaNo);
			ResultSet rs= pr.executeQuery();
			
			while (rs.next()) {
				String ad = rs.getString("urun_ad");
				int fiyat= rs.getInt("fiyat");
				int adet= rs.getInt("adet");
				int tutar = fiyat* adet;
				toplamTutar+= tutar;
				model.addRow(new Object[] {ad, fiyat, adet, tutar});

			}
			
            lblToplamTutar.setText("Toplam Tutar: 0");

	}catch (SQLException e) {
		e.printStackTrace();
	}
}
	public kasaodeme(int masaNo) {
		setTitle("Adisyon");
		this.masaNo=masaNo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(273, 11, 486, 490);
		contentPane.add(panel);
		
		String[] info1 = {"Ürün","Fiyat","Miktar","Tutar"};
		model = new DefaultTableModel(info1,0);
		table = new JTable(model);
		
		JScrollPane sp= new JScrollPane(table);
		sp.setBounds(0, 0, 486, 465);
		
		panel.add(sp);
		
		lblToplamTutar = new JLabel("Toplam Tutar:");
		lblToplamTutar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblToplamTutar.setBounds(0, 464, 486, 26);
		lblToplamTutar.setText("Toplam: " + toplamTutar + " ₺");
		panel.add(lblToplamTutar);
		
		JButton geri_btn = new JButton("Geri");
		geri_btn.setBounds(10, 11, 89, 23);
		geri_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new kasa().setVisible(true);
			
			}
		});
		geri_btn.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(geri_btn);
		
		JButton btnNewButton = new JButton("Ödendi");
		btnNewButton.setBounds(875, 469, 151, 32);
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        try {
			            String sql = "DELETE FROM siparisler WHERE masa_no = ?";
			            PreparedStatement pr = conn.prepareStatement(sql);
			            pr.setInt(1, masaNo);
			            int deleted = pr.executeUpdate();
			            pr.close();

			            if(deleted > 0) {
			                JOptionPane.showMessageDialog(null, "Siparişler başarıyla ödendi ve silindi.");
			            } else {
			                JOptionPane.showMessageDialog(null, "Bu masada sipariş bulunmamaktadır.");
			            }

			            // Tabloyu temizle
			            model.setRowCount(0);
			            toplamTutar = 0;
			            lblToplamTutar.setText("Toplam Tutar: 0");
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Veritabanı hatası: " + ex.getMessage());
			        }
			    }
			});	
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(btnNewButton);
		
		baglantiAc();
		siparisleriGetir();
        lblToplamTutar.setText("Toplam Tutar: " + toplamTutar+ " TL");

	}
}
