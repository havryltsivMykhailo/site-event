package ua.stryi.michailo.validation;

import javax.xml.bind.ValidationException;

/**
 * Created by михайло on 09.05.2017.
 */
public interface Validator {

    void validator(Object o) throws ValidationException;
}
