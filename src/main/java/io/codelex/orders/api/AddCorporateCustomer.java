package io.codelex.orders.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class AddCorporateCustomer {
    
    @NotEmpty
    private String idCard;

    @NotEmpty
    private String extractFromRegister;

    @JsonCreator
    public AddCorporateCustomer(@JsonProperty("idCard") String idCard,
                                @JsonProperty("extractFromRegister") String extractFromRegister) {
        this.extractFromRegister = extractFromRegister;
        this.idCard = idCard;
    }

    public String getExtractFromRegister() {
        return extractFromRegister;
    }

    public String getIdCard() {
        return idCard;
    }
}
