
public class Plan {

	private int id;
	private Vehicle[] vehicles;

	
	public Plan(int id, Vehicle[] vehicles) {
		super();
		this.id = id;
		this.vehicles = vehicles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle[] getVehicles() {
		return vehicles;
	}

	public void setVehicles(Vehicle[] vehicles) {
		this.vehicles = vehicles;
	}

	
}
