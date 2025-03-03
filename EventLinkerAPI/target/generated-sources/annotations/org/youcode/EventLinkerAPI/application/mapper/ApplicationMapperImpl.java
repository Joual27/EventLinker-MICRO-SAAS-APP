package org.youcode.EventLinkerAPI.application.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.announcement.DTOs.EmbeddedAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.mapper.AnnouncementMapper;
import org.youcode.EventLinkerAPI.application.Application;
import org.youcode.EventLinkerAPI.application.DTOs.ApplicationResponseDTO;
import org.youcode.EventLinkerAPI.application.DTOs.CreateApplicationDTO;
import org.youcode.EventLinkerAPI.application.DTOs.EmbeddedApplicationDTO;
import org.youcode.EventLinkerAPI.application.DTOs.UpdateApplicationDTO;
import org.youcode.EventLinkerAPI.application.enums.ApplicationStatus;
import org.youcode.EventLinkerAPI.payment.DTOs.EmbeddedPaymentDTO;
import org.youcode.EventLinkerAPI.payment.mapper.PaymentMapper;
import org.youcode.EventLinkerAPI.user.DTOs.EmbeddedUserDTO;
import org.youcode.EventLinkerAPI.user.mapper.UserMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ApplicationMapperImpl implements ApplicationMapper {

    @Autowired
    private AnnouncementMapper announcementMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public EmbeddedApplicationDTO toEmbeddedDTO(Application entity) {
        if ( entity == null ) {
            return null;
        }

        EmbeddedUserDTO applicant = null;
        LocalDateTime createdAt = null;
        ApplicationStatus status = null;

        applicant = userMapper.toEmbeddedDTO( entity.getApplicant() );
        createdAt = entity.getCreatedAt();
        status = entity.getStatus();

        EmbeddedApplicationDTO embeddedApplicationDTO = new EmbeddedApplicationDTO( applicant, createdAt, status );

        return embeddedApplicationDTO;
    }

    @Override
    public ApplicationResponseDTO toResponseDTO(Application entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        double price = 0.0d;
        ApplicationStatus status = null;
        LocalDateTime createdAt = null;
        String letter = null;
        EmbeddedAnnouncementDTO announcement = null;
        EmbeddedUserDTO applicant = null;
        EmbeddedPaymentDTO payment = null;

        id = entity.getId();
        price = entity.getPrice();
        status = entity.getStatus();
        createdAt = entity.getCreatedAt();
        letter = entity.getLetter();
        announcement = announcementMapper.toEmbeddedDTO( entity.getAnnouncement() );
        applicant = userMapper.toEmbeddedDTO( entity.getApplicant() );
        payment = paymentMapper.toEmbeddedDTO( entity.getPayment() );

        ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO( id, price, status, createdAt, letter, announcement, applicant, payment );

        return applicationResponseDTO;
    }

    @Override
    public Application updateDTOToEntity(UpdateApplicationDTO updateDTO) {
        if ( updateDTO == null ) {
            return null;
        }

        Application application = new Application();

        application.setPrice( updateDTO.price() );
        application.setLetter( updateDTO.letter() );

        return application;
    }

    @Override
    public Application toEntity(CreateApplicationDTO createDTO) {
        if ( createDTO == null ) {
            return null;
        }

        Application application = new Application();

        application.setPrice( createDTO.price() );
        application.setLetter( createDTO.letter() );

        return application;
    }
}
