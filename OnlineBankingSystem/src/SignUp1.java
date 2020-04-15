import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;


public class SignUp1 {

	public JFrame frame;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtfathersname;
	private JTextField txtstreetno;
	private JTextField txttown;
	private JTextField txtcity;
	private JTextField txtstate;
	private JTextField txtpin;
	private JTextField txtphoneno;
	private JTextField txtemailid;
	private JTextField txtdateofbirth;
	private JComboBox comboreligion;
	private JComboBox combocategory;
	private JComboBox comboincome;
	private JComboBox comboeducationalqualification;
	private JComboBox comboaccounttype;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp1 window = new SignUp1();
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
	public SignUp1() {
		initialize();
	}
//	public static String str ;

	/**
	 * Initialize the contents of the frame.
	 */
	Connection con = null;
	private JTextField txtaadhaarnumber;
	private JTextField txtpannumber;
	private void initialize() {
		con = connection.dbConnection();
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 943, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setUndecorated(true);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(79, 106, 139, 20);
		frame.getContentPane().add(txtfirstname);
		txtfirstname.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.RED);
		lblFirstName.setBackground(Color.WHITE);
		lblFirstName.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblFirstName.setBounds(10, 109, 62, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.RED);
		lblLastName.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblLastName.setBounds(239, 109, 75, 14);
		frame.getContentPane().add(lblLastName);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(313, 106, 139, 20);
		frame.getContentPane().add(txtlastname);
		txtlastname.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(Color.RED);
		lblFathersName.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblFathersName.setBounds(504, 109, 88, 14);
		frame.getContentPane().add(lblFathersName);
		
		txtfathersname = new JTextField();
		txtfathersname.setBounds(613, 106, 304, 20);
		frame.getContentPane().add(txtfathersname);
		txtfathersname.setColumns(10);
		
		JLabel lblStreetNo = new JLabel("Street No.");
		lblStreetNo.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblStreetNo.setForeground(Color.RED);
		lblStreetNo.setBounds(10, 169, 62, 14);
		frame.getContentPane().add(lblStreetNo);
		
		txtstreetno = new JTextField();
		txtstreetno.setBounds(79, 166, 373, 20);
		frame.getContentPane().add(txtstreetno);
		txtstreetno.setColumns(10);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setForeground(Color.RED);
		lblTown.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblTown.setBounds(10, 218, 46, 14);
		frame.getContentPane().add(lblTown);
		
		txttown = new JTextField();
		txttown.setBounds(79, 215, 139, 20);
		frame.getContentPane().add(txttown);
		txttown.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblCity.setForeground(Color.RED);
		lblCity.setBounds(258, 218, 33, 14);
		frame.getContentPane().add(lblCity);
		
		txtcity = new JTextField();
		txtcity.setBounds(295, 215, 157, 20);
		frame.getContentPane().add(txtcity);
		txtcity.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setForeground(Color.RED);
		lblState.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblState.setBounds(10, 257, 46, 14);
		frame.getContentPane().add(lblState);
		
		txtstate = new JTextField();
		txtstate.setBounds(79, 254, 139, 20);
		frame.getContentPane().add(txtstate);
		txtstate.setColumns(10);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblPin.setForeground(Color.RED);
		lblPin.setBounds(262, 170, 28, 14);
		frame.getContentPane().add(lblPin);
		
		txtpin = new JTextField();
		txtpin.setBounds(295, 251, 157, 20);
		frame.getContentPane().add(txtpin);
		txtpin.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setForeground(Color.RED);
		lblPhoneNo.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblPhoneNo.setBounds(10, 312, 62, 14);
		frame.getContentPane().add(lblPhoneNo);
		
