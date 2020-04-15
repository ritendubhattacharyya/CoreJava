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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Delete_by_mac extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_by_mac frame = new Delete_by_mac();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	public Delete_by_mac() {
		connection=maintable_connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setDocument(new limitation(17));
		textField.setBounds(38, 90, 171, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from maintable where MAC_ADD='"+textField.getText()+"'  ";
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
		btnNewButton.setBounds(272, 85, 107, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterTheMacadd = new JLabel("Enter the mac_add and press confirm to delete the data!");
		lblEnterTheMacadd.setForeground(Color.WHITE);
		lblEnterTheMacadd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEnterTheMacadd.setBounds(38, 21, 331, 27);
		contentPane.add(lblEnterTheMacadd);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete frame = new delete();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(139, 168, 123, 36);
		contentPane.add(btnNewButton_1);
	}
}
