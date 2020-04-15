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
import java.awt.Font;
import java.awt.Color;

public class Delete_by_purchase_order_no extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_by_purchase_order_no frame = new Delete_by_purchase_order_no();
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
	public Delete_by_purchase_order_no() {
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
		textField.setBounds(43, 96, 179, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from maintable where PURCHASE_ORDER_NO='"+textField.getText()+"'  ";
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
		btnNewButton.setBounds(264, 88, 138, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterThePurchaseorderno = new JLabel("Enter the purchase_order_no and press confirm to delete!");
		lblEnterThePurchaseorderno.setForeground(Color.WHITE);
		lblEnterThePurchaseorderno.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEnterThePurchaseorderno.setBounds(43, 28, 359, 26);
		contentPane.add(lblEnterThePurchaseorderno);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete frame = new delete();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(147, 169, 132, 43);
		contentPane.add(btnNewButton_1);
	}

}
