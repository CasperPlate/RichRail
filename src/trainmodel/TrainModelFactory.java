package trainmodel;

public class TrainModelFactory {
	
	public Train getTrain() {
		return new Train();
	}
	
	public Train getTrainWithName(String name) {
		return new Train(name);
	}
	
	public RollingComponent getRollingComponent(String rCType) {
		if (rCType == null) {
			return null;
		}
		if (rCType.equalsIgnoreCase("LOCOMOTIVE")) {
			return new Locomotive();
		} else if (rCType.equalsIgnoreCase("WAGON1")) {
			return new Wagon1();
		} else if (rCType.equalsIgnoreCase("WAGON2")) {
			return new Wagon2();
		}
		
		return null;
	}
	
	public RollingComponent getRollingComponentWithName(String rCType, String name) {
		if (rCType == null) {
			return null;
		}
		if (rCType.equalsIgnoreCase("LOCOMOTIVE")) {
			return new Locomotive(name);
		} else if (rCType.equalsIgnoreCase("WAGON1")) {
			return new Wagon1(name);
		} else if (rCType.equalsIgnoreCase("WAGON2")) {
			return new Wagon2(name);
		}
		
		return null;
	}
}
