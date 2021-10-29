import jdk.jfr.Name;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    private int categoryId;

    @OneToOne
    @JoinColumn(name = "category_id")
    @MapsId
    private QuizQA quizQAFromCategory;


}
