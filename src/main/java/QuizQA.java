import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int categoryId;

}
