//è la colonnina che contiene i plug, attaccata ad una certa linea elettrica
public class ChargingPoint {

	private int id;	
	private float max_kwLine;
	private Plug[] plugs;

	
	public ChargingPoint(int id, Plug[] plugs, Configuration conf) {
		this.id = id;
		this.plugs = plugs;
		max_kwLine = conf.getMax_kw_line();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Plug[] getPlugs() {
		return plugs;
	}
	
	public void setPlugs(Plug[] plugs) {
		this.plugs = plugs;
	}
	
	public float getMaxKwLine() {
		return max_kwLine;
	}
	
	
}
