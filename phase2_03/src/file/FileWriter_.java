package file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\javafiletest\\b.txt";
        FileWriter fileWriter = null;
        char[] chars = {'l','z','y'};

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write('L');
            fileWriter.write(chars);
            fileWriter.write(chars,0,2);
            fileWriter.write("早安小伙子");
            fileWriter.write("早安小伙子".toCharArray(),0,2);
            fileWriter.write("早安小朋友",0,2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }
}
