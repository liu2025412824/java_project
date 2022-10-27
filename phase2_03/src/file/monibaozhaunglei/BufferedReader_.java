package file.monibaozhaunglei;

/**
 * @author Lzy
 * @version 1.0
 */
public class BufferedReader_ extends Reader_{
    private Reader_ reader_;

    public BufferedReader_(Reader_ reader_){
        this.reader_ = reader_;
    }

    //不想扩展
    public void readFile(){
        reader_.readFile();
    }
    //扩展readFile，多次读取文件
    public void readFiles(int num){
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    //扩展readString,多次读取字符串
    public void readStrings(int num){
        for (int i = 0; i < num; i++) {
            reader_.readString();
        }
    }
}
