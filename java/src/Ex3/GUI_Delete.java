package Ex3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Delete extends JFrame {

	private JPanel contentPane;
	private JTextField txtMsv;

	Process_Student ps = new Process_Student();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Delete frame = new GUI_Delete();
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
	public GUI_Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setBounds(72, 45, 74, 13);
		contentPane.add(lblNewLabel);
		
		txtMsv = new JTextField();
		txtMsv.setBounds(156, 42, 96, 19);
		contentPane.add(txtMsv);
		txtMsv.setColumns(10);
		
		JButton btnNewButton = new JButton("Xóa sinh viên");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ps.delStudent(txtMsv.getText());
			}
		});
		btnNewButton.setBounds(295, 41, 104, 21);
		contentPane.add(btnNewButton);
	}
}
