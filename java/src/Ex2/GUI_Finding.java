package Ex2;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI_Finding extends JFrame {

	private JPanel contentPane1;
	private JTable table1;
	
	private JComboBox comboBox;
	DefaultTableModel  Model =  new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_Student ps = new Process_Student();
	

	
	public void getAllStudent() {
	
		Model.setDataVector(rows, columns);
		table1.setModel(Model);
		 ArrayList<Student> ls =  ps.getListStudent();
		 for(int i=0;i<ls.size();i++) {
			 Student s = (Student) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(s.getID());
			 tbRow.add(s.getName());
			 tbRow.add(s.getClassID());
			 if(s.getGender() == true) {
				 tbRow.add("Nam");
			 }
			 else {
				 tbRow.add("Nữ");
			 }
			 tbRow.add(s.getMark());
			 tbRow.add(s.Rank());
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 table1.setModel(Model);
	}
	
	public void getStudent_by(String IDClass, String Gender) {
		Model.setRowCount(0);
		ArrayList<Student> ls = ps.getStudent_by(IDClass, Gender);
		for (int i = 0; i < ls.size(); i++) {
			Student s = (Student) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getID());
			tbRow.add(s.getName());
			tbRow.add(s.getClassID());
			if(s.getGender() == true) {
				 tbRow.add("Nam");
			 }
			 else {
				 tbRow.add("Nữ");
			 }
			tbRow.add(s.getMark());
			tbRow.add(s.Rank());
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		table1.setModel(Model);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Finding frame = new GUI_Finding();
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
	public GUI_Finding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lớp");
		lblNewLabel.setBounds(68, 28, 45, 13);
		contentPane1.add(lblNewLabel);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(68, 51, 65, 13);
		contentPane1.add(lblGiiTnh);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"62TH3", "62TH4", "62TH5"}));
		comboBox.setBounds(139, 24, 112, 21);
		contentPane1.add(comboBox);
		
		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setBounds(139, 47, 103, 21);
		contentPane1.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(244, 47, 103, 21);
		contentPane1.add(rdNu);
		
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdNam.isSelected() == true) {
					
					getStudent_by((String)comboBox.getSelectedItem(), "Nam");
				}
				if(rdNu.isSelected() == true) {
					getStudent_by((String)comboBox.getSelectedItem(), "Nữ");
				}
				
			}
		});
		btnTim.setBounds(291, 24, 85, 21);
		contentPane1.add(btnTim);
		
		table1 = new JTable();
		table1.setBounds(52, 95, 341, 158);
		contentPane1.add(table1);
		
		columns.add("ID");
		columns.add("Họ và Tên");
		columns.add("Mã lớp");
		columns.add("Giới tính");
		columns.add("Kết quả");
		columns.add("Xep loai");
		
		getAllStudent();
		
		
	}
}
