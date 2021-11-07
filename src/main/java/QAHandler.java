import java.util.List;

public class QAHandler {

    DBTransactions dbTransactions = new DBTransactions();
    private String answerHolder;

    // TODO: 07.11.2021 extend method, refactor if needed
    private void handle1StQuestion (AvailableCategories availableCategories) {
        List<QuizQA> quizQAList = dbTransactions.get5RandomQuestions(availableCategories);

        System.out.println("1. " + quizQAList.get(0).getQuestion());

        // show a b c d
        System.out.println("");

        answerHolder = ResponseScanner.responseScanner();

        //+1 if correct, -1 if not correct;
//        if ()

    }
}
