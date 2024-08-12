package com.cicerodev.email_service_uber.core

interface EmailSenderUseCase {

    fun sendEmail(to: String, subject: String, body: String)
}