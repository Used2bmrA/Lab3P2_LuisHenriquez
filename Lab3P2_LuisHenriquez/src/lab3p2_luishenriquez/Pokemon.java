package lab3p2_luishenriquez;

public class Pokemon {
    protected String nombre;
    protected int pokedexCode;
    protected String naturaleza;
    protected boolean atrapado;
    protected Pokeball pokebola;

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

    public Pokeball getPokebola() {
        return pokebola;
    }

    public void setPokebola(Pokeball pokebola) {
        this.pokebola = pokebola;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Código en la Pokedex: " + pokedexCode + ", Naturaleza: " + naturaleza + ", ¿Atrapado?: " + atrapado + ", Pokebola: " + pokebola;
    }
    
    
}
