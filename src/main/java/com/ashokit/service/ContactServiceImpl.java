package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.ContactInfo;
import com.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	// save contact
	@Override
	public boolean saveContact(ContactInfo contactInfo) {
		ContactInfo saveInfo = contactRepository.save(contactInfo);
		if (saveInfo != null) {
			return true;
		} else {
			return false;
		}

	}

	// fetch all records
	@Override
	public List<ContactInfo> getAllContacts() {
		return contactRepository.findAll();

	}

	// updated a record based on id
	@Override
	public ContactInfo getByContactId(Integer cId) {
		Optional<ContactInfo> findById = contactRepository.findById(cId);
		return findById.isPresent() ? findById.get() : null;
		
		/*
		 * if(findById.isPresent()) { ContactInfo contactInfo = findById.get(); return
		 * contactInfo; } return null;
		 */
	}

	// deleted a record based on id
	@Override
	public boolean deleteByContactId(Integer cId) {
		boolean status = contactRepository.existsById(cId);
		if (status) {
			contactRepository.deleteById(cId);
			return true;
		}

		return false;
	}

}
