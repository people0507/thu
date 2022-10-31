package Ex1;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Student extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel  Model =  new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_Student ps = new Process_Student();
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiem;
	
	public void getAllStudent() {
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
	
	
	public void addStudent( String ID,String Name,String IDClass,String Gender, double Mark) {
		if (Process_Student.insertStudent(ID, Name, IDClass, Gender, Mark) == true)
		{
		
			Model.setRowCount(0);
			ArrayList<Student> ls = ps.getListStudent();
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
		setTitle("Thêm mới sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		
		JLabel lblHTn = new JLabel("Họ tên");
		
		JLabel lblLp = new JLabel("Lớp");
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		
		JLabel lblim = new JLabel("Điểm");
		
		JComboBox cbLop = new JComboBox();
		cbLop.setModel(new DefaultComboBoxModel(new String[] {"62TH4", "62TH5", "62CNPM"}));
		
		JRadioButton rdNam = new JRadioButton("Nam");
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách sinh viên");
		
		table = new JTable();
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		
		txtDiem = new JTextField();
		txtDiem.setColumns(10);
		
		JButton btnThem = new JButton("Thêm sinh viên");
		
		btnThem.addActionListener(new ActionListener() {
			private String Gender;

			public void actionPerformed(ActionEvent e) {
				if(rdNam.isSelected() == true) {
					addStudent(txtMa.getText(), txtTen.getText(), 
							(String)cbLop.getSelectedItem(), "Nam", Double.parseDouble(txtDiem.getText()));
				}
				if(rdNu.isSelected()== true) {
					addStudent(txtMa.getText(), txtTen.getText(), 
							(String)cbLop.getSelectedItem(), "Nữ", Double.parseDouble(txtDiem.getText()));
				}
				
				
				//Process_Student.insertStudent(ID, Name, IDClass, Gender, null);
			
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLp, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblim, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHTn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cbLop, 0, 114, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdNam, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(rdNu, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtMa)
								.addComponent(txtTen)
								.addComponent(txtDiem)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(195)
							.addComponent(btnThem))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHTn, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblim, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(cbLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdNam)
								.addComponent(rdNu))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnThem)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
		contentPane.add(btnThem);
		
		contentPane.add(table);
		columns.add("Mã Sinh Viên");
		columns.add("Họ và Tên");
		columns.add("Mã lớp");
		columns.add("Giới tính");
		columns.add("Kết quả");
		columns.add("Xep loai");
		
		getAllStudent();
	}
}
