package com.example.ebankingbackend.exceptions;

<<<<<<< HEAD
public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(String message) {
=======
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message ) {
>>>>>>> df97d7e52aebcd0d742549be6434daf6fabe2f40
        super(message);
    }
}
