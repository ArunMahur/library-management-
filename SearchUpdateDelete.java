import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SearchUpdateDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	JComboBox comboBox,comboBox_1,comboBox_2,comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUpdateDelete frame = new SearchUpdateDelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void reset()
	{
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_2.setSelectedIndex(0);
		comboBox_3.setSelectedIndex(0);
		
		
	}

	
	
	
	public SearchUpdateDelete() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 715);
		setLocationRelativeTo(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddNewBook = new JLabel("Add New Book");
		
		JLabel lblBookId = new JLabel("Book id");
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				String bid=textField.getText();
			    String query="select * from book where id=?";
			    Connection con=DBInfo.con;
			    try
			    {
			    PreparedStatement ps=con.prepareStatement(query);
			    ps.setString(1, bid);
			    ResultSet res=ps.executeQuery();
			    while(res.next())
			    {
			     String title=res.getString(2);
			     String author=res.getString(3);
			     String subject=res.getString(4);
			     String category=res.getString(5);
			     String publication=res.getString(6);
			     String isbn=res.getString(7);
			     String price=res.getString(8);
			     String quantity=res.getString(9);
			     textField_1.setText(title);
			     comboBox.setSelectedItem(author);
			     comboBox_1.setSelectedItem(subject);
			     comboBox_2.setSelectedItem(category);
			     comboBox_3.setSelectedItem(publication);
			     textField_2.setText(isbn);
			     textField_3.setText(price);
			     textField_4.setText(quantity);
			     
			    }
			    }
			    catch(Exception e)
			    {
			    	e.printStackTrace();
			    }
				
				
				
				
			}
		});
		
		textField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		
		JLabel lblAuthor = new JLabel("Author");
		
		JLabel lblSubject = new JLabel("Subject");
		
		JLabel lblCategory = new JLabel("Category");
		
		JLabel lblPublication = new JLabel("Publication");
		
		JLabel lblIsbn = new JLabel("ISBN");
		
		JLabel lblProce = new JLabel("Price");
		
		JLabel lblQuantity = new JLabel("Quantity");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		 comboBox = new JComboBox(GetValue.getValue("author"));
		
		 comboBox_1 = new JComboBox(GetValue.getValue("subject"));
		
		 comboBox_2 = new JComboBox(GetValue.getValue("category"));
		
		 comboBox_3 = new JComboBox(GetValue.getValue("publication"));
		
		JButton btnSave = new JButton("SEARCH");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
		    String bid=textField.getText();
		    String query="select * from book where id=?";
		    Connection con=DBInfo.con;
		    try
		    {
		    PreparedStatement ps=con.prepareStatement(query);
		    ps.setString(1, bid);
		    ResultSet res=ps.executeQuery();
		    while(res.next())
		    {
		     String title=res.getString(2);
		     String author=res.getString(3);
		     String subject=res.getString(4);
		     String category=res.getString(5);
		     String publication=res.getString(6);
		     String isbn=res.getString(7);
		     String price=res.getString(8);
		     String quantity=res.getString(9);
		     textField_1.setText(title);
		     comboBox.setSelectedItem(author);
		     comboBox_1.setSelectedItem(subject);
		     comboBox_2.setSelectedItem(category);
		     comboBox_3.setSelectedItem(publication);
		     textField_2.setText(isbn);
		     textField_3.setText(price);
		     textField_4.setText(quantity);
		     
		    }
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
			
			
			
			}
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String bid=textField.getText();
			    String title=textField_1.getText();
			    String isbn=textField_2.getText();
			    String price=textField_3.getText();
			    String quantity=textField_4.getText();
			    
			    String author=(String)comboBox.getSelectedItem();
			    String subject=(String)comboBox_1.getSelectedItem();
			    String cat=(String)comboBox_2.getSelectedItem();
			    String pub=(String)comboBox_3.getSelectedItem();
				String query="update book set title=?,author=?,subject=?,category=?,publication=?,isbn=?, price=?,quantity=? where id=?";
				
			   Connection con=DBInfo.con;
			   int i=0;
			   try
			   {
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setString(3, subject);
			ps.setString(4, cat);
			ps.setString(5, pub);
			ps.setString(6, isbn);
			ps.setString(7, price);
			ps.setString(8, quantity);
			ps.setString(9, bid);
			i=ps.executeUpdate();
			
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
				
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Updation failed!!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Updation done!!", "Success", JOptionPane.INFORMATION_MESSAGE);
				  reset();
				}
					
				
			}
		});
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			 String bid=textField.getText();
			 String query="delete from book where id=?";
			 Connection con=DBInfo.con;
			 int i=0;
			 try
			 {
				 PreparedStatement ps=con.prepareStatement(query);
				 ps.setString(1, bid);
				 i=ps.executeUpdate();
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
				if(i!=0)
				{
					JOptionPane.showMessageDialog(getParent(), "Book deleted!!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
				  reset();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(177)
							.addComponent(lblAddNewBook))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookId)
								.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProce, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantity)
								.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblPublication, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblCategory, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_3, 0, 222, Short.MAX_VALUE)
								.addComponent(comboBox_2, 0, 222, Short.MAX_VALUE)
								.addComponent(comboBox_1, 0, 222, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 222, Short.MAX_VALUE)
								.addComponent(textField_3, 190, 190, 190)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
											.addGap(1)
											.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(textField_4, Alignment.LEADING, 190, 190, 190))
									.addGap(18)
									.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))))
					.addGap(74))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblAddNewBook)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBookId))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubject)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublication)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblProce)
							.addGap(18)
							.addComponent(lblQuantity))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset)
						.addComponent(btnUpdate)
						.addComponent(btnDelete))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
