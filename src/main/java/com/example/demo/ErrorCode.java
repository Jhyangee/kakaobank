package com.example.demo;

import java.util.Arrays;

public enum ErrorCode {
    APISERVER("API 통신 에러입니다.")
    ;

    private final String label;

    ErrorCode(String label) {
        this.label = label;
    }
    public static ErrorCode valueOfLabel(String label) {
        return Arrays.stream(values())
                .filter(value -> value.label.equals(label))
                .findAny()
                .orElse(null);
    }
}