package com.anotherspectrum.sententiatitle.title;

import lombok.Getter;

public enum Admin {

    BUM("Else_Bum", ""),
    JAE("", ""),
    HONG("", ""),
    MIN("", "");

    private @Getter String name;
    private @Getter String uuid;




    Admin(String name, String uuid) {

        this.name = name;
        this.uuid = uuid;

    }
}
