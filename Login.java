

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	public void reset()
	{
		textField.setText(null);
		passwordField.setText(null);
	}
	
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		
		passwordField = new JPasswordField();
		
		JButton btnLoginNow = new JButton("Login Now");
		btnLoginNow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			 String uname=textField.getText();
			 char ch[]=passwordField.getPassword();
			 String pass=String.copyValueOf(ch);
			 int flag=0;
			 String usertype="";
			 Connection con=DBInfo.con;
			 String query="select * from login where username=? and password=?";
			 try
			 {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);;
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				flag=1;
				usertype=res.getString("usertype");
				break;
			}
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 if(flag==1 && usertype.equalsIgnoreCase("admin"))
			 {
				 reset();
				 Admin a=new Admin();
				 a.setVisible(true);
			 }
			 if(flag==1 && usertype.equalsIgnoreCase("user"))
			 {
				  reset();
				  User u=new User();
				  u.setVisible(true);
			 }
			 if(flag==0)
			 {
				 System.out.println("no record found!!");
			 }
			 
			 
			 
			 
			 
			 //System.out.println(uname+"::::"+pass);
				
				
				
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		
		JButton btnNewUser = new JButton("New User");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(174)
							.addComponent(lblLoginPage))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterUsername)
								.addComponent(lblEnterPassword)
								.addComponent(btnLoginNow))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnReset)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewUser))
								.addComponent(textField)
								.addComponent(passwordField))))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLoginPage)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoginNow)
						.addComponent(btnReset)
						.addComponent(btnNewUser))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
