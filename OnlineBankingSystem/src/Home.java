import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 863, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToOnline = new JLabel("Welcome to Online Banking System");
		lblWelcomeToOnline.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeToOnline.setBounds(252, 11, 387, 64);
		frame.getContentPane().add(lblWelcomeToOnline);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Withdraw window = new Withdraw();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnWithdraw.setBounds(49, 133, 153, 64);
		frame.getContentPane().add(btnWithdraw);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Credit window = new Credit();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}			
				
			}
		});
		btnCredit.setBounds(646, 133, 153, 64);
		frame.getContentPane().add(btnCredit);
		
		JButton btnAccountBalance = new JButton("Account Balance");
		btnAccountBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					BankBalance window = new BankBalance();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnAccountBalance.setBounds(132, 252, 153, 64);
		frame.getContentPane().add(btnAccountBalance);
		
		JButton btnMiniStatement = new JButton("Mini Statement");
		btnMiniStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					MiniStatement window = new MiniStatement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnMiniStatement.setBounds(575, 252, 153, 64);
		frame.getContentPane().add(btnMiniStatement);
		
		JButton btnLogOut = new JButton("log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					frame.dispose();
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnLogOut.setBounds(357, 364, 153, 64);
		frame.getContentPane().add(btnLogOut);
	}
}
