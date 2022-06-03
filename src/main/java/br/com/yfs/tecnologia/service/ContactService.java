package br.com.yfs.tecnologia.service;

import br.com.yfs.tecnologia.model.Contact;

import java.util.List;

public interface ContactService {

    void saveContact(Contact contact);

    Contact findById(Long id);

    List<Contact> findAll();

    void deleteContactById(Long id);

    void updateContact(Long id, Contact contact);

}
