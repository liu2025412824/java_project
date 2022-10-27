package homework02;

public class BankAccount {
    private double banlance;

    public BankAccount(double banlance) {
        this.banlance = banlance;
    }
    //存款
    public void depsoit(double amount){
        banlance += amount;
    }
    //取款
    public void withdraw(double amount){
        banlance -= amount;
    }

    public double getBanlance() {
        return banlance;
    }

}
