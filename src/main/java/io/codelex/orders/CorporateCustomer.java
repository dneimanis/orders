package io.codelex.orders;

import java.time.LocalDate;

class CorporateCustomer {

    private String id;
    private String idCard;
    private String extractFromRegister;
    private String placeOfRegistration;
    private String trustworthiness;
    private LocalDate cardIssued;

    CorporateCustomer(String id, String idCard, String extractFromRegister, String placeOfRegistration, String trustworthiness, LocalDate cardIssued) {
        this.id = id;
        this.idCard = idCard;
        this.extractFromRegister = extractFromRegister;
        this.placeOfRegistration = placeOfRegistration;
        this.trustworthiness = trustworthiness;
        this.cardIssued = cardIssued;
    }

    public CorporateCustomer() {
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getExtractFromRegister() {
        return extractFromRegister;
    }

    public void setExtractFromRegister(String extractFromRegister) {
        this.extractFromRegister = extractFromRegister;
    }

    public String getPlaceOfRegistration() {
        return placeOfRegistration;
    }

    public void setPlaceOfRegistration(String placeOfRegistration) {
        this.placeOfRegistration = placeOfRegistration;
    }

    public String getTrustworthiness() {
        return trustworthiness;
    }

    public void setTrustworthiness(String trustworthiness) {
        this.trustworthiness = trustworthiness;
    }

    public LocalDate getCardIssued() {
        return cardIssued;
    }

    public void setCardIssued(LocalDate cardIssued) {
        this.cardIssued = cardIssued;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
