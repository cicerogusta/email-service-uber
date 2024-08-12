package com.cicerodev.email_service_uber.adapters

interface EmailSenderGateway {
    fun sendEmail(to: String, subject: String, body: String)
}