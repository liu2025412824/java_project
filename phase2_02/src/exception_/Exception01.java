package exception_;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        try{
            int res = num1 / num2;
        }catch(ArithmeticException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("hello");
        }
        System.out.println("程序继续运行...");
    }
}
