package file;

import java.io.*;

/**
 * @author Lzy
 * @version 1.0
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
//        String filePath = "e:\\javafiletest\\c.txt";
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        String s = br.readLine();
//        System.out.println(s);
//        br.close();

        String filePath = "e:\\javafiletest\\c.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
        BufferedReader br = new BufferedReader(isr);

        //BufferedReader br = new BufferedReader(new InputStreamReader(
                     //new FileInputStream(filePath),"gbk")); //上述两句合在一起
        String s = br.readLine();
        System.out.println(s);

        br.close();
    }
}
