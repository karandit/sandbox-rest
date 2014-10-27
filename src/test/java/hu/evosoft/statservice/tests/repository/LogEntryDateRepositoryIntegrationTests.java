package hu.evosoft.statservice.tests.repository;

import static hu.evosoft.statservice.tests.PersistenceFixture.COLL_LOGENTRYDATE;
import static hu.evosoft.statservice.tests.PersistenceFixture.createLogEntryDate;
import static junit.framework.TestCase.assertEquals;
import hu.evosoft.statservice.repository.LogEntryDateRepository;
import hu.evosoft.statservice.tests.MongoConfiguration;

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
public class LogEntryDateRepositoryIntegrationTests {

    @Autowired 
    private LogEntryDateRepository repo;

    @Autowired
    private MongoOperations mongo;

    @Before
    public void setup() throws Exception {
        mongo.dropCollection(COLL_LOGENTRYDATE);
    }

    @After
    public void teardown() {
        mongo.dropCollection(COLL_LOGENTRYDATE);
    }

    @Test
    public void thatReturnAllItemsFromRepoWorks() throws Exception {
        assertEquals(0, repo.findAll().size());
        mongo.insert(createLogEntryDate());
        assertEquals(1, repo.findAll().size());
    }
}
