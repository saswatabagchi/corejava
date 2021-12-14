import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class FilterTheNullValueFromStream {
	
	public static void main(String[] args) {
        Stream<String> deptList = Stream.of(new String("IT"), new String("HR"),
                null, new String("Development"), null,
                new String("Recruitment"));
        removeNullObjets(deptList);
    }

    public static void removeNullObjets(Stream<String> deptList) {
        List<String> result = deptList.filter(x -> x != null).collect(
                Collectors.toList());
        result.forEach(System.out::println);
    }

}
