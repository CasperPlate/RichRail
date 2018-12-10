package trainmodel;

import java.util.ArrayList;
import java.util.List;

public class TrainYard {
	List<Train> trains = new ArrayList<Train>();
	
	public TrainYard() { }

	public List<Train> getTrains() {
		return trains;
	}

	public void addTrain(Train train) {
		trains.add(train);
	}
	
	public void deleteTrain(Train train) {
		trains.remove(train);
	}
}
