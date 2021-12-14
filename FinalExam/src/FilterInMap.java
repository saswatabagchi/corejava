import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterInMap {

	public static void main(String[] args) {
        Map<Integer,String> mobiles = new HashMap<>();
        mobiles.put(1, "iPhone 7");
        mobiles.put(2, "iPhone 6S");
        mobiles.put(3, "Samsung");
        mobiles.put(4, "1+");
        for (Map.Entry<Integer,String> mobis : mobiles.entrySet()) {
            if(mobis.getValue().equals("Samsung")){
                System.out.println("Filtered Value : "+mobis.getValue());
            }
        }
        // Java8 Filtering
        
        String result = mobiles.entrySet().stream()
                .filter(map -> "Samsung".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        System.out.println("Filtering With Value " + result);
        
        
        Map<Integer, String> deptMap2 = mobiles.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        
        System.out.println("Filtering With Key : " + deptMap2);
    }
}
