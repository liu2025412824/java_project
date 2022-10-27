package collection_;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class news_ {
    public static void main(String[] args) {

        ArrayList alist = new ArrayList();
        alist.add(new News("新馆确诊病例超过千万，数百万的印度信徒徒赴恒河\"圣浴\"引民众担忧"));
        alist.add(new News("男子突然想到两个月前钓的鱼还在锅里，捞起来一看清蒸的已经变成干煸的了"));

        int size = alist.size();

        for (int i = size-1; i >= 0 ; i--) {
            System.out.println(alist.get(i));
            System.out.println(processTitle(((News) alist.get(i)).getTitle()));
        }

    }
    public static String processTitle(String title) {
        if (title == null) {
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0,15);
        }else{
            return title;
        }

    }
}

class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
