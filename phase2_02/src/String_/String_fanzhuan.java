package String_;

public class String_fanzhuan {
    public static void main(String[] args) {
        String str = "abcdef";
        String s = null;
        try {
            s = reverse(str,1,4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        str = s;
        System.out.println(s);
    }

    public static String reverse(String str,int start,int end){

        if(!(str != null && start>=0 && start<end &&end<str.length())){
            throw new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char temp = ' ';
        for(int i = start,j=end;i<j;i++,j--){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
