import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//WIP PRLIMINARY COMPLETION!
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
				main.setModal(isModal());
				
				//enables fullscreen and OS specific look and feel
				GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
				GraphicsDevice gd = env.getDefaultScreenDevice();
				gd.setFullScreenWindow(main);
				Rectangle bounds = env.getMaximumWindowBounds();
				main.setBounds(bounds);
				
				main.setVisible(true);				
				
				dispose();
				
			}
		});
		btnOk.setBounds(163, 36, 89, 23);
		getContentPane().add(btnOk);

	}

}
