package org.courses.tour.entity;

public class Transport {
    private int idTransport;
    private String nameTransport;

    public Transport(int idTransport, String nameTransport) {
        this.idTransport = idTransport;
        this.nameTransport = nameTransport;
    }

    public int getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(int idTransport) {
        this.idTransport = idTransport;
    }

    public String getNameTransport() {
        return nameTransport;
    }

    public void setNameTransport(String nameTransport) {
        this.nameTransport = nameTransport;
    }
}
