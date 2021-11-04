import javax.persistence.*;

@Entity (name = "category")
@Table (name = "category")
public class Category {

    @Id
    @Column (name = "category_id")
    private int categoryId;

    @Column (name = "category_name")
    private String categoryName;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryIdQA")
    private QuizQA quizQAFromCategory;

    public Category() {
    }

    public Category(int categoryId, String categoryName, QuizQA quizQAFromCategory) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.quizQAFromCategory = quizQAFromCategory;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public QuizQA getQuizQAFromCategory() {
        return quizQAFromCategory;
    }
}
