import jdk.jfr.Name;

import javax.persistence.*;

@Entity
@Table (name = "category")
public class Category {

    @Id
    @Column (name = "category_id")
    private int categoryId;

    @OneToOne
    @JoinColumn(name = "category_id")
    @MapsId
    private QuizQA quizQAFromCategory;


}
