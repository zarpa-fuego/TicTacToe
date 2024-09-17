package pe.edu.upeu.modelo;

public class Jugador {

    private String nombre;
    private String simbolo;

    // Se llama constructor, para contruir objetos
    public Jugador(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.simbolo = "X";
    }
    public Jugador( ) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
