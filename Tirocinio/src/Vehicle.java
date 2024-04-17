//è il veicolo da caricare. ci serve sapere quanta energia caricare e in quali plug possiamo metterlo
public class Vehicle {
	
	int id;
	
	float start_time, stop_time;
	
	float energy_to_charge;
	
	Plug[] avaible_plugs;		//ogni macchina ha almeno una colonnina disponibie
	

	
	public Vehicle(int id, float energy_to_charge) {
		super();
		this.id = id;
		this.energy_to_charge = energy_to_charge;
	}

	
	
}
