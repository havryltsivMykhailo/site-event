package ua.stryi.michailo.validation.implementayion;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.exceptions.ValidationExceptions;
import ua.stryi.michailo.utill.ValidationMesseges;

import static ua.stryi.michailo.utill.ValidationMesseges.*;

/**
 * Created by михайло on 13.05.2017.
 */
@Component
public class UserBecend implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (!((User) o).getName().matches("^[a-zA-Z][a-zA-Z-_\\.]{1,20}$")) {
errors.rejectValue("name","name",ValidationMesseges.INVALID_USER_NAME);}
        if (!((User) o).getSecondName().matches("^[a-zA-Z][a-zA-Z-_\\.]{1,20}$")){
            errors.rejectValue("secondName","secondName.empty",ValidationMesseges.INVALID_USER_SECOND_NAME);
        }if (!((User) o).getCity().matches("^[a-zA-Z][a-zA-Z-_\\.]{2,20}$")){
            errors.rejectValue("city","city.empty",ValidationMesseges.INVALID_USER_CITY);
        } if (!((User) o).getPhone().matches("^[0-9-+]{13}$")){
            errors.rejectValue("phone","phone",ValidationMesseges.INVALID_USER_PHONE);
        } if (!((User) o).getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
            errors.rejectValue("email","email.th",ValidationMesseges.INVALID_USER_EMAIL);
        }if (!((User) o).getPassword().matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[a-z]).*$")){
            errors.rejectValue("password","",ValidationMesseges.INVALID_USER_PASSWORD);


        }}
    }

