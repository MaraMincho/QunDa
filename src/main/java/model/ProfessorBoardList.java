package model;

public class ProfessorBoardList {
    String PROFESSOREMAIL;

    public String getPROFESSOREMAIL() {
        return PROFESSOREMAIL;
    }

    public void setPROFESSOREMAIL(String PROFESSOREMAIL) {
        this.PROFESSOREMAIL = PROFESSOREMAIL;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(String roomNum) {
        RoomNum = roomNum;
    }

    String SubjectName;
    String Time;
    String RoomNum;

    ProfessorBoardList() {
        this.RoomNum = getRoomNum();
        this.Time = getTime();
        this.SubjectName = getSubjectName();
        this.PROFESSOREMAIL = getPROFESSOREMAIL();
    }
}


