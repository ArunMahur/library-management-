import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin()
	{
		super("Admin section");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 339);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3,3,5,5));
		
		JButton btnAddNewBook = new JButton("ADD NEW BOOK");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNewBook obj=new AddNewBook();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnAddNewBook);
		
		JButton btnSearchupdatedeleteBook = new JButton("SEARCH/UPDATE/DELETE BOOK BY ID");
		btnSearchupdatedeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchUpdateDelete obj=new SearchUpdateDelete();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnSearchupdatedeleteBook);
		
		JButton btnSearchBy = new JButton("SEARCH BY");
		btnSearchBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SearchBy().setVisible(true);
			}
		});
		contentPane.add(btnSearchBy);
		
		JButton btnAddNewUser = new JButton("ADD NEW USER");
		contentPane.add(btnAddNewUser);
		
		JButton btnSearchupdatedeleteUser = new JButton("SEARCH/UPDATE/DELETE USER");
		contentPane.add(btnSearchupdatedeleteUser);
		
		JButton btnIssueBook = new JButton("ISSUE BOOK");
		contentPane.add(btnIssueBook);
		
		JButton btnSubmitBook = new JButton("SUBMIT BOOK");
		contentPane.add(btnSubmitBook);
		
		JButton btnChangePassword = new JButton("CHANGE PASSWORD");
		contentPane.add(btnChangePassword);
	}

}
