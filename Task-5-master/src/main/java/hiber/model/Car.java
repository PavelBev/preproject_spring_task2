package hiber.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Car {
    @Column(name="model")
    private String model;

    @Column(name="series")
    private int series;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "car")
    private User user;
}
