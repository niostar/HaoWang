package com.xdnice.customclass;

import java.io.Serializable;

public class ApplicationItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9168528875671251652L;
	
	private String iconURL;
	private String appName;
	private String appSize;
	private String downloadCount;
	private String score;
	private String title;
	private String downloadURL;
	private String detailURL;
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppSize() {
		return appSize;
	}
	public void setAppSize(String appSize) {
		this.appSize = appSize;
	}
	public String getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(String downloadCount) {
		this.downloadCount = downloadCount;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDownloadURL() {
		return downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public String getDetailURL() {
		return detailURL;
	}
	public void setDetailURL(String detailURL) {
		this.detailURL = detailURL;
	}
	@Override
	public String toString() {
		return "ApplicationItem [iconURL=" + iconURL + ", appName=" + appName
				+ ", appSize=" + appSize + ", downloadCount=" + downloadCount
				+ ", score=" + score + ", title=" + title + ", downloadURL="
				+ downloadURL + ", detailURL=" + detailURL + "]";
	}
	
	
}
