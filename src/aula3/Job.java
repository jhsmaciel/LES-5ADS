package aula3;

public class Job implements Runnable {
	private String nome;
	
	public Job(String nome) {
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
		Thread threadJoao = new Thread( new Job("João") );
		threadJoao.setPriority(Thread.MAX_PRIORITY);
		threadJoao.start();
		
		Thread threadGuila = new Thread( new Job("Guila") );
		threadJoao.setPriority(Thread.MIN_PRIORITY);
		threadGuila.start();
		
		Thread threadFeijao = new Thread( new Job("Feijão") );
		threadJoao.setPriority(Thread.NORM_PRIORITY);
		threadFeijao.start();

		
	}
}
