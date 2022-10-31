package Ex3;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;



public class GUI_finding extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	DefaultTableModel  Model =  new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_Student ps = new Process_Student();
	

	
	public void getAllStudent() {
	
		Model.setDataVector(rows, columns);
		table.setModel(Model);
		 ArrayList<Student> ls =  ps.getListSyudent();
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
		 table.setModel(Model);
	}
	
	public void getStudent_byClass_Gender(String ClassID, Boolean Gender) {
		Model.setRowCount(0);
		ArrayList<Student> ls = ps.getStudent_byClass_Gender(ClassID, Gender);
		for (int i = 0; i < ls.size(); i++) {
			Student s = (Student) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getID());
			tbRow.add(s.getName());
			tbRow.add(s.getClassID());
			//tbRow.add(s.getGender());
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
		table.setModel(Model);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_finding frame = new GUI_finding();
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
	public GUI_finding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lớp");
		lblNewLabel.setBounds(79, 32, 45, 13);
		contentPane.add(lblNewLabel);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(46, 110, 348, 153);
		contentPane.add(table);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"62TH3", "62TH4", "62TH5"}));
		comboBox.setBounds(159, 28, 131, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Giới tính");
		lblNewLabel_1.setBounds(79, 63, 60, 13);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setBounds(160, 63, 103, 21);
		contentPane.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(277, 63, 103, 21);
		contentPane.add(rdNu);
		
		JButton btnTim = new JButton("Tìm kiếm");
		
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdNam.isSelected() == true) {
					
					getStudent_byClass_Gender((String)comboBox.getSelectedItem(), true);
				}
				if(rdNu.isSelected() == true) {
					getStudent_byClass_Gender((String)comboBox.getSelectedItem(), false);
				}
				
				
			}
		});
		btnTim.setBounds(311, 28, 85, 21);
		contentPane.add(btnTim);

		columns.add("ID");
		columns.add("Họ và Tên");
		columns.add("Mã lớp");
		columns.add("Giới tính");
		columns.add("Kết quả");
		columns.add("Xep loai");
		
		getAllStudent();
	}
}
