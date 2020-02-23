public class SavingsAccountTest{
    public void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount( .04, 2000);
        SavingsAccount saver2 = new SavingsAccount( .04, 3000);

        for( int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        saver1.modifyInterestRate(.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
    
        System.out.println("saver1:");
        saver1.printBalance();
        
        System.out.println("saver2:");
        saver2.printBalance();

    }
}