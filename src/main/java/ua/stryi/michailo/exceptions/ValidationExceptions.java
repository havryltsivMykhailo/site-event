package ua.stryi.michailo.exceptions;

/**
 * Created by михайло on 09.05.2017.
 */
public class ValidationExceptions extends RuntimeException {
    public ValidationExceptions(String messege){
        super(messege);
    }
}
