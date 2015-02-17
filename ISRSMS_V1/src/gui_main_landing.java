import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class gui_main_landing extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
					GraphicsDevice gd = env.getDefaultScreenDevice();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //uses os window manager
					gui_main_landing dialog = new gui_main_landing();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setResizable(false);					
					gd.setFullScreenWindow(this);
					Rectangle bounds = env.getMaximumWindowBounds();
					setBounds(bounds);
				  } catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public gui_main_landing() {
		setBounds(100, 100, 450, 300);

	}

}
