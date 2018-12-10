package trainmodel;

public abstract class RollingComponent {
	private String company;
	private double length;
	private int seats;
	
	public RollingComponent() { }
	
	public RollingComponent(int seats) {
		this.seats = seats;
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
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public String toString() {
		if (company == null & seats == 0 & length == 0) {
			return "No information disclosable about this component";
		}
		return "component belongs to " + company + ", has " + seats + " and is " + length + " meters long";
	}
	
	public boolean equals(Object otherObject) {
		boolean equalObjects = false;
		
		if (otherObject instanceof RollingComponent) {
			RollingComponent otherRollingComponent = (RollingComponent) otherObject;
			
			if (this.company.equals(otherRollingComponent.company) &&
				this.length == otherRollingComponent.length &&
				this.seats == otherRollingComponent.seats) {
				equalObjects = true;
			}
		}
		
		return equalObjects;
	}
}
