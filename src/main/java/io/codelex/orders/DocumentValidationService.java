package io.codelex.orders;

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
