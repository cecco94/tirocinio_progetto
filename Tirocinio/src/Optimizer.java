import java.util.ArrayList;
import java.util.Collections;

public class Optimizer {

	ArrayList<Rettangolo> intersecanti_iniziali = new ArrayList<>();
	ArrayList<Rettangolo> intersecanti_per_fare_la_somma_delle_altezze = new ArrayList<>();
	ArrayList<Rettangolo> da_posizionare;
	ArrayList<Rettangolo> posizionati = new ArrayList<>();
	ArrayList<Integer> estremi_rect_intersecanti = new ArrayList<>();

	
	public Optimizer(ArrayList<Rettangolo> input) {
		da_posizionare = input;
	}
	
	public void posiziona_rect_piu_costoso() {
		posizionati.add(da_posizionare.get(0));		
		da_posizionare.remove(0);
	}
	
	public boolean intersezioni_con_rect_posizionati(Rettangolo daMettere) {
		intersecanti_iniziali.clear();
		for(int i = 0; i < posizionati.size(); i++) {
			if(daMettere.intersect(posizionati.get(i))) {
				intersecanti_iniziali.add(posizionati.get(i));
				return true;
			}
		}
		return false;
	}

	public float altezza_massima_rect_intersecanti() {
		intersecanti_per_fare_la_somma_delle_altezze.clear();
		float h = 0;
		for(Rettangolo r : intersecanti_per_fare_la_somma_delle_altezze) {
			h += r.altezza;
		}
		return h;
	}
	
	public void ordinaRettangoli() {
		Collections.sort(da_posizionare);
	}
	
	public void ottimizza() {
		ordinaRettangoli();
		posiziona_rect_piu_costoso();
		for(int i = 0; i < da_posizionare.size(); i++) {
			posiziona_rettangolo(da_posizionare.get(i));
		}
	}
	
	public void aggiungi_estremi_rect_intersecanti(Rettangolo da_posizionare) {
		//si prende la lista dei rect che intersecano quello da posizionare
		//per ciascuno di questi, vede se l'estremo sinistro/destro si trova tra gli estremi del rect da posizionare
		//in caso positivo, lo aggiunge ad una lista
		estremi_rect_intersecanti.clear();
		for(Rettangolo intersecante : intersecanti_iniziali) {
			if(intersecante.margine_sinistro > da_posizionare.margine_sinistro) {
				estremi_rect_intersecanti.add(intersecante.margine_sinistro);
			}
			if(intersecante.margine_destro < da_posizionare.margine_destro) {
				estremi_rect_intersecanti.add(intersecante.margine_destro);
			}
		}
	}

	private void posiziona_rettangolo(Rettangolo rettangolo_da_posizionare) {
		
		//se il rect non si interseca con nessun altro, lo posiziono senza fare altri controlli
		if(!intersezioni_con_rect_posizionati(rettangolo_da_posizionare)) {
			posizionati.add(rettangolo_da_posizionare);
		}
		else {
			//ha la lista dei rettangoli che lo intersecano, per ogni estremo di questi rettangoli, deve calcolarsi la somma H delle altezze
			//paragona la H di ciascuna scelta e fa la scelta con la H minore. Se H < max potenza erogabile dall'impianto elettrico, allora ok
			//altrimenti manda un errore dove indica il momento e le macchine incrimi
			
			//si deve salvare la H della scelta (per valutare la migliore) e la scelta stessa (per attuarla)
			//ogni scelta può avere tre campi: H, il punto dove mettere il nuovo estremo e la direzione "destra/sinistra"
			
			
			//iniziamo prendendo gli estremi disponibili, prende solo quelli che sono > estremo_sinistro e > estremo_destro	
			aggiungi_estremi_rect_intersecanti(rettangolo_da_posizionare);
			//nel caso in cui non fare niente risulti la scelta migliore
			Mossa stai_fermo = new Mossa("stai_fermo", 0, rettangolo_da_posizionare.altezza);
			int estremo_sinistro_iniziale = rettangolo_da_posizionare.margine_sinistro;
			int estremo_destro_iniziale = rettangolo_da_posizionare.margine_destro;
			
			for(int estremo : estremi_rect_intersecanti) {
				
			}
		}
	}
	
	
}
