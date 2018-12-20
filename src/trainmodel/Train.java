package trainmodel;

import java.util.ArrayList;
import java.util.List;

import Main.RichRailClient;
import observer.TrainObserver;

public class Train implements TrainObserver {
	private List<RollingComponent> components = new ArrayList<RollingComponent>();
	private String name;
	
	public Train() {};
	
	public Train(String name) {
		this.name = name;
	}
	
	@Override
	public void update(RollingComponent component) {
		RichRailClient.refresh();
	}
	
	public double getTotalLength() {
		double totalLength = 0;
		for (RollingComponent component : components) {
			totalLength += component.getLength();
		}
		return totalLength;
	}
	
	public int getNumSeats() {
		int totalSeats = 0;
		for (RollingComponent component : components) {
			totalSeats += component.getSeats();
		}
		return totalSeats;
	}
	
	public void addComponent(RollingComponent component) {
		components.add(component);
	}
	
	public void remComponent(RollingComponent component) {
		components.remove(component);
		update(component);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public List<RollingComponent> getComponents() {
		return components;
	}
	
	public boolean equals(Object otherObject) {
		boolean equalObjects = false;
		
		if (otherObject instanceof Train) {
			Train otherTrain = (Train) otherObject;
			
			if (this.name.equals(otherTrain.name) &&
				this.components.equals(otherTrain.components)) {
				
				equalObjects = true;
			}
		}
		
		return equalObjects;
	}

	public String toString() {
		return name + " has the following components: \n \t " + components;
	}
}
