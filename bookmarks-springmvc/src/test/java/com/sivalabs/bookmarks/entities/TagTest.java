package com.sivalabs.bookmarks.entities;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TagTest
{

	@Test
	public final void testHashCode()
	{
		Tag tag1 = new Tag();
		tag1.setTagName("java");
		
		Tag tag2 = new Tag();
		tag2.setTagName("java");
		assertEquals(tag1.hashCode(),tag2.hashCode());
		System.err.println(tag1.hashCode()+":"+tag2.hashCode());
	}

	@Test
	public final void testEqualsObject()
	{
		Tag tag1 = new Tag();
		tag1.setTagName("java");
		
		Tag tag2 = new Tag();
		tag2.setTagName("java");
		System.err.println(tag1.equals(tag2));
		
		Set<Tag> tagSet = new HashSet<Tag>();
		tagSet.add(new Tag(1, "one"));
		tagSet.add(new Tag(2, "two"));
		tagSet.add(new Tag(3, "three"));
		tagSet.add(new Tag(4, "four"));
		tagSet.add(new Tag(5, "five"));
		
		System.err.println(tagSet.size());
		
		tagSet.remove(new Tag(11, "four"));
		System.err.println(tagSet.size());
	}

}
