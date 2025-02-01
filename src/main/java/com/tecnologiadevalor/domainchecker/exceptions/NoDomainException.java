package com.tecnologiadevalor.domainchecker.exceptions;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoDomainException extends RuntimeException {

    private String title = "No domain available.";
    private String description = "No domains could be found in search.";
}
