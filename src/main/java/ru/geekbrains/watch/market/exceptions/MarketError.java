package ru.geekbrains.watch.market.exceptions;

import lombok.Data;

@Data
public class MarketError {
    private int status;
    private String message;

    public int getStatusCode() {
        return status;
    }

    public void setStatusCode(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MarketError() {
    }

    public MarketError(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
