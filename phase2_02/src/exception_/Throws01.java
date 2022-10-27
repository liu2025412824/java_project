package exception_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) throws FileNotFoundException{
        f1();
    }

    public static void f1() throws FileNotFoundException{
        f2();
    }
    public static void f2() throws FileNotFoundException{
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
}
