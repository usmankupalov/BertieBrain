import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Equals {
    private final Long uuid;

    private final String name;

    private final List<Session> sessions;

    public Equals(final Long uuid, final String name, final List<Session> sessions) {
        this.uuid = uuid;
        this.name = name;
        this.sessions = sessions;
    }

    private Long getUuid() {
        return uuid;
    }

    public final String getName() {
        return name;
    }

    public final List<Session> getSessions() {
        return sessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equals)) return false;
        Equals equals = (Equals) o;
        return uuid.equals(equals.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    public class Session {

        private final Date startDate;

        Session(final Date startDate) {
            this.startDate = startDate;
        }

        final Date getStartDate() {
            return this.startDate;
        }

        final Equals getEquals() {
            return Equals.this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Session)) return false;
            Session session = (Session) o;
            if (startDate != session.startDate && getEquals() != session.getEquals()) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate);
        }
    }
}
