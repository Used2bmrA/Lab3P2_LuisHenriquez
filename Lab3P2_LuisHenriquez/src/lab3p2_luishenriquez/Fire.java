package lab3p2_luishenriquez;

public class Fire extends Pokemon {
    protected int potencia;

    public Fire() {
        
    }

    public Fire(int potencia, String nombre, int pokedex, String naturaleza) {
        super(nombre, pokedex, naturaleza);
        this.potencia = potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Potencia de sus llamas: " + potencia;
    }
}
