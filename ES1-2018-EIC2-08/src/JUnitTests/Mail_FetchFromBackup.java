package JUnitTests;

import static org.junit.Assert.*;

import javax.swing.DefaultListModel;

import org.junit.Test;

import BDA.Email;

import BDA.Mail;

public class Mail_FetchFromBackup {

	@Test
	public void test() {
		DefaultListModel<Email> emails =Mail.FetchFromBackup();
		assertFalse(emails.isEmpty());
	}

}
