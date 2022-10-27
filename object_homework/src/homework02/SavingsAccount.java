package homework02;

public class SavingsAccount extends BankAccount{
    private  int count = 3;
    private double rate = 0.01;

    public SavingsAccount(double banlance) {
        super(banlance);
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void depsoit(double amount) {
        //判断是否免手续费
        if(count > 0){
            super.depsoit(amount);
        }else{
            super.depsoit(amount-1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if(count > 0){
            super.withdraw(amount);
        }else{
            super.withdraw(amount+1);
        }
        count--;
    }

    public void earnMonthlyInterest(){  //每月初统计上月利息，同时将count=3
        count = 3;
        super.depsoit(getBanlance() * rate);
    }
}
