package exercicio_map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Exercicio {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		 Map<String,Integer> votos = new HashMap<>();
		
		   String lista = "C:\\Temp\\votos.txt";
		
	  try (BufferedReader list = new BufferedReader(new FileReader(lista))){
			 
			String line = list.readLine();
			   
	     while (line != null) {
			     System.out.println(line);
			      String[] separar = line.split(",");
			       String nome = separar[0];
			        int votosRecebidos = Integer.parseInt(separar[1]);//Convertendo o número de votos de String para int
			         votos.put(nome,votos.getOrDefault(nome,0) + votosRecebidos);/*getOrDefault para obter o valor atual de votos para o 
			          candidato, somado os votos atuais com os novos votos.*/
			           line = list.readLine();
		}
	  }
	       catch (IOException e) {
			    System.out.println("Erro de leitura de arquivo! " + e.getMessage());
	       }
	            System.out.println("");
	            System.out.println("RESULATDO FINAL");
		
	       for( Map.Entry<String,Integer> resultado: votos.entrySet()) {
                 System.out.println(resultado);
	       }
	       
	       // SAÍDA
	       /*
	        * Alex Blue,15
              Maria Green,22
              Bob Brown,21
              Alex Blue,30
              Bob Brown,15
              Maria Green,27
              Maria Green,22
              Bob Brown,25
              Alex Blue,31

              RESULATDO FINAL
              Alex Blue=76
              Bob Brown=61
              Maria Green=71
	        */
	}
}
