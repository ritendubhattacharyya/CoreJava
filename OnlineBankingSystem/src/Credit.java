import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Credit {

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
					Credit window = new Credit();
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
	public Credit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		con = connection.dbConnection();
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(123, 178, 78, 14);
		frame.getContentPane().add(lblAmount);
		
		accountno = new JTextField();
		accountno.setBounds(260, 118, 197, 20);
		frame.getContentPane().add(accountno);
		accountno.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(123, 121, 106, 14);
		frame.getContentPane().add(lblAccountNumber);
		
		amount = new JTextField();
		amount.setBounds(260, 175, 197, 20);
		frame.getContentPane().add(amount);
		amount.setColumns(10);
		
		JButton btnNewButton = new JButton("Credit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					String query ="SELECT balance FROM bankbalance WHERE cardnumber = ?";
					PreparedStatement st = con.prepareStatement(query);
					
					st.setString(1, accountno.getText());
					ResultSet rs = st.executeQuery();
					int count = 0, value = 0, sum = 0;
					while(rs.next())
					{
						count++;
						if(count == 1)
						{
							value = rs.getInt(1);
							break;
						}
					}
					sum = value + Integer.parseInt(amount.getText());
					String update = "UPDATE bankbalance SET balance = '"+ sum +"' WHERE cardnumber = '"+ accountno.getText() +"' ";
					PreparedStatement st1 = con.prepareStatement(update);
					st1.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Credited");
					
					String updatems = "INSERT INTO ministatement(date, time, details, cardnumber) VALUES(?,?,?,?)";
					
					
					LocalDate dt = DateTime.generateDate();
					LocalTime t = DateTime.generateTime();
					
					PreparedStatement st2 = con.prepareStatement(updatems, Statement.RETURN_GENERATED_KEYS);
					st2.setString(1, dt.toString());
					st2.setString(2, t.toString());
					st2.setString(3, amount.getText() + " credited");
					st2.setString(4, accountno.getText());
					st2.executeUpdate();
					st2.getGeneratedKeys();
					
					st1.close();
					st2.close();
					st.close();
					rs.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton.setBounds(123, 252, 334, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setBounds(123, 320, 334, 42);
		frame.getContentPane().add(btnNewButton_1);
	}
}
