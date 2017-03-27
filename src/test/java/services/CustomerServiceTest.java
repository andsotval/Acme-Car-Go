package services;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/junit.xml"})
@Transactional
public class CustomerServiceTest extends AbstractTest{
	//The SUT------------------------------------------------------
	@Autowired
	CustomerService customerService;
	
	// Tests ------------------------------------------------------------------

		@Test
		public void driver() {
			final Object testingData[][] = {
				{
					"customer1", 438, null
				}, {
					null, 438, IllegalArgumentException.class
				}, {
					"reviewer1", 438, IllegalArgumentException.class
				}, {
					"customer1", 434, IllegalArgumentException.class
				}
			};

			for (int i = 0; i < testingData.length; i++)
				this.template((String) testingData[i][0], (int) testingData[i][1], (Class<?>) testingData[i][2]);
		}

		// Ancillary methods ------------------------------------------------------

		protected void template(final String username, final int announcementId, final Class<?> expected) {
			Class<?> caught;

			caught = null;
			try {
				super.authenticate(username);
				//this.customerService.registerPrincipal(announcementId);
				super.unauthenticate();
			} catch (final Throwable oops) {
				caught = oops.getClass();
			}

			super.checkExceptions(expected, caught);
		}

}
