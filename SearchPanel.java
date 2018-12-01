import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SearchPanel extends JPanel implements ActionListener
{
	JLabel lbl;
	JComboBox combo;
	JButton btn;
	String str;
	public SearchPanel(String str)
	{
		setLayout(new FlowLayout() );
		
		lbl=new JLabel("Select Value");
		this.str=str;
		
		combo=new JComboBox(GetValue.getValue(str));
		btn=new JButton("Search");
		
		
		add(lbl);add(combo);add(btn);
		btn.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String value=(String)combo.getSelectedItem();
		System.out.println(str+":::"+value);
		GetValue.searchValuesBy(str, value);
		JFrame frm=new JFrame();
		frm.setSize(1000, 400);
		frm.setLocationRelativeTo(this);
		JTable table=new JTable(GetValue.records, GetValue.colNames);
	    JScrollPane pane=new JScrollPane(table);
	    frm.add(pane);
	    frm.setVisible(true);  
		  
		
	}
	

}
