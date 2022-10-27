package set_;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.util.HashSet;
import java.util.Set;

public class SetMethod {
    public static void main(String[] args) {

        Set set = new HashSet();
        set.add("john");
        set.add("mack");
        set.add("lucy");
        set.add("null");
        set.add("john");

        System.out.println(set);

        for(Object o:set){
            System.out.println(o);
        }
    }
}

