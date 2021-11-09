package dissanayaka.session;

import java.util.List;

public interface SessionStore {

    boolean saveSession(Session session);
    boolean deleteSession(int sessionId );
    Session getSession(int sessionId);
    List<Session> getAllSession();

}
