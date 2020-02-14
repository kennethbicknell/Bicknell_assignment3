import java.security.SecureRandom;
import java.util.Scanner;
public class CAI3{ 
    SecureRandom rand;
    Scanner in;
    int factor1, factor2, product, correct;
    final static int range = 10;
    
    public CAI3(){
        rand = new SecureRandom();
        in = new Scanner(System.in);
        
        
        this.generateQuestion();

    }

    private int generateFactor(int range){
        return rand.nextInt(range);
    }
    
    public void quiz(){
        this.correct = 0;

        for(int i = 0; i < 10; i++){
           askQuestion();
           readResponse();
           generateQuestion();
       }

       displayCompletionMessage();
    }

    private void askQuestion(){
        System.out.printf("What is %d * %d? ", factor1, factor2);
    }

    private void readResponse(){
        int studentAnswer = in.nextInt();
        if (isAnswerCorrect(studentAnswer)){
            displayCorrectResponse();
            this.correct++;
            return;
        } else {
            displayIncorrectResponse();
            return;
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

    private void generateQuestion(){
        this.factor1 = generateFactor(range);
        this.factor2 = generateFactor(range);

        this.product = factor1 * factor2;
    }

    private void displayCompletionMessage(){
        double grade = ((double) correct / 10) * 100;
        System.out.printf("Your grade is %.0f\n", grade);

        if(passed(grade)){
            System.out.println("Congratulations, you are ready to go to the next level!");
        }  else {
            System.out.println("Please ask your teacher for extra help.");
        }

        refreshQuiz();

    }

    private boolean passed(double grade){
        return (grade >= 75);
    }

    private void refreshQuiz(){
        System.out.print("Would you like to start over? (y/n)  ");
        String response = in.next();
        while(!(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n"))){
            System.out.print("Would you like to start over? (y/n)  ");
            response = in.next();
        }
        
        
        if (response.equalsIgnoreCase("y")){
            System.out.println();
            generateQuestion();
            quiz();
        } else if(response.equalsIgnoreCase("n")){
            System.exit(0);
        }
    }
}

