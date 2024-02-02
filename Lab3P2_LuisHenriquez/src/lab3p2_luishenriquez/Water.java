package lab3p2_luishenriquez;

public class Water extends Pokemon {
    boolean anfibio;
    int swimSpeed;

    public Water(boolean anfibio, int swimSpeed, String nombre, int pokedex, String naturaleza) {
        super(nombre, pokedex, naturaleza);
        this.anfibio = anfibio;
        this.swimSpeed = swimSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", ¿Anfibio?: " + anfibio + ", Rapidez al nadar: " + swimSpeed;
    }
    
    
}
