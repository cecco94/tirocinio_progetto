//è la colonnina che contiene i plug, attaccata ad una certa linea elettrica
public class ChargingPoint {

	int id;	
	float max_kwLine;
	Plug[] plugs;

	public ChargingPoint(int id, Plug[] plugs, Configuration conf) {
		this.id = id;
		this.plugs = plugs;
		max_kwLine = conf.getMax_kw_line();
	}
	
	
}
