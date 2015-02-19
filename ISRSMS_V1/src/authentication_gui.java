import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

//INCOMPLETE! PROBLEM WITH JPASSWORDFIELD! MIGHT BE CHAR[] VALUE
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
	public authentication_gui() {
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(Color.BLACK);
				okButton.setToolTipText("Press after finishing entry to proceed!");
				okButton.addActionListener(new ActionListener() {
					//Actionperform for ok button
					public void actionPerformed(ActionEvent e) {
					
					//declares password and username strings	
					String user;
					char[] temp;
					
					//fetches password and username from jtextfields
					user = username.getText();
					temp = password.getPassword();
					String pswd = new String(temp);
					
					//Initializes error message string 
					String x = "Wrong Username or password! Try Again!";
					
					
					
					//temporary if else loop for authentication (will be replaced by database-based system hardcoded in another class
					//Not working yet! Unsure why!?
					if (user.equals("Tim") && pswd.equals("hallo")){
					
					//Creates object form authentication success dialog class
					auth_success_dialog success_dialog = new auth_success_dialog(); 
					
					//Opens authentication success dialog from class	
					success_dialog.setVisible(true);	
					
					//disposes of authentication GUI, purges it from memory
					dispose();					
						
					}
						
					else{ 
						
						//Sets error message text
						lblerror.setText(x);						
					}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
