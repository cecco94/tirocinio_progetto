//uno dei plug di una colonnina
public class Plug {
	
	int id;
	float max_charge_rate;		//massima potenza
	float min_charge_rate;		//minima potenza

	
	
	public Plug(int id, float max_charge_rate, float min_charge_rate) {
		this.id = id;
		this.max_charge_rate = max_charge_rate;
		this.min_charge_rate = min_charge_rate;
	}
	
}
