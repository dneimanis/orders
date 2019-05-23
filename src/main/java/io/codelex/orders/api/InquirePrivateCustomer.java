package io.codelex.orders.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class InquirePrivateCustomer {
    
    @NotEmpty
    private String idCard;

    @NotEmpty
    private String placeOfRegistration;

    @JsonCreator
    public InquirePrivateCustomer(@JsonProperty("idCard") String idCard,
                                  @JsonProperty("placeOfRegistration") String placeOfRegistration) {
        this.idCard = idCard;
        this.placeOfRegistration = placeOfRegistration;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getPlaceOfRegistration() {
        return placeOfRegistration;
    }
}
