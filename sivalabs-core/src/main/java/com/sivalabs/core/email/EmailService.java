package com.sivalabs.core.email;

/**
 * @author skatam
 *
 */

import java.util.List;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailService
{
	private JavaMailSenderImpl mailSender = null;

	public void setMailSender(JavaMailSenderImpl mailSender)
	{
		this.mailSender = mailSender;
	}

	public void sendEmail(Email email) throws MessagingException
	{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// use the true flag to indicate you need a multipart message
		boolean hasAttachments = (email.getAttachments() != null && email
				.getAttachments().size() > 0);
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
				hasAttachments);
		helper.setTo(email.getTo());
		helper.setFrom(email.getFrom());
		helper.setSubject(email.getSubject());
		helper.setText(email.getText(), true);

		List<Attachment> attachments = email.getAttachments();
		if (attachments != null && attachments.size() > 0) {
			for (Attachment attachment : attachments) {
				String filename = attachment.getFilename();
				DataSource dataSource = new ByteArrayDataSource(
						attachment.getData(), attachment.getMimeType());
				if (attachment.isInline()) {
					helper.addInline(filename, dataSource);
				} else {
					helper.addAttachment(filename, dataSource);
				}
			}
		}

		mailSender.send(mimeMessage);
	}
}
