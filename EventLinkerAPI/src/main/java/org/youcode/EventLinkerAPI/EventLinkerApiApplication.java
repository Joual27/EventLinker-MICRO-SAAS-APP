package org.youcode.EventLinkerAPI;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentMethod;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.youcode.EventLinkerAPI.exceptions.PaymentProcessingException;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@SpringBootApplication
public class EventLinkerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventLinkerApiApplication.class, args);
		Map<String, Object> cardParams = new HashMap<>();
		cardParams.put("number", "4000000000000077");
		cardParams.put("exp_month", 12);
		cardParams.put("exp_year", 34);
		cardParams.put("cvc", "123");

		Map<String, Object> params = new HashMap<>();
		params.put("type", "card");
		params.put("card", cardParams);
		PaymentMethod paymentMethod;
		try {
			paymentMethod = PaymentMethod.create(params);
		}catch (StripeException e){
			throw new PaymentProcessingException(e.getMessage());
		}
		System.out.println("Created PaymentMethod ID: " + paymentMethod.getId());
	}

}

