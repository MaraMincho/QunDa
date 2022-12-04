package model;

import java.sql.*;
import java.util.Scanner;

public class ProfessorDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private final String USER_GET = "select * from PROFESSOR where email = ?";

    private final String PROFESSOR_INSERT = "insert into PROFESSOR values(?, ?, ?, ?)";
    //private final String PROFESSOR_UPDATE = "update member set phone_number = ? where member_id = ?";
    //private String MEMBER_DELETE = "delete member where member_id = ?";

    Scanner scan = new Scanner(System.in);

    public void InsertPROFESSOR(String email, String pw, String name, String postion) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(PROFESSOR_INSERT);
            stmt.setString(1, email);
            stmt.setString(2, pw);
            stmt.setString(3, name);
            stmt.setString(4, postion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(stmt,conn);
        }
    }

    public Professor getProfssor(Professor pf) {
        Professor user = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, pf.getId());
            rs = stmt.executeQuery();

            if(rs.next()) {
                user = new Professor();
                user.setId(rs.getString("Email"));
                user.setName(rs.getString("name"));
                user.setPosition(rs.getString("position"));
                user.setPw(rs.getString("pw"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return user;
    }


}
