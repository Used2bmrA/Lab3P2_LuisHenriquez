package lab3p2_luishenriquez;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3P2_LuisHenriquez {

    static Scanner sc = new Scanner (System.in);
    
    public static void main(String[] args) {
        ArrayList<Pokemon> pokedex = new ArrayList();
        ArrayList<Pokeball> bag = new ArrayList();
        System.out.println("Gotta catch 'em all!");
        int op = 0;
        
        do {
            System.out.println("**** POKEMENÚ PRINCIPAL****\n"
                    + "Elija una opción:\n"
                    + "1. Crear Pokemón\n"
                    + "2. Crear Pokebola\n"
                    + "3. Listar Pokemón\n"
                    + "4. Eliminar Pokemón (los Pokemón no se eliminan, solo se desmayan\n"
                    + "5. Modificar Pokemón\n"
                    + "6. Salir\n");
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1: //Crear pokemon
                    Pokemon nuevoPokemon = CrearPokemon(); //Solicita al usuario la información del pokemón
                    pokedex.add(nuevoPokemon);
                    
                    break;
                case 2: //Crear pokebola
                    
                    break;
                case 3: //Listar
                    
                    break;
                case 4: //Eliminar
                    
                    break;
                case 5: //Modificar
                    
                    break;
                case 6: //Salir
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción invalida, intente otra vez.");
            }
        } while (op != 6);
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
                case 3:
                    String habitat;
                    int dominioVegetal;
                    
                    System.out.println("¿En qué habitat vive este Pokemón?");
                    habitat = sc.nextLine();
                    
                    System.out.println("¿Qué nivel de dominio tiene sobre las plantas?");
                    dominioVegetal = sc.nextInt();
                    
                    Grass nuevoGrass = new Grass(habitat, dominioVegetal, nombre, pokedexCode, naturaleza);
                    nuevoPokemon = nuevoGrass;
                default:
                    System.out.println("Opción invalida, intente otra vez.");
                    break;
            }
        } while (choice != 1 && choice != 2 && choice != 3);
        
        return nuevoPokemon;
    }
    
}
