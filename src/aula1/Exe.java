package aula1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Exe {
	public static void main(String[] args) {
		Exe exe = new Exe();
		exe.escreverArquivo();
	}
	
	
	public void escreverArquivo() {
		String content = "";
		int i = 0 ;
		File file = new File("C://Exercicios/texto.txt");
		if(!file.exists()) {
			criarArquivo(file);
		}
		try {
			FileWriter fw = new FileWriter( file, true );
			do  {
				content = JOptionPane.showInputDialog("Digite qualquer palavra ou frase para inserir no txt");
				fw.write("\n" + content);
				fw.write(" Linha: " + i);
				i++;
				fw.flush();
			} while (!"sair".equals(content));
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
	public void criarArquivo(File f) {
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("Pode ler: %b\n", f.canRead());
		System.out.printf("Arquivo: %b\n", f.isFile());
		System.out.printf("Diretorio: %b\n", f.isDirectory());
	}
}