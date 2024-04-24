//è il veicolo da caricare. ci serve sapere quanta energia caricare e in quali plug possiamo metterlo
public class Vehicle {
	
	int id;	
	float initial_charge;
	float min_charge_rate, max_charge_rate;
	
	Plug[] avaible_plugs;		//ogni macchina ha almeno una colonnina disponibie
	Plan plan; 					//ogni macchina ha 
	public Vehicle(int id, float initial_charge, float min_charge_rate, float max_charge_rate, Plug[] avaible_plugs, Plan plan) {
		this.id = id;
		this.initial_charge = initial_charge;
		this.min_charge_rate = min_charge_rate;
		this.max_charge_rate = max_charge_rate;
		this.avaible_plugs = avaible_plugs;
		this.plan = plan;
		
	}
		


	// ogni macchina ha un id, dei plug che può usare, e una carica iniziale
	// inoltre ha un piano: una lista di rect che indicano quando caricarla e a quale carica deve arrivare
	
}
