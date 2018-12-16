package trainmodel;

public class Wagon1 extends RollingComponent {
	private String afbeelding = "wagon1.png";
	
	public Wagon1() {};
	
	public Wagon1(String name) {
		this.name = name;
	}
	
	@Override
	public String getAfbeelding() {
		return afbeelding;
	}
}
