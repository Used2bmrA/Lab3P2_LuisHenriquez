package lab3p2_luishenriquez;

public class Pokeball {
    protected String color;
    protected int numSerie;
    protected int eficiencia;

    public Pokeball(String color, int numSerie, int eficiencia) {
        this.color = color;
        this.numSerie = numSerie;
        this.eficiencia = eficiencia;
    }

    @Override
    public String toString() {
        return "Color: " + color + ", Número de serie: " + numSerie + ", Eficiencia=" + eficiencia;
    }
}
