/*
 * In questo package si testeranno gli algoritmi di ordinamento
 * Le funzioni per i vari algoritmi sono tutte uguali quindi ne
 * verrà illustrata e commentata una sola, la prima, e verranno
 * poi scpiegate le differenze nelle altre funzioni in caso ce
 * ne siano.
 * 
 * Lo scopo delle funzioni è quello di copiare l'array creato in 
 * array di appoggio in modo che l'array originale si conservi
 * per poter fare tutti i test che si vuole senza problemi
 * 
 * Le funzioni restituiscono il tempo impiegato dall'algoritmo
 * per ordinare l'array d'appoggio, il suddetto tempo viene
 * calcolato grazie all'ausilio della funzione nanotime()
 * 
 * nanotime() non è un timer ma prende il tempo dell'orologio
 * della macchina, il che significa che per avere il tempo di
 * esecuzione effettivo devo prendere il tempo subito prima
 * dell'algoritmo e appena esso finisce e sottrarre tempo iniziale
 * al tempo finale
 */

import asdlab.libreria.Ordinamento.*; //la libreria di ordinamento serve per eseguire i vari algoritmi di ordinamento
									  //senza dover riscrivere le funzioni daccapo

public class Ordinamento {
	/*
	 * @param array: è l'array originale, che non sarà modificato;
	 * @param dimensione: è la dimensione dell'array, serve perchè devo ricreare un'array d'appoggio esattamente uguale al precedente;
	 * @param alg: è l'algoritmo inizializzato e serve per poter richiamare le varie funzioni di ordinamento;
	 */
	@SuppressWarnings("static-access")
	public static long integersort(int [] array, int dimensione, AlgoritmiOrdinamento alg) {

		long tempo; 							//la variabile in cui verrà salvato il tempo eseguito e poi restituita
		int i;									//variabile per la scansione dell'array
		int [] array_appoggio;					//creo l'array di appoggio su cui verrà fatto il test
		array_appoggio = new int [dimensione];	//e lo inizializzo della dimensione dell'originale
		for(i=0; i<dimensione; i++) {			
			array_appoggio[i] = (int) array[i]; //nel for copio l'originale all'interno di quest'ultimo
		}
		tempo = System.nanoTime();						//prendo il tempo prima dell'esecuzione dell'algoritmo
		alg.integerSort(array_appoggio, dimensione);	//eseguo l'algoritmo
		tempo = System.nanoTime() - tempo;				//riprendo il tempo e gli sottraggo il precedente

		return tempo;									//ritorno il tempo impiegato dall'esecuzione
	}

	/*
	 * La differenza tra questo algoritmo e il precedente è che il quicksort
	 * ha bisogno di un array di Comparable, quindi l'array di appoggio che 
	 * istanzierò sarà un array di Integer e non di int
	 */
	@SuppressWarnings("static-access")
	public static long quicksort(int [] array, int dimensione, AlgoritmiOrdinamento alg) {

		long tempo;
		int i;
		Integer array_appoggio[], dimensione_ap;
		dimensione_ap = new Integer (dimensione);
		array_appoggio = new Integer [dimensione_ap];
		for(i=0; i<dimensione; i++) {
			array_appoggio[i] = new Integer (array[i]);
		}
		tempo = System.nanoTime();
		alg.quickSort(array_appoggio);
		tempo = System.nanoTime() - tempo;
		
		return tempo;
	}

	/*
	 * per la spiegazione di questo algoritmo vedi il precedente: sono uguali
	 */
	@SuppressWarnings("static-access")
	public static long mergesort(int [] array, int dimensione, AlgoritmiOrdinamento alg){

		long tempo;
		int i;
		Integer array_appoggio[], dimensione_ap;
		dimensione_ap = new Integer (dimensione);
		array_appoggio = new Integer [dimensione_ap];
		for(i=0; i<dimensione; i++) {
			array_appoggio[i] = new Integer (array[i]);
		}
		tempo = System.nanoTime();
		alg.mergeSort(array_appoggio);
		tempo = System.nanoTime() - tempo;

		return tempo;
	}

	/*
	 * per la spiegazione di questo algoritmo vedi il precedente: sono uguali
	 */
	@SuppressWarnings("static-access")
	public static long heapsort(int [] array, int dimensione, AlgoritmiOrdinamento alg){
		
		long tempo;
	int i;
	Integer array_appoggio[], dimensione_ap;
	dimensione_ap = new Integer (dimensione);
	array_appoggio = new Integer [dimensione_ap];
	for(i=0; i<dimensione; i++) {
		array_appoggio[i] = new Integer (array[i]);
	}
	tempo = System.nanoTime();
	alg.heapSort(array_appoggio);
	tempo = System.nanoTime() - tempo;
	
	return tempo;
	}

	/*
	 * questo algoritmo differisce dai precedenti solo perchè il radixsort ha bisogno di sapere in quale base operare
	 * quindi gli viene passata anche la base sottoforma di stringa e poi convertita in intero tramite la funzione Integer.parseInt
	 * 
	 * per il resto è uguale ai prototipi precedenti
	 */
	@SuppressWarnings("static-access")
	public static long radixsort(int [] array, int dimensione, AlgoritmiOrdinamento alg, String base_str) {
		
		long tempo;
		int i, base, array_appoggio[];
		base = Integer.parseInt(base_str);
		array_appoggio = new int [dimensione];
		for(i=0; i<dimensione; i++) {
			array_appoggio[i] = array[i];
		}
		tempo = System.nanoTime();
		alg.radixSort(array_appoggio, dimensione, base);
		tempo = System.nanoTime() - tempo;
		
		return tempo;
	}
}