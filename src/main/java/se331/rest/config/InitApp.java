package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.Comment;
import se331.rest.entity.Event;
import se331.rest.entity.Organizer;
import se331.rest.entity.Vaccine;
import se331.rest.repository.CommentRepository;
import se331.rest.repository.EventRepository;
import se331.rest.repository.OrganizerRepository;
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
    OrganizerRepository organizerRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    VaccineRepository vaccineRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Event tempEvent = null;
        Comment  comment = null;
        Vaccine vaccine = null;

        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("Dr.Nattaparin").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("Dr.F").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("Dr.J").build());

        tempEvent = eventRepository.save(Event.builder()

                .name("Jesada Kampen")
                .vaccine1("Sinovac")
                .vaccine2("Moderna")
                .vaccine3("Moderna")
                .durationTime1("3rd january 2564")
                .durationTime2("6th april 2564")
                .durationTime3("1st july 2564")
                .location("NewYork")
                .age("20")
                .addimg("https://media.discordapp.net/attachments/751789885622583347/1035191320605626428/unknown.png?width=554&height=554")

                .organizer(org1)
                .build());
        comment = commentRepository.save(Comment.builder()
                .comment("null")
                .name("null").build());
        vaccine = vaccineRepository.save(Vaccine.builder()
                .vaccine(null)
                .id(null)
                .build());
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()


                .name("morty smith")
                .vaccine1("AstraZeneca")
                .vaccine2("Moderna")
                .vaccine3(null)
                .durationTime1("14th april 2564")
                .durationTime2("3rd November 2564")
                .durationTime3(null)
                .age("21")
                .location("Lamphun")
                .addimg("https://media.discordapp.net/attachments/751789885622583347/1035190593049075732/unknown.png?width=831&height=554")



                .organizer(org1)
                .build());
        comment = commentRepository.save(Comment.builder()
                .comment("null")
                .name("null").build());
        tempEvent.getCommentList().add(comment);
        vaccine = vaccineRepository.save(Vaccine.builder()
                .vaccine(null)
                .id(null)
                .build());
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()

                .name("Aranya")
                .vaccine1("Sinovac")
                .vaccine2(null)
                .vaccine3(null)
                .durationTime1("6th july 2564")
                .durationTime2(null)
                .durationTime3(null)
                .age("21")
                .location("Bankkok")
                .addimg("https://media.discordapp.net/attachments/751789885622583347/1035190939385340005/unknown.png")

                .organizer(org2)

                .build());
        comment = commentRepository.save(Comment.builder()
                .comment("null")
                .name("null").build());
        tempEvent.getCommentList().add(comment);
        vaccine = vaccineRepository.save(Vaccine.builder()
                .vaccine(null)
                .id(null)
                .build());
        org2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()

                .name("Songkran")
                .vaccine1("Sinovac")
                .vaccine2("AstraZeneca")
                .vaccine3(null)
                .addimg("https://media.discordapp.net/attachments/751789885622583347/1035189623925780480/unknown.png?width=554&height=554")
                .location("Chiang Mai ")

                .age("32")

                .organizer(org3)
                .build());
        comment = commentRepository.save(Comment.builder()
                .comment("null")
                .name("null").build());
        tempEvent.getCommentList().add(comment);
        vaccine = vaccineRepository.save(Vaccine.builder()
                .vaccine(null)
                .id(null)
                .build());
        org3.getOwnEvents().add(tempEvent);
        addUser();
        org1.setUser(user1);
        user1.setOrganizer(org1);
        org2.setUser(user2);
        user2.setOrganizer(org2);
        org3.setUser(user3);
        user3.setOrganizer(org3);
    }

    User user1,user2,user3;
    private  void addUser(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
      Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
      Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .image("https://media.discordapp.net/attachments/859092780805914644/1036578899624198174/unknown.png")
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
                .username("doctor")
                .password(encoder.encode("doctor"))
                .firstname("doctor")
                .lastname("doctor")
                .email("doctor@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        authorityRepository.save(authDoctor);
        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authDoctor);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }
}
