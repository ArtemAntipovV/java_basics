import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
 @Getter
 @Setter
 @AllArgsConstructor
 @NoArgsConstructor
@Entity
@Table(name = "Courses")
public class Course {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Integer id;

     private String name;

     private int duration;

     @Enumerated(EnumType.STRING)
     @Column(columnDefinition = "enum")
     private CourseType type;

     private String description;

     @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private Teacher teacher;

     @Column(name = "students_count", nullable = true)
     private Integer studentsCount;

     private int price;
     @Column(name = "price_per_hour")

     private float pricePerHour;

     @ManyToMany(cascade = CascadeType.ALL)
     @JoinTable(name = "Subscriptions",
             joinColumns = {@JoinColumn(name = "course_id")},
             inverseJoinColumns = {@JoinColumn(name = "student_id")}
     )
     private List<Student> students;

 }



