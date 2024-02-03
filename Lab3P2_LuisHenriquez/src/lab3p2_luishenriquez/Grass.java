package lab3p2_luishenriquez;

public class Grass extends Pokemon{
    protected String habitat;
    protected int dominioVegetal;

    public Grass(String habitat, int dominioVegetal, String nombre, int pokedex, String naturaleza) {
        super(nombre, pokedex, naturaleza);
        this.habitat = habitat;
        this.dominioVegetal = dominioVegetal;
    }

    @Override
    public String toString() {
        return super.toString() +  ", Habitat: " + habitat + ", Dominio sobre las plantas: " + dominioVegetal;
    }
    
    
}
