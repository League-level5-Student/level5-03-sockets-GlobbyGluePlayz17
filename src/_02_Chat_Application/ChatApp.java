package _02_Chat_Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp implements KeyListener {
	
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
		tf = new JTextField();
		ask.add(p);
		p.add(l);
		ask.pack();
	}
	
	String soc = "";
	
	Server server;
	Client client;
	
	public void chat() {
		int yon = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Select an option", JOptionPane.YES_NO_OPTION);
		
		if (yon == JOptionPane.YES_OPTION) {
			soc = "server";
			server = new Server(8080);
			JOptionPane.showMessageDialog(null, "Server started at: " + server.getIPAddress() + "\nPort: " + server.getPort());
			ask.add(tf);
			tf.setSize(400, 50);
			tf.setLocation(0, 350);
			//tf.setEditable(true);
			tf.addKeyListener(this);
			ask.add(l);
			l.setSize(400, 350);
			l.setLocation(0, 0);
			ask.setSize(415, 440);
			ask.setVisible(true);
			ask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			server.start();
			
		} else {
			soc = "client";
			String ip = JOptionPane.showInputDialog("Please enter the IP Address of the server computer:");
			String portS = JOptionPane.showInputDialog("Please enter the port number of the server computer:");
			int portnum = Integer.parseInt(portS);
			client = new Client(ip, portnum);
			ask.setSize(400, 400);
			ask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ask.setVisible(true);
			client.start();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("aset");
			String newmsg = tf.getText();
			if (newmsg.isEmpty()) {
				l.setText(l.getText() + "\n   —");
			} else {
				l.setText(l.getText() + "\n   " + newmsg);
			}
			tf.setText("");
		} 
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

