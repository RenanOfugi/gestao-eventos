package com.oficinadevalor.gestaoeventos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class DefaultException {

    private Integer code;
    private String message;
}
