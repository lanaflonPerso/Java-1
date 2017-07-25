package student.system.services;

import student.system.entities.HomeworkSubmission;

import java.util.List;

public interface HomeworkSubmissionService {

    List<HomeworkSubmission> findAll();

    HomeworkSubmission findById(long id);

    HomeworkSubmission createOne(HomeworkSubmission homeworksubmission);

    List<HomeworkSubmission> createMany(Iterable<HomeworkSubmission> homeworksubmissions);

    HomeworkSubmission updateOne(HomeworkSubmission homeworksubmission);

    List<HomeworkSubmission> updateMany(Iterable<HomeworkSubmission> homeworksubmissions);

    void deleteById(long id);
}
