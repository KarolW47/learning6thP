import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QAHandler {

    private final DBTransactions dbTransactions = new DBTransactions();


    public int handleQuestionsAndAnswers(AvailableCategories availableCategories) {

        List<QuizQA> quizQAList = dbTransactions.get5RandomQuestionsFromDB(availableCategories);
        int scorePointsCounter = 0;

        for(int i = 1; i<6; i++) {
            System.out.println(i + ". " + quizQAList.get(i - 1).getQuestion());

            List<String> availableAnswersRandomized = new ArrayList<>();
            availableAnswersRandomized.add(quizQAList.get(i - 1).getCorrectAnswer());
            availableAnswersRandomized.add(quizQAList.get(i - 1).getIncorrectAnswer1());
            availableAnswersRandomized.add(quizQAList.get(i - 1).getIncorrectAnswer2());
            availableAnswersRandomized.add(quizQAList.get(i - 1).getIncorrectAnswer3());
            Collections.shuffle(availableAnswersRandomized);

            System.out.println("a) " + availableAnswersRandomized.get(0));
            System.out.println("b) " + availableAnswersRandomized.get(1));
            System.out.println("c) " + availableAnswersRandomized.get(2));
            System.out.println("d) " + availableAnswersRandomized.get(3));
            System.out.println("Pick answer by typing a, b, c or d.");

            boolean isTypedLetterNotAcceptable = true;

            String correctAnswerToActualQuestionHolder =
                    dbTransactions.qetCorrectAnswerFromDB(availableCategories, quizQAList.get(i-1).getQuizQAId());

            while (isTypedLetterNotAcceptable) {
                ResponseScanner responseScanner = new ResponseScanner();
                String answerHolder = responseScanner.scanResponse();
                if (answerHolder.equals("a") || answerHolder.equals("b") || answerHolder.equals("c") || answerHolder.equals("d")) {
                    isTypedLetterNotAcceptable = false;
                    if (answerHolder.equals("a") && availableAnswersRandomized.get(0).equals(correctAnswerToActualQuestionHolder)) {
                        scorePointsCounter+=1;
                    } else if (answerHolder.equals("b") && availableAnswersRandomized.get(1).equals(correctAnswerToActualQuestionHolder)) {
                        scorePointsCounter+=1;
                    } else if (answerHolder.equals("c") && availableAnswersRandomized.get(2).equals(correctAnswerToActualQuestionHolder)) {
                        scorePointsCounter+=1;
                    } else if (answerHolder.equals("d") && availableAnswersRandomized.get(3).equals(correctAnswerToActualQuestionHolder)) {
                        scorePointsCounter+=1;
                    }
                } else {
                    System.out.println("Wrong answer, try again:");
                }
            }
        }
        return scorePointsCounter;
    }
}
