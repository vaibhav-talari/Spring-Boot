package spring.core.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.core.boot.model.Subject;

@Repository
public interface ISubjectRepo extends JpaRepository<Subject, Long> {
	public List<Subject> findAllByDuration(int duration);

}
