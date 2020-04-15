import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;

	/**
	 * Create the frame.
	 */
	public search() {
		connection=maintable_connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1173, 615);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchBy = new JLabel("Search by ");
		lblSearchBy.setForeground(Color.WHITE);
		lblSearchBy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSearchBy.setBounds(99, 11, 93, 23);
		contentPane.add(lblSearchBy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SL_NO", "MAC_ADD", "TYPE", "MAKE", "PURCHASE_ORDER_NO", "PURCHASE_ORDER_DATE", "MACHINE_SL_NO", "PERSON_ATTACHED", "WORKING_STATUS", "AMC_INITIAL_DATE", "AMC_TERMINATED_DATE"}));
		comboBox.setSelectedItem(null);
		comboBox.setBounds(215, 14, 195, 20);
		contentPane.add(comboBox);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the data");
		lblPleaseEnterThe.setForeground(Color.WHITE);
		lblPleaseEnterThe.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPleaseEnterThe.setBounds(10, 77, 195, 14);
		contentPane.add(lblPleaseEnterThe);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String selection=(String)comboBox.getSelectedItem();
					String query="select * from maintable where "+selection+"=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField.getText()  );
					ResultSet rs=pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textField.setBounds(215, 76, 195, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query frame = new query();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(963, 31, 184, 42);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 1137, 450);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
