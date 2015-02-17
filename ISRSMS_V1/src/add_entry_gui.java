import java.awt.EventQueue;

import javax.swing.JDialog;


public class add_entry_gui extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_entry_gui dialog = new add_entry_gui();
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
	public add_entry_gui() {
		setBounds(100, 100, 450, 300);

	}

}
