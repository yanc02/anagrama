import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void printAnagramCombinations(String filePath) {
        // Crear un mapa para almacenar los anagramas encontrados
        Map<String, List<String>> anagramMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Limpiar la palabra actual eliminando espacios en blanco y convirtiéndola a minúsculas
                String word = line.trim().toLowerCase();

                // Generar una clave ordenada para el mapa utilizando los caracteres de la palabra
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                // Verificar si la clave ya existe en el mapa y agregar la palabra correspondiente
                if (!anagramMap.containsKey(key)) {
                    anagramMap.put(key, new ArrayList<>());
                }
                anagramMap.get(key).add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir las combinaciones de anagramas encontrados
        for (List<String> anagramList : anagramMap.values()) {
            if (anagramList.size() > 2) {
                System.out.println(anagramList);
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "wordlist.txt"; // Ruta del archivo que contiene las palabras
        printAnagramCombinations(filePath);
        System.out.println("hola mundo");
    }
}
