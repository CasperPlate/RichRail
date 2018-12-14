package trainmodel;

import java.util.ArrayList;
import java.util.List;

public class TrainYard {
	List<Train> trains = new ArrayList<Train>();
	List<RollingComponent> components = new ArrayList<RollingComponent>();
	
	public TrainYard() { }

	public List<Train> getTrains() {
		return trains;
	}
	
	public Train getTrainByName(String name) {
		for (Train train : trains) {
			if (train.getName().equals(name)) {
				return train;
			}
		}
		return null;
	}
	
	public List<RollingComponent> getComponents() {
		return components;
	}
	
	public RollingComponent getComponentByName(String name) {
		for (RollingComponent component : components) {
			if (component.getName().equals(name)) {
				return component;
			}
		}
		return null;
	}

	public void addTrain(Train train) {
		trains.add(train);
	}
	
	public void deleteTrain(Train train) {
		trains.remove(train);
	}
	
	public void addComponent(RollingComponent component) {
		components.add(component);
	}
}
