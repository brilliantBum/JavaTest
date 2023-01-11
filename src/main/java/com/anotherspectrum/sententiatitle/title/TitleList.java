package com.anotherspectrum.sententiatitle.title;

import lombok.Getter;

public enum TitleList {

    //초반 칭호
    TITLE(""), //모든 칭호
    TITLE1(""), // 스페셜 칭호
    TITLE2("");

    @Getter
    private String name;

    TitleList(String name) {

        this.name = name;

    }

}
