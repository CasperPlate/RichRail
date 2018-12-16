package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import trainmodel.RollingComponent;
import trainmodel.Train;
import trainmodel.TrainYard;
import Main.*;

public class Display implements Serializable {
	private static final long serialVersionUID = 1L;
	private JPanel masterPanel;
	private static Display display = new Display();
	private static List<JPanel> panelList;
	private static Map<String, BufferedImage> imageMap;

	// private BufferedImage locoImage;
	// private BufferedImage wag1Image;
	// private BufferedImage wag2Image;

	private Display() {
		System.out.println("Display started");
		masterPanel = new JPanel();
		panelList = new ArrayList<JPanel>();
		imageMap = new HashMap<String, BufferedImage>();
		System.out.println(panelList.size());
		addPanel();
		System.out.println(panelList.size());
		masterPanel.setLayout(new GridLayout(panelList.size(), 1));
		for (JPanel jp : panelList) {
			masterPanel.add(jp);
			if (masterPanel.isDisplayable()) {
				System.out.println("masterPanel in display visible? yes2");
			} else {
				System.out.println("masterPanel in display visible? no2");
			}
		}
	}

	private void addImage(String path) {
		if (!imageMap.keySet().contains(path)) {
			try {
				imageMap.put(path, ImageIO.read(new File(path)));
			} catch (IOException exc) {
				System.out.println("Can't fine file " + path);
			}
		}
	}

	public void addPanel() {
		for (Train train : RichRailClient.getTrains()) {
			for (RollingComponent rc : train.getComponents()) {
				addImage(rc.getAfbeelding());
			}
			JPanel panel = new JPanel();
			for (RollingComponent rc : train.getComponents()) {
				panel.add(new JLabel(new ImageIcon(imageMap.get(rc.getAfbeelding()))));
			}
			if (masterPanel.isDisplayable()) {
				System.out.println("masterPanel in display visible? yes1");
			} else {
				System.out.println("masterPanel in display visible? no1");
			}
			masterPanel.add(panel);
		}
	}

	public static Display getInstance() {
		if (Display.display == null) {
			synchronized (Display.class) {
				if (Display.display == null) {
					Display.display = new Display();
				}
			}
		}
		return Display.display;
	}

	protected Object readResolver() {
		return getInstance();
	}

	public void save() {
		try {
			serializeToFile();
		} catch (IOException exc) {
			exc.printStackTrace();
			System.out.println("UNABLE TO SAVE DISPLAY FILE");
		}
	}

	public void load() {
		try {
			deserializeFromFile();
		} catch (IOException exc) {
			exc.printStackTrace();
			System.out.println("UNABLE TO LOAD DISPLAY FILE");
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
			System.out.println("UNABLE TO LOAD OBJECTINPUTSTREAM");
		}
	}

	private void serializeToFile() throws IOException {
		OutputStream outStream = new FileOutputStream("display.ser");
		ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
		fileObjectOut.writeObject(Display.display);
		fileObjectOut.close();
		outStream.close();
	}

	private void deserializeFromFile() throws IOException, ClassNotFoundException {
		InputStream inStream = new FileInputStream("display.ser");
		ObjectInputStream fileObjectIn = new ObjectInputStream(inStream);
		Display dp = (Display) fileObjectIn.readObject();
		fileObjectIn.close();
		inStream.close();
		Display.display = dp;
	}

	public JPanel getPanel() {
		return masterPanel;
	}
}
