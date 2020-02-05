package org.sid.contactback.web;

import org.sid.contactback.dao.ContactRepository;
import org.sid.contactback.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ContactRestService {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/chercherContact", method = RequestMethod.GET)
    public Page<Contact> getContacts(
            @RequestParam(name = "mc", defaultValue = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "4") int size) {
        return contactRepository.findByNom(mc, PageRequest.of(page, size));
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Optional<Contact> getContact(@PathVariable Long id) {
        return contactRepository.findById(id);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact c) {

        return contactRepository.save(c);

    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public void supprimer(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }
}
