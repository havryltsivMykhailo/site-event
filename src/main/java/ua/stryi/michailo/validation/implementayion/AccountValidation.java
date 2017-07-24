package ua.stryi.michailo.validation.implementayion;


import org.springframework.stereotype.Component;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.exceptions.ValidationExceptions;
import ua.stryi.michailo.validation.Validator;
import ua.stryi.michailo.utill.ValidationMesseges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class AccountValidation implements Validator {
    @Override
    public void validator(Object o) {
        User user=(User) o;
        Pattern email=Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Pattern name=Pattern.compile("^[a-zA-Z][a-zA-Z-_\\.]{1,20}$");
        Pattern phone=Pattern.compile("/[0-9+]{13}/");

        Matcher matcherEmail=email.matcher(user.getEmail());
        Matcher matcherphone=phone.matcher(user.getPhone());
        Matcher matcherName=name.matcher(user.getName());


        if(!matcherName.matches()){
            System.out.println("tru");
            throw new ValidationExceptions(ValidationMesseges.INVALID_USER_NAME);

    }else {
            System.out.println("false");}

        if(user.getSecondName().isEmpty()){
            throw new ValidationExceptions(ValidationMesseges.INVALID_USER_SECOND_NAME);
        }
        if(!matcherEmail.matches()){
            throw new ValidationExceptions(ValidationMesseges.INVALID_USER_EMAIL);
        }
        if (user.getPhone().isEmpty()||!matcherphone.matches()){
            throw new ValidationExceptions(ValidationMesseges.INVALID_USER_PHONE);
        }

        if(user.getPassword().isEmpty()){
            throw new ValidationExceptions(ValidationMesseges.INVALID_USER_PASSWORD);
        }
    }
}



