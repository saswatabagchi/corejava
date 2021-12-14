package org.saswata.interthread.communication;

class MyData
{
    int value=0;
    int x=0;
    volatile boolean flag=true;
    
    synchronized public void set(int v)
    {
        if(value > v)
            try {wait();}catch(Exception e){}
        
        value=v;
        flag=false;
        notify();
        try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    synchronized public int get()
    {
       
        if(value == x)
            try {wait();}catch(Exception e){}
        
        
        x=value;
        flag=true;
        notify();
        
        return x;            
    }
}

class Producer extends Thread
{
    MyData data;
    
    public Producer(MyData d)
    {
        data=d;
    }
    public void run()
    {
        int count=1;
        while(count<=100)
        {
            data.set(count);
            System.out.println("Producer "+count);
            count++;
        }
    }
}

class Consumer extends Thread
{
    MyData data;
    
    public Consumer(MyData d)
    {
        data=d;
    }
    public void run()
    {
        int value = 1;
        while( value<=100 )
        {
            value=data.get();
            System.out.println("Consumer "+value);
        }
    }
}

public class InterProcess 
{
    public static void main(String[] args) 
    {
        MyData data=new MyData();
        
        Producer p=new Producer(data);
        Consumer c=new Consumer(data);
        
        p.start();
        c.start();
        
    }
}

