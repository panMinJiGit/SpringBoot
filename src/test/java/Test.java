import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test {



    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("A", "11");
        map.put("B", "22");
        map.put("C", "33");
        map.forEach((k,v) -> System.out.println(k+":"+v));
        System.out.println("----------------");
        Collection<String> col = map.values();
        col.remove("11");
        map.forEach((k,v) -> System.out.println(k+":"+v));

    }
}
