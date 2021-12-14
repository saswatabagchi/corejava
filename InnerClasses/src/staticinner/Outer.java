package staticinner;

public class Outer {
    
	public static  int i = 20 ;
	static void f1() {
		System.out.println("Outers Static Method");
	}
	void f4 () {
		System.out.println("Outers Non Static  Method");
	}
//static inner class can not access non static variable 
	static class Inner {

		static void f2() {
			System.out.println("Inners Static Method");
		}

		void f3() {
			System.out.println("Non Static Method Inside the Inner class" + i);
		}

	}

	public static void main(String[] args) {

		Outer.f1();
		Outer.Inner.f2();

		Outer.Inner inner = new Outer.Inner();

		inner.f3();
		inner.f2();

	}

}
