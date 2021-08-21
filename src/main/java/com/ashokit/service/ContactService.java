package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.ContactInfo;

public interface ContactService {

	public boolean saveContact(ContactInfo contactInfo);

	public List<ContactInfo> getAllContacts();

	public ContactInfo editByContactId(Integer cId);

	public boolean deleteByContactId(Integer cId);
}
