import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class auth_success_dialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					auth_success_dialog dialog = new auth_success_dialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public auth_success_dialog() {
		setBounds(100, 100, 450, 130);
		getContentPane().setLayout(null);
		
		JLabel lblSuccessYouAre = new JLabel("Success! You are now logged in!");
		lblSuccessYouAre.setBounds(125, 11, 209, 14);
		getContentPane().add(lblSuccessYouAre);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gui_main_landing main = new gui_main_landing();
				main.setVisible(true);
				
				dispose();
				
			}
		});
		btnOk.setBounds(163, 36, 89, 23);
		getContentPane().add(btnOk);

	}

}
