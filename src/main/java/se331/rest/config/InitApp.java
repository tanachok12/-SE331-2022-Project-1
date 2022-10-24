package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.Event;

import se331.rest.entity.Vaccine;
import se331.rest.repository.EventRepository;
import se331.rest.repository.VaccineRepository;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    VaccineRepository vaccineRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Vaccine vac1, vac2, vac3;
        vac1 = vaccineRepository.save(Vaccine.builder()
                .title("CAMT").build());
        vac2 = vaccineRepository.save(Vaccine.builder()
                .title("CMU").build());
        vac3 = vaccineRepository.save(Vaccine.builder()
                .title("ChiangMai").build());
        Event tempEvent = null;
        tempEvent = eventRepository.save(Event.builder()
                .id("13")
                .patient("Midterm Exam")
                .title("Jadsada")
                .surname("Kampen")
                .age("19")
                .location("Lumpoon")
                .petAllowed(false)
                .vaccine(vac1)
                .build());
        vac1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .id("114")
                .patient("Midterm Exam")
                .title("Jadsada")
                .surname("Kampen")
                .age("19")
                .location("Lumpoon")
                .petAllowed(false)
                .vaccine(vac1)
                .build());
        vac1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .id("1")
                .patient("Midterm Exam")
                .title("Jadsada")
                .surname("Kampen")
                .age("19")
                .location("Lumpoon")
                .petAllowed(false)
                .vaccine(vac1)
                .build());
        vac2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .id("1")
                .patient("Midterm Exam")
                .title("Jadsada")
                .surname("Kampen")
                .age("19")
                .location("Lumpoon")
                .petAllowed(false)
                .vaccine(vac1)
                .build());
        vac3.getOwnEvents().add(tempEvent);
        addUser();
        vac1.setUser(user1);
        user1.setVaccine(vac1);
        vac2.setUser(user2);
        user2.setVaccine(vac2);
        vac3.setUser(user3);
        user3.setVaccine(vac3);
    }

    User user1,user2,user3;
    private  void addUser(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
      Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("disableUser")
                .password(encoder.encode("disableUser"))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disableUser@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authUser);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }
}
