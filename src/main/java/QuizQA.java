import javax.persistence.*;

@Entity
@Table (name = "quiz_qa")
public class QuizQA {

    @Id
    @Column (name = "quiz_qa_id")
    private int quizQAId;

    @Column (name = "question")
    private String question;

    @Column (name = "correct_answer")
    private String correctAnswer;

    @Column (name = "incorrect_answer1")
    private String incorrectAnswer1;

    @Column (name = "incorrect_answer2")
    private String incorrectAnswer2;

    @Column (name = "incorrect_answer3")
    private String incorrectAnswer3;

    @Column (name = "category_id")
    private int categoryIdQA;

    public QuizQA() {
    }

    public QuizQA(int quizQAId, String question, String correctAnswer, String incorrectAnswer1, String incorrectAnswer2, String incorrectAnswer3, int categoryIdQA) {
        this.quizQAId = quizQAId;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer1 = incorrectAnswer1;
        this.incorrectAnswer2 = incorrectAnswer2;
        this.incorrectAnswer3 = incorrectAnswer3;
        this.categoryIdQA = categoryIdQA;
    }


    public int getQuizQAId() {
        return quizQAId;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getIncorrectAnswer1() {
        return incorrectAnswer1;
    }

    public String getIncorrectAnswer2() {
        return incorrectAnswer2;
    }

    public String getIncorrectAnswer3() {
        return incorrectAnswer3;
    }
}
