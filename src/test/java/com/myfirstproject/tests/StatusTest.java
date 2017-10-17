package com.myfirstproject.tests;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.myfirstproject.App;
import com.myfirstproject.model.StatusUpdate;
import com.myfirstproject.model.StatusUpdateDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class StatusTest {

	@Autowired
	private StatusUpdateDao statusUpdateDao;
	@Test
	public void testSave() {
		StatusUpdate status = new StatusUpdate("This is a test status update!");
		statusUpdateDao.save(status);
		Assert.assertNotNull("not null id", status.getId());
		Assert.assertNotNull("not null date", status.getAdded());
		
		StatusUpdate retrieved = statusUpdateDao.findOne(status.getId());
		Assert.assertEquals("Matching status updates", status, retrieved);
		
	}
}
