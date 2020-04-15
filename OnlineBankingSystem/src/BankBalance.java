import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class BankBalance {

	public JFrame frame;
	private JTextField cardno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankBalance window = new BankBalance();
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
	public BankBalance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		con = connection.dbConnection();
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Card Number");
		lblAccountNumber.setBounds(124, 100, 103, 14);
		frame.getContentPane().add(lblAccountNumber);
		
		cardno = new JTextField();
		cardno.setBounds(254, 97, 230, 20);
		frame.getContentPane().add(cardno);
		cardno.setColumns(10);
		
		JButton btnNewButton = new JButton("Check Balance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT balance FROM bankbalance WHERE cardnumber = ?";
					
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, cardno.getText());
					ResultSet rs = st.executeQuery();
					rs.next();
					
					int value = rs.getInt(1);
					JOptionPane.showMessageDialog(null, value + "/-");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(124, 188, 170, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnBack.setBounds(316, 188, 168, 39);
		frame.getContentPane().add(btnBack);
	}

}
