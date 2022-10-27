package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = " ";
        while((line = br.readLine()) != null){
            String[] split = line.split("=");
            System.out.println(split[0]+"的值是："+split[1]);
        }

        br.close();
    }
}
