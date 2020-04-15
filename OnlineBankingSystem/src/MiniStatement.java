import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class MiniStatement {

	public JFrame frame;
	private JComboBox comboBox;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniStatement window = new MiniStatement();
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
	private JTextField cardnumber;
	
	public MiniStatement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		con = connection.dbConnection();
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Generate Mini Statement");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "SELECT date, time, details FROM ministatement WHERE cardnumber = ? AND date LIKE ?";
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, cardnumber.getText());
					if(comboBox.getSelectedItem().toString() == "Jan")
						st.setString(2, "____-01%");
					if(comboBox.getSelectedItem().toString() == "Feb")
						st.setString(2, "____-02%");
					if(comboBox.getSelectedItem().toString() == "March")
						st.setString(2, "____-03%");
					if(comboBox.getSelectedItem().toString() == "April")
						st.setString(2, "____-04%");
					if(comboBox.getSelectedItem().toString() == "May")
						st.setString(2, "____-05%");
					if(comboBox.getSelectedItem().toString() == "June")
						st.setString(2, "____-06%");
					if(comboBox.getSelectedItem().toString() == "July")
						st.setString(2, "____-07%");
					if(comboBox.getSelectedItem().toString() == "Aug")
						st.setString(2, "____-08%");
					if(comboBox.getSelectedItem().toString() == "Sept")
						st.setString(2, "____-09%");
					if(comboBox.getSelectedItem().toString() == "Oct")
						st.setString(2, "____-10%");
					if(comboBox.getSelectedItem().toString() == "Nov")
						st.setString(2, "____-11%");
					if(comboBox.getSelectedItem().toString() == "Dec")
						st.setString(2, "____-12%");
					
					ResultSet rs = st.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					rs.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setBounds(10, 11, 182, 33);
		frame.getContentPane().add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"}));
		comboBox.setBounds(562, 11, 99, 33);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 458, 339);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblCardNumber = new JLabel("Card number");
		lblCardNumber.setBounds(202, 15, 84, 24);
		frame.getContentPane().add(lblCardNumber);
		
		cardnumber = new JTextField();
		cardnumber.setBounds(290, 11, 252, 33);
		frame.getContentPane().add(cardnumber);
		cardnumber.setColumns(10);
		
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
		btnBack.setBounds(507, 363, 154, 45);
		frame.getContentPane().add(btnBack);
	}
}
