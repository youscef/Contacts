package org.sid.contactback.dao;

import org.sid.contactback.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    public Page<Contact> findByNom(String mc, Pageable pageable);
}
