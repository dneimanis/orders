package io.codelex.orders;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "privateCustomers")
public class PrivateCustomerRecord {

    @Id
    private String id;
    private String idCard;
    private String placeOfRegistration;
    private String trustworthiness;
    private LocalDate cardIssued;
    
    public PrivateCustomerRecord(String id, String idCard, String placeOfRegistration, String trustworthiness, LocalDate cardIssued) {
        this.id = id;
        this.idCard = idCard;
        this.placeOfRegistration = placeOfRegistration;
        this.trustworthiness = trustworthiness;
        this.cardIssued = cardIssued;
    }

    PrivateCustomerRecord() {
    }

    void setId(String id) {
        this.id = id;
    }

    void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    void setPlaceOfRegistration(String placeOfRegistration) {
        this.placeOfRegistration = placeOfRegistration;
    }

    public void setTrustworthiness(String trustworthiness) {
        this.trustworthiness = trustworthiness;
    }

    public void setCardIssued(LocalDate cardIssued) {
        this.cardIssued = cardIssued;
    }

    public String getId() {
        return id;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getPlaceOfRegistration() {
        return placeOfRegistration;
    }

    public String getTrustworthiness() {
        return trustworthiness;
    }

    public LocalDate getCardIssued() {
        return cardIssued;
    }
}
