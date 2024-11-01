import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Purchaselist")
@Getter
@Setter
public class PurchasetLists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String coursesName;


    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
