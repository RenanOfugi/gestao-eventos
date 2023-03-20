package com.oficinadevalor.gestaoeventos.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DefaultErrorsViolations {

    private List<String> errors;

    public DefaultErrorsViolations(List<String> errors) {
        this.errors = errors;
    }
}
