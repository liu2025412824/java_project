package file.monibaozhaunglei;

/**
 * @author Lzy
 * @version 1.0
 */
public class Test_ {
    public static void main(String[] args) {

        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.readFile();//不使用扩展
        bufferedReader_.readFiles(5);

        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
        //bufferedReader_2.readString();//无动作，调用的是父类的readString()
        bufferedReader_2.readStrings(5);
    }
}
