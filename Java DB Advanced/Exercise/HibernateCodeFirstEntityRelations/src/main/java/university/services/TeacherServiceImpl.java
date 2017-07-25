package university.services;

import university.entities.Teacher;
import university.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Teacher findById(long id) {
        return this.teacherRepository.findOne(id);
    }

    @Override
    public Teacher create(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> multipleCreate(Iterable<Teacher> teachers) {
        return this.teacherRepository.save(teachers);
    }

    @Override
    public void deleteById(long id) {
        this.teacherRepository.delete(id);
    }

}
