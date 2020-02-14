import java.security.SecureRandom;
import java.util.Scanner;
public class CAI1{ 
    SecureRandom rand;
    Scanner in;
    int factor1, factor2, product;
    final static int range = 10;
    
    public CAI1(){
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
        System.out.println("Very good!");
    }

    private void displayIncorrectResponse(){
        System.out.println("No. Please try again.");
    }
}