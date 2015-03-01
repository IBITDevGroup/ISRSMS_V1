package GUI.Chat;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class chat_gui extends JDialog {

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
		setBounds(100, 100, 450, 300);

	}

}
