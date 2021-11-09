package dissanayaka.session;

import dissanayaka.character.student.Student;
import dissanayaka.classes.ClassRoom;

import java.util.List;

public class Session {

    private int sessionId;
    private String sessionDate;
    private String sessionStartTime;
    private String sessionEndTime;
    private ClassRoom sessionClassRoom;
    private List<Student> sessionStudent;

    public Session(int sessionId, String sessionDate, String sessionStartTime, String sessionEndTime, ClassRoom sessionClassRoom, List<Student> sessionStudent) {
        this.sessionId = sessionId;
        this.sessionDate = sessionDate;
        this.sessionStartTime = sessionStartTime;
        this.sessionEndTime = sessionEndTime;
        this.sessionClassRoom = sessionClassRoom;
        this.sessionStudent = sessionStudent;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getSessionStartTime() {
        return sessionStartTime;
    }

    public void setSessionStartTime(String sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    public String getSessionEndTime() {
        return sessionEndTime;
    }

    public void setSessionEndTime(String sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    public ClassRoom getSessionClassRoom() {
        return sessionClassRoom;
    }

    public void setSessionClassRoom(ClassRoom sessionClassRoom) {
        this.sessionClassRoom = sessionClassRoom;
    }

    public List<Student> getSessionStudent() {
        return sessionStudent;
    }

    public void setSessionStudent(List<Student> sessionStudent) {
        this.sessionStudent = sessionStudent;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", sessionDate='" + sessionDate + '\'' +
                ", sessionStartTime='" + sessionStartTime + '\'' +
                ", sessionEndTime='" + sessionEndTime + '\'' +
                ", sessionClassRoom=" + sessionClassRoom +
                ", sessionStudent=" + sessionStudent +
                '}';
    }
}
