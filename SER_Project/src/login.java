import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField textFieldUN;
	private JPasswordField PasswordField;

	/**
	 * Create the frame.
	 */
	public login() {
		connection=Sqlite_Connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(74, 52, 92, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(188, 49, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(74, 117, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(188, 114, 133, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from  Employeeinfo where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField.getText() );
					pst.setString(2, passwordField.getText() );
					
					ResultSet rs=pst.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count = count + 1;
					}
					
					if(count ==1)
					{
						//JOptionPane.showMessageDialog(null, "username and password is correct");
						query frame = new query();
						frame.setVisible(true);
						dispose();
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "duplicate uername and password");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "username and password is incorrect please try again...");
					}
					rs.close();
					pst.close();
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setBounds(74, 165, 247, 36);
		contentPane.add(btnNewButton);
		
		JButton btnSignup = new JButton("signup");
		btnSignup.setBackground(Color.LIGHT_GRAY);
		btnSignup.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup frame = new signup();
				frame.setVisible(true);
				dispose();
			}
		});
		btnSignup.setBounds(74, 212, 247, 38);
		contentPane.add(btnSignup);
	}

}