		txtphoneno = new JTextField();
		txtphoneno.setBounds(79, 309, 373, 20);
		frame.getContentPane().add(txtphoneno);
		txtphoneno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblNewLabel.setBounds(757, 257, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox combogender = new JComboBox();
		combogender.setBounds(813, 254, 104, 20);
		frame.getContentPane().add(combogender);
		combogender.addItem("Male");
		combogender.addItem("Female");
		combogender.addItem("Others");
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblEmailId.setForeground(Color.RED);
		lblEmailId.setBounds(10, 374, 62, 14);
		frame.getContentPane().add(lblEmailId);
		
		txtemailid = new JTextField();
		txtemailid.setBounds(79, 371, 373, 20);
		frame.getContentPane().add(txtemailid);
		txtemailid.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("DOB(DD/MM/YYYY)");
		lblDateOfBirth.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblDateOfBirth.setForeground(Color.RED);
		lblDateOfBirth.setBounds(504, 257, 126, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
		txtdateofbirth = new JTextField();
		txtdateofbirth.setToolTipText("DD/MM/YYYY");
		txtdateofbirth.setForeground(new Color(0, 0, 0));
		txtdateofbirth.setBounds(640, 254, 104, 20);
		frame.getContentPane().add(txtdateofbirth);
		txtdateofbirth.setColumns(10);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status");
		lblMaritalStatus.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblMaritalStatus.setForeground(Color.RED);
		lblMaritalStatus.setBounds(504, 374, 96, 14);
		frame.getContentPane().add(lblMaritalStatus);
		
		JComboBox combomaritalstatus = new JComboBox();
		combomaritalstatus.setModel(new DefaultComboBoxModel(new String[] {"Married", "Unmarried"}));
		combomaritalstatus.setBounds(640, 371, 104, 20);
		frame.getContentPane().add(combomaritalstatus);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("MV Boli", Font.BOLD, 14));
		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						String fetchId = "SELECT cardnumber FROM userdetails";
						Statement st1 = con.createStatement();
						List<Integer> lr = new ArrayList<>();
						ResultSet rs = st1.executeQuery(fetchId);
						while(rs.next())	
							lr.add(rs.getInt("cardnumber"));
						createRandomNumber r = new createRandomNumber();
						int Rand = r.Random();
						for(int i=0;i<lr.size();i++)
						{
							if(lr.get(i) == Rand)
							{
								Rand = r.Random();
								i = 0;
							}
						}	
						
						String fetchPin = "SELECT pinno FROM userdetails";
						List<Integer> lr1 = new ArrayList<>();
						ResultSet rs1 = st1.executeQuery(fetchPin);
						while(rs1.next())
							lr1.add(rs1.getInt("pinno"));
						int Pin = r.RandomPin();
						for(int i=0;i<lr1.size();i++)
						{
							if(lr1.get(i) == Pin)
							{
								Pin = r.RandomPin();
								i = 0;
							}
						}
						
						String query = "INSERT INTO userdetails(firstname,lastname,strtno,town,city,state,pin,gender,dob,phonenumber,emailaddress,maretalstatus,religion,category,income,educationalqualification,panno,aadhaarno,accounttype,cardnumber,pinno) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement st = con.prepareStatement(query);
						
						//st.setString(1, rs.next());
						st.setString(1, txtfirstname.getText());
						st.setString(2, txtlastname.getText());
						st.setString(3, txtstreetno.getText());
						st.setString(4, txttown.getText());
						st.setString(5, txtcity.getText());
						st.setString(6, txtstate.getText());
						st.setString(7, txtpin.getText());
						st.setString(8, combogender.getSelectedItem().toString());
						st.setString(9, txtdateofbirth.getText());
						st.setString(10, txtphoneno.getText());
						st.setString(11, txtemailid.getText());
						st.setString(12, combomaritalstatus.getSelectedItem().toString());
						st.setString(13, comboreligion.getSelectedItem().toString());
						st.setString(14, combocategory.getSelectedItem().toString());
						st.setString(15, comboincome.getSelectedItem().toString());
						st.setString(16, comboeducationalqualification.getSelectedItem().toString());
						st.setString(17, txtpannumber.getText());
						st.setString(18, txtaadhaarnumber.getText());
						st.setString(19, comboaccounttype.getSelectedItem().toString());
						st.setInt(20, Rand);
						st.setInt(21, Pin);
						st.executeUpdate();
						
						CreateMail.SentMail(txtemailid.getText(), Rand, Pin);
						
						String query1 = "INSERT INTO bankbalance(cardnumber, balance) VALUES(?, ?)";
						PreparedStatement st2 = con.prepareStatement(query1);
						
						st2.setInt(1, Rand);
						st2.setInt(2, 0);
						st2.executeUpdate();

						JOptionPane.showMessageDialog(null, "data uploaded");
						
						st2.close();
						st1.close();
						st.close();
						
						frame.dispose();
						LogIn window = new LogIn();
						window.frame.setVisible(true);
						
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
			}
		});
		btnSubmit.setBounds(295, 552, 157, 59);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("MV Boli", Font.BOLD, 14));
		btnCancel.setBackground(new Color(255, 51, 51));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{								
					frame.dispose();
					LogIn window = new LogIn();
					window.frame.setVisible(true);					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnCancel.setBounds(504, 552, 157, 59);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setForeground(Color.RED);
		lblReligion.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblReligion.setBounds(764, 430, 46, 14);
		frame.getContentPane().add(lblReligion);
		
		comboreligion = new JComboBox();
		comboreligion.setModel(new DefaultComboBoxModel(new String[] {"Hindu", "Muslim", "Sikh", "Christian", "Others"}));
		comboreligion.setBounds(813, 427, 104, 20);
		frame.getContentPane().add(comboreligion);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setForeground(Color.RED);
		lblCategory.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblCategory.setBounds(757, 228, 46, 14);
		frame.getContentPane().add(lblCategory);
		
		combocategory = new JComboBox();
		combocategory.setModel(new DefaultComboBoxModel(new String[] {"General", "SC", "ST", "OBC"}));
		combocategory.setBounds(813, 309, 104, 20);
		frame.getContentPane().add(combocategory);
		
		JLabel lblIncome = new JLabel("Income");
		lblIncome.setForeground(Color.RED);
		lblIncome.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblIncome.setBounds(764, 374, 46, 14);
		frame.getContentPane().add(lblIncome);
		
		comboincome = new JComboBox();
		comboincome.setModel(new DefaultComboBoxModel(new String[] {"<40000", "<70000", "<100000", "<150000", ">150000"}));
		comboincome.setBounds(813, 371, 104, 20);
		frame.getContentPane().add(comboincome);
		
		JLabel lblEducationalQualification = new JLabel("Educational Qualification");
		lblEducationalQualification.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblEducationalQualification.setForeground(Color.RED);
		lblEducationalQualification.setBounds(504, 315, 126, 14);
		frame.getContentPane().add(lblEducationalQualification);
		
		comboeducationalqualification = new JComboBox();
		comboeducationalqualification.setModel(new DefaultComboBoxModel(new String[] {"UG", "PG", "Graduate", "Doctorate"}));
		comboeducationalqualification.setBounds(640, 309, 104, 20);
		frame.getContentPane().add(comboeducationalqualification);
		
		JLabel lblAadhaarNumber = new JLabel("Aadhaar number");
		lblAadhaarNumber.setForeground(Color.RED);
		lblAadhaarNumber.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblAadhaarNumber.setBounds(504, 200, 113, 14);
		frame.getContentPane().add(lblAadhaarNumber);
		
		txtaadhaarnumber = new JTextField();
		txtaadhaarnumber.setBounds(613, 197, 304, 20);
		frame.getContentPane().add(txtaadhaarnumber);
		txtaadhaarnumber.setColumns(10);
		
		JLabel lblPanNumber = new JLabel("Pan number");
		lblPanNumber.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblPanNumber.setForeground(Color.RED);
		lblPanNumber.setBounds(504, 153, 88, 14);
		frame.getContentPane().add(lblPanNumber);
		
		txtpannumber = new JTextField();
		txtpannumber.setBounds(613, 150, 304, 20);
		frame.getContentPane().add(txtpannumber);
		txtpannumber.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card number");
		lblCardNumber.setForeground(Color.RED);
		lblCardNumber.setFont(new Font("MV Boli", Font.PLAIN, 17));
		lblCardNumber.setBounds(10, 442, 113, 14);
		frame.getContentPane().add(lblCardNumber);
		
		JLabel lblxxxxxxxx = new JLabel("XXXX-XXXX");
		lblxxxxxxxx.setFont(new Font("MV Boli", Font.PLAIN, 16));
		lblxxxxxxxx.setBounds(143, 442, 113, 14);
		frame.getContentPane().add(lblxxxxxxxx);
		
		JLabel lblPinpassword = new JLabel("Pin(Password)");
		lblPinpassword.setForeground(Color.RED);
		lblPinpassword.setFont(new Font("MV Boli", Font.PLAIN, 16));
		lblPinpassword.setBounds(10, 475, 113, 14);
		frame.getContentPane().add(lblPinpassword);
		
		JLabel lblXxxx = new JLabel("XXXX");
		lblXxxx.setFont(new Font("MV Boli", Font.PLAIN, 16));
		lblXxxx.setBounds(143, 477, 62, 14);
		frame.getContentPane().add(lblXxxx);
		
		JLabel lblCardNumberAnd = new JLabel("Card number And 4 digit pin number will be generate to your email...please check mail after submitting this form.");
		lblCardNumberAnd.setForeground(Color.RED);
		lblCardNumberAnd.setFont(new Font("MV Boli", Font.PLAIN, 16));
		lblCardNumberAnd.setBounds(10, 516, 907, 25);
		frame.getContentPane().add(lblCardNumberAnd);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblAccountType.setForeground(Color.RED);
		lblAccountType.setBounds(504, 430, 84, 14);
		frame.getContentPane().add(lblAccountType);
		
		comboaccounttype = new JComboBox();
		comboaccounttype.setModel(new DefaultComboBoxModel(new String[] {"Savings Acc", "Current Acc", "Fixed Deposite Acc", "Reccuring Deposite Acc"}));
		comboaccounttype.setBounds(640, 427, 104, 20);
		frame.getContentPane().add(comboaccounttype);
		
		JButton btnX = new JButton("X");
		btnX.setSelected(true);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnX.setFont(new Font("MV Boli", Font.BOLD, 11));
		btnX.setBackground(new Color(139, 0, 0));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBounds(893, 0, 50, 27);
		frame.getContentPane().add(btnX);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setFont(new Font("MV Boli", Font.BOLD, 18));
		lblSignUp.setForeground(new Color(128, 0, 128));
		lblSignUp.setBounds(444, 11, 120, 25);
		frame.getContentPane().add(lblSignUp);
	}
}
