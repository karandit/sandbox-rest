package hu.evosoft.statservice.tests;

import hu.evosoft.statservice.pojo.DestinationHost;
import hu.evosoft.statservice.pojo.LogEntryDate;

public class PersistenceFixture {

    public static final String COLL_DESTINATIONHOST = "DestinationHost";
    public static final String COLL_LOGENTRYDATE = "LogEntryDate";

    public static DestinationHost createDestHost() {
        DestinationHost host = new DestinationHost();
        host.setName("index.hu");
        host.setValue(1456);
        return host;
    }

    public static LogEntryDate createLogEntryDate() {
        return new LogEntryDate("aaa", 123L, 4500);
    }

}
