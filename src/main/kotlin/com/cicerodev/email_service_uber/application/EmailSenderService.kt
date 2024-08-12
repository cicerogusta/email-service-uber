package com.cicerodev.email_service_uber.application

import com.cicerodev.email_service_uber.adapters.EmailSenderGateway
import com.cicerodev.email_service_uber.core.EmailSenderUseCase
import org.springframework.stereotype.Service

@Service
class EmailSenderService(
    val emailSenderGateway: EmailSenderGateway
) : EmailSenderUseCase {
    override fun sendEmail(to: String, subject: String, body: String) {
        emailSenderGateway.sendEmail(to, subject, body)
    }
}