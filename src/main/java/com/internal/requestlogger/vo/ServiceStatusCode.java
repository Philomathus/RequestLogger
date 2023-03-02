package com.internal.requestlogger.vo;

import lombok.Data;
import lombok.ToString;
import java.util.Objects;

@Data
@ToString
public class ServiceStatusCode {
    private int code;
    private String message;

    public ServiceStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(!(o instanceof ServiceStatusCode that)) {
            return false;
        } else {
            return this.code == that.code;
        }
    }

    public int hashCode() {
        return Objects.hash(code);
    }
}
