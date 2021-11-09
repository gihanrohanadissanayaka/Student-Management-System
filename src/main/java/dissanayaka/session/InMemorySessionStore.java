package dissanayaka.session;

import java.util.ArrayList;
import java.util.List;

public class InMemorySessionStore implements SessionStore {

    private static List<Session> sessionList = new ArrayList<>();
    @Override
    public boolean saveSession(Session session) {
        for( Session session1: sessionList){
            if( session1.getSessionId() == session.getSessionId() ){
                return false;
            }
        }
        sessionList.add(session);
        return true;
    }

    @Override
    public boolean deleteSession(int sessionId) {
        for( Session session: sessionList ){
            if( session.getSessionId() == sessionId ){
                sessionList.remove(session);
                return true;
            }
        }
        return false;
    }

    @Override
    public Session getSession(int sessionId) {
        for( Session session: sessionList ){
            if( session.getSessionId() == sessionId ){
                return session;
            }
        }
        return null;       }

    @Override
    public List<Session> getAllSession() {
        return sessionList;
    }
}
