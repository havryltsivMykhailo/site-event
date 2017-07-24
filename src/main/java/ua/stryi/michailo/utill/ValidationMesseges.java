package ua.stryi.michailo.utill;

/**
 * Created by михайло on 09.05.2017.
 */
public interface ValidationMesseges {

    String ACCOUNT_ALREADY_EXISTS = "Account with such credentials is already created";

    String INVALID_USER_NAME = "User name is Invalid";
    String INVALID_USER_SECOND_NAME = "User second name is Invalid";
    String INVALID_USER_EMAIL = "User email is Invalid";
    String INVALID_USER_PHONE = "User phone is Invalid";
    String INVALID_USER_PASSWORD = "User password is invalid, password is at least 8 characters long";
    String INVALID_USER_CITY="User city is invalid";
}
