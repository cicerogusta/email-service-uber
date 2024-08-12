package com.cicerodev.email_service_uber.controllers

import com.cicerodev.email_service_uber.application.EmailSenderService
import com.cicerodev.email_service_uber.core.EmailRequest
import com.cicerodev.email_service_uber.core.exceptions.EmailServiceException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/email")
class EmailSenderController(private val emailSenderService: EmailSenderService) {

        @PostMapping()
        fun sendEmail(@RequestBody request: EmailRequest): ResponseEntity<String>{
            try {
                emailSenderService.sendEmail(request.to, request.subject, request.body)
                return ResponseEntity.ok("email send successfully")

            }catch (ex: EmailServiceException) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email")


            }
        }

}