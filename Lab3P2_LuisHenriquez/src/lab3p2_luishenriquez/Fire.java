package lab3p2_luishenriquez;

public class Fire extends Pokemon {
    int potencia;

    public Fire() {
        
    }

    public Fire(int potencia, String nombre, int pokedex, String naturaleza) {
        super(nombre, pokedex, naturaleza);
        this.potencia = potencia;
    }
}
