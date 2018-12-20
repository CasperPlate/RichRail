package ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.RichRailClient;
import trainmodel.RollingComponent;
import trainmodel.Train;

public class DisplayJPanelFactory {
	private static DisplayJPanelFactory display = new DisplayJPanelFactory();
	private static Map<String, BufferedImage> imageMap = new HashMap<String, BufferedImage>();
	private static Set<String> triedImages = new HashSet<String>();

	private DisplayJPanelFactory() {
		System.out.println("Display started");

	}

	public static DisplayJPanelFactory getInstance() {
		if (DisplayJPanelFactory.display == null) {
			synchronized (DisplayJPanelFactory.class) {
				if (DisplayJPanelFactory.display == null) {
					DisplayJPanelFactory.display = new DisplayJPanelFactory();
				}
			}
		}
		return DisplayJPanelFactory.display;
	}

	protected Object readResolver() {
		return getInstance();
	}

	public JPanel getPanel(Train train) {
		return getPanel(train, false);
	}

	public JPanel getPanel(Train train, boolean alternative) {
		for (RollingComponent rc : train.getComponents()) {
			if (!alternative) {
				addImage(rc.getAfbeelding());
			} else {
				addImage("alt-" + rc.getAfbeelding());
			}
		}
		JPanel panel = new JPanel();
		for (RollingComponent rc : train.getComponents()) {
			if (!alternative) {
				ImageIcon ic = new ImageIcon(getFromImageMap(rc.getAfbeelding()));
				panel.add(new JLabel(ic));
			} else {
				ImageIcon ic = new ImageIcon(getFromImageMap("alt-" + rc.getAfbeelding()));
				panel.add(new JLabel(ic));
			}
		}
		return panel;
	}
	
	private BufferedImage getFromImageMap(String image) {
		BufferedImage img = imageMap.get(image);
		if (img == null) {
			if (image.equals("ERROR.png")) {
				BufferedImage error = new BufferedImage(100, 50, BufferedImage.TYPE_INT_BGR);
				Graphics2D g2d = error.createGraphics();
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.fillRect(0, 0, 100, 50);
				Random random = new Random();
				g2d.setColor(Color.getHSBColor(random.nextFloat(), random.nextFloat(), random.nextFloat()));
				g2d.drawLine(0, 0, 100, 50);
				g2d.drawLine(0, 50, 100, 0);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setColor(Color.RED);
				g2d.drawString("ERROR", 30, 20);
				g2d.drawString("NOT FOUND", 15, 37);
				g2d.dispose();
				return error;
			}
			addImage("ERROR.png");
			return getFromImageMap("ERROR.png");
		}
		return img;
	}

	private void addImage(String path) {
		if (!triedImages.contains(path) && !imageMap.keySet().contains(path)) {
			try {
				triedImages.add(path);
				imageMap.put(path, ImageIO.read(new File(path)));
			} catch (IOException exc) {
				System.out.println("Can't find file " + path);
				for (Window w : RichRailClient.getWindows()) {
					w.appendLoggingPane("Can't find image \"" + path + "\"\r\n");
				}
			}
		}
	}
}
