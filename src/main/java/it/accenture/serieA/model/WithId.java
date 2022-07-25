package it.accenture.serieA.model;

public interface WithId<K> {
    K getId();

    void setId(K id);
}
