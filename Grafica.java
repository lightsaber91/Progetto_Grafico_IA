/*
 * Questo � il file contenete il main del programma.
 * E' nella class chiamato grafica poich� avevo cominciato qui a
 * creare le prime basi grafiche e a fare le prime prove con le finestre.
 * Ogni finestra del programma � creata con il JOptionPane in
 * quanto volevo solo fare una GUI di contorno senza troppo fronzoli.
 * 
 * Il funzionamento del main � il seguente:
 * - Avvio una schermata che da all'utente un minimo di informazioni sull'uso
 *   che deve fare, su come usarlo, e ci� che gli pu� servire;
 *   
 * - Dopo di che chiedo di inserire il perscorso in cui salvare il file con
 * 	 i risultati dei test, � una scelta opzionale in quanto alla fine dell'
 *   esecuzione verranno mostrati in una finestra;
 *   
 * - Se viene inserito il percorso viene chiesto anche il nome del file;
 * 
 * - A questo punto � necessario sapere la dimensione dell'array che si vuole
 *   creare, e subito dopo crearlo tramite la funzione CreaArray.crea;
 *   
 * - Ora l'utente deve selezionare il tipo di algoritmo da utilizzare e per questo
 *   c'� la funzione SceltaAlgoritmo.scegli();
 *   
 * - Infine viene invocata la funzione per eseguire i test Wait.finestra;
 */

import javax.swing.*;

class Grafica {
	
	public static void main (String[] args){
		
		String path, name=null, dim;
		//path � il percorso in cui salvare il file dei test
		//name � il nome del file ed � inizializzato a null perch� per scrivere su file il programma controlla che il nome esista e se non viene cambiato rimane null
		//dim � la dimensione dell'array che poi verr� convertita in intero
		
		int dimensione, selezione, array_random[], _menu;
		//dimensione � la variabile intera che conterr� la dimensione dell'array
		//selezione � la variabile in cui viene salvato l'algoritmo di ordinamento scelto
		//array_random � l'array che verr� creato per essere poi ordinato
		//_menu � ci� che ritorna il JOptionPane iniziale in cui viene fatta l'introduzione al programma, in caso sia -1 si esce
		
		long [] time = new long [5];
		//Qui viene istanziato un'array di 5 long che serviranno per salvare i tempi di ordinamento
		
		_menu = JOptionPane.showOptionDialog(null, "Questo programma serve a testare i tempi di esecuzione di vari algoritmi di ordinamento su array diversi\n\n"
												  +"Gli algoritmi che possono essere testati sono i seguenti: \n"
												  +" - Integersort\n - QuickSort\n - Mergesort\n - Heapsort\n - Radix-sort\n\n"
												  +"Nelle schermate successive saranno chieste informazioni in pi� per il corretto funzionamento del programma: \n"
												  +" -) Il percorso in cui salvare i file in cui verranno scritti i risultati dei test eseguiti - (Opzionale)\n"
												  +" -) Il nome del file in cui salvare i risultati ottenuti - (Solo se selezionata la cartella)\n"
												  +" -) La dimensione dell'array random su cui eseguire i test - (Obbligatoria)\n"
												  +" -) La base del Radix-Sort - (Solo se selezionato l'algoritmo)\n\n", 
												  "Test Algoritmi Ordinamento.jar",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Continua"},null);
		//questo JOptionPane crea la schermata inizale in cui vengono spiegate le richieste del programma e come si dovr� procedere
		
		if(_menu == -1)				//Questo controllo serve per l'uscita dal programma
			System.exit(1);

		path = JOptionPane.showInputDialog(null,"Inserisci il percorso in cui vuoi salvare il file contenente i risultati dei test eseguiti\n\n"
												+"Es: C:\\Cartella1\\Cartella2\\ . . .\n\n"
												+"Premi \"Annulla\" se non vuoi salvare il file\n","Test Algoritmi Ordinamento.jar", JOptionPane.QUESTION_MESSAGE);
		//Inizializzo il path con una stringa inserita dall'utente tramite JOptionPane
		
		if(path!=null){ //Se il percorso esiste (si vuole quindi salvare il file) si chiede un nome per il file allo stesso modo del precedente
			name = JOptionPane.showInputDialog(null,"Inserisci il nome del file in cui verranno salvati i risultati dei test eseguiti\n\n"
													+"Premi \"Annulla\" se non vuoi salvare il file\n","Test Algoritmi Ordinamento.jar", JOptionPane.QUESTION_MESSAGE);
		}
		
		
		
		dim = JOptionPane.showInputDialog(null,"Inserisci la dimensione dell'array da creare\n"
											  +"Se la dimensione inserita � troppo grande il programma potrebbe risultare troppo lento!\n"
											  +"Oltre i 10 milioni di elementi si rischia di impiegare molto tempo\n\n","Test Algoritmi Ordinamento.jar", JOptionPane.QUESTION_MESSAGE);
		//con questo JOptionPane si chiede la dimensione dell'array
		
		if(dim==null) //Se non viene inserito nulla il programma si chiude
			System.exit(1);
		
		dimensione = Integer.parseInt(dim);
		//Converto la dimensione in intero
		
		array_random = new int [dimensione];
		//Inizializzo l'array
		
		CreaArray.crea(array_random, dimensione);
		//uso la funzione per creare array
		
		do {
			selezione = SceltaAlgoritmo.scegli();
			Wait.finestra(selezione, array_random, dimensione, time, path, name);
			//In questo ciclo mostro lo stesso men� principale ogni volta che finisco l'esecuzione di un'algoritmo e faccio effettuare la scelta di quale algoritmo eseguire
			
		} while (selezione!=-1);
				
		System.exit(0);
	}
}