package _02_Chat_Application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
	
	public static void main(String[] args) {
		ChatApp ca = new ChatApp();
		ca.createUI();
		ca.chat();
	}
	
	JFrame ask;
	JPanel p;
	JLabel l;
//	JButton yes;
//	JButton no;
	JTextField tf;
	
	public void createUI() {
		ask = new JFrame("ChatApp");
		p = new JPanel();
		l = new JLabel();
//		yes = new JButton("Yes");
//		no = new JButton("No");
		tf = new JTextField();
		ask.add(p);
		p.add(l);
//		p.add(yes);
//		p.add(no);
		//p.add(tf);
		ask.setVisible(true);
		ask.pack();
	}
	
	public void chat() {
		int yon = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Select an option", JOptionPane.YES_NO_OPTION);
		
		if (yon == JOptionPane.YES_OPTION) {
			
		} else {
			
		}
	}
}

