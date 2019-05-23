package io.codelex.orders;

import javax.persistence.Entity;

@Entity
public class CorporateCustomer {

    private String id;
    private String idCard;
    private String extractFromRegister;
    private ValidationResult idCardValidationStatus;
    private ValidationResult extractFromRegisterValidationStatus;

    public CorporateCustomer(String id, String idCard, String extractFromRegister) {
        this.id = id;
        this.idCard = idCard;
        this.extractFromRegister = extractFromRegister;
    }

    CorporateCustomer() {
    }

    void setId(String id) {
        this.id = id;
    }

    void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    void setExtractFromRegister(String extractFromRegister) {
        this.extractFromRegister = extractFromRegister;
    }
}
