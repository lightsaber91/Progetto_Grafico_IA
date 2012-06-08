/*
 * In questo file avviene la creazione del pannello grafico con cui si sceglie
 * quale algoritmo di ordinamento utilizzare per ordinare l'array random 
 * precedentemente creato
 */

import javax.swing.*;
//libreria per il pannello grafico JOptionPane

public class SceltaAlgoritmo {
	
	//La funzione restituisce un intero, ovvero il numero del bottone premuto,
	//che consentirà di avviare il giusto algoritmo nel main()
	
	public static int scegli() {
		String[] buttons = {"Integersort", "Quicksort", "Mergesort", "Heapsort", "Radix-sort","Esegui Tutti"};
		//Creo un array di stringhe contenente i nomi dei bottoni
		
		int scelta; //istanzio un intero in cui verrà salvata la scelta al passaggio successivo
		
		scelta = JOptionPane.showOptionDialog(null, "Scegli l'algoritmo su cui eseguire i test", "Test Algoritmi Ordinamento.jar"
				,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,buttons,buttons);
		// Uso un JOptionPane personalizzato che mi consente di tenere traccia di quale bottone clicko con il mouse
		// e di salvarmi tale scelta nella variabile istanziata precedentemente in modo da selezionare il giusto
		// algoritmo scelto dall'utente
		return scelta;
	}
}