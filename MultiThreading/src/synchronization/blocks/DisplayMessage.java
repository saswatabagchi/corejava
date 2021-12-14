package synchronization.blocks;

public class DisplayMessage {

	public void sayHello(String name) {
		System.out.println("How are you from before  block " + name);
		synchronized (this) {
			for (int i = 1; i <= 10; i++) {
				System.out.println("How are you from block " + name);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	  synchronized  public void sayHello1(String name)  {
		for (int i = 1; i <= 10; i++) {
			System.out.println("How are you from  syn instance method " + name + " times " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public    void sayHello2(String name)  {
		for (int i = 1; i <= 10; i++) {
			System.out.println("How are you from  non syn instance method " + name + " times " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
	public   static synchronized void sayHello3(String name)  {
		for (int i = 1; i <= 10; i++) {
			System.out.println("How are you from  static syn method " + name + " times " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
