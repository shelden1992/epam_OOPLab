package org.courses.tour.entity;

import java.util.StringJoiner;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", Transport.class.getSimpleName() + "[", "]")
                .add("idTransport=" + idTransport)
                .add("nameTransport='" + nameTransport + "'")
                .toString();
    }
}
