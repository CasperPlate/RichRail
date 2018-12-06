package trainmodel;

public abstract class RollingComponent {
	private String company;
	private double length;
	
	public RollingComponent() {
		
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getLength() {
		return length;
	}
	
	public String toString() {
		return "component belongs to " + company + " and is " + length + " meters long";
	}
	
	public boolean equals(Object otherObject) {
		boolean equalObjects = false;
		
		if (otherObject instanceof RollingComponent) {
			RollingComponent otherRollingComponent = (RollingComponent) otherObject;
			
			if (this.company.equals(otherRollingComponent.company) &&
				this.length == otherRollingComponent.length) {
				equalObjects = true;
			}
		}
		
		return equalObjects;
	}
}
