package com.roha.modernJava.forum.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/29/22.
 */
public class ForumSubject {
	List<ForumMessage> messages = new ArrayList<>();

	Forum forum;
	private String subject;
}
