package Ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class GUI_Update extends JFrame {

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Update frame = new GUI_Update();
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
	public GUI_Update() {
		setTitle("Cập nhật thông tin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setBounds(102, 24, 103, 20);
		contentPane.add(lblNewLabel);
		
		txtMa = new JTextField();
		txtMa.setBounds(215, 25, 116, 19);
		contentPane.add(txtMa);
		txtMa.setColumns(10);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(358, 24, 85, 21);
		contentPane.add(btnTim);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setBounds(102, 73, 103, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lớp");
		lblNewLabel_2.setBounds(102, 108, 103, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setBounds(102, 148, 103, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Điểm");
		lblNewLabel_4.setBounds(102, 188, 103, 20);
		contentPane.add(lblNewLabel_4);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(215, 74, 116, 19);
		contentPane.add(txtTen);
		
		txtDiem = new JTextField();
		txtDiem.setColumns(10);
		txtDiem.setBounds(215, 189, 116, 19);
		contentPane.add(txtDiem);
		
		JComboBox cbLop = new JComboBox();
		cbLop.setBounds(215, 108, 116, 21);
		contentPane.add(cbLop);
		
		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setBounds(208, 148, 67, 21);
		contentPane.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(295, 148, 51, 21);
		contentPane.add(rdNu);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(358, 188, 85, 21);
		contentPane.add(btnUpdate);
	}

}
