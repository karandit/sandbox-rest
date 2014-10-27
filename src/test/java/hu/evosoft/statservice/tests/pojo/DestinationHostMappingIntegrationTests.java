package hu.evosoft.statservice.tests.pojo;

import static hu.evosoft.statservice.tests.MongoAssertions.usingMongo;
import static hu.evosoft.statservice.tests.PersistenceFixture.COLL_DESTINATIONHOST;
import static hu.evosoft.statservice.tests.PersistenceFixture.createDestHost;
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
public class DestinationHostMappingIntegrationTests {
	
    @Autowired
    MongoOperations mongo;
	
	@Before
	public void setup() throws Exception {
		mongo.dropCollection(COLL_DESTINATIONHOST);
	}

	@After
	public void teardown() {
		mongo.dropCollection(COLL_DESTINATIONHOST);
	}

	@Test
	public void that_DestinationHost_Is_Inserted_Into_Collection() throws Exception {
		mongo.insert(createDestHost());

		assertEquals(1, mongo.getCollection(COLL_DESTINATIONHOST).count());
	}

	@Test
	public void that_DestinationHost_Mapping_Works() throws Exception {
		mongo.insert(createDestHost());
		
		DocumentAssertions found = usingMongo(mongo).collection(COLL_DESTINATIONHOST).first();
        assertTrue(found.hasField("name"));
        assertEquals("index.hu", found.fieldContent("name"));
        assertTrue(found.hasField("value"));
        assertEquals(1456, found.fieldContent("value"));
	}
}
