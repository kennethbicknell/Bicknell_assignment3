public class SavingsAccountTest{
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        SavingsAccount.modifyInterestRate(.04);

        for( int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        System.out.println("saver1:");
        saver1.printBalance();
        
        System.out.println("saver2:");
        saver2.printBalance();

        System.out.println();
        
        SavingsAccount.modifyInterestRate(.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
    
        System.out.println("saver1:");
        saver1.printBalance();
        
        System.out.println("saver2:");
        saver2.printBalance();

    }
}