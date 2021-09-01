package com.connectall.adapter.zabbix.bean;

public class CAEvent {
	
	private ZabbixEvent fields;
	private String appLinkName;
	public ZabbixEvent getFields() {
		return fields;
	}
	public void setFields(ZabbixEvent fields) {
		this.fields = fields;
	}
	public String getAppLinkName() {
		return appLinkName;
	}
	public void setAppLinkName(String appLinkName) {
		this.appLinkName = appLinkName;
	}
	@Override
	public String toString() {
		return "CAEvent [fields=" + fields + ", appLinkName=" + appLinkName + "]";
	}

}
