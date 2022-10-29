package com.roha.modernJava.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/29/22.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ForumSubject {
	List<ForumMessage> messages = new ArrayList<>();

	Forum forum;
	private String subject;
}
