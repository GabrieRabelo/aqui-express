package com.projarquistao.aquiexpress.business.model;

import java.time.LocalDateTime;

public class Sale {
    private long id;
    private LocalDateTime date;

    public Sale(long id, LocalDateTime date) {
        this.id = id;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
