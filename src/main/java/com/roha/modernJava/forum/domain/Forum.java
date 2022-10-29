package com.roha.modernJava.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created on 10/28/22.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Forum {
	private List<ForumSubject> subjects;
	private String name;

	public ForumMessage addMessage(String subject, String content, User bob) {
		return null;
	}
}
