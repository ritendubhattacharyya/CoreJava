import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;

public class Delete_by_working_status extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_by_working_status frame = new Delete_by_working_status();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;

	/**
	 * Create the frame.
	 */
	public Delete_by_working_status() {
		connection=maintable_connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "Inactive", "Condemned"}));
		comboBox.setSelectedItem(null);
		comboBox.setBounds(66, 105, 156, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String values=comboBox.getSelectedItem().toString();
					String query="delete from maintable where WORKING_STATUS='"+values+"'  ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "data deleted");
					
					pst.close();
					
					delete frame = new delete();
					frame.setVisible(true);
					dispose();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(268, 94, 145, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterTheWorkingstatus = new JLabel("Enter the Working_status and press confirm to delete the data!");
		lblEnterTheWorkingstatus.setForeground(Color.WHITE);
		lblEnterTheWorkingstatus.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEnterTheWorkingstatus.setBounds(54, 29, 359, 28);
		contentPane.add(lblEnterTheWorkingstatus);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete frame = new delete();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(174, 171, 127, 43);
		contentPane.add(btnNewButton_1);
		
		
	}
}
