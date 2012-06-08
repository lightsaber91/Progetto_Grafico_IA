/*
 * Questa Classe serve per effettuare la scrittura su file
 * in modo da salvare i tempi di esecuzione degli algoritmi
 * su un file esterno che può essere scelto a piacere dall'
 * utente, nella posizione ritenuta più comoda.
 * 
 *  Nei test effettuati funziona sia su Windows che su Linux
 *  
 *  In caso la cartella contenente il file non esista viene creata,
 *  lo stesso vale per il file, mentre se il file già esiste la
 *  scrittura viene ripresa dalla fine mantenendo intatte
 *  le informazioni che gia sono al suo interno.
 *  
 *  Il prototipo di scrittura su file è:
 *  "nome_algoritmo" ha ordinato un array di "num_elementi" in "tempo_esecuzione"
 */

import java.io.File;			// Questi tre import servono per poter scrivere, 
import java.io.FileWriter;		// creare il file, creare la cartella e generare
import java.io.IOException;		// un'eccezione in caso di errori

import javax.swing.JOptionPane;	// Questa libreria viene utilizzata per creare le finestre

public class ScritturaFile {
	
	/*
	 * @param nome_algoritmo: viene passata una stringa contenente il nome dell'algoritmo appena eseguito;
	 * @param tempo: il tempo impiegato dall'algoritmo a ordinare;
	 * @param dimensione_array: la grandezza dell'array ordinato;
	 * @param path: il percorso dove salvare il file;
	 * @param name: il nome del file su cui scrivere;
	 */

	public static void salva_info(String nome_algoritmo, double tempo, int dimensione_array, String path, String name) {
		String path_name;					//Inizializzo una stringa che si andrà a comporre di percorso e nome file;
		File _dir = new File(path);			//Creo un file _dir che mi servirà per controllare se la cartella contenete il file esiste
		_dir.mkdirs();						//in caso contrario la creo con la funzione mkdirs()
		path_name = path + name;			
		File _file = new File(_dir, name);	//Associo il file nella directory con il nome scelto dall'utente
		File _new= new File (path_name);	//Associo il percorso file e il nome ad un File
		try {								//in modo che venga creato il file se non esiste
			_new.createNewFile();			//e gestisco l'eccezione
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		FileWriter new_write;				//Inizializzo il filewriter per scrivere su file
		try {
			new_write = new FileWriter(_file, true);
			//questa è la funzione che permette di scrivere su file dalla fine
			
			new_write.write(nome_algoritmo+" ha ordinato in "+tempo+" ms un array di "+dimensione_array+" elementi;\n\r\r\n");
			//questa è la stringa scritta su file
			
			new_write.flush();
			//con la funzione flush() svuoto il buffer immediatamente in modo da scrivere subito su file e non avere problemi di sorta
			
			new_write.close();
			//chiudo il file
			
			
			JOptionPane.showOptionDialog(null, "Scrittura su file eseguita correttamente!\n\n"
											   +"Il risultato è stato salvato in: "+path_name+" \n",
											   "Test Algoritmi Ordinamento.jar", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Continua"}, null);
			//Mostro una finestra che informa l'utente dell'avvenuta scrittura su file;
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}