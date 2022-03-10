package com.dannycodes.email;

import com.dannycodes.email.entities.Email;
import com.dannycodes.email.repositories.EmailRepository;
import com.dannycodes.email.services.EmailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

@SpringBootTest
class EmailApplicationTests {


	private final Log log = LogFactory.getLog(this.getClass());


	@Autowired
	private EmailService emailService;

	@Autowired
	private EmailRepository emailRepository;

	@Test
	public void create() {
		Email email = new Email();

		email.setFirstname("dan");
		email.setLastname("john");
		email.setDepartment("DEVELOPER");
		email.setPassword("FRDT76NJVNGF");
		email.setAlternateEmail("anybody@gmail.com");
		email.setEmail("danjohn@gmail.com");
		email.setMailboxCapacity(500);
		Email e =emailRepository.save(email);

		log.info(email);
		Assertions.assertNotNull(e);

		org.assertj.core.api.Assertions.assertThat(e.getFirstname()).isEqualToIgnoringCase("dan");

		Assertions.assertSame(e,e);

		org.assertj.core.api.Assertions.assertThatNoException();
		Assertions.assertEquals(e.getMailboxCapacity(),500);
	}


	@Test
	public void test1(){

		Email e = new Email();

		String c = e.c();

		log.info(c);
		Assertions.assertNotNull(c);
		org.assertj.core.api.Assertions.assertThat(c.length())
				.isEven()
				.isEqualTo(12)
				.isGreaterThan(10)
				.isNotNull()
				.isGreaterThanOrEqualTo(11)
		         .isLessThan(50);

	}

	@Test
	public void test2(){

		Email e = new Email();
		String d = e.theDepartment();

		org.assertj.core.api.Assertions.assertThat(d.equalsIgnoreCase("sales"));
		Assertions.assertEquals(d,d.toUpperCase());
		log.info(d);

	}

}
