package com.roha.modernJava.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created on 10/28/22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forum {
	private List<ForumSubject> subjects = new ArrayList<>();
	private String name;

	public Forum(String name) {
		this.name = name;
	}

	public ForumMessage addMessage(String subject, String content, User user) {
		return locateSubject(subject).addMessage(content, user);
	}

	private ForumSubject locateSubject(String subject) {
		Optional<ForumSubject> subjectOptional = subjects.stream().filter(forumSubject -> forumSubject.getSubject().equals(subject)).findFirst();
		if (subjectOptional.isPresent()) {
			return subjectOptional.get();
		}
		else {
			ForumSubject forumSubject = new ForumSubject(subject);
			this.subjects.add(forumSubject);
			return forumSubject;
		}
	}

	public List<ForumSubject> getLastActiveSubjects() {
		Collections.sort(subjects, new Comparator<ForumSubject>() {
			@Override
			public int compare(ForumSubject o1, ForumSubject o2) {
				return o2.getLastUpdated().compareTo(o1.getLastUpdated());
			}
		});
		return subjects;
	}
}
