import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class delete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete frame = new delete();
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
	public delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Mac_add");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_by_mac frame = new Delete_by_mac();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 10, 183, 63);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Purchase_order_no");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_by_purchase_order_no frame = new Delete_by_purchase_order_no();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(97, 95, 222, 63);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Machine_sl_no");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_by_machine_sl_no frame = new Delete_by_machine_sl_no();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(241, 10, 183, 63);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Person_attached");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_by_person_attached frame = new Delete_by_person_attached();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 187, 183, 63);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working_status");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_by_working_status frame = new Delete_by_working_status();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(241, 187, 183, 63);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Back");
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query frame = new query();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(151, 267, 130, 50);
		contentPane.add(btnNewButton_5);
	}
}
