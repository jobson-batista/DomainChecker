package com.tecnologiadevalor.domainchecker.enums;

public enum URLS {

    REGISTRO_BR_BASE("https://registro.br/rdap"),
    REGISTRO_BR_DOMAIN_URL("/domain"),
    GODADDY_PROD_BASE("https://api.godaddy.com/v1/domains"),
    GODADDY_OTE_BASE("https://api.ote-godaddy.com/v1/domains"),
    GODADDY_AVALIABLE("/available");


    private final String value;

    URLS(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
