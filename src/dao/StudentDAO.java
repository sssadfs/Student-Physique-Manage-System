package dao;

import db.DbConnect;
import domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IstudentDAO {
    protected static final String FIELDS_INSERT = "id,name,gender,age,weight,height";
    protected static final String INSERT_SQL = "insert into stu_info (" + FIELDS_INSERT + ") values (?,?,?,?,?,?)";
    protected static final String SELECT_SQL = "select " + FIELDS_INSERT + " from stu_info where id=?";
    protected static final String SELECT_BY_NAME_SQL = "select " + FIELDS_INSERT + " from stu_info where name=?";
    protected static final String UPDATE_SQL = "update stu_info set id=?,name=?,gender=?,age=?,weight=?,height=? where id=?";
    protected static final String DELETE_SQL = "delete from stu_info where id=?";

    @Override
    public Student create(Student stu) throws Exception {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        DbConnect dbConnect = new DbConnect();

        try {
            conn = dbConnect.getDbConnect();
            prepStmt = conn.prepareStatement(INSERT_SQL);
            setStudentParams(prepStmt, stu);
            prepStmt.executeUpdate();
            return stu;
        } finally {
            DbConnect.closeDB(conn, prepStmt, rs);
        }
    }

    public Student find(Student stu) throws Exception {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        DbConnect dbConnect = new DbConnect();

        try {
            conn = dbConnect.getDbConnect();
            prepStmt = conn.prepareStatement(SELECT_SQL);
            prepStmt.setString(1, stu.getId());
            rs = prepStmt.executeQuery();

            if (rs.next()) {
                return getStudent(rs);
            }
            return null;
        } finally {
            DbConnect.closeDB(conn, prepStmt, rs);
        }
    }

    @Override
    public List<Student> findAll() throws Exception {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<Student>();
        DbConnect dbConnect = new DbConnect();

        try {
            conn = dbConnect.getDbConnect();
            prepStmt = conn.prepareStatement("select " + FIELDS_INSERT + " from stu_info");
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                students.add(getStudent(rs));
            }
            return students;
        } finally {
            DbConnect.closeDB(conn, prepStmt, rs);
        }
    }

    @Override
    public Student findByName(String name) throws Exception {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        DbConnect dbConnect = new DbConnect();

        try {
            conn = dbConnect.getDbConnect();
            prepStmt = conn.prepareStatement(SELECT_BY_NAME_SQL);
            prepStmt.setString(1, name);
            rs = prepStmt.executeQuery();

            if (rs.next()) {
                return getStudent(rs);
            }
            return null;
        } finally {
            DbConnect.closeDB(conn, prepStmt, rs);
        }
    }

    @Override
    public void remove(Student stu) throws Exception {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        DbConnect dbConnect = new DbConnect();

        try {
            conn = dbConnect.getDbConnect();
            prepStmt = conn.prepareStatement(DELETE_SQL);
            prepStmt.setString(1, stu.getId());
            prepStmt.executeUpdate();
        } finally {
            DbConnect.closeDB(conn, prepStmt, rs);
        }
    }

    @Override
    public void update(Student stu) throws Exception {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        DbConnect dbConnect = new DbConnect();

        try {
            conn = dbConnect.getDbConnect();
            prepStmt = conn.prepareStatement(UPDATE_SQL);
            setStudentParams(prepStmt, stu);
            prepStmt.setString(7, stu.getId());
            int rowCount = prepStmt.executeUpdate();

            if (rowCount == 0) {
                throw new Exception("Update Error: Student Id:" + stu.getId());
            }
        } finally {
            DbConnect.closeDB(conn, prepStmt, rs);
        }
    }

    private void setStudentParams(PreparedStatement prepStmt, Student stu) throws Exception {
        prepStmt.setString(1, stu.getId());
        prepStmt.setString(2, stu.getName());
        prepStmt.setString(3, stu.getGender());
        prepStmt.setInt(4, stu.getAge());
        prepStmt.setDouble(5, stu.getWeight());
        prepStmt.setDouble(6, stu.getHeight());
    }

    private Student getStudent(ResultSet rs) throws Exception {
        Student stu = new Student();
        stu.setId(rs.getString(1));
        stu.setName(rs.getString(2));
        stu.setGender(rs.getString(3));
        stu.setAge(rs.getInt(4));
        stu.setWeight(rs.getDouble(5));
        stu.setHeight(rs.getDouble(6));
        return stu;
    }

}
