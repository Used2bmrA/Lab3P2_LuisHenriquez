package lab3p2_luishenriquez;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3P2_LuisHenriquez {

    static Scanner sc = new Scanner(System.in);
    static SecureRandom sr = new SecureRandom();
    static ArrayList<Pokemon> pokedex = new ArrayList();
    static ArrayList<Pokeball> ballsack = new ArrayList();
    
    public static void main(String[] args) {
        Fire charmander = new Fire(55, "Charmander", 007, "Tímida");
        Water squirtle = new Water(true, 50, "Squirtle", 004, "Tímido");
        Grass lechuga = new Grass("jungla", 50, "Bulbasaur", 001, "Extrovertido");
        pokedex.add(charmander);
        pokedex.add(lechuga);
        pokedex.add(squirtle);
        
        Pokeball nueva = new Pokeball("Rojo", 1, 3);
        Pokeball nueva2 = new Pokeball("Rojo", 2, 3);
        Pokeball nueva3 = new Pokeball("Rojo", 3, 3);
        Pokeball nueva4 = new Pokeball("Rojo", 4, 1);
        Pokeball nueva5 = new Pokeball("Rojo", 5, 1);
        ballsack.add(nueva);
        ballsack.add(nueva2);
        ballsack.add(nueva3);
        ballsack.add(nueva4);
        ballsack.add(nueva5);
        
        System.out.println("Gotta catch 'em all!");
        int op = 0;
        
        do {
            System.out.println("**** POKEMENÚ PRINCIPAL****\n"
                    + "Elija una opción:\n"
                    + "1. Crear Pokemón\n"
                    + "2. Crear Pokebola\n"
                    + "3. Listar Pokemón\n"
                    + "4. Eliminar Pokemón (los Pokemón no se eliminan, solo se desmayan)\n"
                    + "5. Capturar Pokemón\n"
                    + "6. Modificar Pokemón\n"
                    + "7. Salir");
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1: //Crear pokemon
                    Pokemon nuevoPokemon = CrearPokemon(); //Solicita al usuario la información del pokemón
                    pokedex.add(nuevoPokemon);
                    
                    break;
                case 2: //Crear pokebola
                    Pokeball nuevaPokebola = CrearPokebola();
                    ballsack.add(nuevaPokebola);
                    
                    break;
                case 3: //Listar
                    ListarPokemon(); //Lista los pokemón
                    
                    break;
                case 4: //Eliminar
                    int choice;
                    int thisOne;
                    Pokemon aEliminar;
                    
                    ArrayList<Pokemon> choppingBlock = new ArrayList();
                    
                    do {
                        System.out.println("¿Qué tipo Pokemón desea eliminar?\n"
                                + "1. Fuego\n"
                                + "2. Agua\n"
                                + "3. Hierba");
                        choice = sc.nextInt();
                        sc.nextLine();
                    } while (choice != 1 && choice != 2 && choice != 3);
                    
                    System.out.println("¿Cuál de los siguientes pokemon desea eliminar?");
                    choppingBlock = ListarPokemonPorTipo(choice);
                    thisOne = sc.nextInt() - 1;
                    sc.nextLine();
                    
                    for (int i = 0; i < pokedex.size(); i++) {
                        if (pokedex.get(i).equals(choppingBlock.get(thisOne))) {
                            pokedex.remove(i);
                        }
                    }
                    
                    break;
                case 5: //Capturar
                    int pokeballChoice;
                    Pokemon encounter;
                    Pokeball ball;
                    int accion;
                    int requiredToCatch;

                    encounter = PokemonRandom();

                    if (ballsack.isEmpty()) {
                        System.out.println("You do not have the balls to catch that pokemon.");
                    } else {
                        int cont = 0;
                        for (int i = 0; i < pokedex.size(); i++) {
                            if (pokedex.get(i).isAtrapado()) {
                                cont++;
                            }
                        }
                        if (pokedex.size() == cont) {
                            System.out.println("There's nothing left to do here!\n");
                        } else {
                            do {
                                System.out.println("¿Desea intentar capturarlo?\n"
                                        + "1. Sí\n"
                                        + "2. Huir (fijo es un Zubat)");
                                accion = sc.nextInt();
                                sc.nextLine();

                                switch (accion) {
                                    case 1:
                                        System.out.println("¿Qué pokebola desea usar?");
                                        ListarPokebola();
                                        pokeballChoice = sc.nextInt() - 1;
                                        Pokeball aUtilizar = ballsack.get(pokeballChoice);

                                        if (aUtilizar.getEficiencia() == 3) { //Eficiencia 3 de 3
                                            System.out.println("¡Has caputrado a " + encounter.getNombre() + "!\n");
                                            encounter.setPokebola(aUtilizar);
                                            encounter.setAtrapado(true);
                                            ballsack.remove(aUtilizar);
                                        } else if (aUtilizar.getEficiencia() != 3) { //Eficiencia 1 y 2 de 3
                                            requiredToCatch = sr.nextInt(1, 4);
                                            if (aUtilizar.getEficiencia() >= requiredToCatch) {
                                                System.out.println("¡Has caputrado a " + encounter.getNombre() + "!\n");
                                                encounter.setPokebola(aUtilizar);
                                                encounter.setAtrapado(true);
                                            } else {
                                                System.out.println(encounter.getNombre()
                                                        + " ha escapado. You could not, in fact, catch them all.");
                                            }
                                            ballsack.remove(aUtilizar);
                                        }

                                        break;
                                    case 2:
                                        System.out.println("You run back to your mommy...\n");
                                        break;
                                    default:
                                        System.out.println("Opción invalida, intente otra vez.\n");
                                }
                            } while (accion != 1 && accion != 2);
                        }
                    }
                    
                    break;
                case 6: //Modificar
                    
                    
                    break;
                case 7: //Salir
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción invalida, intente otra vez.");
            }
        } while (op != 7);
    }

    private static Pokemon CrearPokemon() {
        int choice;
        String nombre;
        int pokedexCode;
        String naturaleza = "";
        int seleccionNaturaleza = 0;

        Pokemon nuevoPokemon = new Pokemon();
        System.out.println("Ingrese el nombre del pokemón:");
        nombre = sc.nextLine();

        System.out.println("Ingrese el código del pokedex:");
        pokedexCode = sc.nextInt();
        sc.nextLine();

        do {
            System.out.println("El pokemon es de naturaleza _____:\n"
                    + "1. Tímido\n"
                    + "2. Energético\n"
                    + "3. Misterioso");
            seleccionNaturaleza = sc.nextInt();
            sc.nextLine();

            switch (seleccionNaturaleza) {
                case 1:
                    naturaleza = "Tímido";
                    break;
                case 2:
                    naturaleza = "Energético";
                    break;
                case 3:
                    naturaleza = "Misterioso";
                    break;
                default:
                    System.out.println("Opción invalida, intente otra vez.");
            }
        } while (seleccionNaturaleza != 1 && seleccionNaturaleza != 2 && seleccionNaturaleza != 3);

        do {
            System.out.println("¿De qué tipo es el nuevo pokemón?\n"
                    + "1. Fuego\n"
                    + "2. Agua\n"
                    + "3. Hierba");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    int potencia;
                    System.out.println("¿Cuál es la potencia de sus llamas?");
                    potencia = sc.nextInt();
                    sc.nextLine();
                    
                    Fire nuevoFire = new Fire(potencia, nombre, pokedexCode, naturaleza);
                    nuevoPokemon = nuevoFire;
                    break;
                case 2:
                    boolean anfibio = false;
                    int anfibioChoice = 0;
                    int rapidez;
                    
                    do {
                        System.out.println("¿El pokemón puede vivir fuera del agua?\n"
                                + "1. Sí\n"
                                + "2. No");
                        anfibioChoice = sc.nextInt();
                        switch (anfibioChoice) {
                            case 1:
                                anfibio = true;
                                break;
                            case 2:
                                anfibio = false;
                                break;
                            default:
                                System.out.println("Opción invalida, intente otra vez.");
                        }
                        
                    } while (anfibioChoice != 1 && anfibioChoice != 2);
                    
                    System.out.println("¿Con qué rapidez nada el pokemón?");
                    rapidez = sc.nextInt();
                    
                    Water nuevoWater = new Water(anfibio, rapidez, nombre, pokedexCode, naturaleza);
                    nuevoPokemon = nuevoWater;
                    break;
                case 3:
                    String habitat;
                    int dominioVegetal;
                    
                    System.out.println("¿En qué habitat vive este Pokemón?");
                    habitat = sc.nextLine();
                    
                    do {
                        System.out.println("¿Qué nivel de dominio tiene sobre las plantas?");
                        dominioVegetal = sc.nextInt();
                        sc.nextLine();
                    } while (dominioVegetal < 1 || dominioVegetal > 100);
                    
                    Grass nuevoGrass = new Grass(habitat, dominioVegetal, nombre, pokedexCode, naturaleza);
                    nuevoPokemon = nuevoGrass;
                    break;
                default:
                    System.out.println("Opción invalida, intente otra vez.");
                    break;
            }
        } while (choice != 1 && choice != 2 && choice != 3);
        
        return nuevoPokemon;
    }

    private static void ListarPokemon() {
        String resultado = "";
        int conteo = 1;
        for (int i = 0; i < pokedex.size(); i++) {
            if (pokedex.get(i) instanceof Fire) {
                resultado += conteo + ". " + pokedex.get(i).toString()+"\n";
            } else if (pokedex.get(i) instanceof Water) {
                resultado += conteo + ". " + pokedex.get(i).toString()+"\n";
            } else {
                resultado += conteo + ". " + pokedex.get(i).toString()+"\n";
            }
            conteo++;
        }
        
        System.out.println(resultado);
    }

    private static Pokeball CrearPokebola() {
        String color;
        int numSerie;
        int eficiencia;
        
        System.out.println("¿De qué color es la pokebola?");
        color = sc.nextLine();
        
        System.out.println("Ingrese el número de serie de la pokebola:");
        numSerie = sc.nextInt();
        sc.nextLine();
        
        do {
            System.out.println("¿Qué eficiencia tiene la pokebola?");
            eficiencia = sc.nextInt();
            sc.nextLine();
        } while (eficiencia < 1 || eficiencia > 3);
        
        return new Pokeball(color, numSerie, eficiencia);
    }

    private static ArrayList<Pokemon> ListarPokemonPorTipo(int choice) {
        ArrayList<Pokemon> choppingBlock = new ArrayList();
        String resultado = "";
        int conteo = 1;
        
        switch (choice) {
            case 1:
                for (int i = 0; i < pokedex.size(); i++) {
                    if (pokedex.get(i) instanceof Fire) {
                        resultado += conteo + ". " + pokedex.get(i).toString() + "\n";
                        choppingBlock.add(pokedex.get(i));
                        conteo++;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < pokedex.size(); i++) {
                    if (pokedex.get(i) instanceof Water) {
                        resultado += conteo + ". " + pokedex.get(i).toString() + "\n";
                        choppingBlock.add(pokedex.get(i));
                        conteo++;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < pokedex.size(); i++) {
                    if (pokedex.get(i) instanceof Grass) {
                        resultado += conteo + ". " + pokedex.get(i).toString() + "\n";
                        choppingBlock.add(pokedex.get(i));
                        conteo++;
                    }
                }
                break;
            default:
        }
        
        System.out.println(resultado);
        return choppingBlock;
    }

    private static void ListarPokebola() {
        int conteo = 1;
        for (int i = 0; i < ballsack.size(); i++) {
            System.out.println(conteo + ". " + ballsack.get(i).toString());
            conteo++;
        }
    }

    private static Pokemon PokemonRandom() {
        int cont = 0;
        
        for (int i = 0; i < pokedex.size(); i++) {
            if (pokedex.get(i).isAtrapado()) {
                cont ++;
            }
        }
        
        if (pokedex.size() == cont) {
            System.out.println("You have caught them all!");
        } else {
            Pokemon encounter = pokedex.get(sr.nextInt(0, pokedex.size()));

            while (encounter.isAtrapado()) {
                encounter = pokedex.get(sr.nextInt(0, pokedex.size()));
            }

            System.out.println("¡El pokemón " + encounter.getNombre() + " ha aparecido!");

            return encounter;
        }
        
        return null;
    }
    
}
