package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<TrainObserver> trainObservers = new ArrayList<>();
	
	public void addObserver(TrainObserver trainObserver) {
		if (!trainObservers.contains(trainObserver)) {
			trainObservers.add(trainObserver); 
		}
	}
	
	public void notifyObservers() {
		for (TrainObserver observer : trainObservers) {
			observer.refreshDisplayPanel();
		}
	}
}
