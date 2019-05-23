package io.codelex.orders;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrivateCustomer {

    @Id
    private String id;
    private String idCard;
    private String placeOfRegistration;
    private ValidationResult idCardValidationStatus;
    private ValidationResult getPlaceOfRegistrationValidationStatus;
    public PrivateCustomer(String id, String idCard, String placeOfRegistration) {
        this.id = id;
        this.idCard = idCard;
        this.placeOfRegistration = placeOfRegistration;
    }

    PrivateCustomer() {
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
}
