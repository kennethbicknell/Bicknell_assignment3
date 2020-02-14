import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;
public class CAI5{ 
    private SecureRandom rand;
    private Scanner in;
    private double num1, num2, answer;
    private int range, type, tempType, numCorrect;
    final static double acceptable_error = .000001;

    public static void main(String[] args){
        CAI5 test = new CAI5();
        test.quiz();
    }
    
    public CAI5(){
        rand = new SecureRandom();
        in = new Scanner(System.in);
        
        
    }

    private int generateFactor(){
        return rand.nextInt(range);
    }
    
    public void quiz(){
        readDifficulty();
        readProblemType();
        this.numCorrect = 0;
        this.generateQuestionArgument();

        for(int i = 0; i < 10; i++){
           askQuestion();
           readResponse();
           generateQuestionArgument();
       }

       displayCompletionMessage();
    }

    private void askQuestion(){
        switch(tempType){
            case 0:
                System.out.printf("what is %.0f + %.0f? ", num1, num2);
                break;
            case 1:
                System.out.printf("what is %.0f * %.0f? ", num1, num2);
                break;
            case 2:
                System.out.printf("what is %.0f - %.0f? ", num1, num2);
                break;
            case 3:
                System.out.printf("what is %.0f / %.0f? ", num1, num2);
                break;
            
        }
    }

    private void readResponse(){
        double studentAnswer = in.nextDouble();
        if (isAnswerCorrect(studentAnswer)){
            displayCorrectResponse();
            this.numCorrect++;
            return;
        } else {
            displayIncorrectResponse();
            return;
        }
    }

    private boolean isAnswerCorrect(Double response){
        if(tempType == 3){
            return (Math.abs(response - answer) < .1);
        } else {
            return (Math.abs(response - answer) < acceptable_error);
        }
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

    private void generateQuestionArgument(){
        this.num1 = generateFactor();
        this.num2 = generateFactor();

        if(type == 4){
            tempType = rand.nextInt(4);
        }

        switch(tempType){
            case 0:
                answer = num1 + num2;
                break;
            case 1:
                answer = num1 * num2;
                break;
            case 2:
                answer = num1 - num2;
                break;
            case 3:
                answer = num1 / num2;
                break;
        }
    }

    private void displayCompletionMessage(){
        double grade = ((double) numCorrect / 10) * 100;
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
            quiz();
        } else if(response.equalsIgnoreCase("n")){
            System.exit(0);
        }
    }

    private void readDifficulty(){
        System.out.print("Please enter a difficulty level from 1-4 ");
        int difficulty = in.nextInt();
        while (difficulty > 4 || difficulty < 1){
            System.out.print("Please enter a difficulty level from 1-4 ");
            difficulty = in.nextInt();
        }

        range = (int)Math.pow(10, difficulty);

    }

    private void readProblemType(){
        System.out.println("Please enter a problem type from 1-5.");
        System.out.println("1: addition");
        System.out.println("2: multiplication");
        System.out.println("3: Subtraction");
        System.out.println("4: Division");
        System.out.println("5: Random mix of questions");
        int type = in.nextInt();
        while (type > 5 || type < 1){
            System.out.print("Please enter a problem type from 1-5 ");
            type = in.nextInt();
        }

        this.type = type - 1;
        this.tempType = type -1;
    }
}

