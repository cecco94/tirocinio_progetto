
public class Rettangolo  implements Comparable<Rettangolo> {

	public int base;
	public float altezza, max_altezza_possibile;
	public int margine_sinistro;
	public int margine_destro;
	public float area;
	
	public Rettangolo(int ms, int md, float a, float max_h) {
		if(md <= ms) {
			System.out.println("base negativa!");
			//ritorna i dati della parte del piano incriminati
		}
		
		margine_sinistro = ms;
		margine_destro = md;
		area = a;
		
		base = margine_destro - margine_sinistro;
		altezza = area/base;
		
		//è la massima portata erogabile dal plug, collegato ad una certa rete = min(portata plug, portata impiano elettrico)
		max_altezza_possibile = max_h;
		
		if(altezza > max_altezza_possibile) {
			System.out.println("piano non possibile, il plug non eiresce a erogare tutta questa energia in poco tempo");
			//ritorna i dati della parte del piano incriminati
		}
		
	}
	
	public boolean intersect(Rettangolo rect) {
		boolean primo_caso = rect.margine_sinistro < margine_destro && margine_destro < rect.margine_destro;	//sta a sinistra dell'alatro
		boolean secondo_caso = rect.margine_sinistro < margine_sinistro && margine_sinistro < rect.margine_destro;	//sta a destra dellaltro rect
		boolean terzo_caso = margine_sinistro <= rect.margine_sinistro && margine_destro >= rect.margine_destro;	//contiene l'altro rect
		boolean quarto_caso = margine_sinistro >= rect.margine_sinistro && margine_destro <= rect.margine_destro;	//è contenuto nell'altro rect
		return primo_caso || secondo_caso || terzo_caso || quarto_caso;
	}
	
	public void restringi_base_verso_destra(int nuovo_margine_sinistro) {
		if(nuovo_margine_sinistro < margine_sinistro) {
			System.out.println("stai allargando il rect a sinistra");
			return;
		}
		margine_sinistro = nuovo_margine_sinistro;
		base = margine_destro - margine_sinistro;
		altezza = area/base;
	}
	
	public void restringi_base_verso_sinsistra(int nuovo_margine_destro) {
		if(nuovo_margine_destro > margine_sinistro) {
			System.out.println("stai allargando il rect a destra");
			return;
		}
		margine_destro = nuovo_margine_destro;
		base = margine_destro - margine_sinistro;
		altezza = area/base;
	}

	@Override
	public int compareTo(Rettangolo r) {
		if(r.altezza > altezza)
			return 1;
		if(r.altezza < altezza)
			return -1;
		
		//se hanno la stessa altezza, vince chi è più largo (da vedere)
		if(r.base > base)
			return 1;
		if(r.base < base)
			return -1;
		
		return 0;
	}
	
}
