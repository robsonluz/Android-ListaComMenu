package robs.listas2.model;

import java.io.Serializable;

/**
 * Created by robson on 02/03/16.
 */
public class Noticia implements Serializable {

    private String titulo;
    private String texto;

    public Noticia() {
    }

    public Noticia(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
