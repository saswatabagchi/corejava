package maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		map.put("John", 70);
		map.put("Tom", 60);
		map.put("Lee", 99);
		map.put("Brad", 80);

		Set<String> keySet = map.keySet();
		System.out.println("Keys:" + keySet);

		Collection<Integer> values = map.values();
		System.out.println("Values:" + values);
		
		 map.forEach((k,v) -> System.out.println("foreach Key = "
	                + k + ", Value = " + v));
		 Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
         
	        while(itr.hasNext())
	        {
	             Map.Entry<String, Integer> entry = itr.next();
	             System.out.println("By iterator Key = " + entry.getKey() +
	                                 ", Value = " + entry.getValue());
	        }     
	    
		for (String key : keySet) {
			System.out.println("Key:" + key + " Value:" + map.get(key));
		}

	}

}
