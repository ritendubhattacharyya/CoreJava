import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class update extends JFrame {

	private JPanel contentPane;
	private JTextField macadd;
	private JTextField type;
	private JTextField make;
	private JTextField machineslno;
	private JTextField personattached;
	private JTextField purchaseorderno;
	private JTextField remarks;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	
	public void fillcombobox()
	{
		try {
			String query="select * from maintable";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				comboBox.addItem(rs.getString("SL_NO"));
			}
			//comboBox.setSelectedItem(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public update() {
		connection=maintable_connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSlno = new JLabel("ENTER SL_NO");
		lblSlno.setForeground(Color.WHITE);
		lblSlno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblSlno.setBounds(10, 29, 116, 14);
		contentPane.add(lblSlno);
		
		JLabel lblMackadd = new JLabel("MAC_ADD");
		lblMackadd.setForeground(Color.WHITE);
		lblMackadd.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblMackadd.setBounds(234, 29, 68, 14);
		contentPane.add(lblMackadd);
		
		macadd = new JTextField();
		macadd.setBackground(Color.LIGHT_GRAY);
		macadd.setForeground(Color.BLACK);
		macadd.setDocument(new limitation(17));
		macadd.setBounds(296, 26, 167, 20);
		contentPane.add(macadd);
		macadd.setColumns(10);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblType.setBounds(11, 157, 60, 14);
		contentPane.add(lblType);
		
		type = new JTextField();
		type.setBackground(Color.LIGHT_GRAY);
		type.setBounds(65, 154, 134, 20);
		contentPane.add(type);
		type.setColumns(10);
		
		JLabel lblMake = new JLabel("MAKE");
		lblMake.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblMake.setForeground(Color.WHITE);
		lblMake.setBounds(11, 213, 60, 14);
		contentPane.add(lblMake);
		
		make = new JTextField();
		make.setBackground(Color.LIGHT_GRAY);
		make.setBounds(65, 210, 134, 20);
		contentPane.add(make);
		make.setColumns(10);
		
		JLabel lblMachineslno = new JLabel("MACHINE_SL_NO");
		lblMachineslno.setForeground(Color.WHITE);
		lblMachineslno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblMachineslno.setBounds(222, 93, 114, 14);
		contentPane.add(lblMachineslno);
		
		machineslno = new JTextField();
		machineslno.setBackground(Color.LIGHT_GRAY);
		machineslno.setBounds(336, 90, 167, 20);
		contentPane.add(machineslno);
		machineslno.setColumns(10);
		
		JLabel lblPersonattached = new JLabel("PERSON_ATTACHED");
		lblPersonattached.setForeground(Color.WHITE);
		lblPersonattached.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPersonattached.setBounds(234, 157, 135, 14);
		contentPane.add(lblPersonattached);
		
		personattached = new JTextField();
		personattached.setBackground(Color.LIGHT_GRAY);
		personattached.setBounds(379, 154, 156, 20);
		contentPane.add(personattached);
		personattached.setColumns(10);
		
		JLabel lblPurchaseorderno = new JLabel("PURCHASE_ORDER_NO");
		lblPurchaseorderno.setForeground(Color.WHITE);
		lblPurchaseorderno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPurchaseorderno.setBounds(592, 29, 150, 14);
		contentPane.add(lblPurchaseorderno);
		
		purchaseorderno = new JTextField();
		purchaseorderno.setBackground(Color.LIGHT_GRAY);
		purchaseorderno.setBounds(755, 26, 78, 20);
		contentPane.add(purchaseorderno);
		purchaseorderno.setColumns(10);
		
		JLabel lblPurchaseorderdate = new JLabel("PURCHASE_ORDER_DATE");
		lblPurchaseorderdate.setForeground(Color.WHITE);
		lblPurchaseorderdate.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPurchaseorderdate.setBounds(592, 90, 150, 14);
		contentPane.add(lblPurchaseorderdate);
		
		JDateChooser purchaseorderdate = new JDateChooser();
		purchaseorderdate.setBounds(755, 87, 113, 20);
		contentPane.add(purchaseorderdate);
		
		JLabel lblWorkingstatus = new JLabel("WORKING_STATUS");
		lblWorkingstatus.setForeground(Color.WHITE);
		lblWorkingstatus.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblWorkingstatus.setBounds(12, 289, 134, 14);
		contentPane.add(lblWorkingstatus);
		
		JComboBox workingstatus = new JComboBox();
		workingstatus.setModel(new DefaultComboBoxModel(new String[] {"Active", "Inactive", "Condemned"}));
		workingstatus.setSelectedItem(null);
		workingstatus.setBounds(136, 286, 114, 20);
		contentPane.add(workingstatus);
		
		JLabel lblRemarks = new JLabel("REMARKS");
		lblRemarks.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblRemarks.setForeground(Color.WHITE);
		lblRemarks.setBounds(275, 245, 86, 14);
		contentPane.add(lblRemarks);
		
		remarks = new JTextField();
		remarks.setBackground(Color.LIGHT_GRAY);
		remarks.setBounds(365, 242, 218, 64);
		contentPane.add(remarks);
		remarks.setColumns(10);
		
		JLabel lblAmcinitialdate = new JLabel("AMC_INITIAL_DATE");
		lblAmcinitialdate.setForeground(Color.WHITE);
		lblAmcinitialdate.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblAmcinitialdate.setBounds(608, 173, 134, 14);
		contentPane.add(lblAmcinitialdate);
		
		JDateChooser amcinitialdate = new JDateChooser();
		amcinitialdate.setBounds(755, 167, 113, 20);
		contentPane.add(amcinitialdate);
		
		JLabel lblAmcterminateddate = new JLabel("AMC_TERMINATED_DATE");
		lblAmcterminateddate.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblAmcterminateddate.setForeground(Color.WHITE);
		lblAmcterminateddate.setBounds(608, 245, 156, 14);
		contentPane.add(lblAmcterminateddate);
		
		JDateChooser amcterminateddate = new JDateChooser();
		amcterminateddate.setBounds(766, 239, 102, 20);
		contentPane.add(amcterminateddate);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(65, 90, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	    comboBox = new JComboBox();
	    comboBox.setSelectedItem(null);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//comboBox.setSelectedItem(null);
					String query="select * from maintable where SL_NO=? ";
					//comboBox.setSelectedItem(null);
					PreparedStatement pst=connection.prepareStatement(query);
					//comboBox.setSelectedItem(null);
					pst.setString(1, (String)comboBox.getSelectedItem());
					//comboBox.setSelectedItem(null);
					ResultSet rs=pst.executeQuery();
					//comboBox.setSelectedItem(null);
					
					while(rs.next())
					{
						textField.setText(rs.getString("SL_NO"));
						macadd.setText(rs.getString("MAC_ADD"));
						type.setText(rs.getString("TYPE"));
						make.setText(rs.getString("MAKE"));
						purchaseorderno.setText(rs.getString("PURCHASE_ORDER_NO"));
						((JTextField)purchaseorderdate.getDateEditor()).setText(rs.getString("PURCHASE_ORDER_DATE"));
						machineslno.setText(rs.getString("MACHINE_SL_NO"));
						personattached.setText(rs.getString("PERSON_ATTACHED"));
						((JTextField)amcinitialdate.getDateEditor()).setText(rs.getString("AMC_INITIAL_DATE"));
						((JTextField)amcterminateddate.getDateEditor()).setText(rs.getString("AMC_TERMINATED_DATE"));
						remarks.setText(rs.getString("REMARKS"));
						
					}
					//comboBox.setSelectedItem(null);
					pst.close();
					
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		//comboBox.setSelectedItem(null);
		comboBox.setBounds(131, 26, 68, 20);
		contentPane.add(comboBox);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query frame = new query();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 370, 174, 69);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String values=workingstatus.getSelectedItem().toString();
					String query="Update maintable set SL_NO='"+textField.getText()+"' , MAC_ADD='"+macadd.getText()+"' , TYPE='"+type.getText()+"', MAKE='"+make.getText()+"', PURCHASE_ORDER_NO='"+purchaseorderno.getText()+"', PURCHASE_ORDER_DATE='"+((JTextField)purchaseorderdate.getDateEditor()).getText()+"', MACHINE_SL_NO='"+machineslno.getText()+"', PERSON_ATTACHED='"+personattached.getText()+"', WORKING_STATUS='"+values+"', AMC_INITIAL_DATE='"+((JTextField)amcinitialdate.getDateEditor()).getText()+"', AMC_TERMINATED_DATE='"+((JTextField)amcterminateddate.getDateEditor()).getText()+"', REMARKS='"+remarks.getText()+"' where SL_NO='"+textField.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "updated");
					
					pst.close();
					
					query frame = new query();
					frame.setVisible(true);
					dispose();
					
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(694, 370, 174, 69);
		contentPane.add(btnUpdate);
		
		JLabel lblSlno_1 = new JLabel("SL_NO");
		lblSlno_1.setForeground(Color.WHITE);
		lblSlno_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblSlno_1.setBounds(10, 93, 61, 14);
		contentPane.add(lblSlno_1);
		
		fillcombobox();
		
		
		
	}
}
