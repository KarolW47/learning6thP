import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Film {

    @Id
    private int id;

    String question;

    String correctAnswer;

    String incorrectAnswer1;

    String incorrectAnswer2;

    String incorrectAnswer3;

}
