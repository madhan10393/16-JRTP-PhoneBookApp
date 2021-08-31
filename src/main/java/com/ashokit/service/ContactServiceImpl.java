package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		contactInfo.setActiveSwitch('Y');
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
		List<ContactInfo> findAll = contactRepository.findAll();
		List<ContactInfo> collect = findAll.stream().filter(contact -> contact.getActiveSwitch() == 'Y').collect(Collectors.toList());
		return collect;

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

		/*
		 * related to hard delete
		 * 
		 * boolean status = contactRepository.existsById(cId); if (status) {
		 * contactRepository.deleteById(cId); return true; }
		 */

		// related to soft delete
		Optional<ContactInfo> findById = contactRepository.findById(cId);
		if (findById.isPresent()) {
			ContactInfo contactInfo = findById.get();
			contactInfo.setActiveSwitch('N');
			contactRepository.save(contactInfo);
			return true;
		}

		return false;
	}

}
