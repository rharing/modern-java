package com.roha.modernJava.forum.domain;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created on 10/28/22.
 */
class ForumTest {

	@Test
	public void should_add_message_and_subject() {
		// given a forum dedicated to java content
		Forum forum = new Forum("Java still rocks");
		// when we add a message with subject 'awesome java projects' by the user called 'bob' and the content of ' check it out here:https://github.com/akullpp/awesome-java

		User bob = User.builder().name("Bob").build();
		// note that a builder here is not very usefull yet, a builder becomes more usefull once you have way more parameters to create an object
		ForumMessage forumMessage = forum.addMessage("awesome java projects", "check it out here:https://github.com/akullpp/awesome-java", bob);
		assertNotNull(forumMessage);
		// then the forum should have a subject
		assertEquals(1, forum.getSubjects().size());

		// when adding a message to the same subject by whoever user
		forumMessage = forum.addMessage("awesome java projects", "nah that was just an example", bob);
		// then we still have only one subject
		assertEquals(1, forum.getSubjects().size());

		// when we change the subject
		forumMessage = forum.addMessage("awesome vue3 projects", "check it out here:https://next.awesome-vue.js.org/", bob);
		// then we should have 2 subjects
		assertEquals(2, forum.getSubjects().size());

		//when i want a list of subjects i want them ordered by the newest addition on top
//		List<ForumSubject> subjects = forum.getLastActiveSubjects();
//		assertEquals("awesome vue3 projects", subjects.get(0).getSubject());
//		assertEquals("awesome java projects", subjects.get(1).getSubject());
	}

	/**
	 * Method under test: {@link Forum#Forum(String)}
	 */
	@Test
	void testConstructor() {
		Forum actualForum = new Forum("Name");
		List<ForumSubject> lastActiveSubjects = actualForum.getLastActiveSubjects();
		assertTrue(lastActiveSubjects.isEmpty());
		assertSame(lastActiveSubjects, actualForum.getSubjects());
		assertEquals("Name", actualForum.getName());
	}

	/**
	 * Method under test: {@link Forum#addMessage(String, String, User)}
	 */
	@Test
	void testAddMessage() {
		Forum forum = new Forum("Name");
		User user = new User("Name");
		ForumMessage actualAddMessageResult = forum.addMessage("Hello from the Dreaming Spires",
				"Not all who wander are lost", user);
		assertEquals("Not all who wander are lost", actualAddMessageResult.getContent());
		assertSame(user, actualAddMessageResult.getUser());
		DateTime when = actualAddMessageResult.getWhen();
		assertEquals(1, when.getEra());
		assertEquals(0, when.year().getLeapAmount());
	}

	/**
	 * Method under test: {@link Forum#addMessage(String, String, User)}
	 */
	@Test
	void testAddMessage2() {
		Forum forum = new Forum("Name");
		User user = new User("Name");
		forum.addMessage("Hello from the Dreaming Spires", "Not all who wander are lost", user);
		ForumMessage actualAddMessageResult = forum.addMessage("Hello from the Dreaming Spires",
				"Not all who wander are lost", new User("Name"));
		assertEquals("Not all who wander are lost", actualAddMessageResult.getContent());
		assertEquals(user, actualAddMessageResult.getUser());
		DateTime when = actualAddMessageResult.getWhen();
		assertEquals(1, when.getEra());
		assertEquals(0, when.year().getLeapAmount());
	}

	/**
	 * Method under test: {@link Forum#addMessage(String, String, User)}
	 */
	@Test
	void testAddMessage3() {
		Forum forum = new Forum("Name");
		forum.addMessage("Subject", "Not all who wander are lost", new User("Hello from the Dreaming Spires"));
		User user = new User("Name");
		forum.addMessage("Hello from the Dreaming Spires", "Not all who wander are lost", user);
		ForumMessage actualAddMessageResult = forum.addMessage("Hello from the Dreaming Spires",
				"Not all who wander are lost", new User("Name"));
		assertEquals("Not all who wander are lost", actualAddMessageResult.getContent());
		assertEquals(user, actualAddMessageResult.getUser());
		DateTime when = actualAddMessageResult.getWhen();
		assertEquals(1, when.getEra());
		assertEquals(0, when.year().getLeapAmount());
	}

	/**
	 * Method under test: {@link Forum#getLastActiveSubjects()}
	 */
	@Test
	void testGetLastActiveSubjects() {
		assertTrue((new Forum("Name")).getLastActiveSubjects().isEmpty());
	}


/*
	@Test
	public void should_reply_on_a_message() {
		// this testcase focus on the builder pattern,read: "https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java"
		Forum forum = new Forum("java beyond basics");
		User bob = new User("bob");
		ForumMessage forumMessage = forum.addMessage("the builder pattern", "such a good pattern, read all about it here: https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java", bob);
		User joshua = new User("joshua");

		assertEquals("awesome java projects", forumMessage.getSubject());
		assertEquals(1, forum.getSubjects().size());
		ForumMessage bookadvertisement = forumMessage.reply("yes it is and you should definetely read joshua bloch Effective java", joshua);
		assertNotNull(bookadvertisement);
		assertEquals("the builder pattern", forumMessage.getSubject());
		assertEquals(1, forum.getSubjects().size());

		assertEquals(2, forumMessage.getSubject().getMessages().size());
	}
*/
}




