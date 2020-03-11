package com.projectabhishek.partyDetailService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The advice class to render a HTTP 404 when a PartyNotFoundException is thrown
 */
public class PartyNotFoundExceptionAdvice {
    //The @ResponseBody annotation signals that this advice is rendered straight into response body
    // The @ResponseStatus annotation says to issue a HTTP 404 i..e NOT_FOUND exception
    //The body of the advice generates the content. In this case, it gives the message of the exception.
    @ResponseBody
    @ExceptionHandler(PartyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String partyNotFoundHandler(PartyNotFoundException ex) {
        return ex.getMessage();
    }
}
