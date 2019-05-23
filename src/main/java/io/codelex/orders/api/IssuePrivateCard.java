package io.codelex.orders.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class IssuePrivateCard {

    @NotEmpty
    private String idCard;

    @JsonCreator
    public IssuePrivateCard(@JsonProperty("idCard") String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }
}
