package lab3p2_luishenriquez;

public class Pokemon {
    String nombre;
    int pokedexCode;
    String naturaleza;
    boolean atrapado;
    String pokebola;

    public Pokemon() {
    }

    public Pokemon(String nombre, int pokedex, String naturaleza) {
        this.nombre = nombre;
        this.pokedexCode = pokedex;
        this.naturaleza = naturaleza;
        atrapado = false;
        pokebola = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPokedex() {
        return pokedexCode;
    }

    public void setPokedex(int pokedex) {
        this.pokedexCode = pokedex;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public boolean isAtrapado() {
        return atrapado;
    }

    public void setAtrapado(boolean atrapado) {
        this.atrapado = atrapado;
    }

    public String getPokebola() {
        return pokebola;
    }

    public void setPokebola(String pokebola) {
        this.pokebola = pokebola;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Código en la Pokedex: " + pokedexCode + ", Naturaleza: " + naturaleza + ", ¿Atrapado?: " + atrapado + ", Pokebola: " + pokebola;
    }
    
    
}
