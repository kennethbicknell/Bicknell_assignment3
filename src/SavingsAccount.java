public class SavingsAccount{
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double interestRate, double initialDeposit){
        this.savingsBalance = 0;
        modifyInterestRate(interestRate);
        deposit(initialDeposit);
    }

    public void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }

    public void calculateMonthlyInterest(){
        double monthlyInterestRate = annualInterestRate / 12;
        deposit(this.savingsBalance * monthlyInterestRate);
    }

    private void deposit(double amount){
        this.savingsBalance += amount;
    }
}