package com.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_INFO")
public class ContactInfo {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;

	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_NUMBER")
	private Long ContactNumber;

	@Column(name = "ACTIVE_SW")
	private Character ActiveSwitch;

	@Column(name = "CREATED_DATE")
	private LocalDate createdDate;

	@Column(name = "UPDATED_DATE")
	private LocalDate updatedDate;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		ContactNumber = contactNumber;
	}

	public Character getActiveSwitch() {
		return ActiveSwitch;
	}

	public void setActiveSwitch(Character activeSwitch) {
		ActiveSwitch = activeSwitch;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "ContactInfo [contactId=" + contactId + ", contactName=" + contactName + ", ContactNumber="
				+ ContactNumber + ", ActiveSwitch=" + ActiveSwitch + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

}