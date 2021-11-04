package pt.iade.unimanagerdb.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanagerdb.models.Course;

public interface CourseRepository extends CrudRepository<Course,Integer> {
    
}
