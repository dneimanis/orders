package io.codelex.orders.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class AddCorporateCustomer {
    
    @NotEmpty
    private String idCard;

    @NotEmpty
    private String extractFromRegister;

    @NotEmpty
    private String placeOfRegistration;

    @JsonCreator
    public AddCorporateCustomer(@JsonProperty("idCard") String idCard,
                                @JsonProperty("extractFromRegister") String extractFromRegister,
                                @JsonProperty("placeOfRegistration") String placeOfRegistration) {
        this.extractFromRegister = extractFromRegister;
        this.idCard = idCard;
        this.placeOfRegistration = placeOfRegistration;
    }

    public String getExtractFromRegister() {
        return extractFromRegister;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getPlaceOfRegistration() {
        return placeOfRegistration;
    }
}
