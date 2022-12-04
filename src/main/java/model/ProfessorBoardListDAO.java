package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorBoardListDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private final String PROFESSORBOARDLIST_INSERT_STRING = "insert into PROFESSORBOARDLIST values(?, ?, ?, ?)";
    private final String PROFESSORBOARDLIST_Search_BoardList = "select * from PROFESSORBOARDLIST WHERE PROFESSOREMAIL = ?";


    public List<ProfessorBoardList> InfoBoardlist(String InfoEmail) {
        List<ProfessorBoardList> boardLists = new ArrayList<ProfessorBoardList>();


        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(PROFESSORBOARDLIST_Search_BoardList);
            stmt.setString(1, InfoEmail);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProfessorBoardList pbo = new ProfessorBoardList();
                pbo.setPROFESSOREMAIL(rs.getString("PROFESSOREMAIL"));
                pbo.setSubjectName(rs.getString("TIME"));
                pbo.setRoomNum(rs.getString("SUBJECTNAME"));
                pbo.setTime(rs.getString("ROOMNUM"));
                boardLists.add(pbo);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return boardLists;

    }
    public void InsertPROFESSOR_board_list(String Professor, String Time, String RoomNum, String Subject) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(PROFESSORBOARDLIST_INSERT_STRING);
            stmt.setString(1, Professor);
            stmt.setString(2, Time);
            stmt.setString(3, RoomNum);
            stmt.setString(4, Subject);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
}
