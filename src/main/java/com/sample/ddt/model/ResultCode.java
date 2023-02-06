package com.sample.ddt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(1, "success"),
    Exception(0, "exception");

    public final int code;
    private final String message;
}
