package com.roha.modernJava.forum.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 10/28/22.
 */
class ForumTest {

	@Test
	public void should_add_message_and subject(){
		// given a forum dedicated to java content
		Forum forum = new Forum("Java still rockzz")
		// when we add a message with subject 'awesome java projects' by the user called 'bob' and the content of ' check it out here:https://github.com/akullpp/awesome-java

		ForumMessage forumMessage = forum.addMessage("awesome java projects","check it out here:https://github.com/akullpp/awesome-java", " bob");
		assertNotNull(forumMessage);

		assertEquals("awesome java projects", forumMessage.getSubject());
		assertEquals(1, forum.getSubjects().size());
	}

}
