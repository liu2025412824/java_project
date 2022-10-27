package homework02;

public class Test {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(1000);
        sa.depsoit(100);
        sa.depsoit(100);
        sa.depsoit(100);
        System.out.println(sa.getBanlance()); //1300
        sa.depsoit(100);
        System.out.println(sa.getBanlance()); //1399

        //月初，定时器自动调用一下earnMonthlyInterest
        sa.earnMonthlyInterest();
        System.out.println(sa.getBanlance()); //1412.99
        sa.withdraw(100);
        sa.withdraw(100);
        sa.withdraw(100);   //1112.99
        sa.withdraw(100);   //1011.99
        System.out.println(sa.getBanlance());
    }
}
