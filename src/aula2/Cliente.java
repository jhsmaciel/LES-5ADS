package aula2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
public class Cliente {
	private String urlServidor = "127.0.0.1";
	public Cliente() { 
		try {
			System.out.println("Cliente iniciado");
			Socket srv = new Socket(urlServidor,4000);	System.out.println("Cliente conectado no servidor");
			InputStream in = srv.getInputStream();
			OutputStream out = srv.getOutputStream();
			
			InputStreamReader isrIn = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isrIn);
			
			InputStream kbd = System.in;
			InputStreamReader kbdIsr = new InputStreamReader(kbd);
			BufferedReader kbdBr = new BufferedReader(kbdIsr);

			String linhaKbd = "";
			while (!"sair".equals(linhaKbd)) { 
				if (br.ready()) { 
					String linha = br.readLine();
					System.out.println(linha);
				}
				
				if (kbdBr.ready()) { 
					linhaKbd = kbdBr.readLine();
					out.write(linhaKbd.getBytes());
					out.write("\n".getBytes());
					out.flush();
				}
			}
			srv.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Cliente();
	}
}