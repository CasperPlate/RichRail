package trainmodel;

public class Locomotive extends RollingComponent {
	private String afbeelding = "locomotive.png";
	
	public Locomotive() {};
	
	public Locomotive(String name) {
		this.name = name;
	}
	
	public String getAfbeelding() {
		return afbeelding;
	}
}
