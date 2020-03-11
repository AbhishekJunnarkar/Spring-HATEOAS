package com.projectabhishek.partyDetailService.exception;

/**
 * PartyNotFoundException is an exception used to indicate when an employee is looked up but not found.
 */
public class PartyNotFoundException extends RuntimeException {

    public PartyNotFoundException(Long id) {
        super("Could not find party " + id);
    }
}
