public class SavingsAccountTest{
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        SavingsAccount.modifyInterestRate(.04);
        System.out.printf("Month\tSaver1\t\tSaver2\n");

        for( int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();

            saver2.calculateMonthlyInterest();

            printSavers(i + 1, saver1, saver2);
        }

        
        SavingsAccount.modifyInterestRate(.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        printSavers(13, saver1, saver2);
    


    }

    private static void printSavers(int month, SavingsAccount saver, SavingsAccount saver2){
        System.out.print(month+"\t");
        saver.printBalance();
        saver2.printBalance();
        System.out.println();
    }
}