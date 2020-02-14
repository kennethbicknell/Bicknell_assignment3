import java.security.SecureRandom;
import java.util.Scanner;
public class CAI2{ 
    SecureRandom rand;
    Scanner in;
    int factor1, factor2, product;
    final static int range = 10;
    
    public CAI2(){
        rand = new SecureRandom();
        in = new Scanner(System.in);
        
        
        factor1 = generateFactor(range);
        factor2 = generateFactor(range);
        product = factor1 * factor2;

    }

    private int generateFactor(int range){
        return rand.nextInt(range);
    }
    
    public void quiz(){
        askQuestion();
        readResponse();
    }

    private void askQuestion(){
        System.out.printf("What is %d * %d? ", factor1, factor2);
    }

    private void readResponse(){
        int studentAnswer = in.nextInt();
        if (isAnswerCorrect(studentAnswer)){
            displayCorrectResponse();
            System.exit(0);
        } else {
            displayIncorrectResponse();
            readResponse();
        }
    }

    private boolean isAnswerCorrect(int response){
        return (response == this.product);
    }

    private void displayCorrectResponse(){
        switch(rand.nextInt(4)){
            case 0:
                System.out.println("Very good!");
                break;
            case 1:
                System.out.println("Excellent!");
                break;
            case 2:
                System.out.println("Nice work!");
                break;
            case 3:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    private void displayIncorrectResponse(){
        switch(rand.nextInt(4)){
            case 0:
                System.out.println("No. Please try again.");
                break;
            case 1:
                System.out.println("Wrong. Try once more.");
                break;
            case 2:
                System.out.println("Don’t give up!");
                break;
            case 3:
                System.out.println("No. Keep trying.");
                break;
        }
    }
}

