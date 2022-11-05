package com.roha.modernJava.forum.domain;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLModel;
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
public class ForumMessage {
	private User user;
	private String content;
	private ForumSubject forumSubject;
	private List<ForumMessage> replies =new ArrayList<>();
	private DateTime when = new DateTime();

	public ForumMessage(ForumSubject forumSubject,String content, User user) {
		this.forumSubject = forumSubject;
		this.user = user;
		this.content = content;
	}

	public String getSubject() {
		return this.forumSubject.getSubject();
	}

	public ForumMessage reply(String content, User user) {
		 ForumMessage reply = new ForumMessage(forumSubject, content,user);
		 this.replies.add(reply);
		 return reply;
	}
}
