package eleicao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leitor {
	Scanner sc = null;
	File file = null;
	
	public Leitor (String path) {
		file = new File(path);
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
			e.printStackTrace();
		}
	}
	
	
	//COMOFAS
	//Delimitador tem que mudar pra pegar apenas o partido,
	//mas quando nao existe coligacao o caracter
	//" - " nao esta presente, checar arquivo .csv
	public Partido lePartido(){
		Partido part = null;
		sc.nextLine();
		sc.useDelimiter(";|\\n");
		String partido = null;
		Partido[] listapartidos = null;
		int indice;
		while (sc.hasNext()){
			sc.next(); sc.next(); sc.next();
			partido = sc.next();
			
			if (partido.contains("-")){ // Partido sem coligação 
				indice = partido.indexOf("-") - 1; //acha o indice do caracter que separa coligação
				//teste
				partido = partido.substring(0, indice); //retorna a substring do início até o índice
			}
			
			System.out.println(partido);
			sc.next(); sc.next();
		}
		
		
		return part;
	}
	

}
