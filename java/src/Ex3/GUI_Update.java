package Ex3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI_Update extends JFrame {

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiem;
	private JComboBox comboBox;

	Process_Student ps = new Process_Student();
	

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentID = new JLabel("Mã sinh viên");
		lblStudentID.setBounds(70, 20, 85, 13);
		contentPane.add(lblStudentID);
		
		JLabel lblStudentName = new JLabel("Họ tên");
		lblStudentName.setBounds(70, 57, 45, 13);
		contentPane.add(lblStudentName);
		
		JLabel lblLp = new JLabel("Lớp");
		lblLp.setBounds(70, 80, 45, 13);
		contentPane.add(lblLp);
		
		JLabel lblStudentGender = new JLabel("Giới tính");
		lblStudentGender.setBounds(70, 103, 57, 13);
		contentPane.add(lblStudentGender);
		
		JLabel lblStudentMark = new JLabel("Điểm");
		lblStudentMark.setBounds(70, 126, 45, 13);
		contentPane.add(lblStudentMark);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"62TH3", "62TH4", "62TH5"}));
		comboBox.setBounds(165, 76, 110, 21);
		contentPane.add(comboBox);
		
		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setBounds(158, 99, 57, 21);
		contentPane.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(230, 99, 45, 21);
		contentPane.add(rdNu);
		
		txtMa = new JTextField();
		txtMa.setBounds(165, 17, 110, 19);
		contentPane.add(txtMa);
		txtMa.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(165, 54, 110, 19);
		contentPane.add(txtTen);
		
		
		
		txtDiem = new JTextField();
		txtDiem.setBounds(165, 123, 110, 19);
		contentPane.add(txtDiem);
		txtDiem.setColumns(10);
		
		
		
		JLabel lblUpdateStudent = new JLabel("");
		lblUpdateStudent.setBounds(187, 171, 45, 13);
		contentPane.add(lblUpdateStudent);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st = ps.getStudent_byID(txtMa.getText());
				txtTen.setText(st.getName());
				for (int j = 0; j < comboBox.getItemCount(); j++) {
					if (((String) comboBox.getItemAt(j)).equals(st.getClassID())) {
						comboBox.setSelectedIndex(j);
					}
				}
				if(st.getGender()==true) {
					rdNam.setSelected(true);
					rdNu.setSelected(false);
				}
				if(st.getGender()==false) {
					rdNu.setSelected(true);
					rdNam.setSelected(false);
				}
				txtDiem.setText(String.valueOf(st.getMark()));
				
			}
		});
		btnTim.setBounds(310, 16, 96, 21);
		contentPane.add(btnTim);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		
		btnCapnhat.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if(rdNam.isSelected()==true) 
				{
					ps.updateStudent(txtMa.getText(),txtTen.getText(),(String)comboBox.getSelectedItem(),true,Double.parseDouble(txtDiem.getText()));
					
				}
				if(rdNu.isSelected()==true) 
				{
					ps.updateStudent(txtMa.getText(),txtTen.getText(),(String)comboBox.getSelectedItem(),false,Double.parseDouble(txtDiem.getText()));
					
				}
				
			}
		});
		btnCapnhat.setBounds(310, 99, 96, 21);
		contentPane.add(btnCapnhat);
		
		
	}
}
