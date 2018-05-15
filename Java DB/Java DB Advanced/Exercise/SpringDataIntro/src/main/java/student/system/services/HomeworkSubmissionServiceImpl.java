package student.system.services;

import student.system.entities.HomeworkSubmission;
import student.system.repositories.HomeworkSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HomeworkSubmissionServiceImpl implements HomeworkSubmissionService {

    private final HomeworkSubmissionRepository homeworkSubmissionRepository;

    @Autowired
    public HomeworkSubmissionServiceImpl(HomeworkSubmissionRepository homeworkSubmissionRepository) {
        this.homeworkSubmissionRepository = homeworkSubmissionRepository;
    }

    @Override
    public List<HomeworkSubmission> findAll() {
        return this.homeworkSubmissionRepository.findAll();
    }

    @Override
    public HomeworkSubmission findById(long id) {
        return this.homeworkSubmissionRepository.findOne(id);
    }

    @Override
    public HomeworkSubmission createOne(HomeworkSubmission homeworkSubmission) {
        return this.homeworkSubmissionRepository.save(homeworkSubmission);
    }

    @Override
    public List<HomeworkSubmission> createMany(Iterable<HomeworkSubmission> homeworkSubmissions) {
        return this.homeworkSubmissionRepository.save(homeworkSubmissions);
    }

    @Override
    public HomeworkSubmission updateOne(HomeworkSubmission homeworkSubmission) {
        return this.homeworkSubmissionRepository.save(homeworkSubmission);
    }

    @Override
    public List<HomeworkSubmission> updateMany(Iterable<HomeworkSubmission> homeworkSubmissions) {
        return this.homeworkSubmissionRepository.save(homeworkSubmissions);
    }

    @Override
    public void deleteById(long id) {
        this.homeworkSubmissionRepository.delete(id);
    }

}
