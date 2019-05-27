package io.codelex.orders;

import org.springframework.stereotype.Component;

@Component
public class DocumentValidationService {

    public ValidationResult validateIdCard(String idCard) {
        return ValidationResult.VALID;
    }

    public ValidationResult validatePlaceOfRegistration(String placeOfRegistration) {
        return ValidationResult.VALID;
    }

    public ValidationResult validateExtractFromRegister(String extractFromRegister) {
        return ValidationResult.VALID;
    }
}
