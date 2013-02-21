package br.com.micheldealmeida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
public class IO {
	
	public String[] listarArquivos(final File diretorio) {
	
		
		String vetorArquivos[] = new String[diretorio.listFiles().length];
		int i=0;
	    for (final File entrada : diretorio.listFiles()) {
	        if (entrada.isDirectory()) {
	        	listarArquivos(entrada);
	        } else {
	            //System.out.println(entrada.getName());
	        	vetorArquivos[i] = entrada.getName();
	        	i++;
	        }
	    }
		return vetorArquivos;
	}
	


	public List<String> ler(String nomeArquivo) {
		try {
			String texto;

			File file = new File(nomeArquivo);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			List<String> lista = new ArrayList<String>();

			while ((texto = bufferedReader.readLine()) != null) {
				// System.out.println(texto+" oi"+x);
				lista.add(texto);

			}

			bufferedReader.close();

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void escrever(String nomeArquivo) {
		try {
			PrintStream saida = new PrintStream(new FileOutputStream(nomeArquivo+".txt"));
			System.setOut(saida);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}