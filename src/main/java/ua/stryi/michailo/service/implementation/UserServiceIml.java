package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.mail.MailConfig;
import ua.stryi.michailo.repo.UserRepo;
import ua.stryi.michailo.service.PhotosService;
import ua.stryi.michailo.service.UserService;
import ua.stryi.michailo.validation.implementayion.UserBecend;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class UserServiceIml implements UserService, UserDetailsService{
@Autowired
    private UserRepo userRepo;
@Autowired
    UserBecend userBecend;
@Autowired
    PhotosService photosService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepo.findByEmailOrPhone(s,s);
        Collection<GrantedAuthority>authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isActive(), true, true, true, authorities);

    }



    @Override
    public void add(User user,String dates) {

Properties props=new Properties();
        props.put("mail.smtp.auth", MailConfig.MAIL_SMTP_AUTH);
        props.put("mail.smtp.starttls.enable", MailConfig.MAIL_SMTP_START_TLS_ENABLE);
        props.put("mail.smtp.host", MailConfig.MAIL_SMTP_HOST);
        props.put("mail.smtp.port", MailConfig.MAIL_SMTP_PORT);
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(MailConfig.USER_NAME, MailConfig.USER_PASSWORD);
                    }
                });


        try {
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));

message.setFrom(new InternetAddress(MailConfig.USER_NAME));

            message.setSubject("Activate your account");
message.setText("http://localhost:8081/registration/activation/"+user.getActivator());
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }


        String []d=dates.split("-",3);
        GregorianCalendar gregorianCalendar=new GregorianCalendar(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]));

user.setAge(gregorianCalendar);

        userRepo.save(user);

    }

    @Override
    public void edit(User user) {
userRepo.save(user);
    }

    @Override
    public void delete(int id) {
userRepo.delete(id);
    }

    @Override
    public User FindById(Integer id) {
       return userRepo.findOne(id);
    }

    @Override
    public User FindByLogin(String login) {
        return userRepo.findByEmailOrPhone(login,login);
    }

    @Override
    public User FindByEmail(String email) {
        return null;
    }

    @Override
    public List<User> FindAll() {
        return userRepo.findAll();
    }

    @Override
    public void activ(String activator) {
      User user=userRepo.findByActivator(activator);
        GregorianCalendar gregorianCalendar=new GregorianCalendar();
user.setDate(gregorianCalendar);

      user.setActive(true);
      userRepo.save(user);
    }
    public String authenticationUserName() {
        SecurityContext context = SecurityContextHolder.getContext();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String userLogin;
        if (principal instanceof UserDetails) {
            userLogin = ((UserDetails)principal).getUsername();
        } else {
            userLogin = principal.toString();
        }
        return userLogin;
    }

    @Override
    public User authenticationUser() {
        return userRepo.findByEmail(authenticationUserName());
    }

    @Override
    public List<User> findByUser(String a) {
        List<User>userList=new ArrayList<>();
        String b[]= a.split(" ");
        if (b.length>1){
            String name=b[0];
            String secondName=b[1];
            userList.addAll(userRepo.findByNameAndSecondName(name,secondName));

        }else {
            userList.addAll(userRepo.findByUser(a));
        }
        return userList;
    }


}
