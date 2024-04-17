//è la linea dove sono attaccate le colonnine
//per es. può essere la linea di un garage
public class Configuration {		

	private float max_kw_line;
	private ChargingPoint[] chargingPoints;	
	
	public Configuration(float max_kw_line, ChargingPoint[] chargingPoints) {
		super();
		this.max_kw_line = max_kw_line;
		this.chargingPoints = chargingPoints;
	}

	public float getMax_kw_line() {
		return max_kw_line;
	}
	
	public void setMax_kw_line(float max_kw_line) {
		this.max_kw_line = max_kw_line;
	}

	public ChargingPoint[] getChargingPoints() {
		return chargingPoints;
	}

	public void setChargingPoints(ChargingPoint[] chargingPoints) {
		this.chargingPoints = chargingPoints;
	}
	
	
}
