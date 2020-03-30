import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test {



    public static void main(String[] args) {

       /* Map<String, String> map = new HashMap<String, String>();
        map.put("A", "11");
        map.put("B", "22");
        map.put("C", "33");
        map.forEach((k,v) -> System.out.println(k+":"+v));
        System.out.println("----------------");
        Collection<String> col = map.values();
        col.remove("11");
        map.forEach((k,v) -> System.out.println(k+":"+v));*/

        /*StandardPBEStringEncryptor standardPBEStringEncryptor =new StandardPBEStringEncryptor();
        *//*配置文件中配置如下的算法*//*
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        *//*配置文件中配置的password*//*
        standardPBEStringEncryptor.setPassword("EWRREWRERWECCCXC");
        *//*要加密的文本*//*
        String username = standardPBEStringEncryptor.encrypt("admin");
        String password =standardPBEStringEncryptor.encrypt("admin123");
        *//*将加密的文本写到配置文件中*//*
        System.out.println(username);
        System.out.println(password);*/



    }
}
