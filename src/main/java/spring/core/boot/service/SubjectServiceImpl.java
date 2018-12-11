package spring.core.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.core.boot.dao.ISubjectRepo;
import spring.core.boot.model.Subject;

@Service
public class SubjectServiceImpl implements ISubjectService {
	
	@Autowired
	private ISubjectRepo subjectRepo;

	@Override
	public Long saveSubject(Subject subject) {
		Subject savedSubject=subjectRepo.save(subject);
		return savedSubject==null?-1:savedSubject.getSubjectid();
		}

	@Override
	public boolean deleteSubject(long subjectid) {
		boolean isDeleted=false;
		if(subjectRepo.existsById(subjectid))
		{
			subjectRepo.deleteById(subjectid);
			isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public Subject getSubject(long subjectid) {
		Optional<Subject> subjectData=subjectRepo.findById(subjectid);
		return subjectData.isPresent()?subjectData.get():null;
		
	}

	@Override
	public List<Subject> getAllsubjects() {
		return subjectRepo.findAll();
		
	}

	@Override
	public List<Subject> getSubjectwithduration(int duration) {
		return subjectRepo.findAllByDuration(duration);
	}

	

}
