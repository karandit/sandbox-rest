package hu.evosoft.statservice.tests.pojo;

import static hu.evosoft.statservice.tests.MongoAssertions.usingMongo;
import static hu.evosoft.statservice.tests.PersistenceFixture.COLL_LOGENTRYDATE;
import static hu.evosoft.statservice.tests.PersistenceFixture.createLogEntryDate;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import hu.evosoft.statservice.tests.MongoConfiguration;
import hu.evosoft.statservice.tests.MongoAssertions.CollectionAssertions.DocumentAssertions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MongoConfiguration.class })
public class LogEntryDateMappingIntegrationTests {
    
    @Autowired
    MongoOperations mongo;
    
    @Before
    public void setup() throws Exception {
        mongo.dropCollection(COLL_LOGENTRYDATE);
    }

    @After
    public void teardown() {
        mongo.dropCollection(COLL_LOGENTRYDATE);
    }

    @Test
    public void that_LogEntryDate_Is_Inserted_Into_Collection() throws Exception {
        mongo.insert(createLogEntryDate());

        assertEquals(1, mongo.getCollection(COLL_LOGENTRYDATE).count());
    }

    @Test
    public void that_LogEntryDate_Mapping_Works() throws Exception {
        mongo.insert(createLogEntryDate());
        
        DocumentAssertions found = usingMongo(mongo).collection(COLL_LOGENTRYDATE).first();
        assertTrue(found.hasField("timeStamp"));
        assertEquals(123L, found.fieldContent("timeStamp"));
        assertTrue(found.hasField("value"));
        assertEquals(4500, found.fieldContent("value"));
    }
}
