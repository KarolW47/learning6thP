import javax.persistence.*;

@Entity (name = "category")
@Table (name = "category")
public class Category {

    @Id
    @Column (name = "category_id")
    private int categoryId;

    @Column (name = "category_name")
    private String categoryName;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryIdQA")
    private QuizQA quizQAFromCategory;


    public String getCategoryName() {
        return categoryName;
    }

    public QuizQA getQuizQAFromCategory() {
        return quizQAFromCategory;
    }
}
