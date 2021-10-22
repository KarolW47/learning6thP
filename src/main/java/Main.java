import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // boolean variable for running this whole app in loop
        boolean isStillRunning = true;

        // checking if app running or if it's stopped by user
        while (isStillRunning) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome in quiz by KaWa! :)");

            /// TODO: 21.10.2021 more categories
            System.out.println("Categories:");
            System.out.println("1 - Film");
            System.out.println("2 - Sport");
            System.out.println("Chose category:");

            //// boolean to check for illegalArgument exception loop while user choosing category
            /// TODO: 22.10.2021 TryCatch for scanning number of cattegory form user
            boolean stillCheckingForUsersCategoryPick = true;

            // taking number of chosen category form user
            int chosenQuizCategory = scanner.nextInt();

            // switching chosen category and running proper quiz
            /// TODO: 21.10.2021 complete with functions to actually run quiz and interact with user
            switch (chosenQuizCategory) {
                case 1 -> System.out.println("Stuff happening with quiz for Film category");
                case 2 -> System.out.println("Stuff happening with quiz for Sport category");
            }

            // boolean to check for illegalArgument exception loop while user choosing to exit or play agian
            boolean stillCheckingIfUserWantToLeave = true;
            // String for user's exit choice
            String playAgainOption = null;

            // loop for IllegalArgument while user trying to exit and type something else than String
            while (stillCheckingIfUserWantToLeave) {
                System.out.println("Wanna play again? y/n");

                // taking user answer (y/n), if he wants to end or not, handle exception for IlleaglArgument
                try {
                    playAgainOption = scanner.next();
                } catch (IllegalArgumentException illegalArgumentException) {
                    System.out.println("Wrong answer.");
                    System.out.println("Press 'y' if you want to play again or press 'n' if you want to exit.");
                } finally {
                    assert playAgainOption != null;
                    if (playAgainOption.equals("n")) {
                        System.out.println("Till next time :>");
                        stillCheckingIfUserWantToLeave = false;
                        isStillRunning = false;
                    } else if (playAgainOption.equals("y")) {
                        System.out.println("---------------------------------------------------------------------");
                        stillCheckingIfUserWantToLeave = false;
                    } else {
                        System.out.println("Wrong answer.");
                        System.out.println("Press 'y' if you want to play again or press 'n' if you want to exit.");
                    }
                }
            }
        }


    }
}


