import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jidesoft.swing.RangeSlider;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class userInterface extends JFrame {

	private static JButton button_9 = new JButton();
	private static JButton button_4 = new JButton();
	private static JButton button_3 = new JButton();
	private static JButton button_5 = new JButton();
	private static JButton button_10 = new JButton();
	private static JButton button_11 = new JButton();
	private static JButton button_12 = new JButton();
	private static JButton button_6 = new JButton();
	private static JButton button_15 = new JButton();
	private static JButton button_14 = new JButton();
	private static JButton button_13 = new JButton();
	private static JButton button_7 = new JButton();
	private static JButton button_18 = new JButton();
	private static JButton button_17 = new JButton();
	private static JButton button_16 = new JButton();
	private static JButton button_8 = new JButton();
	private static JButton button_19 = new JButton("Import");
	private static JButton button_20 = new JButton("Delete");
	private static JButton button_2 = new JButton("Play");
	private static JButton button = new JButton("Stop");
	private static JButton btnSave = new JButton("Save");
	private static JButton button_1 = new JButton("Load");
	private static JButton button_21 = new JButton("Save to Cropped");
	private static JPanel panel_1 = new JPanel();
	private RangeSlider slider = new RangeSlider(0,10000000,0,10000000);
	private static JFrame frame = new JFrame();
	private JLabel lblNewLabel = new JLabel("");
	private Icon icon;
	private static char b1;
	private static char b2;
	private static char b3;
	private static char b4;
	private static char b5;
	private static char b6;
	private static char b7;
	private static char b8;
	private static char b9;
	private static char b10;
	private static char b11;
	private static char b12;
	private static char b13;
	private static char b14;
	private static char b15;
	private static char b16;
	private static String[] keyOptions = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	
	private static boolean running = true;
	private boolean assignMode = false;
	private JPanel panel;
	private JFileChooser chooser;
	private DefaultListModel importedFilesModel = new DefaultListModel();
	private DefaultListModel croppedFilesModel = new DefaultListModel();
	private static final int defaultWidth = 1200;
	private static final int defaultHeight = 800;
	private String currentFileName = null;
	private int locOfFile = 0;
	private boolean fileInImportedModel = true;
	
	private int keyPress = 0;/////////////////////////////////////////////////////////////////////
	private boolean keyDown = false;/////////////////////////////////////////////////////////////
	
	
	private static audioFile file1 = new audioFile(); 
	private static audioFile file2 = new audioFile(); 
	private static audioFile file3 = new audioFile(); 
	private static audioFile file4 = new audioFile(); 
	private static audioFile file5 = new audioFile(); 
	private static audioFile file6 = new audioFile(); 
	private static audioFile file7 = new audioFile(); 
	private static audioFile file8 = new audioFile(); 
	private static audioFile file9 = new audioFile();
	private static audioFile file10 = new audioFile(); 
	private static audioFile file11 = new audioFile(); 
	private static audioFile file12 = new audioFile(); 
	private static audioFile file13 = new audioFile(); 
	private static audioFile file14 = new audioFile(); 
	private static audioFile file15 = new audioFile(); 
	private static audioFile file16 = new audioFile(); 
	private static audioFile temp = new audioFile();
	private JTextField textField;
	private JTextField textField_1;
	
	/*
	public void keyPressed(KeyEvent event) {
		char key = event.getKeyChar();
		if (key == file1.keyTrigger) {
			file1.playFile();
		}
		System.out.println(key);
		System.out.println(file1.keyTrigger);
	} */
	
	private char chooseKeyAssign(JButton btn, audioFile file) {
		String input = (String)JOptionPane.showInputDialog(
				frame,
				"Assign a key to this button",
				"Key Assignment",
				JOptionPane.PLAIN_MESSAGE,
				icon,
				keyOptions,
				"a");
		char key = input.charAt(0);
		if(file.fileName == null) {
			btn.setText("Unassigned [" + key + "]");
		}
		else {
			btn.setText(file.fileName + " [" + key + "]");
		}
		return key;
	}
	
	private void updateButtonText(JButton btn, audioFile file) {
		if (file.keyTrigger == '\0') {
			btn.setText(file.fileName + " [-]");
		}
		else {
			btn.setText(file.fileName + " [" + file.keyTrigger + "]");
		}
	}
	
	private void playOnKeyPress(char key, audioFile file) {
		if (key == file.keyTrigger) {
			if (keyPress == 0) {
				file.playFile();
			}	
		}
	}
	
	private void disableall() {
		button.setEnabled(false);
		button_2.setEnabled(false);
		button_20.setEnabled(false);
		//panel_1.setEnabled(false);
		slider.setEnabled(false);
		btnSave.setEnabled(false);
		button_1.setEnabled(false);
		button_21.setEnabled(false);
		button_19.setEnabled(false);
	}
	
	private void enableall() {
		button.setEnabled(true);
		button_2.setEnabled(true);
		button_20.setEnabled(true);
		//panel_1.setEnabled(true);
		slider.setEnabled(true);
		btnSave.setEnabled(true);
		button_1.setEnabled(true);
		button_21.setEnabled(true);
		button_19.setEnabled(true);
	}
	
	private void disabled() {
		button.setEnabled(false);
		button_2.setEnabled(false);
		button_20.setEnabled(false);
		//panel_1.setEnabled(false);
		slider.setEnabled(false);
		button_21.setEnabled(false);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setEnabled(false);
	}
	
	private void enabled() {
		button.setEnabled(true);
		button_2.setEnabled(true);
		button_20.setEnabled(true);
		//panel_1.setEnabled(true);
		slider.setEnabled(true);
		button_21.setEnabled(true);
		lblNewLabel.setEnabled(true);
	}
	
	public userInterface() {
		disabled();
		getContentPane().setBackground(SystemColor.windowBorder);
		setSize(defaultWidth, defaultHeight);
		setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(".")); 
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent event) {
			  		char key = event.getKeyChar();
			  		playOnKeyPress(key, file1);
			  		playOnKeyPress(key, file2);
			  		playOnKeyPress(key, file3);
			  		playOnKeyPress(key, file4);
			  		playOnKeyPress(key, file5);
			  		playOnKeyPress(key, file6);
			  		playOnKeyPress(key, file7);
			  		playOnKeyPress(key, file8);
			  		playOnKeyPress(key, file9);
			  		playOnKeyPress(key, file10);
			  		playOnKeyPress(key, file11);
			  		playOnKeyPress(key, file12);
			  		playOnKeyPress(key, file13);
			  		playOnKeyPress(key, file14);
			  		playOnKeyPress(key, file15);
			  		playOnKeyPress(key, file16);
				    if(keyPress >= 2) {
				    	keyPress = -1;
				    }
				    keyPress = keyPress + 1;
					return true;
		      }
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					String filePath = selectedFile.getPath();
					try {
						importedFilesModel.clear();
						croppedFilesModel.clear();
						storedFiles.loadKit(filePath);
						for(int i = 0; i < storedFiles.fileNames.size(); i++) {
							importedFilesModel.addElement(storedFiles.fileNames.get(i));
						}
						for(int i = 0; i < storedFiles.croppedFileNames.size(); i++) {
							croppedFilesModel.addElement(storedFiles.croppedFileNames.get(i));
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		button_5 = new JButton("Unassigned [-]");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file4.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_5, file4);
					enableall();
				}
				else {
					file4.playFile();	
				}	
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file4.keyTrigger = chooseKeyAssign(button_5, file4);
				}
			}
		});
		
		button_6 = new JButton("Unassigned [-]");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file8.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_6, file8);
					enableall();
				}
				else {
					file8.playFile();	
				}	
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file8.keyTrigger = chooseKeyAssign(button_6, file8);
				}
			}
		});
		
		button_7 = new JButton("Unassigned [-]");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file12.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_7, file12);
					enableall();
				}
				else {
					file12.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file12.keyTrigger = chooseKeyAssign(button_7, file12);
				}
			}
		});
		
		button_8 = new JButton("Unassigned [-]");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file16.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_8, file16);
					enableall();
				}
				else {
					file16.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file16.keyTrigger = chooseKeyAssign(button_8, file16);
				}
			}
		});
		
		button_3 = new JButton("Unassigned [-]");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file3.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_3, file3);
					enableall();
				}
				else {
					file3.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file3.keyTrigger = chooseKeyAssign(button_3, file3);
				}
			}
		});
		
		button_4 = new JButton("Unassigned [-]");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file2.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_4, file2);
					enableall();
				}
				else {
					file2.playFile();	
				}	
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file2.keyTrigger = chooseKeyAssign(button_4, file2);
				}
			}
		});
		
		button_9 = new JButton("Unassigned [-]");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file1.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_9, file1);
					enableall();
				}
				else {
					file1.playFile();	
				}	
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file1.keyTrigger = chooseKeyAssign(button_9, file1);
				}
			}
		});
		
		button_10 = new JButton("Unassigned [-]");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file5.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_10, file5);
					enableall();
				}
				else {
					file5.playFile();	
				}	
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file5.keyTrigger = chooseKeyAssign(button_10, file5);
				}
			}
		});
		
		button_11 = new JButton("Unassigned [-]");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file6.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_11, file6);
					enableall();
				}
				else {
					file6.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file6.keyTrigger = chooseKeyAssign(button_11, file6);
				}
			}
		});
		
		button_12 = new JButton("Unassigned [-]");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file7.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_12, file7);
					enableall();
				}
				else {
					file7.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file7.keyTrigger = chooseKeyAssign(button_12, file7);
				}
			}
		});
		
		button_13 = new JButton("Unassigned [-]");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file11.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_13, file11);
					enableall();
				}
				else {
					file11.playFile();	
				}	
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file11.keyTrigger = chooseKeyAssign(button_13, file11);
				}
			}
		});
		
		button_14 = new JButton("Unassigned [-]");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file10.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_14, file10);
					enableall();
				}
				else {
					file10.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file10.keyTrigger = chooseKeyAssign(button_14, file10);
				}
			}
		});
		
		button_15 = new JButton("Unassigned [-]");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file9.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_15, file9);
					enableall();
				}
				else {
					file9.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file9.keyTrigger = chooseKeyAssign(button_15, file9);
				}
			}
		});
		
		button_16 = new JButton("Unassigned [-]");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file15.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_16, file15);
					enableall();
				}
				else {
					file15.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file15.keyTrigger = chooseKeyAssign(button_16, file15);
				}
			}
		});
		
		button_17 = new JButton("Unassigned [-]");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file14.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_17, file14);
					enableall();
				}
				else {
					file14.playFile();	
				}	
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file14.keyTrigger = chooseKeyAssign(button_17, file14);
				}
			}
		});
		
		button_18 = new JButton("Unassigned [-]");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(assignMode) {
					file13.updateAudioFile(temp.fileName, temp.filePath, temp.startPlayback, temp.endPlayback);
					assignMode = false;
					updateButtonText(button_18, file13);
					enableall();
				}
				else {
					file13.playFile();	
				}
			}
			public void mouseReleased(MouseEvent arg0) {
				if(SwingUtilities.isRightMouseButton(arg0)){
					file13.keyTrigger = chooseKeyAssign(button_18, file13);
				}
			}
		});
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (button.isEnabled()) {
					if(temp.clipRunning) {
						temp.clip.stop();
					}
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (button_2.isEnabled()) {
					temp.playFile();
				}
			}
		});
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String inputVal = JOptionPane.showInputDialog("Please enter a file name");
				String fileName = inputVal.concat(".txt");
				try {
					storedFiles.saveKit(fileName);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		button_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					String filePath = selectedFile.getPath();
					String fileName = selectedFile.getName();
					storedFiles.filePaths.add(filePath);					
					storedFiles.fileNames.add(fileName);
					storedFiles.fileStartLocations.add((long) 0);
					long endVal = 0;
					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
						Clip clip = AudioSystem.getClip();
						if(!clip.isOpen()) {
							clip.open(stream);
							endVal = clip.getMicrosecondLength();
							storedFiles.fileEndLocations.add(endVal);
							clip.close();
						}					
					}
					catch (Exception e) {
				        System.out.println("Error with playing sound.");
				        e.printStackTrace();
					}	
					importedFilesModel.addElement(fileName);
					
					
					int n = JOptionPane.showConfirmDialog(
							frame,
							"Would you like to crop your imported audio file?",
							"Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					if (n == JOptionPane.YES_OPTION) {
						enabled();
						button_20.setEnabled(false);
						slider.setLowValue(0);
						slider.setHighValue(0);
						slider.setMaximum((int)endVal);
						slider.setHighValue((int)endVal);
						
						try {
							cropFile.displayWaveform(filePath);
						} catch (UnsupportedAudioFileException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						BufferedImage img = null;
						try {
						    img = ImageIO.read(new File("waveform.png"));
						} catch (IOException e) {
						    e.printStackTrace();
						}			
						Image resizedImg = img.getScaledInstance(lblNewLabel.getWidth(), img.getHeight() /*lblNewLabel.getHeight()*/, Image.SCALE_SMOOTH);
						lblNewLabel.setIcon(new ImageIcon(resizedImg));		
						
						temp = new audioFile(fileName, filePath, 0, endVal);
						
						//GENERATE IMAGE
					}
					else {
						storedFiles.croppedFilePaths.add(filePath);
						storedFiles.croppedFileNames.add(fileName + " [Original]");
						storedFiles.croppedFileStartLocations.add((long) 0);
						storedFiles.croppedFileEndLocations.add(endVal);
						croppedFilesModel.addElement(fileName + " [Original]");
						
					}
				}
			}
		});
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (button_20.isEnabled()) {
					int n = JOptionPane.showConfirmDialog(
							frame,
							"Are you sure you want to delete this audio file?",
							"Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					if (n == JOptionPane.YES_OPTION) {
						disabled();
						if(currentFileName != null) {
							if(fileInImportedModel) {
								storedFiles.fileNames.remove(locOfFile);
								storedFiles.filePaths.remove(locOfFile);
								storedFiles.fileStartLocations.remove(locOfFile);
								storedFiles.fileEndLocations.remove(locOfFile);
								importedFilesModel.removeElement(currentFileName);
							}
							else {
								storedFiles.croppedFileNames.remove(locOfFile);
								storedFiles.croppedFilePaths.remove(locOfFile);
								storedFiles.croppedFileStartLocations.remove(locOfFile);
								storedFiles.croppedFileEndLocations.remove(locOfFile);
								croppedFilesModel.removeElement(currentFileName);
							}
						}
						currentFileName = null;
					}
				}
			}
		});
		
		panel_1.setBackground(SystemColor.inactiveCaption);
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				cropFile.crop(temp, slider.getLowValue(), slider.getHighValue());
				textField.setText(String.valueOf(slider.getLowValue()));
				textField_1.setText(String.valueOf(slider.getHighValue()));
			}
		});

		slider.setBackground(SystemColor.inactiveCaption);
		
		textField = new JTextField();
		textField.setColumns(8);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    update();
			  }
			  public void removeUpdate(DocumentEvent e) {
				  update();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  update();
			  }
			  public void update() {
				  if(textField.getText().equals(""))
				  {
					  int f = 0;
				  }
				  else
				  {
					  try
					    {
					      int i = Integer.parseInt(textField.getText());
						  slider.setLowValue(i);
						  cropFile.crop(temp, slider.getLowValue(), slider.getHighValue());
					    }
					  catch (NumberFormatException nfe)
					    {
					        JOptionPane.showMessageDialog(null,
					                "Error: Please enter only numbers int the field", "Error Massage",
					                JOptionPane.ERROR_MESSAGE);
					    }
				  }
			  }
			});
		
		textField_1 = new JTextField();
		textField_1.setColumns(8);
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    update();
			  }
			  public void removeUpdate(DocumentEvent e) {
				  update();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  update();
			  }
			  public void update() {
				  if(textField_1.getText().equals(""))
				  {
					  int f = 0;
				  }
				  else
				  {
					  try
					    {
					      int i = Integer.parseInt(textField_1.getText());
						  slider.setHighValue(i); 
						  cropFile.crop(temp, slider.getLowValue(), slider.getHighValue());
					    }
					  catch (NumberFormatException nfe)
					    {
					        JOptionPane.showMessageDialog(null,
					                "Error: Please enter only numbers in the field", "Error Massage",
					                JOptionPane.ERROR_MESSAGE);
					    }
				  }
			  }
			});
		
		button_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				disabled();
				storedFiles.croppedFilePaths.add(temp.filePath);
				storedFiles.croppedFileNames.add(temp.fileName + " [Cropped]");
				storedFiles.croppedFileStartLocations.add(temp.startPlayback);
				storedFiles.croppedFileEndLocations.add(temp.endPlayback);
				croppedFilesModel.addElement(temp.fileName + " [Cropped]");
			}
		});
		
		
		
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(slider, GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(292)
					.addComponent(button_21)
					.addPreferredGap(ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_21)))
					.addGap(6))
		);
		panel_1.setLayout(gl_panel_1);
		
		JList list = new JList(importedFilesModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enabled();
				currentFileName = (String)list.getSelectedValue();
				for(int i = 0; i < storedFiles.fileNames.size(); i++) {
					if(storedFiles.fileNames.get(i).equals(currentFileName)) {
						locOfFile = i;
						fileInImportedModel = true;
						temp.fileName = storedFiles.fileNames.get(locOfFile);
						temp.filePath = storedFiles.filePaths.get(locOfFile);
						temp.startPlayback = storedFiles.fileStartLocations.get(locOfFile);
						temp.endPlayback = storedFiles.fileEndLocations.get(locOfFile);
						break;
					}
				}
				if (e.getClickCount() == 1) {		
					try {
						cropFile.displayWaveform(temp.filePath);
					} catch (UnsupportedAudioFileException ev) {
						// TODO Auto-generated catch block
						ev.printStackTrace();
					} catch (IOException event) {
						// TODO Auto-generated catch block
						event.printStackTrace();
					}
					
					BufferedImage img = null;
					try {
					    img = ImageIO.read(new File("waveform.png"));
					} catch (IOException e1) {
					    e1.printStackTrace();
					}			
					Image resizedImg = img.getScaledInstance(lblNewLabel.getWidth(), img.getHeight() /*lblNewLabel.getHeight()*/, Image.SCALE_SMOOTH);
					lblNewLabel.setIcon(new ImageIcon(resizedImg));		
					
					slider.setLowValue(0);
					slider.setHighValue(0);
					slider.setMaximum(temp.getFileLength(temp.filePath));
					slider.setHighValue((int)temp.endPlayback);
					slider.setLowValue((int)temp.startPlayback);
				}
				if (e.getClickCount() == 2) {
					int n = JOptionPane.showConfirmDialog(
							frame,
							"Would you like to assign this audio file to a button?",
							"Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					if (n == JOptionPane.YES_OPTION) {
						disableall();
						assignMode = true;
					}
				}
			}
		});
		tabbedPane.addTab("Imported", null, list, null);
		
		
		JList list_1 = new JList(croppedFilesModel);
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enabled();
				currentFileName = (String)list_1.getSelectedValue();
				for(int i = 0; i < storedFiles.croppedFileNames.size(); i++) {
					if(storedFiles.croppedFileNames.get(i).equals(currentFileName)) {
						locOfFile = i;
						fileInImportedModel = false;
						temp.fileName = storedFiles.croppedFileNames.get(locOfFile);
						temp.filePath = storedFiles.croppedFilePaths.get(locOfFile);
						temp.startPlayback = storedFiles.croppedFileStartLocations.get(locOfFile);
						temp.endPlayback = storedFiles.croppedFileEndLocations.get(locOfFile);
						break;
					}
				}
				if (e.getClickCount() == 1) {
					try {
						cropFile.displayWaveform(temp.filePath);
					} catch (UnsupportedAudioFileException ev) {
						// TODO Auto-generated catch block
						ev.printStackTrace();
					} catch (IOException event) {
						// TODO Auto-generated catch block
						event.printStackTrace();
					}
					
					BufferedImage img = null;
					try {
					    img = ImageIO.read(new File("waveform.png"));
					} catch (IOException e1) {
					    e1.printStackTrace();
					}			
					Image resizedImg = img.getScaledInstance(lblNewLabel.getWidth(), img.getHeight() /*lblNewLabel.getHeight()*/, Image.SCALE_SMOOTH);
					lblNewLabel.setIcon(new ImageIcon(resizedImg));		
					
					slider.setLowValue(0);
					slider.setHighValue(0);
					slider.setMaximum(temp.getFileLength(temp.filePath));
					slider.setHighValue((int)temp.endPlayback);
					slider.setLowValue((int)temp.startPlayback);
				}
				if (e.getClickCount() == 2) {
					int n = JOptionPane.showConfirmDialog(
							frame,
							"Would you like to assign this audio file to a button?",
							"Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					if (n == JOptionPane.YES_OPTION) {
						disableall();
						assignMode = true;
					}
				}
			}
		});
		tabbedPane.addTab("Cropped", null, list_1, null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_15, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_18, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_17, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_16, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_19, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_20, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_15, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_18, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_17, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_16, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_19, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_20, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
		);
		getContentPane().setLayout(groupLayout);

	}
		
	public static void main(String[] args) throws IOException {
		new Thread(new Runnable() {
			public void run() {
				while (running) {
					try {
						Thread.sleep((long) 1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(file1.clipRunning){
						file1.stopFile();
						button_9.setBackground(Color.CYAN);
					}
					else {
						button_9.setBackground(SystemColor.inactiveCaption);
					}
					if(file2.clipRunning == true){
						file2.stopFile();
						button_4.setBackground(Color.CYAN);
					}
					else {
						button_4.setBackground(SystemColor.inactiveCaption);
					}
					if(file3.clipRunning == true){
						file3.stopFile();	
						button_3.setBackground(Color.CYAN);
					}
					else {
						button_3.setBackground(SystemColor.inactiveCaption);
					}
					if(file4.clipRunning == true){
						file4.stopFile();	
						button_5.setBackground(Color.CYAN);
					}
					else {
						button_5.setBackground(SystemColor.inactiveCaption);
					}
					if(file5.clipRunning == true){
						file5.stopFile();
						button_10.setBackground(Color.CYAN);
					}
					else {
						button_10.setBackground(SystemColor.inactiveCaption);
					}
					if(file6.clipRunning == true){
						file6.stopFile();	
						button_11.setBackground(Color.CYAN);
					}
					else {
						button_11.setBackground(SystemColor.inactiveCaption);
					}
					if(file7.clipRunning == true){
						file7.stopFile();
						button_12.setBackground(Color.CYAN);
					}
					else {
						button_12.setBackground(SystemColor.inactiveCaption);
					}
					if(file8.clipRunning == true){
						file8.stopFile();	
						button_6.setBackground(Color.CYAN);
					}
					else {
						button_6.setBackground(SystemColor.inactiveCaption);
					}
					if(file9.clipRunning == true){
						file9.stopFile();
						button_15.setBackground(Color.CYAN);
					}
					else {
						button_15.setBackground(SystemColor.inactiveCaption);
					}
					if(file10.clipRunning == true){
						file10.stopFile();
						button_14.setBackground(Color.CYAN);
					}
					else {
						button_14.setBackground(SystemColor.inactiveCaption);
					}
					if(file11.clipRunning == true){
						file11.stopFile();	
						button_13.setBackground(Color.CYAN);
					}
					else {
						button_13.setBackground(SystemColor.inactiveCaption);
					}
					if(file12.clipRunning == true){
						file12.stopFile();	
						button_7.setBackground(Color.CYAN);
					}
					else {
						button_7.setBackground(SystemColor.inactiveCaption);
					}
					if(file13.clipRunning == true){
						file13.stopFile();	
						button_18.setBackground(Color.CYAN);
					}
					else {
						button_18.setBackground(SystemColor.inactiveCaption);
					}
					if(file14.clipRunning == true){
						file14.stopFile();	
						button_17.setBackground(Color.CYAN);
					}
					else {
						button_17.setBackground(SystemColor.inactiveCaption);
					}
					if(file15.clipRunning == true){
						file15.stopFile();	
						button_16.setBackground(Color.CYAN);
					}
					else {
						button_16.setBackground(SystemColor.inactiveCaption);
					}
					if(file16.clipRunning == true){
						file16.stopFile();	
						button_8.setBackground(Color.CYAN);
					}
					else {
						button_8.setBackground(SystemColor.inactiveCaption);
					}
					if(temp.clipRunning == true) {
						temp.stopFile();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						JFrame frame = new userInterface();
						frame.setTitle("Audio Sampler");// + TodoPlanner.getName());
						frame.setLocation(0,0);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);		
					}
				});
			}
		}).start();		
	}
}
