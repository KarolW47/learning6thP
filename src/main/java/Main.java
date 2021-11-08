import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        boolean isStillRunning = true;
        ResponseScanner responseScanner = new ResponseScanner();

        // loop determines if app running
        while (isStillRunning) {

            System.out.println("Welcome in quiz by KaWa! :)");

            boolean stillCheckingForUsersCategoryPick = true;
            int chosenQuizCategory = 0;

            // loop to check user's category pick, handle exception for InputMismatch
            while (stillCheckingForUsersCategoryPick) {
                /// TODO: 21.10.2021 more categories
                System.out.println("Categories:");
                System.out.println("1 - Film");
                System.out.println("2 - Sport");
                System.out.println("Chose category:");

                try {
                    chosenQuizCategory = Integer.parseInt(responseScanner.scanResponse());
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Wrong answer.");
                } finally {
                    if (chosenQuizCategory >= 1 && chosenQuizCategory <= 2) {
                        stillCheckingForUsersCategoryPick = false;
                    } else {
                        System.out.println("It needs to be number of a available category.");
                    }
                }
            }

            QAHandler qaHandler = new QAHandler();
            int obtainedPointsInQuiz;
            // switching chosen category and running proper quiz
            switch (chosenQuizCategory) {
                case 1 -> {
                    obtainedPointsInQuiz = qaHandler.handleQuestionAndAnswers(AvailableCategories.FILM);
                    System.out.println("You obtained "+ obtainedPointsInQuiz + "/5 points");
                }
                case 2 -> {
                    obtainedPointsInQuiz = qaHandler.handleQuestionAndAnswers(AvailableCategories.SPORT);
                    System.out.println("You obtained "+ obtainedPointsInQuiz + "/5 points");
                }
            }

            boolean stillCheckingIfUserWantToLeave = true;
            String playAgainOption = null;

            // loop to check user's answer (y/n), if he wants to end or not, handle exception for IllegalArgument
            while (stillCheckingIfUserWantToLeave) {
                System.out.println("Wanna play again? y/n");

                try {
                    playAgainOption = responseScanner.scanResponse();
                } catch (IllegalArgumentException illegalArgumentException) {
                    System.out.println("Wrong answer.");
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
                        System.out.println("Press 'y' if you want to play again or press 'n' if you want to exit.");
                    }
                }
            }
        }
    }
}


