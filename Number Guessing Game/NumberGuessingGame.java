import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> scoreCard = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        NumberGuessingGame object = new NumberGuessingGame();
        object.menu(scoreCard);
    }

    public int randomNumber(int num) {
        Random random = new Random();
        int randomNumber = random.nextInt(num) + 1;
        return randomNumber;
    }

    public void menu(ArrayList<Integer> scoreCard) {
        NumberGuessingGame object = new NumberGuessingGame();
        Scanner sc = new Scanner(System.in);
        System.out.println("************************");
        System.out.println("Choose the Event from the below options :"+"\n");
        System.out.println(" |1|  Lets Begin   |1|");
        System.out.println(" |2|  Score Board     |2|");
        System.out.println(" |3|  Exit the game   |3|");
        System.out.println();
        System.out.println("************************");
        try {
            System.out.print("Enter the Number from the option to perform the Event : ");
            int menuOption = sc.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"Enter the Range limit to the Number Guess : ");
                    int num = sc.nextInt();
                    int randomNumber = object.randomNumber(num);
                    object.guessNumber(randomNumber);
                    break;
                case 2:
                    object.displayscoreCard();
                    break;
                case 3:
                    System.out.print("\n"+"*********************"+"\n");
                    System.out.println("\n"+"Wanna break... See you soon... bybyee...");
                    System.out.print("\n"+"*********************"+"\n");
                    System.exit(0);
                    break;
                default:
                    throw new InputMismatchException("Invalid Entry...! Please check the above options... ");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreCard);
        }
    }
    
    public void guessNumber(int randomNumber) {
        Scanner sc = new Scanner(System.in);
        int guessedNumber;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            guessedNumber = sc.nextInt();
            guess++;
            if (guessedNumber > randomNumber) {
                System.out.println("Lower");
            } else if (guessedNumber < randomNumber) {
                System.out.println("Higher");
            }
        } 
        while(randomNumber != guessedNumber);
        System.out.println(" ");
        if (guess == 1)
        {
            System.out.println("Hurray... You answered number is correct in " + guess + " try..!");
        } 
        else 
        {
            System.out.println("Hurray... You answered number is correct in " + guess + " tries..!");
        }
        scoreCard.add(guess);
        System.out.println(" ");
        menu(scoreCard);
    }

    public void displayscoreCard()
    {
        System.out.println("************************");
        System.out.println("     Score Card         ");
        System.out.println("************************");
        System.out.println("Your fastest games today out of all tries is: " +"\n");

        Collections.sort(scoreCard);

        for (Integer scores : scoreCard) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreCard);
    }
}