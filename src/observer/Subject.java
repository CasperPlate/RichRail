package observer;

import java.util.ArrayList;
import java.util.List;

import trainmodel.RollingComponent;
import trainmodel.Train;

public class Subject {
	private List<TrainObserver> trainObservers = new ArrayList<>();
	private List<TrainYardObserver> trainYardObservers = new ArrayList<>();
	
	public void addObserver(TrainObserver trainObserver) {
		if (!trainObservers.contains(trainObserver)) {
			trainObservers.add(trainObserver); 
		}
	}
	
	public void addObserver(TrainYardObserver trainYardObserver) {
		if (!trainYardObservers.contains(trainYardObserver)) {
			trainYardObservers.add(trainYardObserver); 
		}
	}
	
	public void notifyObservers(RollingComponent component) {
		for (TrainObserver observer : trainObservers) {
			observer.update(component);
		}
	}
	
	public void notifyObservers(Train train) {
		for (TrainYardObserver observer : trainYardObservers) {
			observer.update(train);
		}
	}
}
