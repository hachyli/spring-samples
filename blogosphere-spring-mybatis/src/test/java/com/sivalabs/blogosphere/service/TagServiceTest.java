package com.sivalabs.blogosphere.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blogosphere.domain.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class TagServiceTest
{
	@Autowired private BlogService bs;
	
	@Test
	public void testDummy()
	{
		assertTrue(true);
	}
	
	//************** Tag Methods ************//
	@Test
	public void testGetAllTags() {
		List<Tag> tags = bs.getAllTags();
		assertNotNull(tags);
		for (Tag tag : tags) {
			System.err.println(tag);
		}
	}

}
