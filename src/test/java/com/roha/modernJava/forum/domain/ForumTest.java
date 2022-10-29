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
		Forum forum = Forum.builder().build().name("Java still rocks").build();
		// when we add a message with subject 'awesome java projects' by the user called 'bob' and the content of ' check it out here:https://github.com/akullpp/awesome-java

		User bob = User.builder().name("Bob").build();
		ForumMessage forumMessage = forum.addMessage("awesome java projects","check it out here:https://github.com/akullpp/awesome-java", bob);
		assertNotNull(forumMessage);

		assertEquals("awesome java projects", forumMessage.getSubject());
		assertEquals(1, forum.getSubjects().size());
	}

	public void should_reply_on_a_message(){
		// this testcase focus on the builder pattern,read: "https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java"
		Forum forum = new Forum("java beyond basics");
		User bob = new User("bob")
		ForumMessage forumMessage = forum.addMessage("the builder pattern","such a good pattern, read all about it here: https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java", bob);
		User joshua = new User("joshua")

		assertEquals("awesome java projects", forumMessage.getSubject());
		assertEquals(1, forum.getSubjects().size());
		ForumMessage bookadvertisement = forumMessage.reply("yes it is and you should definetely read joshua bloch Effective java", joshua);
		assertNotNull(bookadvertisement);
		assertEquals("the builder pattern", forumMessage.getSubject());
		assertEquals(1, forum.getSubjects().size());

		assertEquals(2,forumMessage.getSubject().getMessages().size());



	}


}
