import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class query extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					query frame = new query();
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
	public query() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 372);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("INPUT DATA");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input_data frame = new input_data();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(78, 11, 348, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE DATA");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete frame = new delete();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(78, 63, 348, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DISPLAY DATA");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Display frame = new Display();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(78, 167, 348, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOG OUT");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You have succesfully Logged out...");
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(78, 271, 348, 41);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SEARCH DATA");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search frame = new search();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(78, 219, 348, 41);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("UPDATE DATA");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update frame = new update();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(78, 115, 348, 41);
		contentPane.add(btnNewButton_5);
	}
}
