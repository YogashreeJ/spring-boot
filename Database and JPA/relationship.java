/*@OneToMany / @ManyToOne

OneToMany → One entity owns many of another

ManyToOne → Many entities belong to one entity */
public class relationships {

@Entity
public class Student {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "student")
    private List<Course> courses;
}

@Entity
public class Course {
    @Id
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
}

//mappedBy → tells JPA which side owns the relationship