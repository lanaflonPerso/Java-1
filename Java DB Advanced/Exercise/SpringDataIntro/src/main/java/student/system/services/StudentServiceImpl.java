package student.system.services;

import student.system.entities.Student;
import student.system.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(long id) {
        return this.studentRepository.findOne(id);
    }

    @Override
    public Student createOne(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> createMany(Iterable<Student> students) {
        return this.studentRepository.save(students);
    }

    @Override
    public Student updateOne(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> updateMany(Iterable<Student> students) {
        return this.studentRepository.save(students);
    }

    @Override
    public void deleteById(long id) {
        this.studentRepository.delete(id);
    }

    @Override
    public List<String> findStudentsInfo() {
        return this.studentRepository.findStudentsInfo();
    }

}
