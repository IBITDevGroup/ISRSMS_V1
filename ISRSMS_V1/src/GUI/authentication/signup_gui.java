package GUI.authentication;
import sqlcontrol.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//NOT FULLY FUNCTIONAL YET! HAVE TO DEBUG SOMETIME SOON!

public class signup_gui extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtusername;
	private JPasswordField psswd;
	private JPasswordField psswdconfirm;
	private JPasswordField adminpsswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			signup_gui dialog = new signup_gui();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	Connection signupconnection = null;
	
	
	public signup_gui() {
		
		//Calls sqlite connection class for loginconnection
		signupconnection = SQLite_login_connector.logindb_connection();
		
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIsrsmsSignup = new JLabel("ISRSMS Signup");
		lblIsrsmsSignup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIsrsmsSignup.setBounds(159, 11, 190, 50);
		contentPanel.add(lblIsrsmsSignup);
		{
			JLabel lblChooseAUsername = new JLabel("<html>Choose a Username  <br>(Preferrably your real Name!)</html>");
			lblChooseAUsername.setBounds(10, 136, 200, 28);
			contentPanel.add(lblChooseAUsername);
		}
		
		txtusername = new JTextField();
		txtusername.setBounds(224, 133, 200, 20);
		contentPanel.add(txtusername);
		txtusername.setColumns(10);
		{
			JLabel lblChooseAPassword = new JLabel("Choose a password");
			lblChooseAPassword.setToolTipText("Longer Passwords are safer!");
			lblChooseAPassword.setBounds(10, 173, 144, 42);
			contentPanel.add(lblChooseAPassword);
		}
		{
			JLabel lblRetypePassword = new JLabel("Re-Type Password");
			lblRetypePassword.setBounds(10, 226, 116, 42);
			contentPanel.add(lblRetypePassword);
		}
		
		    psswd = new JPasswordField();
		    psswd.setToolTipText("Enter Password here.");
		    psswd.setBounds(224, 184, 200, 20);
		    contentPanel.add(psswd);
		{
			psswdconfirm = new JPasswordField();
			psswdconfirm.setToolTipText("Re-type the above.");
			psswdconfirm.setBounds(224, 237, 200, 20);
			contentPanel.add(psswdconfirm);
		}
		{
			JLabel lblEnterAdminConfirmation = new JLabel("Enter Admin Confirmation");
			lblEnterAdminConfirmation.setToolTipText("REQUIRED");
			lblEnterAdminConfirmation.setBounds(10, 312, 190, 50);
			contentPanel.add(lblEnterAdminConfirmation);
		}
		{
			JLabel lblerror = new JLabel("  ");
			lblerror.setForeground(Color.RED);
			lblerror.setBounds(10, 368, 414, 50);
			contentPanel.add(lblerror);
		}
		{
			adminpsswd = new JPasswordField();
			adminpsswd.setBounds(224, 327, 200, 20);
			contentPanel.add(adminpsswd);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
					
					String username = txtusername.getText();
					
					char[] temp_psswd = psswd.getPassword();
					char[] temp_psswdconfirm = psswdconfirm.getPassword();
					char[] temp_adminpsswd = adminpsswd.getPassword();
						
					String psswd = new String(temp_psswd);
					String psswdconfirm = new String(temp_psswdconfirm);
					String adminpsswd = new String(temp_adminpsswd);
					
					boolean usrnme;
					boolean a;
					
					
				try{
					
					//Query for sqlite db + result set.
					  String queryusername = "select * from login_data where username=?";					
					  PreparedStatement pst_signup = signupconnection.prepareStatement(queryusername);
					  pst_signup.setString(1, username);
					  ResultSet usernameresults = pst_signup.executeQuery();
					  
					  int count = 0;
					  
					  while(usernameresults.next()){
						  count++;
					      }
					 
					  pst_signup.close();
					  usernameresults.close();
					  
					  
					    if(count == 0){
					    	if(psswd.equals(psswdconfirm)){
					    		if(adminpsswd.equals("admin")){  //Not permanent, have to replace once MySQL server is up!
					    			
					    			String queryadd = "insert into login_data (username, password) values (?,?) "; //adds entries to sqlite table for login info!
					    			PreparedStatement pst_add = signupconnection.prepareStatement(queryadd);
					    			pst_add.setString(1, username);
					    			pst_add.setString(2, psswd);
					    			
					    			pst_add.execute();
					    		
					    			JOptionPane.showMessageDialog(null, "Data saved!");   
					    			
					    			dispose();
					    			
					    		    pst_add.close();
					    		    					    			
					    		}
					    		else{
					    		  JOptionPane.showMessageDialog(null, "The Admin Password is incorrect!");   	
					    		  }				    		
					    		
					    	}				    	
					    	else{
					    	  JOptionPane.showMessageDialog(null, "Your Passwords do not match!");
					    	  }    	
					    	
					       }
					    					    
					  
					    else{
					      JOptionPane.showMessageDialog(null, "Your username is already taken!");	
					      }
						
						
						
				  }
				
				catch(Exception f){
					JOptionPane.showMessageDialog(null, "<html>Something went worng! <br> Report this error ASAP! <br></html>"+f);
				    }
				
				
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					JButton btnHelp = new JButton("help");
					btnHelp.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {						
							
							signuphelp help = new signuphelp();
							help.setVisible(true);
							
						}
					});
					buttonPane.add(btnHelp);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
