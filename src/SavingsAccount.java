public class SavingsAccount{
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount( double initialDeposit){
        this.savingsBalance = 0;
        deposit(initialDeposit);
    }

    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }

    public void calculateMonthlyInterest(){
        double monthlyInterestRate = annualInterestRate / 12;
        deposit(this.savingsBalance * monthlyInterestRate);
    }

    private void deposit(double amount){
        this.savingsBalance += amount;
    }

    public void printBalance(){
        System.out.printf("%.2f\t\t", this.savingsBalance);
    }
}