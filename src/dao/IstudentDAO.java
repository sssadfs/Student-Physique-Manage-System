package dao;

import domain.Student;
import java.util.List;

public interface IstudentDAO {
    public abstract Student create(Student stu) throws Exception;
    public abstract void remove(Student stu) throws Exception;
    public abstract List<Student> findAll() throws Exception;
    public abstract Student findByName(String name) throws Exception;
    public abstract void update(Student stu) throws Exception;
}
