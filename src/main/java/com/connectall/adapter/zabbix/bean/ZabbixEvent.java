package com.connectall.adapter.zabbix.bean;

public class ZabbixEvent {
	
	private String id;
	private String name;
	private String severity;
	private String tags;
	private String createDt;
	private String value;
	private String hostIp;
	private String hostName;
	private String triggerDescription;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getTriggerDescription() {
		return triggerDescription;
	}
	public void setTriggerDescription(String triggerDescription) {
		this.triggerDescription = triggerDescription;
	}
	@Override
	public String toString() {
		return "ZabbixEvent [id=" + id + ", name=" + name + ", severity=" + severity + ", tags=" + tags + ", createDt="
				+ createDt + ", value=" + value + ", hostIp=" + hostIp + ", hostName=" + hostName
				+ ", triggerDescription=" + triggerDescription + "]";
	}
	
	

}
