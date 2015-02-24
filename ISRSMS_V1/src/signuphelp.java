

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signuphelp extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			signuphelp dialog = new signuphelp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public signuphelp() {
		setBounds(100, 100, 340, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea txtrSigningUp = new JTextArea();
		txtrSigningUp.setText("1.\tSigning up for ISRSMS\r\nSigning up for ISRSMS is retardedly simple! \r\nJust hover your mouse over the specific fields\r\n and follow the instructions.\r\n\r\n2.\tChoosing a username\r\nYour username has to, of course, be unique. \r\nPreferably choose your real name as your \r\nusername, that way you won\u2019t forget shit.  \r\nAll usernames are stored in a secure SQL database.\r\n\r\n3.\tChoosing a password\r\nAs passwords are private, passwords don\u2019t \r\nhave to be unique. Remember, the longer \r\nthe password, the harder it is to guess!\r\n Similar to usernames, all passwords are stored\r\n in a secure SQL database. Make sure that both\r\n passwords you have entered match!\r\n\r\n4.\tThe admin confirmation\r\nFor obvious reasons, you cannot simply create\r\n an account for ISRSMS! Find a teacher or prefect\r\n who is in possession of the admin confirmation\r\n code and ask him to confirm your signup by entering\r\n said code!\r\n\r\n5.\tTroubleshooting\r\nThis is a signup dialog, dumbass, so there really is no\r\n reason for any serious issues to occur. Should an error\r\n message be displayed anyways, follow the\r\n on-screen instructions!\r\n");
		txtrSigningUp.setBounds(10, 11, 414, 507);
		contentPanel.add(txtrSigningUp);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
