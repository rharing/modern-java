package com.roha.modernJava.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/29/22.
 */
@Data
public class ForumSubject {
	private String subject;
	List<ForumMessage> messages = new ArrayList<>();

	Forum forum;
	private DateTime lastUpdated;

	private DateTime created = new DateTime();

	public ForumSubject(String subject) {
		this.subject = subject;
	}

	public ForumMessage addMessage(String content, User user) {
		ForumMessage forumMessage = new ForumMessage(content, user);
		this.lastUpdated = new DateTime();
		this.messages.add(forumMessage);
		return forumMessage;
	}

	public void setCreated(DateTime created) {
		// do nothing as created is only set once
	}
}
