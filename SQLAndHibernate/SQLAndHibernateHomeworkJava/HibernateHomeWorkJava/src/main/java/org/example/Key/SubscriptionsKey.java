package org.example.Key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Course;
import org.example.Student;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter

public class SubscriptionsKey implements Serializable {
    @OneToOne
    private Student student;

    @OneToOne
    private Course course;

    public SubscriptionsKey(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}

