package spring.core.boot.service;

import java.util.List;

import spring.core.boot.model.Subject;


public interface ISubjectService {

	public Long saveSubject(Subject subject);
	public boolean deleteSubject(long subjectid);
	public Subject getSubject(long subjectid);
	public List<Subject> getAllsubjects();
	public List<Subject> getSubjectwithduration(int duration);

}
