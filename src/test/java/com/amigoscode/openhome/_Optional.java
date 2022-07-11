package com.amigoscode.openhome;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.System.out;

public class _Optional {
    public static void main(String[] args) {
        String nickName = getNickName("Duke");
        if (nickName == null) {
            nickName = "Openhome Reader";
        }
        out.println(nickName);

        Optional<String> nameOptional = getNickNameOptional("Justin1");
        // String s = nameOptional.get(); // 直接get(), 沒有的話，會出例外
        String s2 = nameOptional.orElse("Sub"); // 所以更好的做法是用 orElse
        // out.println("s: "+s);
        out.println("s2: "+s2);

    }

    static String getNickName(String name) {
        Map<String, String> nickNames = new HashMap<>(); // 假裝的鍵值資料庫
        nickNames.put("Justin", "caterpillar");
        nickNames.put("Monica", "momor");
        nickNames.put("Irene", "hamimi");
        return nickNames.get(name); // 鍵不存在時會傳回null
    }

    static Optional<String> getNickNameOptional(String name) {
        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("Justin", "caterpillar");
        nickNames.put("Monica", "momor");
        nickNames.put("Irene", "hamimi");
        String nickName = nickNames.get(name);
        return nickName == null ? Optional.empty() : Optional.of(nickName);
    }

    /*
        可使用Optional的ofNullable()來銜接程式庫中會傳回null的方法，使用ofNullable()方法時，
        若指定了非null值就會呼叫of()方法，指定了null值就會呼叫empty()方法。
        例如，先前的getNickName()方法可以更簡潔地修改為：
     */
    static Optional<String> getNickName3(String name) {
        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("Justin", "caterpillar");
        nickNames.put("Monica", "momor");
        nickNames.put("Irene", "hamimi");
        return Optional.ofNullable(nickNames.get(name));
    }

}
