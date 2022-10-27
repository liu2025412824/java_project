package importanthomework;

public class homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testwork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1+n2;
            }
        },10,18);
    }
}

interface ICalculate{
    public double work(double n1,double n2);
}

class Cellphone{
    public void testwork(ICalculate ical,double n1,double n2){
        double result = ical.work(n1,n2);
        System.out.println("result="+result);
    }
}