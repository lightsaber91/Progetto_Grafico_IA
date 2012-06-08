/*
 * Questo file serve a creare gli array random su cui fare i test
 *
 * @param array: l'array passato dal main in cui salvare valori random
 * @param dimensione: la dimensione dell'array anch'essa proveniente dal main
 * 
 */
public class CreaArray {
	public static void crea(int [] array,int dimensione){

		int i; //variabile contatore per il ciclo
		
		for (i=0; i<dimensione; i++){
			//ciclo for per riempire l'array con valori random
			
			array[i] = (int) (Math.round(Math.random()*(dimensione-1)));
			
			/* Math.round() serve per arrotondare i valori
			 * Math.random() genera numeri random nell'intervallo [0,1]
			 *
			 * Li moltiplico per la dimensione-1 perchè l'integersort non
			 * funziona solo con array nei quali gli elementi vanno da [0, k-1]
			 * dove k è la dimensione dell'array
			 */
		}
	}
}