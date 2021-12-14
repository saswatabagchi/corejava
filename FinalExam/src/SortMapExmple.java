import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortMapExmple {

	public static void main(String[] args) {
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Maths", 95);
        marks.put("Chemistry", 84);
        marks.put("Physics", 92);
        marks.put("Languages", 94);
        sortByKey(marks);
    }

    public static void sortByKey(Map<String, Integer> marks) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        marks.entrySet().stream()
         .sorted(Map.Entry.<String, Integer>comparingByKey())
         .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        System.out.println(sortedMap);
    }
}
