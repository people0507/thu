package Ex1;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
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
		 ArrayList<Student> ls =  ps.getListStudent();
		 for(int i=0;i<ls.size();i++) {
			 Student s = (Student) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(s.getID());
			 tbRow.add(s.getName());
			 tbRow.add(s.getClassID());
			 tbRow.add(s.getGender());
			 tbRow.add(s.getMark());
			 tbRow.add(s.Rank());
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 table.setModel(Model);
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
			tbRow.add(s.getGender());
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
		setTitle("Tra cứu sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lớp");
		lblNewLabel.setBounds(111, 47, 99, 22);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"62TH3", "62TH4", "62TH5"}));
		comboBox.setBounds(202, 48, 156, 22);
		contentPane.add(comboBox);
		

		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setBounds(206, 98, 103, 21);
		contentPane.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(348, 101, 103, 21);
		contentPane.add(rdNu);
		
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
		btnTim.setBounds(383, 48, 85, 21);
		contentPane.add(btnTim);
		
		table = new JTable();
		table.setBounds(111, 142, 385, 211);
		contentPane.add(table);
		
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Giới tính");
		lblNewLabel_1.setBounds(92, 102, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		

		//tbHeader.add("ID");
		//tbHeader.add("Name");
		//tbHeader.add("ClassID");
		//tbHeader.add("Gender");
		//tbHeader.add("Mark");
		//tbHeader.add("Result");
		//Model.setDataVector(rows, tbHeader);
		//table.setModel(Model);
		
		columns.add("ID");
		columns.add("Họ và Tên");
		columns.add("Mã lớp");
		columns.add("Giới tính");
		columns.add("Kết quả");
		columns.add("Xep loai");
		
		getAllStudent();
		
	}
	
}
