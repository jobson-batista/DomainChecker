package com.tecnologiadevalor.domainchecker;

import com.tecnologiadevalor.domainchecker.services.DomainCheckerService;

public class Main {
    public static void main(String[] args) {
        DomainCheckerService service = new DomainCheckerService();
        service.check();
    }
}