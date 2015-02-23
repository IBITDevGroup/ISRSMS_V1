import java.awt.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class authentication_gui extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField password;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			authentication_gui dialog = new authentication_gui();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	//Initializes global connection variable
	Connection loginconnection = null;
	
	
	
	public authentication_gui() {
		
		//Calls sqlite connection class for loginconnection
		loginconnection = SQLite_login_connector.logindb_connection();
		
		
		setBounds(100, 100, 450, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		password = new JPasswordField();
		password.setToolTipText("Enter your password here");
		password.setBounds(130, 63, 217, 20);
		contentPanel.add(password);
		
		username = new JTextField();
		username.setToolTipText("Enter your username here");
		username.setBounds(130, 32, 217, 20);
		contentPanel.add(username);
		username.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(30, 35, 90, 14);
		contentPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 60, 90, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblIsrSmsLogin = new JLabel("ISR SMS Login");
		lblIsrSmsLogin.setBounds(190, 11, 102, 14);
		contentPanel.add(lblIsrSmsLogin);
		
		JLabel lblerror = new JLabel("");
		lblerror.setForeground(Color.RED);
		lblerror.setBounds(110, 95, 280, 14);
		contentPanel.add(lblerror);
		
		JLabel labelimg = new JLabel("");		
		ImageIcon img_logo = new ImageIcon("graphics_resources/isr1.png"); //creates ImageIcon object
		labelimg.setIcon(img_logo);				
		labelimg.setBounds(357, 31, 75, 52);
		contentPanel.add(labelimg);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(Color.GRAY);
				okButton.setForeground(Color.WHITE);
				okButton.setToolTipText("Press after finishing entry to proceed!");
				okButton.addActionListener(new ActionListener() {
					//ActionPerform for OK button
					public void actionPerformed(ActionEvent e) {
					
					//declares password and user name strings	
					String user;
					char[] temp;
					
					//fetches password and user name from JTextFields
					user = username.getText();
					temp = password.getPassword();
					String pswd = new String(temp);
					
					//Initializes error message string 
					String x = "Wrong Username or password! Try Again!";
					
					
					
					//temporary if else loop for authentication (will be replaced by database-based system hard-coded in another class
					if (user.equals("Tim") && pswd.equals("hallo")){
					

					
						
					//disposes of authentication GUI, purges it from memory
					dispose();	
					
					//Opens Main Landing GUI in full screen mode
					GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
					GraphicsDevice gd = env.getDefaultScreenDevice();
					
					gui_main_landing main = new gui_main_landing();
					main.setVisible(true);
					main.setModal(true);
					main.setResizable(false);					
					gd.setFullScreenWindow(main);
					Rectangle bounds = env.getMaximumWindowBounds();
					main.setBounds(bounds);
								
					
									
					
					}
						
					
					
					
					else{ 					
						//Sets error message text
						lblerror.setText(x);     }
					
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setToolTipText("Closes login window and cancels operation");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
