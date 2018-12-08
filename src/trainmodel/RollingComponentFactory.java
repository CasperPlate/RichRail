package trainmodel;

public class RollingComponentFactory {
	
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
}
