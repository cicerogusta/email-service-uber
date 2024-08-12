package com.cicerodev.email_service_uber.core

 data class EmailRequest(var to: String, var subject: String, var body: String) {
}