package com.roha.modernJava.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

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

	public ForumMessage addMessage(String subject, String content, User user) {
		Optional<ForumSubject> subjectOptional = subjects.stream().findFirst(forumSubject -> forumSubject.getSubject().equals(subject));
		if(subjectOptional.isPresent()){
			subjectOptional.get().addMessage(content, user);
		}
		else{
			ForumSubject forumSubject = ForumSubject.builder().subject(subject);
			this.subjects.add(forumSubject);
			forumSubject.addMessage(content, user);
		}
	}
}
