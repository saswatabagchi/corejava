package synchronization.classlock;

public class DisplayMessage {

	public synchronized static void sayHello(String name) {
	//public  static void sayHello(String name) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("How are you " + name + "times" + i);
			try {
				Thread.sleep(2000);
				DisplayMessage.sayHello1(name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public  static void sayHello1(String name)  {
			for (int i = 1; i <= 10; i++) {
				System.out.println("How are you from non syn method " + name + " times " + i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

}
