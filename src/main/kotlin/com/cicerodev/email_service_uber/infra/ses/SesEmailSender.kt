package com.cicerodev.email_service_uber.infra.ses

import com.amazonaws.AmazonServiceException
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.model.*
import com.cicerodev.email_service_uber.adapters.EmailSenderGateway
import com.cicerodev.email_service_uber.core.exceptions.EmailServiceException
import org.springframework.stereotype.Service

@Service
class SesEmailSender(
   private val amazonSimpleEmailService: AmazonSimpleEmailService
) : EmailSenderGateway {
    override fun sendEmail(to: String, subject: String, body: String) {
        val request = SendEmailRequest()
            .withSource("cicerodev@gmail.com")
            .withDestination(Destination().withToAddresses(to))
            .withMessage(
                Message()
                    .withSubject(Content(subject))
                    .withBody(Body().withText(Content(body)))
            )
        try {
            amazonSimpleEmailService.sendEmail(request)

        } catch (exception: AmazonServiceException) {
            throw EmailServiceException("Failure while sending email", exception)

        }
    }
}