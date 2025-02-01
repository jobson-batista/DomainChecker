package com.tecnologiadevalor.domainchecker.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String type;
    private String title;
    private String detail;
}
