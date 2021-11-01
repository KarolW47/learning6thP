import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean isStillRunning = true;

        // loop determines if app running
        while (isStillRunning) {
            Scanner scanner = new Scanner(System.in);

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
                    chosenQuizCategory = scanner.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Wrong answer.");
                } finally {
                    if (chosenQuizCategory>=1 && chosenQuizCategory<=2) {
                        stillCheckingForUsersCategoryPick = false;
                    } else {
                        System.out.println("It needs to be number of a available category.");
                        scanner.nextLine();
                    }
                }
            }

            // switching chosen category and running proper quiz

            switch (chosenQuizCategory) {
                case 1 -> {
                    DBConnector dbConnector = new DBConnector();
                    SessionFactory actualSessionFactory = dbConnector.sessionFactory();
                    Session actualSession = actualSessionFactory.openSession();

                    //this is just for tests to check for errors while connecting with db
                    // TODO: 01.11.2021 gotta change it to properly working quiz
                    List<Category> result = (List<Category>) actualSession.createQuery("from Category").list();
                    Optional <Category> cat = result.stream().filter(c -> c.getQuizQAFromCategory().getQuizQAId() == 5).findFirst();
                    QuizQA quizQA = cat.get().getQuizQAFromCategory();
                    System.out.println(quizQA.getCorrectAnswer());

                }

                case 2 -> System.out.println("Stuff happening with quiz for Sport category");
            }

            boolean stillCheckingIfUserWantToLeave = true;
            String playAgainOption = null;

            // loop to check user's answer (y/n), if he wants to end or not, handle exception for IllegalArgument
            while (stillCheckingIfUserWantToLeave) {
                System.out.println("Wanna play again? y/n");

                try {
                    playAgainOption = scanner.next();
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


