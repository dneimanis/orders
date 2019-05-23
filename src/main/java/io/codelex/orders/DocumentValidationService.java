package io.codelex.orders;

public class DocumentValidationService {

    public ValidationResult validateIdCard(String idCard) {
        return ValidationResult.VALID;
    }

    public ValidationResult validatePlaceOfRegistration() {
        return ValidationResult.VALID;
    }

    public ValidationResult validateExtractFromRegister(String extractFromRegister) {
        return ValidationResult.VALID;
    }
}
