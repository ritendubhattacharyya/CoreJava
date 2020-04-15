import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class LogIn {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection con = null;
	public LogIn() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		con = connection.dbConnection();
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 450, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setUndecorated(true);
		
		JLabel lblUserName = new JLabel("Number");
		lblUserName.setForeground(Color.RED);
		lblUserName.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblUserName.setBounds(116, 77, 71, 20);
		frame.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(116, 108, 225, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Pin");
		lblPassword.setForeground(Color.RED);
		lblPassword.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblPassword.setBounds(116, 153, 71, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 178, 225, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(new Color(255, 204, 255));
		btnLogIn.setFont(new Font("MV Boli", Font.BOLD, 14));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM userdetails WHERE cardnumber=? AND pinno=?";
					PreparedStatement loginCheck = con.prepareStatement(query);
					loginCheck.setString(1, textField.getText());
					loginCheck.setString(2, passwordField.getText());
					
					ResultSet rs = loginCheck.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count++;
					}
					if(count == 1)
					{
//						JOptionPane.showMessageDialog(null, "login successful...");
						
						frame.dispose();
						Home window = new Home();
						window.frame.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Entered either wrong cardnumber or pinno please enter again");
					}
					loginCheck.close();
					rs.close();
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnLogIn.setBounds(116, 225, 89, 39);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setFont(new Font("MV Boli", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					SignUp1 window = new SignUp1();
					window.frame.setVisible(true);
//					LogIn window = new LogIn();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(235, 225, 106, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnX = new JButton("X");
		btnX.setSelected(true);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(128, 0, 0));
		btnX.setFont(new Font("MV Boli", Font.BOLD, 11));
		btnX.setBounds(400, 0, 50, 27);
		frame.getContentPane().add(btnX);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setForeground(new Color(128, 0, 128));
		lblLogIn.setFont(new Font("MV Boli", Font.BOLD, 16));
		lblLogIn.setBounds(192, 11, 89, 42);
		frame.getContentPane().add(lblLogIn);
	}
}
