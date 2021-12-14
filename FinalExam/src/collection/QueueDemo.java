package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueDemo {
	
	 public static void main(String[] args)
	    {
	        Queue<Integer> q
	            = new LinkedList<>();
	  
	        // Adds elements {0, 1, 2, 3, 4} to
	        // the queue
	        for (int i = 0; i < 5; i++)
	            q.add(i);
	  
	        // Display contents of the queue.
	        System.out.println("Elements of queue "
	                           + q);
	  
	        // To remove the head of queue.
	        int removedele = q.remove();
	        System.out.println("removed element-"
	                           + removedele);
	  
	        System.out.println(q);
	  
	        // To view the head of queue
	        int head = q.peek();
	        System.out.println("head of queue-"
	                           + head);
	  
	        // Rest all methods of collection
	        // interface like size and contains
	        // can be used with this
	        // implementation.
	        int head1 = q.poll();
	        int size = q.size();
	        System.out.println("Size of queue-"
	                           + size);
	        
	        Queue<Integer> pbq
            = new PriorityBlockingQueue<Integer>();
  
        // Adding items to the pbq
        // using add()
        pbq.add(10);
        pbq.add(20);
        pbq.add(15);
  
        // Printing the top element of
        // the PriorityBlockingQueue
        System.out.println(pbq.peek());
  
        // Printing the top element and
        // removing it from the
        // PriorityBlockingQueue
        System.out.println(pbq.poll());
  
        // Printing the top element again
        System.out.println(pbq.peek());
	    }

}
