package chat;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class chat_gui extends JDialog {
	
	String Username;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	ArrayList<String> userList = new ArrayList<String>();
	boolean isConnected;
	public JTextField usernameField;	
    public JTextArea onlineUsersArea;
	public JTextArea chatTextArea;
	public JTextArea inputTextArea;
    
public class IncomingReader implements Runnable{

	        public void run() {
	            String Stream;
	        	String[] data;
	            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";
	            
	            try {
	                while ((stream = reader.readLine()) != null) {

	                    data = stream.split(":");

	                     if (data[2].equals(chat)) {

	                        chatTextArea.append(data[0] + ": " + data[1] + "\n");
	                        chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength());

	                    } else if (data[2].equals(connect)){

	                        chatTextArea.removeAll();
	                        userAdd(data[0]);

	                    } else if (data[2].equals(disconnect)) {


	                        userRemove(data[0]);

	                    } else if (data[2].equals(done)) {


	                    	onlineUsersArea.setText("");
	                        writeUsers();
	                        userList.clear();

	                    }
	                 
	                }
	           }
	            catch(Exception ex) {
	            	JOptionPane.showMessageDialog(null, ex);
	            }
	     }
	        
}



public void ListenThread() {
    Thread IncomingReader = new Thread(new IncomingReader());
    IncomingReader.start();
}

public void userAdd(String data) {
    userList.add(data);

}

public void userRemove(String data) {
    chatTextArea.append(data + " has disconnected.\n");

}

public void writeUsers() {
    String[] tempList = new String[(userList.size())];
    userList.toArray(tempList);
    for (String token:tempList) {

    	onlineUsersArea.append(token + "\n");

    }

}
	
public void sendDisconnect() {

    String bye = (Username + ": :Disconnect");
     try{
         writer.println(bye); // Sends server the disconnect signal.
         writer.flush(); // flushes the buffer
     } catch (Exception e) {
         chatTextArea.append("Could not send Disconnect message.\n");
     }

   }

public void Disconnect() {

     try {
            chatTextArea.append("Disconnected.\n");
            sock.close();
            } 
     catch(Exception ex) {
            chatTextArea.append("Failed to disconnect. \n");
     }
     isConnected = false;
     usernameField.setEditable(true);
     onlineUsersArea.setText(""); 
}	       

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat_gui dialog = new chat_gui();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setResizable(false);
					dialog.setAlwaysOnTop(true);
					dialog.setAutoRequestFocus(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public chat_gui() {
		
		setBounds(100, 100, 650, 500);
		getContentPane().setLayout(null);
		
		JLabel lblUsersOnline = new JLabel("Users online:");
		lblUsersOnline.setBounds(493, 12, 129, 16);
		getContentPane().add(lblUsersOnline);
		
		JTextArea onlineUsersArea = new JTextArea();
		onlineUsersArea.setEditable(false);
		onlineUsersArea.setBounds(433, 52, 189, 398);
		getContentPane().add(onlineUsersArea);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setEditable(false);
		chatTextArea.setLineWrap(true);
		chatTextArea.setBounds(12, 52, 398, 283);
		getContentPane().add(chatTextArea);
		
		JTextArea inputTextArea = new JTextArea();
		inputTextArea.setLineWrap(true);
		inputTextArea.setBounds(12, 347, 311, 66);
		getContentPane().add(inputTextArea);
		
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO add your handling code here:
		        String nothing = "";
		        if ((inputTextArea.getText()).equals(nothing)) {
		            inputTextArea.setText("");
		            inputTextArea.requestFocus();
		        } else {
		            try {
		               writer.println(Username + ":" + inputTextArea.getText() + ":" + "Chat");
		               writer.flush(); // flushes the buffer
		            } catch (Exception ex) {
		                chatTextArea.append("Message could not be sent. \n");
		            }
		            inputTextArea.setText("");
		            inputTextArea.requestFocus();
		        }

		        inputTextArea.setText("");
		        inputTextArea.requestFocus();	
				
			}
		});
		sendButton.setBounds(334, 347, 76, 66);
		getContentPane().add(sendButton);
		
		JLabel lblConnected = new JLabel("");
		lblConnected.setBackground(Color.LIGHT_GRAY);
		lblConnected.setForeground(Color.GREEN);
		lblConnected.setBounds(12, 434, 74, 16);
		getContentPane().add(lblConnected);
		
		JLabel lblDisconnected = new JLabel("Disconnected");
		lblDisconnected.setForeground(Color.RED);
		lblDisconnected.setBackground(Color.LIGHT_GRAY);
		lblDisconnected.setBounds(98, 434, 86, 16);
		getContentPane().add(lblDisconnected);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(0, 40, 650, 8);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(419, 41, 16, 421);
		getContentPane().add(separator_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(12, 12, 74, 16);
		getContentPane().add(lblUsername);
		
		JButton connectButton = new JButton("Connect");
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				
				if (isConnected == false) {
		            Username = usernameField.getText();
		            usernameField.setEditable(false);
		            
		            try {
		                sock = new Socket("127.0.0.1", 5000); //loop-back IP just for testing. will add server IP later, will have to change port as well!
		                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
		                reader = new BufferedReader(streamreader);
		                writer = new PrintWriter(sock.getOutputStream());
		                writer.println(Username + ":has connected.:Connect"); // Displays to everyone that user connected.
		                writer.flush(); // flushes the buffer
		                isConnected = true; // Used to see if the client is connected.
		                lblDisconnected.setText("");
		                lblConnected.setText("Connected!");
		            } catch (Exception ex) {
		                chatTextArea.append(" Cannot Connect! Check your Internet Connection and try again. ");
		                usernameField.setEditable(true);
		                lblConnected.setText("");
		                lblDisconnected.setText("Disconnected!");
		            }
		            
		            //penis! Malte ist ein hurensohn!!
		            ListenThread();
		        } else if (isConnected == true) {
		            chatTextArea.append("You are already connected. \n");		            
		        }				
			}
		});
		connectButton.setBounds(213, 7, 98, 26);
		getContentPane().add(connectButton);
		
		JButton disconnectButton = new JButton("Disconnect");
		disconnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sendDisconnect();
		        Disconnect();
		        lblConnected.setText("");
                lblDisconnected.setText("Disconnected!");
				
			}
		});
		disconnectButton.setBounds(323, 7, 98, 26);
		getContentPane().add(disconnectButton);
		
		usernameField = new JTextField();
		usernameField.setBounds(80, 10, 129, 21);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		

	}
}
