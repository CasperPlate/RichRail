package trainmodel;

import java.util.ArrayList;
import java.util.List;

import Main.RichRailClient;
import observer.Subject;
import observer.TrainYardObserver;

public class TrainYard extends Subject implements TrainYardObserver {
	List<Train> trains = new ArrayList<Train>();
	List<RollingComponent> components = new ArrayList<RollingComponent>();
	
	public TrainYard() {
		addObserver(this);
	}
	
	@Override
	public void update(Train train) {
		RichRailClient.refresh();
	}
	
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
		notifyObservers(train);
		addObserver(train);
	}
	
	public void deleteTrain(Train train) {
		trains.remove(train);
		update(train);
	}
	
	public void addComponent(RollingComponent component) {
		components.add(component);
	}
	
	public void addComponentToTrain(RollingComponent component, Train train) {
		for (RollingComponent realComponent : components) {
			if(component.equals(realComponent)) {
				for (Train realTrain : trains) {
					if(train.equals(realTrain)) {
						train.addComponent(realComponent);
						notifyObservers(realComponent);
					}
				}
			}
		}
	}
}
