//è la linea dove sono attaccate le colonnine
//per es. può essere la linea di un garage
public class Configuration {		

	float max_kw_line;
	ChargingPoint[] chargingPoints;	
	
	public Configuration(float max_kw_line, ChargingPoint[] chargingPoints) {
		super();
		this.max_kw_line = max_kw_line;
		this.chargingPoints = chargingPoints;
	}

	public float getMax_kw_line() {
		return max_kw_line;
	}
	
	
}
