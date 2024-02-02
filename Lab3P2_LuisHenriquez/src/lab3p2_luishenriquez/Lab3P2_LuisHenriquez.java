package lab3p2_luishenriquez;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3P2_LuisHenriquez {

    static Scanner sc = new Scanner (System.in);
    
    public static void main(String[] args) {
        ArrayList<Pokemon> pokedex = new ArrayList();
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
        
    }
    
}
