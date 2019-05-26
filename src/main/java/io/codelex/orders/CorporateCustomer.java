package io.codelex.orders;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CorporateCustomer {

    @Id
    private String id;
    private String idCard;
    private String extractFromRegister;
    private String placeOfRegistration;
    private String trustworthiness;
    private String isCardIssued = "No";

    public CorporateCustomer(String id, String idCard, String extractFromRegister, String placeOfRegistration, String trustworthiness, String isCardIssued) {
        this.id = id;
        this.idCard = idCard;
        this.extractFromRegister = extractFromRegister;
        this.placeOfRegistration = placeOfRegistration;
        this.trustworthiness = trustworthiness;
        this.isCardIssued = isCardIssued;
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

    void setPlaceOfRegistration(String placeOfRegistration) {
        this.placeOfRegistration = placeOfRegistration;
    }

    void setTrustworthiness(String trustworthiness) {
        this.trustworthiness = trustworthiness;
    }

    void setIsCardIssued(String isCardIssued) {
        this.isCardIssued = isCardIssued;
    }

    public String getId(String id) {
        return id;
    }

    public String getIdCard(String id) {
        return idCard;
    }

    public String getExtractFromRegister(String id) {
        return extractFromRegister;
    }

    public String getPlaceOfRegistration(String id) {
        return placeOfRegistration;
    }

    String getTrustworthiness() {
        return trustworthiness;
    }

    public String getIsCardIssuaed(String id) {
        return isCardIssued;
    }
}
