package GUI;
import sqlcontrol.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;

//INCOMPLTE; MAJOR WIP
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
					gui_main_landing dialog = new gui_main_landing();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setResizable(false);					
					gd.setFullScreenWindow(dialog);
					Rectangle bounds = env.getMaximumWindowBounds();
					dialog.setBounds(bounds);
					
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					
				  
				} 
				
				   catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the dialog.
	 */
	public gui_main_landing() {
		
		ImageIcon cheap_logo = new ImageIcon("graphics_resources/cheap_logo.png"); //creates logo icon
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("Student Browser");
		internalFrame.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.WHITE));
		internalFrame.setBounds(10, 11, 412, 965);	
		internalFrame.setResizable(true);
		internalFrame.setFrameIcon(cheap_logo);
		getContentPane().add(internalFrame);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("Main");
		internalFrame_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.WHITE));
		internalFrame_1.setBounds(432, 11, 1462, 625);
		internalFrame_1.setResizable(true);
		internalFrame_1.setFrameIcon(cheap_logo);
		getContentPane().add(internalFrame_1);	
		
		JInternalFrame internalFrame_2 = new JInternalFrame("Quick Access");
		internalFrame_2.setAutoscrolls(true);
		internalFrame_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, new Color(255, 255, 255)));
		internalFrame_2.setBounds(432, 647, 1462, 329);
		internalFrame_2.setResizable(true);
		internalFrame_2.setFrameIcon(cheap_logo);
		
		getContentPane().add(internalFrame_2);
		internalFrame_2.setVisible(true);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
		
		ImageIcon save_one_icon = new ImageIcon("graphics_resources/save_one.png"); //Creates save one icon
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("Add");
		ImageIcon new_icon = new ImageIcon("graphics_resources/new.png");
		mnNew.setIcon(new_icon);
		mnFile.add(mnNew);
		
		JMenuItem mntmEntry = new JMenuItem("Entry            ");
		ImageIcon entry_icon = new ImageIcon("graphics_resources/new_entry.png");
		mntmEntry.setIcon(entry_icon);
		mnNew.add(mntmEntry);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(gui_main_landing.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		mnFile.add(mntmOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setIcon(new ImageIcon(gui_main_landing.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		mnFile.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Redo"               );
		mntmRedo.setIcon(new ImageIcon(gui_main_landing.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		mnFile.add(mntmRedo);
		
		JSeparator separator_2 = new JSeparator();
		mnFile.add(separator_2);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.setIcon(new ImageIcon(gui_main_landing.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(gui_main_landing.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		mnFile.add(mntmSave);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmRefreshAll = new JMenuItem("Refresh All");
		ImageIcon refresh_icon = new ImageIcon("graphics_resources/refresh.png");
		mntmRefreshAll.setIcon(refresh_icon);
		mnFile.add(mntmRefreshAll);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JButton btnSaveAll = new JButton("Refresh");
		btnSaveAll.setForeground(Color.WHITE);
		btnSaveAll.setBackground(Color.DARK_GRAY);
		menuBar.add(btnSaveAll);
		
		JButton btnChat = new JButton("Chat");
		btnChat.setForeground(Color.WHITE);
		btnChat.setBackground(Color.DARK_GRAY);
		menuBar.add(btnChat);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		menuBar.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});

	}
}
