package pt.iade.unimanagerdb.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cour_id") 
    private int id;
    @Column(name="cour_name")
    private String name; 
    public Course() {}
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
