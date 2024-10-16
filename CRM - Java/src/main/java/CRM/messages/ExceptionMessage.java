package CRM.messages;

import org.springframework.http.HttpStatus;

public record ExceptionMessage(String message, HttpStatus status) {
}
