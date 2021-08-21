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
		List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();
		contactRepository.findAll().forEach(contactInfo -> contactInfos.add(contactInfo));
		return contactInfos;

	}

	// updated a record based on id
	@Override
	public ContactInfo editByContactId(Integer cId) {
		Optional<ContactInfo> findById = contactRepository.findById(cId);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			return null;
		}

	}

	// deleted a record based on id
	@Override
	public boolean deleteByContactId(Integer cId) {
		try {
			contactRepository.deleteById(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
