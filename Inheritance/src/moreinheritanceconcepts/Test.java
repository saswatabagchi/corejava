package moreinheritanceconcepts;

public class Test {

	public static void main(String[] args) {
		
		
		//Child x =  new Parent() ;
		Parent c =  new Child() ;
		Child d;
		d = (Child) c;
        c.dispalyFromParent("saswata");
        System.out.println("variable access c "+ c.c);
        System.out.println("variable access d "+ d.c);
        System.out.println("final variable access c "+ c.e);
        System.out.println("final variable access d "+ d.e);
        //System.out.println("private variable access c "+ c.f);
        System.out.println("private variable access d "+ d.f);
        System.out.println("Normal variable access c "+ c.g);
        System.out.println("Normal variable access d "+ c.g);
        System.out.println("hash code  c "+ c.hashCode());
        System.out.println("hash code  d "+ d.hashCode());
        System.out.println("check the equality "+ ( c==d));
        c.x = 20;
        c.y = 32;
       	d.m1();
       	c.m1();
        //System.out.println("variable access "+ c.d);
	}

}
