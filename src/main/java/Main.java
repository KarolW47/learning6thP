import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean isStillRunning = true;

        while (isStillRunning) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome in quiz by KaWa! :)");

            /// TODO: 21.10.2021 more categories
            System.out.println("Chose category:");
            System.out.println("1 - Film");
            System.out.println("2 - Sport");

            // Taking number of chosen category form user
            int chosenQuizCategory = scanner.nextInt();

            // Switching chosen category and running quiz
            /// TODO: 21.10.2021 complete with functions to actually run quiz and interact with user
            switch (chosenQuizCategory){
                case 1 -> System.out.println("Stuff happening with quiz for Film category");
                case 2 -> System.out.println("Stuff happening with quiz for Sport category");
            }

            System.out.println("Wanna play again? y/n");

            // Taking user type (y/n), if he wants to end
            String playAgainOption = scanner.nextLine();

            // Checking chosen parameter and ending app or contunue quiz from the begining
            if (playAgainOption.equals("n")){
                isStillRunning = false;
            }
        }
    }
}

