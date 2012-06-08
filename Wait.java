/*
 * Questa classe � la funzione che gestisce le chiamate alle funzioni di
 * ordinamento e di scrittura file dope che esse sono state selezionate
 * dall'utente nel file selezione
 * 
 * Il nome della classe � wait poich� all'inizio avevo intenzione di fare
 * in questo file solo la parte relativa ai thread per la gestione del pannello
 * grafico
 * 
 * La parte relativa ai thread viene infatti usata per aprire un pannello che
 * avvisa l'utente che il programma sta eseguendo l'algoritmo mentre
 * esso effettivamante esegue, e per la chiusura della stessa finestra
 * 
 * Ogni algoritmo viene eseguito 5 volte sullo stesso array e poi viene fatta
 * una media dei tempi poich� � stato visto che la funzione System.nanotime()
 * ha tempi diversi per ordinare lo stesso array e quindi per cercare di ridurre
 * al minimo gli errori viene fatta una media di 5 tempi poich� se si aumentasse
 * il numero di prove i tempi di esecuzione su input grandi aumenterebbero molto
 * 
 */
import javax.swing.JOptionPane;					//questa � la libreria per i pannelli grafici
import asdlab.libreria.Ordinamento.*;			//questa � la libreria per le funzioni di ordinamento
import java.lang.Thread;						//questa � la libreria per la gestione dei thread


public class Wait extends Thread {
	/*
	 * la funzione run() serve per dire al thread appena parte che cosa deve fare
	 * in questo caso deve mostrare una finestra che informa l'utente di attendere
	 * la fine dell'esecuzione dell'algoritmo
	 * 
	 * La finestra � fatta con JOptionPane e la variabile clk in serve rilevare se
	 * � stato premuto il tasto di chiusura della stessa ed in caso terminare il programma
	 * 
	 */
	public void run(){
		JOptionPane.showOptionDialog(null, "L'operazione richieder� del tempo!\n Attendere...\n ","Test Algoritmi Ordinamento.jar", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {}, null);
	}
	/*
	 * @param algoritmo: � un intero e serve per selezionare il giusto algoritmo
	 * @param array_random: � l'array creato e va poi passato alle funzioni di ordinamento
	 * @param dimensione: � la dimensione dell'array e va passato alle funzioni di ordinamento
	 * @param time: � l'array in cui salvare i tempi di esecuzione dei vari algoritmi
	 * @param path: � il percorso dove salavre il file con i risultati
	 * @param name: � il nome del file contenente i risultati
	 * 
	 */
	public static void finestra(int algoritmo, int [] array_random, int dimensione, long [] time, String path, String name) {
		
		Thread _t = new Wait();										//Inizializzo nuovo thread
		String base_radix = null;									//Inizializzo la base del radix-sort
		AlgoritmiOrdinamento alg = new AlgoritmiOrdinamento();		//Inizializzo l'algoritmo di ordinamento
		
		_t.setPriority(MAX_PRIORITY);								//Imposto la massima priorit� al thread appena creato
																	//in modo che la finestra si apra subito, prima che l'algoritmo
																	//inizi ad ordinare, altrimenti per array piccoli la finestra si aprirebbe
																	//dopo aver finito il calcolo
	switch (algoritmo) {

 		case 0:													//il case 0 � utilizzato per l'integersort	
 			_t.start();											//faccio partire il thread
 			for(int i=0;i<5;i++) {								// inizio il ciclo per fare le 5 prove
 				time[0] = time[0] + Ordinamento.integersort(array_random, dimensione, alg);
 			}
 			time[0]=time[0]/5;									//faccio la media dei tempi di quelle 5 prove
 			_t.interrupt();										//chiudo il thread
 			JOptionPane.showOptionDialog(null, "Integersort Eseguito!\n"
 											  +"Ordinati "+dimensione+" elementi in "+time[0]/1000000+"ms \n\n",
 											  "Test Algoritmi Ordinamento.jar", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Ok"}, null);
 																//mostro il pannello che conferma la corretta esecuzione del programma
 			if(name!=null)										//se il file � stato creato vengono salvati i risultati
 				ScritturaFile.salva_info("IntegerSort", (double) time[0]/1000000, dimensione, path, name);
 		break;
 		
 		//per il case 1 guarda la descrizione del case 0

 		case 1:
 			_t.start();
 			for(int i=0;i<5;i++) {
 				time[1] = time[1] + Ordinamento.quicksort(array_random, dimensione, alg);
 			}
 			time[1]=time[1]/5;
 			_t.interrupt();
 			JOptionPane.showOptionDialog(null, "Quicksort Eseguito!\n"
 											  +"Ordinati "+dimensione+" elementi in "+time[1]/1000000+"ms \n\n",
 											  "Test Algoritmi Ordinamento.jar", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Ok"}, null);
 			if(name!=null)
 				ScritturaFile.salva_info("QuickSort", (double) time[1]/1000000, dimensione, path, name);
 		break;
 		
 		//per il case 2 guarda la descrizione del case 0

 		case 2:
 			_t.start();
 			for(int i=0;i<5;i++) {
 				time[2] = time[2] + Ordinamento.mergesort(array_random, dimensione, alg);
 			}
 			time[2]=time[2]/5;
 			_t.interrupt();
 			JOptionPane.showOptionDialog(null, "Mergesort Eseguito!\n"
 											  +"Ordinati "+dimensione+" elementi in "+time[2]/1000000+"ms \n\n",
 											  "Test Algoritmi Ordinamento.jar", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Ok"}, null);
 			if(name!=null)
 				ScritturaFile.salva_info("MergeSort", (double) time[2]/1000000, dimensione, path, name);
 		break;
 		
 		//per il case 3 guarda la descrizione del case 0

 		case 3:
 			_t.start();
 			for(int i=0;i<5;i++) {
 				time[3] = time[3] + Ordinamento.heapsort(array_random, dimensione, alg);
 			}
 			time[3]=time[3]/5;
 			_t.interrupt();
 			JOptionPane.showOptionDialog(null, "Heapsort Eseguito!\n"
 											  +"Ordinati "+dimensione+" elementi in "+time[3]/1000000+"ms \n\n",
 											  "Test Algoritmi Ordinamento.jar", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Ok"}, null);
 			if(name!=null)
 				ScritturaFile.salva_info("HeapSort", (double) time[3]/1000000, dimensione, path, name);
 		break;
 		
 		//per il case 4 guarda la descrizione del case 0
 		//la differenza rispetto ai case precedenti � solo la richiesta della base del radix-sort

 		case 4:
 			base_radix = JOptionPane.showInputDialog(null,"Inserisci la base del Radix-sort\n\n","Test Algoritmi Ordinamento.jar", JOptionPane.INFORMATION_MESSAGE);
 			_t.start();
 			for(int i=0;i<5;i++) {
 				time[4] = time[4] + Ordinamento.radixsort(array_random, dimensione, alg, base_radix);
 			}
 			time[4]=time[4]/5;
 			_t.interrupt();
 			JOptionPane.showOptionDialog(null, "Radix-Sort base "+base_radix+ " Eseguito!\n"
 											  +"Ordinati "+dimensione+" elementi in "+time[4]/1000000+"ms \n\n",
 											  "Test Algoritmi Ordinamento.jar", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Ok"}, null);
 			if(name!=null) {
 				ScritturaFile.salva_info("Radix-Sort base "+ base_radix, (double) time[4]/1000000, dimensione, path, name);
 			}
 		break;
 		
 		case 5:
 			for(int i=0; i<5;i++){
 				finestra(i,array_random,dimensione, time, path, name);
 			}
 		break;
	 }
		
	}
}