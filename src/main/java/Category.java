import javax.persistence.*;

@Entity
public class Category {

    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "category_id")
    @MapsId
    private Film film;


}
