
public class OptimizerDueMacchine {
	
	//R0, R1 sono già ordinati in base all'orario di partenza
	public static Rettangolo[] ottimizza_due_macchine(Rettangolo R0, Rettangolo R1, float massima_somma_altezze) throws RectImpossibleException{
				
		Rettangolo[] soluzione = new Rettangolo[2];
		soluzione[0] = R0;
		soluzione[1] = R1;
		
		//se non si intersecano fine
		if(!R1.intersect(R0)) {
			return controlla_soluzione(soluzione, massima_somma_altezze);
		}
		
		float h_somma_iniziale = R0.altezza + R1.altezza;
			
		//vedo cosa conviene fare: prendere il più basso e lo restringo finchè non sono più intersecanti.
		//oppure restringere entrambi. (lo posso fare solo se uno non è contenuto nell'altro)
		if( R0.altezza != R1.altezza && !R0.contiene_altro(R1) && !R1.contiene_altro(R0) ) {
			
			Rettangolo R0_primo_caso = new Rettangolo(R0.margine_sinistro, R0.margine_destro, R0.area, R0.max_altezza_possibile, R0.min_altezza_possibile);
			Rettangolo R1_primo_caso = new Rettangolo(R1.margine_sinistro, R1.margine_destro, R1.area, R1.max_altezza_possibile, R1.min_altezza_possibile);
			
			float nuova_h_max = restringi_rettangolo_piu_basso(R0_primo_caso, R1_primo_caso);
			
			//se hSomma è diminuita significa che conviene fare così. perchè hSomma è l'altezza minore che può avere il rect più alto
			if(nuova_h_max < h_somma_iniziale) {
				soluzione[0] = R0_primo_caso;
				soluzione[1] = R1_primo_caso;
				return controlla_soluzione(soluzione, massima_somma_altezze);
			}
		}
			
		//siamo nell'ultimo caso, dobbiamo vedere se ci conviene lasciarli com'erano oppure diminuire la base anche di quello più alto
		//devo rimpicciolire anche quello maggiore finchè entrambi non hanno la stessa altezza
		//per avere la stessa altezza, l'equazione è h1 = A1/b1 = h2 = A2/b2. Altro vincolo: la somma delle basi deve 
		//essere massima, quindi b1 + b2 = B, dove B è la somma iniziale
		Rettangolo R0_ultimo_caso = new Rettangolo(R0.margine_sinistro, R0.margine_destro, R0.area, R0.max_altezza_possibile, R0.min_altezza_possibile);
		Rettangolo R1_ultimo_caso = new Rettangolo(R1.margine_sinistro, R1.margine_destro, R1.area, R1.max_altezza_possibile, R1.min_altezza_possibile);
		
		float h_ultimo_tentativo = restringi_entrambi(R0_ultimo_caso, R1_ultimo_caso);
		
		if(h_ultimo_tentativo <= h_somma_iniziale) {
			soluzione[0] = R0_ultimo_caso;
			soluzione[1] = R1_ultimo_caso;
			return controlla_soluzione(soluzione, massima_somma_altezze);
		}
		
		//se tutti i tentativi non funzionano, conviene lasciare la situazione iniziale
		if(R0.altezza + R1.altezza < massima_somma_altezze) {
			return soluzione;
		}
		return null;
	}

	public static Rettangolo[] controlla_soluzione(Rettangolo[] soluzione, float massima_somma_altezze) {
		if(soluzione[0].altezza < massima_somma_altezze && soluzione[1].altezza < massima_somma_altezze) {
			return soluzione;
		}
		//se i rect sono troppo alti, non esiste soluzione
		return null;
	}

	public static float restringi_entrambi(Rettangolo r0_ultimo_caso, Rettangolo r1_ultimo_caso) {
		int base_totale = r1_ultimo_caso.margine_destro - r0_ultimo_caso.margine_sinistro;
		float rapporto_aree = r1_ultimo_caso.area/r0_ultimo_caso.area;
				
		int nuova_base_rect_destro = (int)(base_totale*rapporto_aree/(1 + rapporto_aree));
		int nuova_base_rect_sinitro = (int)(base_totale - nuova_base_rect_destro);
		
		r1_ultimo_caso.restringi_base_verso_destra(r1_ultimo_caso.margine_destro - nuova_base_rect_destro);
		r0_ultimo_caso.restringi_base_verso_sinsistra(r0_ultimo_caso.margine_sinistro + nuova_base_rect_sinitro);
		
		//è un controllo sulla massima altezza, se il rect modificato sale troppo, faccio in modo che questa soluzione non venga mai presa
		if(r0_ultimo_caso.altezza > r0_ultimo_caso.max_altezza_possibile) {
			r0_ultimo_caso.altezza = 999999;		
		}
		if(r1_ultimo_caso.altezza > r1_ultimo_caso.max_altezza_possibile) {
			r1_ultimo_caso.altezza = 999999;		
		}
		
		//System.out.println("restringo entrambi, altezze " + r0_ultimo_caso.altezza + ", " + r1_ultimo_caso.altezza);
		
		return Math.max(r0_ultimo_caso.altezza, r1_ultimo_caso.altezza);
	}

	
    public static float restringi_rettangolo_piu_basso(Rettangolo r0, Rettangolo r1) {
		if(r0.altezza < r1.altezza) {
			r0.restringi_base_verso_sinsistra(r1.margine_sinistro);
		}
		else {
			r1.restringi_base_verso_destra(r0.margine_destro);
		}
		
		//è un controllo sulla massima altezza, se il rect modificato sale troppo, faccio in modo che questa soluzione non venga mai presa
		if(r0.altezza > r0.max_altezza_possibile) {
			r0.altezza = 999999;		
		}
		if(r1.altezza > r1.max_altezza_possibile) {
			r1.altezza = 999999;		
		}
		
		//System.out.println("restringo il più basso");
		
		return Math.max(r0.altezza, r1.altezza);
	}
	
}
