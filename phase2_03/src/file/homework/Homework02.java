package file.homework;

import java.io.*;

/**
 * @author Lzy
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {

        String filePath = "e:\\javafiletest\\ok.txt";
        BufferedReader br = null;
        String line = null;
        int count = 0;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
            while((line = br.readLine()) != null){
                System.out.println((++count)+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
