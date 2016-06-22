package com.cnnp.social.base;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "base")
public class BaseSetting {
	private String splitchar;

	public String getSplitchar() {
		return splitchar;
	}

	public void setSplitchar(String splitchar) {
		this.splitchar = splitchar;
	}
	
	
}
