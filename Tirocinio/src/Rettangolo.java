
public class Rettangolo  implements Comparable<Rettangolo> {

	public int base;
	//è la massima portata erogabile dal plug, collegato ad una certa rete = min(portata plug, portata impiano elettrico)
	public float altezza, max_altezza_possibile;
	//è la minima carica che usa la macchina per ricaricarsi
	public float min_altezza_possibile;
	public int margine_sinistro;
	public int margine_destro;
	public float area;
	
	public Rettangolo(int ms, int md, float a, float max_h, float min_h) throws RectImpossibleException{
		if(md <= ms) {
			System.out.println("base negativa!");
			//ritorna i dati della parte del piano incriminati
			throw new RectImpossibleException();
		}
		
		margine_sinistro = ms;
		margine_destro = md;
		area = a;
		
		base = margine_destro - margine_sinistro;
		altezza = area/base;
		
		max_altezza_possibile = max_h;
		min_altezza_possibile = min_h;
		
		if(altezza > max_altezza_possibile) {
			//ritorna i dati della parte del piano incriminati
			System.out.println("piano non possibile, il plug non eiresce a erogare tutta questa energia in così poco tempo");
			throw new RectImpossibleException();
		}
		
		if(altezza < min_altezza_possibile) {
			altezza = min_altezza_possibile;
			base = (int)(area/altezza);
		}
		
	}
	
	public boolean intersect(Rettangolo rect) {
		boolean primo_caso = rect.margine_sinistro < margine_destro && margine_destro < rect.margine_destro;	//sta a sinistra dell'alatro
		boolean secondo_caso = rect.margine_sinistro < margine_sinistro && margine_sinistro < rect.margine_destro;	//sta a destra dellaltro rect
		boolean terzo_caso = margine_sinistro <= rect.margine_sinistro && margine_destro >= rect.margine_destro;	//contiene l'altro rect
		boolean quarto_caso = margine_sinistro >= rect.margine_sinistro && margine_destro <= rect.margine_destro;	//è contenuto nell'altro rect
		return primo_caso || secondo_caso || terzo_caso || quarto_caso;
	}
	
	public boolean contiene_altro(Rettangolo rect) {
		return margine_sinistro <= rect.margine_sinistro && margine_destro >= rect.margine_destro;	//contiene l'altro rect
	}
	
	public boolean e_contenuto(Rettangolo rect) {
		return rect.margine_sinistro < margine_sinistro && margine_sinistro < rect.margine_destro;	//sta a destra dellaltro rect
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
		if(nuovo_margine_destro > margine_destro) {
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
