import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CodigoMorse {

    private static final Map<Character, String> MORSE_ALFABETO = new HashMap<>();
    private static final Map<String, Character> ALFABETO_MORSE = new HashMap<>();

    static {
        MORSE_ALFABETO.put('a', ".-");
        MORSE_ALFABETO.put('b', "-...");
        MORSE_ALFABETO.put('c', "-.-.");
        MORSE_ALFABETO.put('d', "-..");
        MORSE_ALFABETO.put('e', ".");
        MORSE_ALFABETO.put('f', "..-.");
        MORSE_ALFABETO.put('g', "--.");
        MORSE_ALFABETO.put('h', "....");
        MORSE_ALFABETO.put('i', "..");
        MORSE_ALFABETO.put('j', ".---");
        MORSE_ALFABETO.put('k', "-.-");
        MORSE_ALFABETO.put('l', ".-..");
        MORSE_ALFABETO.put('m', "--");
        MORSE_ALFABETO.put('n', "-.");
        MORSE_ALFABETO.put('ñ', "--.--");
        MORSE_ALFABETO.put('o', "---");
        MORSE_ALFABETO.put('p', ".--.");
        MORSE_ALFABETO.put('q', "--.-");
        MORSE_ALFABETO.put('r', ".-.");
        MORSE_ALFABETO.put('s', "...");
        MORSE_ALFABETO.put('t', "-");
        MORSE_ALFABETO.put('u', "..-");
        MORSE_ALFABETO.put('v', "...-");
        MORSE_ALFABETO.put('w', ".--");
        MORSE_ALFABETO.put('x', "-..-");
        MORSE_ALFABETO.put('y', "-.--");
        MORSE_ALFABETO.put('z', "--..");

        ALFABETO_MORSE.putAll(MORSE_ALFABETO.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Convertir de texto a código Morse");
        System.out.println("2. Convertir de código Morse a texto");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                convertirTextoAMorse(scanner);
                break;
            case 2:
                convertirMorseATexto(scanner);
                break;
            default:
                System.out.println("Opción no válida");
        }
     scanner.close();
}

    private static void convertirTextoAMorse(Scanner scanner) {
        System.out.print("Ingrese el texto a convertir: ");
        scanner.nextLine(); // Consumir el salto de línea pendiente
        String texto = scanner.nextLine().toLowerCase(); // Usar nextLine() para leer la línea completa

        StringBuilder codigoMorse = new StringBuilder();
        for (char letra : texto.toCharArray()) {
            if (letra == ' ') {
                codigoMorse.append(" "); // Agregar espacio para separar palabras
            } else if (MORSE_ALFABETO.containsKey(letra)) {
                codigoMorse.append(MORSE_ALFABETO.get(letra)).append(" ");
            } else {
                codigoMorse.append(letra).append(" "); // Mantener caracteres no definidos como están
            }
        }

        System.out.println("Código Morse: " + codigoMorse);
    }

    private static void convertirMorseATexto(Scanner scanner) {
        System.out.print("Ingrese el código Morse a convertir: ");
        scanner.nextLine();
        String codigoMorse = scanner.nextLine().trim().toLowerCase();
    
        StringBuilder texto = new StringBuilder();
        for (String palabraMorse : codigoMorse.split("   ")) {
            for (String codigo : palabraMorse.split(" ")) { 
                Character letra = ALFABETO_MORSE.get(codigo);
                if (letra != null) {
                    texto.append(letra);
                } else {
                    texto.append(" "); 
                }
            }
            texto.append(" "); 
        }
    
        System.out.println("Texto: " + texto.toString());
    }
      }     
