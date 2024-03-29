package br.com.diego.AppVet.enums;

public enum Status {
    INICIADA, CONCLUIDA, CANCELADA;

    public static Status getByName(String value) {
        for (Status status : Status.values()) {
            if (status.name().equals(value)) {
                return status;
            }
        }
        return null;
    }
}
