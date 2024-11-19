package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTest {

	// DI, 제어의 역전
	@Autowired
	private Restaurant restaurant = new Restaurant();
	
	@Test
	public void testExist() {
		System.out.println("restaurant : " + restaurant);
		log.info("restaurant : " + restaurant);
		log.info(restaurant.getChef());
	}

}
