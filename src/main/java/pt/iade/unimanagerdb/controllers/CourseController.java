package pt.iade.unimanagerdb.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanagerdb.models.Course;
import pt.iade.unimanagerdb.models.exceptions.NotFoundException;
import pt.iade.unimanagerdb.models.repositories.CourseRepository;



@RestController
@RequestMapping(path = "/api/courses")
public class CourseController {
    private Logger logger = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Course> getCourses() {
        logger.info("Sending all courses");
        return courseRepository.findAll();
    }    
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourseById(@PathVariable int id) {
        logger.info("Sending all courses");
        Optional<Course> _course = courseRepository.findById(id);
        if (_course.isPresent()) return _course.get();
        else throw new NotFoundException(""+id, "Course", "id");
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course saveCourse(@RequestBody Course course) {
        logger.info("Saving course with name: "+course.getName());
        // Verificações aqui e se falhar posso enviar uma exceção
        Course newCourse = courseRepository.save(course);
        return newCourse;
    }
    
}
