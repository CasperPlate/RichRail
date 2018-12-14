package trainmodel;

public abstract class RollingComponent {
	protected String name;
	protected String company;
	protected double length;
	protected int seats;
	
	public RollingComponent() { }
	
	public RollingComponent(int seats) {
		this.seats = seats;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		if (company == null & seats == 0 & length == 0 && name == null) {
			return "No information disclosable about this component";
		}
		return name;
	}
	
	public boolean equals(Object otherObject) {
		boolean equalObjects = false;
		
		if (otherObject instanceof RollingComponent) {
			RollingComponent otherRollingComponent = (RollingComponent) otherObject;
			
			if (this.name.equals(otherRollingComponent.getName())) {
				equalObjects = true;
			}
		}
		
		return equalObjects;
	}

}
