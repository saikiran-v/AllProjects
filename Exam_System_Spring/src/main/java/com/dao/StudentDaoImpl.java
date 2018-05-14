package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.Student;

/**
 * @author saikiran.v
 *
 */
public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbc;
	private RowMapper<Student> rm1 = new RowMapper<Student>() {

		public Student mapRow(ResultSet rs, int val) throws SQLException {
			Student prod = new Student();
			if (rs.next()) {

				prod.setStudId(rs.getInt(1));
				prod.setName(rs.getString(2));
				prod.setAdmissionId(rs.getInt(3) + "");
			}
			return prod;
		}
	};
	private ResultSetExtractor<Student> rm = new ResultSetExtractor<Student>() {

		@Override
		public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
			Student prod = new Student();
			if (rs.next()) {

				prod.setStudId(rs.getInt(1));
				prod.setName(rs.getString(2));
				prod.setAdmissionId(rs.getInt(3) + "");
			}
			return prod;
		}
	};

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.StudentDao#getStudent(int)
	 */
	@Override
	public Student getStudent(int sid) {

		return jdbc.query("select * from studentdetails where studentId=?", rm, sid);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.StudentDao#insertStudent()
	 */
	@Override
	public void insertStudent(Student student) {

		jdbc.update("insert into studentdetails values(?,?,?)", student.getStudId(), student.getName(),
				student.getAdmissionId());
	}

	/* (non-Javadoc)
	 * @see com.dao.StudentDao#insertSubject()
	 */
	@Override
	public void insertSubject(Student student) {
		
		
		
	}

}
