package com.cicerodev.email_service_uber.core.exceptions

import java.lang.RuntimeException

class EmailServiceException(message: String?, cause: Throwable? = null) : RuntimeException(message, cause) {

    constructor(message: String?) : this(message, null)

}
