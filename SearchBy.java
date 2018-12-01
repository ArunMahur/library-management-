import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBy extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBy frame = new SearchBy();
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
	public SearchBy() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 277);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel lblSearchBy = new JLabel("Search By");
		
		
		
		String value[]={"Select","All","Author","Subject","Categrory","Publication"};
		JComboBox comboBox = new JComboBox(value);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			  String str=(String)comboBox.getSelectedItem();
			  if(str.equalsIgnoreCase("select"))
				  JOptionPane.showMessageDialog(getParent(), "Pls select any option", "Information", JOptionPane.WARNING_MESSAGE);
			  else if(str.equalsIgnoreCase("all"))
			  {
				
				JFrame frm=new JFrame("All Records");
				frm.setSize(1000, 600);
				frm.setLocationRelativeTo(frm);
				
				
				GetValue.searchAllValues();
				JTable table=new JTable(GetValue.records, GetValue.colNames);
			    JScrollPane pane=new JScrollPane(table);
			    frm.add(pane);
			    frm.setVisible(true);
			  
			  }
			  else
			  {
				JFrame frm=new JFrame("Search by");
				frm.setSize(400, 150);
				frm.setLocationRelativeTo(frm);
				
				
				SearchPanel obj=new SearchPanel(str);
				
				frm.add(obj);
				frm.setVisible(true);
				
				
				
				  
			  }
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(165)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSearchBy)
									.addGap(28)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchBy)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnNewButton)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
