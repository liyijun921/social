package com.cnnp.social.homepage.manager.dto;



import java.util.List;


public class HomePageInfoAllDto {
	
	private String PortalName;//日程标题
	private String CARD_WIDTH;//责任人		
	private String CARD_TOP_COLOR;
	private long CARD_INDEX; 
	private List<HomePageFormInAllDto> SUBCARDS;
	
	public String getPortalName() {
		return PortalName;
	}

	public void setPortalName(String PortalName) {
		this.PortalName = PortalName;
	}

	public String getCARD_WIDTH() {
		return CARD_WIDTH;
	}

	public void setCARD_WIDTH(String CARD_WIDTH) {
		this.CARD_WIDTH = CARD_WIDTH;
	}

	public String getCARD_TOP_COLOR() {
		return CARD_TOP_COLOR;
	}

	public void setCARD_TOP_COLOR(String CARD_TOP_COLOR) {
		this.CARD_TOP_COLOR = CARD_TOP_COLOR;
	}

	public long getCARD_INDEX() {
		return CARD_INDEX;
	}

	public void setCARD_INDEX(long CARD_INDEX) {
		this.CARD_INDEX = CARD_INDEX;
	}
	
	public List<HomePageFormInAllDto> getSUBCARDS() {
		return SUBCARDS;
	}

	public void setSUBCARDS(List<HomePageFormInAllDto> SUBCARDS) {
		this.SUBCARDS = SUBCARDS;
	}
	
}
