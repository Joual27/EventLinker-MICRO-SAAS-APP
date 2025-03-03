package org.youcode.EventLinkerAPI.payment.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.payment.DTOs.EmbeddedPaymentDTO;
import org.youcode.EventLinkerAPI.payment.Payment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public EmbeddedPaymentDTO toEmbeddedDTO(Payment entity) {
        if ( entity == null ) {
            return null;
        }

        double amount = 0.0d;
        String status = null;
        LocalDateTime processedOn = null;

        amount = entity.getAmount();
        status = entity.getStatus();
        processedOn = entity.getProcessedOn();

        EmbeddedPaymentDTO embeddedPaymentDTO = new EmbeddedPaymentDTO( amount, status, processedOn );

        return embeddedPaymentDTO;
    }
}
