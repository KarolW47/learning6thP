import java.util.List;
import java.util.stream.Collectors;

public class QAHandler {
// TODO: 02.11.2021 QA handler - showQ and Ax4 (abcd), get choice, chceck choice

    private void handle1StQuestion (List<QuizQA> quizQAList) {
        String firstQuestion = quizQAList.get(0).getQuestion();
        System.out.println("1. "+ firstQuestion);
    }
}
