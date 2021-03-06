package by.pisetskiy.iquiz.model.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Formula;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@SuperBuilder
public class Quiz extends BaseEntity {

    private String title;
    @Column(columnDefinition = "SMALLINT")
    private Integer timeLimit;
    @Formula("(select count(qs.id) from question qs where qs.quiz_id = id)")
    private int questionsCount;

    @ManyToMany(mappedBy = "quizzes")
    @ToString.Exclude
    @Builder.Default
    private Set<JobPosition> positions = new HashSet<>();
}
