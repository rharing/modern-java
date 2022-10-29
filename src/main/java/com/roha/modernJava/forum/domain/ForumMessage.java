package com.roha.modernJava.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 10/29/22.
 */
@Data
public class ForumMessage {
	private User user;
	private String content;
	private 

	public ForumMessage(String content, User user) {
		this.user = user;
		this.content = content;
	}
}
