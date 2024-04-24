
public class MainClass {

//	private Plan plan;
//	private Configuration configuration;

	
	public static void main(String[] args) throws RectImpossibleException{
		
		float max_altezza_fornita = 4.8f; 
		
		Rettangolo r0 = new Rettangolo(0, 10, 15, 0, max_altezza_fornita);
		Rettangolo r1 = new Rettangolo(0, 10, 10, 30, max_altezza_fornita);	
		
		Rettangolo[] soluzione = OptimizerDueMacchine.ottimizza_due_macchine(r0, r1, max_altezza_fornita);
		
		if(soluzione == null) {
			System.out.println("piano impossibile");
		}
		
		else {
			System.out.println(soluzione[0].margine_sinistro + ", " + soluzione[0].margine_destro + " area = " + soluzione[0].area + " altezza = " + soluzione[0].altezza 
					+ " // " + soluzione[1].margine_sinistro + ", " + soluzione[1].margine_destro + " area = " + soluzione[1].area + " altezza = " + soluzione[1].altezza );
		}
	}
	

}


//possiamo vedere il problema in modo geometrico: ogni macchina è un rettangolo di base = tempo, altezza = potenza e area = energia
//l'area resta costante, mentre l'altezza e la base possono allargarsi/restringersi
//il rettangolo gigante di base = tempo a disposizione e altezza = portata max della linea ci dice quanta energia al massimo può
//caricare la rete. Se la somma delle aree delle macchine è > area rettangolono --> il problema non ha soluzioni (approfondire, perchè 
//i plug hanno una portata diversa, quindi non è banale)
		
//sarebbe meglio avere rettangoli con tanta base e poca altezza, perchè la linea deve avere poca portata per diminuire il costo
//siccome dobbiamo vedere anche la portata dei plug, la base è min(portata rete, portata plug)

//se due rettangoli con base massima si intersecano, la somma delle altezze nella parte di intersezione è la più piccola possibile:
//se diminuisce la base dei rettangoli, deve aumentare la loro altezza, quindi la somma della altezze cresce, anche se diminuisce
//la parte di intersezione --> il minimo dell'altezza è min(somma altezze rect con base massima, max(altezze dei due rect separati)), in 
//altre parole, non ci resta che secgliere se lasciarli intersecai o separarli. Come separarli al meglio però?

//ci sono due possibili modi in cui due rect possono incrociarsi: uno è dentro all'altro o uno è di fianco all'altro
//In ogni caso, o accorciamo il primo verso sinistra e l'altro verso destra o viceversa. (Otteniamo una funzione H = max(h1, h2) che dipende 
//dai due punti che stiamo spostando) Accorciamo per prima la base del rect più basso, fino a raggiungere, se necessario, l'altezza dell'altro
//rect. Poi se ancora sono incrociai, accorciamo di un poco la base del rect più altro e ricominciamo la storia. In questo modo approssiamiamo la 
//separazione dove max(altezze dei due rect separati) è la più piccola. Siccome la separazione avviene in due modi possibili, 
//min(sposto il promo a destra e l'altro a sinistra, viceversa) è ciò che ci serve

//possiamo ordinare i rect (quando hanno la base più larga possibile) per la loro altezza: quelli più alti sono quelli che hanno bisogno di molta carica 
//e non hanno molto tempo a disposizione

//prima di tutto posizioniamo loro, poi mettiamo gli altri e decidiamo se restringerli nel caso di intersezione
//siccome inizio con tutti i rect di base massima, non posso traslarli, posso solo restringerli verso destra/sinistra
//ongi nuovo rect che metto, se si interseca con un altro, devo decidere se lasciarlo così o restringerlo a destra/sinistra

//se si interseca con più rect, posso restringerli in più modi: evito l'intersezione con A? evito quella con B? Evito l'intersez con tutti?
//guarda tutte le possibilità e prende la migliore.


//la possibilità che più macchine collidano nella stessa colonnina pone un limite sulla base dei rect: se gli orari non si incrociano ce ne freghiamo.
//altrimenti spartiamo il tempo di carica in comune tra le macchine in modo proporzionale a quanta energia vogliono










//  1) se dobbiamo ottimizzare il tempo di ricarica, conviene ordinare le macchine in base
//a quanta energia vogliono: dalla più costosa alla meno costosa
		
//sappiamo quanto al massimo può erogare la linea (treshold T) --> l'altezza h del rect al massimo può essere = T
//fissiamo l'altezza dei rettangoli = T --> la base diventa area/T

//il problema si riconduce a piazzare i rettangoli nella linea del tempo in modo che non si sovrappongano

//i plug però hanno una portata minore rispetto alla linea --> i rect hanno base più larga e minore altezza, però nello stesso tempo 
//possiamo caricare più macchine contemporaneamente (dipende dal rapporto tra la portata dei plug e la portata della linea)




//possiamo risolverlo anche ricorsivamente, facciamo come al punto 1), diminuendo gradualmente la T finchè non esistono soluzioni
