package lab3p2_luishenriquez;

public class Grass extends Pokemon{
    String habitat;
    int dominioVegetal;

    public Grass(String habitat, int dominioVegetal, String nombre, int pokedex, String naturaleza) {
        super(nombre, pokedex, naturaleza);
        this.habitat = habitat;
        this.dominioVegetal = dominioVegetal;
    }
}
