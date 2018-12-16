package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Main.RichRailClient;


public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private Display display;
	private JPanel masterPanel = new JPanel();
	private JPanel displayPanel = new JPanel();

	private JTextArea consoleArea = new JTextArea();
	private JTextArea loggingArea = new JTextArea();
	private JScrollPane consoleScroller = new JScrollPane(consoleArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane loggingScroller = new JScrollPane(loggingArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JTextField commandTypeField = new JTextField();
	private JButton executeButton = new JButton("execute");
	private JButton saveButton = new JButton("save");
	private JButton loadButton = new JButton("load");

	private int width = 1092;
	private int height = 750;

	private void initialize() {
		display = Display.getInstance();
		consoleArea.setEditable(false);
		loggingArea.setEditable(false);
		loggingArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		consoleArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		consoleArea.setBackground(Color.BLACK);
		consoleArea.setForeground(Color.WHITE);

		/** Add stuff to be initialized above this */

		executeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeCommand(commandTypeField.getText());
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.save();
				masterPanel.repaint();
			}
		});

		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.load();
				masterPanel.repaint();
			}
		});

		commandTypeField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					executeCommand(commandTypeField.getText());
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

	public Window(String name) {
		super(name);
		initialize();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setSize(width, height);
				setLayout(new BorderLayout());
				setResizable(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// The master panel to which every other panel will get added
				masterPanel = new JPanel();
				masterPanel.setLayout(new BorderLayout());
				masterPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

				// Panels to be added to the master panel
				displayPanel.setLayout(new BorderLayout());
				displayPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

				JPanel consolePanel = new JPanel();
				consolePanel.setLayout(new GridLayout(1, 2, 5, 0));
				consolePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

				JPanel commandPanel = new JPanel();
				commandPanel.setLayout(new GridLayout());
				commandPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

				JPanel saveloadPanel = new JPanel();
				saveloadPanel.setLayout(new GridLayout());
				saveloadPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

				masterPanel.add(displayPanel, BorderLayout.NORTH);
				masterPanel.add(consolePanel, BorderLayout.CENTER);
				masterPanel.add(commandPanel, BorderLayout.SOUTH);

				// Adding components to the content holding panels
				displayPanel.add(display.getPanel());
				consolePanel.add(loggingScroller);
				consolePanel.add(consoleScroller);
				commandPanel.add(commandTypeField);
				commandPanel.add(executeButton);
				saveloadPanel.add(saveButton);
				saveloadPanel.add(loadButton);

				// Adding the master panel to the window
				getContentPane().add(masterPanel, BorderLayout.CENTER);
				getContentPane().add(saveloadPanel, BorderLayout.SOUTH);
			}
		});
	}

	private void refreshDisplayPanel() {
		System.out.println("HIJ REFRESHED NU");
		displayPanel.add(new JButton("RAAAAAA"));
		
		displayPanel.setBackground(Color.GREEN);
		displayPanel.add(display.getPanel());
		displayPanel.repaint();
		System.out.println("HIJ IS GEREFRESHED");
		masterPanel.repaint();
	}
	
	

	private void executeCommand(String command) {
		System.out.println("" + display.hashCode());
		displayPanel.removeAll();
		loggingArea.append(command + "\r\n");
		logger(command);
		consoleArea.append("hey it did this " + command + "\r\n");
		RichRailClient.command(command);
		display.addPanel();
		refreshDisplayPanel();
	}
	
	private void logger(String command) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String filename = "command-log.txt";
			String toWrite = "[" + dateFormat.format(date) + "]" + command + "\r\n";
			Files.write(Paths.get(filename), toWrite.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException exc) {
			
		}
	}

}
