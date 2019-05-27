package io.codelex.orders;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "corporateCustomers")
public class CorporateCustomerRecord {

    @Id
    private String id;
    private String idCard;
    private String extractFromRegister;
    private String placeOfRegistration;
    private String trustworthiness;
    private LocalDate cardIssued;

    public CorporateCustomerRecord(String id, String idCard, String extractFromRegister, String placeOfRegistration, String trustworthiness, LocalDate cardIssued) {
        this.id = id;
        this.idCard = idCard;
        this.extractFromRegister = extractFromRegister;
        this.placeOfRegistration = placeOfRegistration;
        this.trustworthiness = trustworthiness;
        this.cardIssued = cardIssued;
    }

    CorporateCustomerRecord() {
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

    void setCardIssued(LocalDate cardIssued) {
        this.cardIssued = cardIssued;
    }

    public String getIdCard() {
        return idCard;
    }

    String getExtractFromRegister() {
        return extractFromRegister;
    }

    String getPlaceOfRegistration() {
        return placeOfRegistration;
    }

    String getTrustworthiness() {
        return trustworthiness;
    }

    LocalDate getCardIssued() {
        return cardIssued;
    }

    String getId() {
        return id;
    }
}
