package com.in28minutes.soap.webservices.soapcoursemanagement.soap.service;

import com.in28minutes.soap.webservices.soapcoursemanagement.soap.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {

    private static List<Course> courses = new ArrayList<Course>();

    static {
        Course course1 = new Course(1, "Spring", "10 Steps");
        Course course2 = new Course(2, "Spring MVC", "10 Examples");
        Course course3 = new Course(3, "Spring Boot", "6K students");
        Course course4 = new Course(4, "Maven", "Most popular maven course on the web");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

    }

    public Course findById(int id){
        for (Course course: courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;

    }

    public List<Course> findAll() {
        return courses;
    }

    public int deleteById(int id){
        Iterator<Course> iterator= courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId() == id) {
                iterator.remove();
                return 1;
            }
        }
        return 0;

    }
}
