package org.sid.contactback;

import org.sid.contactback.dao.ContactRepository;
import org.sid.contactback.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ContactbackApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(ContactbackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("yy-MM-yyyy");
		contactRepository.save(new Contact("youssef","amraoui",df.parse("04-05-1993"),"ucef.stg@gmail.com",0326L,"photos"));
		contactRepository.save(new Contact("Zakaria","rasso",df.parse("05-12-1993"),"zakaria.stg@gmail.com",0326L,"photos"));
		contactRepository.save(new Contact("lamia","fatni",df.parse("15-11-1998"),"lamia.stg@gmail.com",0326L,"photos"));
		contactRepository.save(new Contact("khadija","brahim",df.parse("20-07-2000"),"khadija.stg@gmail.com",0326L,"photos"));

		contactRepository.findAll().forEach(contact -> {
			System.out.println(contact.getNom());
		});
	}
}
