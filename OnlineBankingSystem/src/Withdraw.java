import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw {

	public JFrame frame;
	private JTextField accountno;
	private JTextField amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
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
	public Withdraw() {
		initialize();
	}
	Connection con = null;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		con = connection.dbConnection();
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(199, 102, 92, 14);
		frame.getContentPane().add(lblAccountNumber);
		
		accountno = new JTextField();
		accountno.setBounds(301, 99, 192, 20);
		frame.getContentPane().add(accountno);
		accountno.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(199, 160, 68, 14);
		frame.getContentPane().add(lblAmount);
		
		amount = new JTextField();
		amount.setBounds(301, 157, 192, 20);
		frame.getContentPane().add(amount);
		amount.setColumns(10);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					String query ="SELECT balance FROM bankbalance WHERE cardnumber = ?";
					PreparedStatement st = con.prepareStatement(query);
					
					st.setString(1, accountno.getText());
					ResultSet rs = st.executeQuery();
					int count = 0, value = 0, diff = 0;
					while(rs.next())
					{
						count++;
						if(count == 1)
						{
							value = rs.getInt(1);
							break;
						}
					}
					int a = Integer.parseInt(amount.getText());
					if(value > 0 && value >= a)
					{
						diff = value - a;
						String update = "UPDATE bankbalance SET balance = '"+ diff +"' WHERE cardnumber = '"+ accountno.getText() +"' ";
						PreparedStatement st1 = con.prepareStatement(update);
						st1.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Cash succesfully withdrawn");
						
						String updatems = "INSERT INTO ministatement(date, time, details, cardnumber) VALUES(?,?,?,?)";
						
						
						LocalDate dt = DateTime.generateDate();
						LocalTime t = DateTime.generateTime();
						
						PreparedStatement st2 = con.prepareStatement(updatems, Statement.RETURN_GENERATED_KEYS);
						st2.setString(1, dt.toString());
						st2.setString(2, t.toString());
						st2.setString(3, amount.getText() + " debited");
						st2.setString(4, accountno.getText());
						st2.executeUpdate();
						st2.getGeneratedKeys();
						
						
						
						st1.close();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You have not sufficient account balance...");
					}
					
					st.close();
					rs.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		btnWithdraw.setBounds(199, 235, 294, 36);
		frame.getContentPane().add(btnWithdraw);
		
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
		btnBack.setBounds(199, 295, 294, 36);
		frame.getContentPane().add(btnBack);
	}
}
