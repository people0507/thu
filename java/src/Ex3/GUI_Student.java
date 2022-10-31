package Ex3;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI_Student extends JFrame {

	private JPanel contentPane;
	private JTextField txtMsv;
	private JTextField txtMark;
	private JTextField txtName;
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
	
	public  void addStudent(String ID, String Name, boolean Gender, String ClassID, double Mark) {
        if (ps.insertStudent(ID, Name, Gender, ClassID, Mark) == true) {
            Model.setRowCount(0);
            ArrayList<Student> ls = ps.getListSyudent();
            for (int i = 0; i < ls.size(); i++) {
                Student s = (Student) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getID());
                tbRow.add(s.getName());
                tbRow.add(s.getClassID());
                if(s.getGender()==true) {
                     tbRow.add("Nam");
                 }
                 if(s.getGender()==false) {
                     tbRow.add("Nữ");
                 }
                tbRow.add(s.getMark());
                tbRow.add(s.Rank());

                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
        }

    }
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Student frame = new GUI_Student();
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
	public GUI_Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setBounds(128, 25, 79, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblTn = new JLabel("Tên");
		lblTn.setBounds(128, 56, 79, 13);
		contentPane.add(lblTn);
		
		JLabel lblLp = new JLabel("Lớp");
		lblLp.setBounds(128, 79, 79, 13);
		contentPane.add(lblLp);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(128, 102, 79, 13);
		contentPane.add(lblGiiTnh);
		
		JLabel lblim = new JLabel("Điểm");
		lblim.setBounds(128, 131, 79, 13);
		contentPane.add(lblim);
		
		txtMsv = new JTextField();
		txtMsv.setBounds(220, 22, 119, 19);
		contentPane.add(txtMsv);
		txtMsv.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"62TH1", "62TH3", "62TH4", "62TH5"}));
		comboBox.setBounds(217, 79, 122, 21);
		contentPane.add(comboBox);
		
		JRadioButton rbMale = new JRadioButton("Nam");
		rbMale.setBounds(227, 98, 54, 21);
		contentPane.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("Nữ");
		rbFemale.setBounds(304, 98, 103, 21);
		contentPane.add(rbFemale);
		
		txtMark = new JTextField();
		txtMark.setColumns(10);
		txtMark.setBounds(217, 128, 122, 19);
		contentPane.add(txtMark);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(220, 53, 119, 19);
		contentPane.add(txtName);
		
		JButton btnAdd = new JButton("Thêm sinh viên");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbMale.isSelected()==true) {
                    addStudent(txtMsv.getText(),txtName.getText(),true,(String)comboBox.getSelectedItem(),Double.parseDouble(txtMark.getText()));
                }
                if(rbFemale.isSelected()==true) {
                    addStudent(txtMsv.getText(),txtName.getText(),false,(String)comboBox.getSelectedItem(),Double.parseDouble(txtMark.getText()));
                }
			}
		});
		btnAdd.setBounds(389, 52, 123, 21);
		contentPane.add(btnAdd);
		
		table = new JTable();
		table.setBounds(91, 186, 387, 156);
		contentPane.add(table);
		
		
		columns.add("ID");
		columns.add("Họ và Tên");
		columns.add("Mã lớp");
		columns.add("Giới tính");
		columns.add("Kết quả");
		columns.add("Xep loai");
		
		getAllStudent();
	}
}


