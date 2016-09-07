package com.cnnp.social.meeting.manager;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "upload")
public class DutySetting {

	private String success;
	
	private String directory;
}
