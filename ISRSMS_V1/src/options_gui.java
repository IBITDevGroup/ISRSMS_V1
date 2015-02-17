import java.awt.EventQueue;

import javax.swing.JDialog;


public class options_gui extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					options_gui dialog = new options_gui();
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
	public options_gui() {
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(null);

	}

}
