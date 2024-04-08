package pl.dmcs.iwalecture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.iwalecture.model.Student;
import pl.dmcs.iwalecture.repository.StudentRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentRESTController {
    private StudentRepository studentRepository;

    @Autowired
    public StudentRESTController(StudentRepository studentRepository) { this.studentRepository = studentRepository; }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAllStudents() { return studentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id) {
        Student student = studentRepository.findById(id);
        if(student == null)
        {
            System.out.println("Student not found!");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        studentRepository.deleteById(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id){
        student.setId(id);
        studentRepository.save(student);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Student> updatePartOfStudent(@RequestBody Map<String, Object> updates, @PathVariable("id") long id) {
        Student student = studentRepository.findById(id);
        if(student == null)
        {
            System.out.println("Student not found!");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        //student.setId(id);
        partialUpdate(student, updates);
        studentRepository.save(student);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudents() {
        studentRepository.deleteAll();
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id) {
        Student student = studentRepository.findById(id);
        if(student == null) {
            System.out.println("Student not found!");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> replaceAllStudents(@RequestBody List<Student> newStudents) {
        studentRepository.deleteAll();
        studentRepository.saveAll(newStudents);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private void partialUpdate(Student student, Map<String, Object> updates){
        if(updates.containsKey("firstname")){
            student.setFirstname((String) updates.get("firstname"));
        }
        if(updates.containsKey("lastname")){
            student.setLastname((String) updates.get("lastname"));
        }
        if(updates.containsKey("email")){
            student.setEmail((String) updates.get("email"));
        }
        if(updates.containsKey("telephone")){
            student.setTelephone((String) updates.get("telephone"));
        }
    }
}
