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
import java.awt.event.ActionEvent;

public class AddNewBook extends JFrame {

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
					AddNewBook frame = new AddNewBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void reset()
	{
		textField.setText(bookID());
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_2.setSelectedIndex(0);
		comboBox_3.setSelectedIndex(0);
		
		
	}

	public String bookID()
	{
		String id="";
		for(int i=1;i<=7;i++)
		{
			id+=(int)(Math.random()*9)+1;
			//System.out.println(id);
		}
		return id;
	}
	
	public void setValue(String option)
	{
		
		String value=JOptionPane.showInputDialog("Enter "+option+" name");
	    System.out.println(value);
	    if(value.length()==0)
	    {
	    JOptionPane.showMessageDialog(getParent(), "Enter value");	
	    }
	    else
	    {
		Connection con=DBInfo.con;
		String query="insert into "+option+"(name) values(?)";
		System.out.println(query);
		
		int i=0;
		try
		{
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, value.toUpperCase());
		i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(i==1)
		{
			JOptionPane.showMessageDialog(getParent(),option+" Added!!","Success",JOptionPane.INFORMATION_MESSAGE);
		}
		if(i==0)
		{
			JOptionPane.showMessageDialog(getParent(),option+"Not Added!!","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		dispose();
		new AddNewBook().setVisible(true);
	    }
	}
	
	
	public AddNewBook() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 562);
		setLocationRelativeTo(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("FILE");
		menuBar.add(mnFile);
		
		JMenu mnAddNew = new JMenu("Add New");
		menuBar.add(mnAddNew);
		
		JMenuItem mntmAuthor = new JMenuItem("Author");
		mntmAuthor.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				setValue(arg0.getActionCommand());
				
			}
		});
		mnAddNew.add(mntmAuthor);
		
		JMenuItem mntmSubject = new JMenuItem("Subject");
		mntmSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setValue(arg0.getActionCommand());
			}
		});
		mnAddNew.add(mntmSubject);
		
		JMenuItem mntmCategory = new JMenuItem("Category");
		mntmCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setValue(arg0.getActionCommand());
			}
		});
		mnAddNew.add(mntmCategory);
		
		JMenuItem mntmPublication = new JMenuItem("Publication");
		mntmPublication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setValue(arg0.getActionCommand());
			}
		});
		mnAddNew.add(mntmPublication);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddNewBook = new JLabel("Add New Book");
		
		JLabel lblBookId = new JLabel("Book id");
		
		textField = new JTextField(bookID());
		textField.setEditable(false);
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
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() 
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
			String query="insert into book values(?,?,?,?,?,?,?,?,?)";
			
		   Connection con=DBInfo.con;
		   int i=0;
		   try
		   {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, bid);
		ps.setString(2, title);
		ps.setString(3, author);
		ps.setString(4, subject);
		ps.setString(5, cat);
		ps.setString(6, pub);
		ps.setString(7, isbn);
		ps.setString(8, price);
		ps.setString(9, quantity);
		i=ps.executeUpdate();
		
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
			
			if(i==0)
			{
				JOptionPane.showMessageDialog(getParent(), "Book not added!!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if(i==1)
			{
				JOptionPane.showMessageDialog(getParent(), "Book added!!", "Success", JOptionPane.INFORMATION_MESSAGE);
			  reset();
			}
			
			
			
			}
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
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
								.addComponent(comboBox_3, 0, 196, Short.MAX_VALUE)
								.addComponent(comboBox_2, 0, 196, Short.MAX_VALUE)
								.addComponent(comboBox_1, 0, 196, Short.MAX_VALUE)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_4)
								.addComponent(textField_3)
								.addComponent(textField_2)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))))
					.addGap(68))
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
						.addComponent(btnReset))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
