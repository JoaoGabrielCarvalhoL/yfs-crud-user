package br.com.yfs.tecnologia.service.impl;

import br.com.yfs.tecnologia.exception.NotFoundException;
import br.com.yfs.tecnologia.model.Contact;
import br.com.yfs.tecnologia.repository.ContactRepository;
import br.com.yfs.tecnologia.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact findById(Long id) {
        Optional<Contact> contactResult = contactRepository.findById(id);
        return contactResult.orElseThrow(() -> new NotFoundException("Contact not found! Id: " + id));
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public void deleteContactById(Long id) {
        Optional<Contact> contactResult = contactRepository.findById(id);
        if (contactResult.isEmpty()) {
            throw new NotFoundException("Contact not found! Id: " + id);
        }
        contactRepository.delete(contactResult.get());
    }

    @Override
    public void updateContact(Long id, Contact contact) {
        Optional<Contact> contactResult = contactRepository.findById(id);
        if(contactResult.isEmpty()) {
            throw new NotFoundException("Contact not found! Id: " + id);
        }
        contactResult.get().setCellphone(contact.getCellphone());
        contactResult.get().setTelephone(contact.getTelephone());
        contactRepository.save(contactResult.get());
    }
}
