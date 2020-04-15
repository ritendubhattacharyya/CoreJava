import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;

public class input_data extends JFrame {

	private JPanel contentPane;
	private JTextField slno;
	private JTextField mac_add;
	private JTextField type;
	private JTextField make;
	private JTextField purchase_orderno;
	private JTextField machine_slno;
	private JTextField person_attached;
	private JTextField remarks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					input_data frame = new input_data();
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
	public input_data() {
		connection=maintable_connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSlno = new JLabel("SL_NO.");
		lblSlno.setForeground(Color.WHITE);
		lblSlno.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblSlno.setBounds(10, 11, 47, 14);
		contentPane.add(lblSlno);
		
		slno = new JTextField();
		slno.setBackground(Color.LIGHT_GRAY);
		slno.setBounds(56, 8, 47, 20);
		contentPane.add(slno);
		slno.setColumns(10);
		
		JLabel lblMacadd = new JLabel("MAC_ADD");
		lblMacadd.setForeground(Color.WHITE);
		lblMacadd.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblMacadd.setBounds(239, 11, 62, 14);
		contentPane.add(lblMacadd);
		
		mac_add = new JTextField();
		mac_add.setBackground(Color.LIGHT_GRAY);
		mac_add.setDocument(new limitation(17));
		mac_add.setBounds(311, 8, 206, 20);
		contentPane.add(mac_add);
		mac_add.setColumns(10);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(10, 76, 47, 14);
		contentPane.add(lblType);
		
		type = new JTextField();
		type.setBackground(Color.LIGHT_GRAY);
		type.setBounds(54, 73, 107, 20);
		contentPane.add(type);
		type.setColumns(10);
		
		JLabel lblMake = new JLabel("MAKE");
		lblMake.setForeground(Color.WHITE);
		lblMake.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblMake.setBounds(10, 139, 36, 14);
		contentPane.add(lblMake);
		
		make = new JTextField();
		make.setBackground(Color.LIGHT_GRAY);
		make.setBounds(53, 136, 108, 20);
		contentPane.add(make);
		make.setColumns(10);
		
		JLabel lblPurchase = new JLabel("PURCHASE ORDER NO. ");
		lblPurchase.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPurchase.setForeground(Color.WHITE);
		lblPurchase.setBounds(653, 11, 137, 20);
		contentPane.add(lblPurchase);
		
		purchase_orderno = new JTextField();
		purchase_orderno.setBackground(Color.LIGHT_GRAY);
		purchase_orderno.setBounds(800, 8, 47, 20);
		contentPane.add(purchase_orderno);
		purchase_orderno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PURCHASE ORDER DATE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(634, 76, 156, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMachineSlNo = new JLabel("MACHINE SL NO.");
		lblMachineSlNo.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblMachineSlNo.setForeground(Color.WHITE);
		lblMachineSlNo.setBounds(205, 76, 120, 14);
		contentPane.add(lblMachineSlNo);
		
		machine_slno = new JTextField();
		machine_slno.setBackground(Color.LIGHT_GRAY);
		machine_slno.setBounds(311, 73, 243, 20);
		contentPane.add(machine_slno);
		machine_slno.setColumns(10);
		
		JLabel lblPersonAttached = new JLabel("PERSON ATTACHED");
		lblPersonAttached.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPersonAttached.setForeground(Color.WHITE);
		lblPersonAttached.setBounds(205, 139, 120, 14);
		contentPane.add(lblPersonAttached);
		
		person_attached = new JTextField();
		person_attached.setBackground(Color.LIGHT_GRAY);
		person_attached.setBounds(325, 136, 182, 20);
		contentPane.add(person_attached);
		person_attached.setColumns(10);
		
		JLabel lblWorkingStatus = new JLabel("WORKING STATUS");
		lblWorkingStatus.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblWorkingStatus.setForeground(Color.WHITE);
		lblWorkingStatus.setBounds(10, 276, 136, 14);
		contentPane.add(lblWorkingStatus);
		
		JComboBox working_status = new JComboBox();
		working_status.setModel(new DefaultComboBoxModel(new String[] {"Active", "Inactive", "Condemned"}));
		working_status.setSelectedItem(null);
		working_status.setBounds(156, 273, 90, 20);
		contentPane.add(working_status);
		
		JLabel lblAmcInitialDate = new JLabel("AMC INITIAL DATE");
		lblAmcInitialDate.setForeground(Color.WHITE);
		lblAmcInitialDate.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblAmcInitialDate.setBounds(653, 179, 137, 14);
		contentPane.add(lblAmcInitialDate);
		
		JLabel lblAmcTerminatedDate = new JLabel("AMC TERMINATED DATE");
		lblAmcTerminatedDate.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblAmcTerminatedDate.setForeground(Color.WHITE);
		lblAmcTerminatedDate.setBounds(634, 243, 156, 14);
		contentPane.add(lblAmcTerminatedDate);
		
		JLabel lblRemarks = new JLabel("REMARKS ");
		lblRemarks.setForeground(Color.WHITE);
		lblRemarks.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblRemarks.setBounds(219, 226, 82, 14);
		contentPane.add(lblRemarks);
		
		remarks = new JTextField();
		remarks.setBackground(Color.LIGHT_GRAY);
		remarks.setBounds(311, 223, 273, 67);
		contentPane.add(remarks);
		remarks.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(Color.LIGHT_GRAY);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(800, 76, 91, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBackground(Color.LIGHT_GRAY);
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(800, 173, 91, 20);
		contentPane.add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBackground(Color.LIGHT_GRAY);
		dateChooser_2.setDateFormatString("dd/MM/yyyy");
		dateChooser_2.setBounds(800, 243, 91, 20);
		contentPane.add(dateChooser_2);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into maintable (SL_NO, MAC_ADD, TYPE, MAKE, PURCHASE_ORDER_NO, PURCHASE_ORDER_DATE, MACHINE_SL_NO, PERSON_ATTACHED, WORKING_STATUS, AMC_INITIAL_DATE, AMC_TERMINATED_DATE, REMARKS) values (?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,slno.getText());
					pst.setString(2,mac_add.getText());
					pst.setString(3,type.getText());
					pst.setString(4,make.getText());
					pst.setString(5,purchase_orderno.getText());
					pst.setString(6,((JTextField)dateChooser.getDateEditor()).getText());
					pst.setString(7,machine_slno.getText());
					pst.setString(8,person_attached.getText());
					String values=working_status.getSelectedItem().toString();
					pst.setString(9,values);
					pst.setString(10,((JTextField)dateChooser_1.getDateEditor()).getText());
					pst.setString(11,((JTextField)dateChooser_2.getDateEditor()).getText());
					pst.setString(12,remarks.getText());
					
					pst.execute();
					
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
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
		btnNewButton.setBounds(301, 410, 206, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				query frame = new query();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(785, 417, 134, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(10, 417, 134, 38);
		contentPane.add(btnExit);
		
		
	}
}
