package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Main.CommandInfoHolder;
import Main.RichRailClient;
import trainmodel.RollingComponent;
import trainmodel.Train;
import utils.CSVUtils;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private DisplayJPanelFactory display;
	private JPanel masterPanel = new JPanel();
	private JPanel displayPanel = new JPanel();

	private JPanel displayLeft = new JPanel();
	private JPanel displayRight = new JPanel();
	private JTextPane consoleArea = new JTextPane();
	private JTextPane loggingArea = new JTextPane();
	private JScrollPane displayLeftScroller = new JScrollPane(displayLeft, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane displayRightScroller = new JScrollPane(displayRight, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane consoleScroller = new JScrollPane(consoleArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane loggingScroller = new JScrollPane(loggingArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JTextField commandTypeField = new JTextField();
	private JButton executeButton = new JButton("execute");
	private JButton saveButton = new JButton("save");
	private JButton loadButton = new JButton("load");
	private String controlMessage = "Check \"" + System.getProperty("user.dir") + "\" to see if the file exists.\r\n";

	private int displayAmount = 0;
	private int width = 1092;
	private int height = 750;

	public Window(String name) {
		super(name);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		initialize();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setSize(width, height);
				setLayout(new BorderLayout());
				setResizable(false);
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

				// The master panel to which every other panel will get added
				masterPanel = new JPanel();
				masterPanel.setLayout(new BorderLayout());
				masterPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

				// Panels to be added to the master panel
				displayPanel.setLayout(new GridLayout(1, 2, 5, 0));
				displayPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				displayPanel.setPreferredSize(new Dimension(1086, 200));

				displayLeft.setLayout(new GridLayout(displayAmount, 1, 0, 3));
				displayLeft.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

				displayRight.setLayout(new GridLayout(displayAmount, 1, 0, 3));
				displayRight.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

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

				for (Train tr : RichRailClient.getTrains()) {
					displayLeft.add(display.getPanel(tr));
					displayRight.add(display.getPanel(tr, true));
				}

				// Adding components to the content holding panels
				displayPanel.add(displayLeftScroller);
				displayPanel.add(displayRightScroller);
				consolePanel.add(loggingScroller);
				consolePanel.add(consoleScroller);
				commandPanel.add(commandTypeField);
				commandPanel.add(executeButton);
				saveloadPanel.add(saveButton);
				saveloadPanel.add(loadButton);

				// Adding the master panel to the window
				getContentPane().add(masterPanel, BorderLayout.CENTER);
				getContentPane().add(saveloadPanel, BorderLayout.SOUTH);

				logger("Started Window");
			}
		});
	}

	private void initialize() {
		display = DisplayJPanelFactory.getInstance();
		consoleArea.setEditable(false);
		loggingArea.setEditable(false);
		loggingArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		consoleArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		consoleArea.setBackground(Color.BLACK);
		consoleArea.setForeground(Color.WHITE);

		displayAmount = RichRailClient.getTrains().size();

		/** Add stuff to be initialized above this for simplicity */

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application?");
				if (i == 0) {
					logger("Closing window");
					dispose();
				}
			}
		});

		executeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeCommand(commandTypeField.getText());
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saving");
				save();
			}
		});

		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Loading");
				load();
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

	public void appendConsolePane(String msg) {
		appendConsolePane(msg, Color.WHITE);
	}

	public void appendConsolePane(String msg, Color c) {
		appendTextPane(consoleArea, msg, c);
	}

	public void appendLoggingPane(String msg) {
		appendLoggingPane(msg, Color.BLACK);
	}

	public void appendLoggingPane(String msg, Color c) {
		appendTextPane(loggingArea, msg, c);
	}

	private void appendTextPane(JTextPane tp, String msg, Color c) {
		StyledDocument doc = tp.getStyledDocument();
		Style style = tp.addStyle("", null);
		StyleConstants.setForeground(style, c);
		try {
			doc.insertString(doc.getLength(), msg, style);
		} catch (BadLocationException e) {
			consoleArea.setText(consoleArea.getText() + "SOMETHING WENT WRONG TRYING TO SHOW A MESSAGE");
		}
	}

	private void save() {
		String filename = "trains.csv";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to load");
		fileChooser.setCurrentDirectory(new File(filename));
		fileChooser.setFileFilter(new FileNameExtensionFilter("Comma Separated Value files", "csv"));
		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			filename = fileChooser.getSelectedFile().getName();
			if (!filename.contains(".")) {
				filename += ".csv";
			}
			try {
				PrintWriter pw = new PrintWriter(filename);
				pw.close();
				boolean firstTime = true;
				for (Train train : RichRailClient.getTrains()) {
					String toWrite = "";
					if (!firstTime) {
						toWrite += "\r\n";
					}
					firstTime = false;
					toWrite += train.getName() + ",";
					for (RollingComponent component : train.getComponents()) {
						toWrite += component.getName() + ";" + component.getClass().getSimpleName().toLowerCase() + ",";
					}
					long count = toWrite.chars().filter(ch -> ch == ',').count();
					if (count >= train.getComponents().size() && toWrite.charAt(toWrite.length() - 1) == ',') {
						toWrite = toWrite.substring(0, toWrite.length() - 1);
					}
					Files.write(Paths.get(filename), toWrite.getBytes(), StandardOpenOption.APPEND);
				}
				appendLoggingPane("Pressed the save button\r\n", Color.BLUE);
				logger("saved to file \"" + filename + "\"");
				appendConsolePane("Succesfully saved the trains to \"" + filename + "\"\r\n", Color.GREEN);
			} catch (IOException exc) {
				appendConsolePane("Unable to save, please make sure \"" + filename + "\" exists and is editable.\r\n",
						Color.RED);
				appendConsolePane(controlMessage, Color.RED);
			}
		} else {
			System.out.println("Cancelled saving");
		}
	}

	private void load() {
		String filename = "trains.csv";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to load");
		fileChooser.setCurrentDirectory(new File(filename));
		fileChooser.setFileFilter(new FileNameExtensionFilter("Comma Separated Value files", "csv"));
		int userSelection = fileChooser.showOpenDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			filename = fileChooser.getSelectedFile().getName();
			try {
				Scanner scanner = new Scanner(new File(filename));
				RichRailClient.getTrains().clear();
				RichRailClient.getComponents().clear();
				Set<String> uniqueComponentNames = new HashSet<String>();
				while (scanner.hasNext()) {
					List<String> line = CSVUtils.parseLine(scanner.nextLine());
					String trainName = line.get(0);
					RichRailClient.command("new train " + trainName);
					List<String> trainComponentNames = new ArrayList<String>();
					int times = 0;
					for (String comp : line) {
						if (times == 0) {
							times++;
							continue;
						}
						List<String> info = Arrays.asList(comp.split(";"));
						if (!uniqueComponentNames.contains(info.get(0))) {
							uniqueComponentNames.add(info.get(0));// 1=classtype, 0=componentname
							RichRailClient.command("create wagon " + info.get(1) + " " + info.get(0));
						}
						trainComponentNames.add(info.get(0));
					}
					for (String componentName : trainComponentNames) {
						RichRailClient.command("add " + componentName + " to " + trainName);
					}
				}
				scanner.close();
				appendLoggingPane("Pressed the load button\r\n", Color.BLUE);
				logger("Loaded from file \"" + filename + "\"");
				appendConsolePane("Succesfully loaded the trains from \"" + filename + "\"\r\n", Color.GREEN);
			} catch (IOException exc) {
				appendConsolePane("Unable to load, please make sure \"" + filename + "\" exists and is editable.\r\n",
						Color.RED);
				appendConsolePane(controlMessage, Color.RED);
			}
		} else {
			System.out.println("Cancelled loading");
		}
	}

	public void refreshDisplayPanel() {
		displayLeft.removeAll();
		displayRight.removeAll();
		for (Train tr : RichRailClient.getTrains()) {
			displayLeft.add(display.getPanel(tr));
			displayRight.add(display.getPanel(tr, true));
		}
		displayAmount = RichRailClient.getTrains().size();
		masterPanel.revalidate();
		masterPanel.repaint();
	}

	private void executeCommand(String command) {
		appendLoggingPane(command + "\r\n");
		if (command.trim().equalsIgnoreCase("help")) {
			logger(command);
			helpCommand();
			return;
		}
		if (RichRailClient.command(command)) {
			appendConsolePane(CommandInfoHolder.getCommand() + "\r\n");
			logger(command);
		} else {
			appendConsolePane("Unable to run command \"" + command + "\"" + "\r\n", Color.RED);
		}
	}

	private void helpCommand() {
		String fancyFy = "@===============Help===============@\r\n";
		String helpText = fancyFy 
				+ "new train <trainName>\r\n" 
				+ "\tto create a new train\r\n"
				+ "create wagon <componentType> <componentName>\r\n" 
				+ "\tto create a new rolling component\r\n"
				+ "add <componentName> to <trainName>\r\n" 
				+ "\tto add a component to the back of a train\r\n"
				+ "delete <trainName>\r\n" 
				+ "\tto delete a train\r\n" 
				+ "remove <componentName> from <trainName>\r\n"
				+ "\tto remove a component from a train\r\n" + fancyFy;
		 appendConsolePane(helpText, Color.CYAN);
	}

	private void logger(String command) {
		String filename = "command-log.txt";
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
			Date date = new Date();
			String toWrite = "[" + dateFormat.format(date) + "][" + getTitle() + "]" + command + "\r\n";
			Files.write(Paths.get(filename), toWrite.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException exc) {
			appendConsolePane("Unable to log, please make sure \"" + filename + "\" exists and is editable.\r\n",
					Color.RED);
			appendConsolePane(controlMessage, Color.RED);
		}
	}

}
