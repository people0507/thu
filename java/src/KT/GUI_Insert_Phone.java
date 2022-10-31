package KT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI_Insert_Phone extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPrice;
	private JTextField txtAmount;

	DefaultTableModel  Model =  new DefaultTableModel();
	Process_Phone ps = new Process_Phone();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Insert_Phone frame = new GUI_Insert_Phone();
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
	public GUI_Insert_Phone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(101, 20, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(101, 43, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Year");
		lblNewLabel_2.setBounds(101, 65, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Company");
		lblNewLabel_3.setBounds(101, 88, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(101, 111, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setBounds(101, 134, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		txtID = new JTextField();
		txtID.setBounds(189, 17, 96, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JTextField txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(189, 40, 96, 19);
		contentPane.add(txtName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(189, 108, 96, 19);
		contentPane.add(txtPrice);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(189, 131, 96, 19);
		contentPane.add(txtAmount);
		
		JComboBox cbYear = new JComboBox();
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"2006", "2020", "2022"}));
		cbYear.setBounds(189, 61, 96, 21);
		contentPane.add(cbYear);
		
		JComboBox cbCompany = new JComboBox();
		cbCompany.setModel(new DefaultComboBoxModel(new String[] {"Apple", "SamSung"}));
		cbCompany.setBounds(189, 84, 96, 21);
		contentPane.add(cbCompany);
	
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ps.insertPhone(txtID.getText(),txtName.getText(),Integer.parseInt((String)cbYear.getSelectedItem()),(String)cbCompany.getSelectedItem(),Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtAmount.getText()));
			}
		});
		btnAdd.setBounds(147, 171, 85, 21);
		contentPane.add(btnAdd);
		
	}



	
	
}
