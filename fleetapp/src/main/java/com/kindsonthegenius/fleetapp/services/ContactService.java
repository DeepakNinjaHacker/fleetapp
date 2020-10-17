package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Contact;
import com.kindsonthegenius.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

	public void save(Contact contact) {
		contactRepository.save(contact);
	}

	public Optional<Contact> findById(Integer id) {
		return contactRepository.findById(id);
	}

	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}
}
