package Service;

import java.awt.EventQueue;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class GUI_Service extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtID;
	private JTextField txtPrice;
	
	DefaultTableModel  Model =  new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_Service ps = new Process_Service();
	private JTextField txtService;
	
	//Model.setColumnIdentifiers(new Object[]{"ID","Service", "Price"});

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Service frame = new GUI_Service();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void get_AllService() {
	
		Model.setDataVector(rows, columns);
		table.setModel(Model);
		 ArrayList<Service> ls =  ps.get_ListService();
		 for(int i=0;i<ls.size();i++) {
			 Service s = (Service) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(s.getServiceID());
			 tbRow.add(s.getName());
			 tbRow.add(s.getPrice());
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 table.setModel(Model);
		 
	}
	// add
	public  void addService(String serviceID,String Name,double Price) {
		if (ps.add_Service(serviceID, Name, Price) == true) {
			Model.setRowCount(0);
			ArrayList<Service> ls = ps.get_ListService();
			for (int i = 0; i < ls.size(); i++) {
				Service s = (Service) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getServiceID());
				tbRow.add(s.getName());
				tbRow.add(s.getPrice());	
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
		
	}
	
	public  void updateService(String serviceID,String Name,double Price) {
		if (ps.update_Service(serviceID, Name, Price) == true) {
			Model.setRowCount(0);
			ArrayList<Service> ls = ps.get_ListService();
			for (int i = 0; i < ls.size(); i++) {
				Service s = (Service) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getServiceID());
				tbRow.add(s.getName());
				tbRow.add(s.getPrice());	
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
	}
	
	public  void deleteService(String serviceID) {
		if (ps.delete_Service(serviceID) == true) {
			Model.setRowCount(0);
			ArrayList<Service> ls = ps.get_ListService();
			for (int i = 0; i < ls.size(); i++) {
				Service s = (Service) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getServiceID());	
				tbRow.add(s.getName());
				tbRow.add(s.getPrice());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
	}
	
	
	
	
	
	
	
	

	/**
	 * Create the frame.
	 */
	public GUI_Service() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH DỊCH VỤ");
		lblNewLabel.setBounds(303, 41, 158, 33);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(391, 95, 333, 222);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				txtID.setText((String)(Model.getValueAt(index,0)));
				txtService.setText((String)(Model.getValueAt(index,1)));
				txtPrice.setText(String.valueOf(Model.getValueAt(index,2)));
			}
		});

		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "QU\u1EA2N L\u00DD D\u1ECACH V\u1EE4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(55, 96, 307, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã dịch vụ");
		lblNewLabel_1.setBounds(51, 40, 80, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên dịch vụ");
		lblNewLabel_1_1.setBounds(51, 71, 70, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giá dịch vụ");
		lblNewLabel_1_2.setBounds(51, 104, 70, 13);
		panel.add(lblNewLabel_1_2);
		
		txtID = new JTextField();
		txtID.setBounds(126, 37, 149, 19);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(126, 98, 149, 19);
		panel.add(txtPrice);
		
		JButton btnAddService = new JButton("Thêm");
		btnAddService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("") || txtService.getText().equals("") || txtPrice.getText().equals("")) {
					showMessageDialog(null, "Please enter enough information.");
				}else{
	                    ArrayList<Service> arr = ps.get_ListService();
	                    boolean checkSame = false;
	                    for (int i = 0; i < arr.size(); i++) {
	                    	Service s = (Service) arr.get(i);
	                        if (txtID.getText().equals(s.getServiceID())) {
	                            checkSame = true;
	                        }
	                    }
	                    if (checkSame) showMessageDialog(null,"ID already exists.");        
	                    else {
	                    	int result = JOptionPane.showConfirmDialog(contentPane,"Do you want to insert this service?", "Insert",
	     			               JOptionPane.YES_NO_OPTION,
	     			               JOptionPane.QUESTION_MESSAGE);
	     			            if(result == JOptionPane.YES_OPTION){
	     			            	addService(txtID.getText(),txtService.getText(),Double.parseDouble(txtPrice.getText()));
	     			            	txtID.setText(null);
	    							txtService.setText(null);
	    							txtPrice.setText(null);
	     			            }
	                    }
				}
			}
		});
		btnAddService.setBounds(37, 154, 70, 21);
		panel.add(btnAddService);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(contentPane,"Do you want to update this service?", "Update",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	updateService(txtID.getText(),txtService.getText(),Double.parseDouble(txtPrice.getText()));
			            	txtID.setText(null);
							txtService.setText(null);
							txtPrice.setText(null);
			            }
			}
		});
		btnEdit.setBounds(126, 154, 70, 21);
		panel.add(btnEdit);
		
		JButton btnDel = new JButton("Xóa");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(contentPane,"Do you want to delete this service?", "Delete",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			               deleteService(txtID.getText());
							txtID.setText(null);
							txtService.setText(null);
							txtPrice.setText(null);
			            }
			}
		});
		btnDel.setBounds(69, 198, 70, 21);
		panel.add(btnDel);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(167, 198, 70, 21);
		panel.add(btnExit);
		
		txtService = new JTextField();
		txtService.setBounds(126, 68, 149, 19);
		panel.add(txtService);
		txtService.setColumns(10);
		
		
		
		columns.add("Mã dịch vụ");
		columns.add("Tên dịch vụ");
		columns.add("Giá dịch vụ");
		
		get_AllService();
		
	}
}
