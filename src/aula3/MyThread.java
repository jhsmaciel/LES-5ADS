package aula3;

public class MyThread extends Thread {
	private String nome;
	
	public MyThread(String nome) {
		this.nome = nome;
	}

	@Override
	public void run() {
		int i = 0;
		do {
			System.out.println(nome + " "+i++);
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (true);		
	}
	
	public static void main(String[] args) {
		MyThread thread = new MyThread("João");
		thread.start();
		MyThread threadNome = new MyThread("Guila");
		threadNome.start();
	}
}
