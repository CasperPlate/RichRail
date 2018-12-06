package trainmodel;

import java.util.ArrayList;
import java.util.List;

public class Train {
	private List<RollingComponent> components = new ArrayList<RollingComponent>();
	private String name;
	
	public Train(String name) {
		this.name = name;
	}
	
	public double getTotalLength() {
		double totalLength = 0;
		for (RollingComponent component : components) {
			totalLength += component.getLength();
		}
		return totalLength;
	}
	
	public void addComponent(RollingComponent component) {
		components.add(component);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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
}
