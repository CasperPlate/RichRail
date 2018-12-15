package trainmodel;

public class Wagon2 extends RollingComponent {
	private String afbeelding = "wagon2.png";
	
	public Wagon2() {};

	public Wagon2(String name) {
		this.name = name;
	}
	
	public String getAfbeelding() {
		return afbeelding;
	}
}
