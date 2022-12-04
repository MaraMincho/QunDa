package model;

import org.h2.command.dml.Insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private final String GetRoom = "SELECT * FROM ROOM WHERE head = ?";
    private final String InsertRoom = "insert into Room(head, body) values(?, ?);";
    public void InesrtRoom(String haed, String body) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(InsertRoom);
            stmt.setString(1, haed);
            stmt.setString(2, body);
            stmt.executeUpdate();
        }catch (SQLException e) {e.printStackTrace();}
        finally {
            JDBCUtil.close(stmt, conn);
        }
    }
    public List<Room> InfoRoomList(String Roomnum) {
        List<Room> rommlist = new ArrayList<Room>();
        Room newroom = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(GetRoom);
            stmt.setString(1, Roomnum);
            rs = stmt.executeQuery();

            while (rs.next()) {
                newroom = new Room();
                newroom.setIndex(rs.getString("INDEX"));
                newroom.setHead(rs.getString("HEAD"));
                newroom.setBody(rs.getString("BODY"));
                rommlist.add(newroom);
            }
        }catch (SQLException e) {e.printStackTrace();}
        finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return rommlist;
    }
}
