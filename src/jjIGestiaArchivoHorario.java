import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public interface jjIGestiaArchivoHorario {
    static void jjReadHorariosAlumnos(String archivo) throws FileNotFoundException, IOException { 
	ArrayList<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] fila = linea.split(";");
            datos.add(fila);
        }
    } 
    }

    public static void jjShowAlumnos(String nombreArchivo) {
    int extensionIndex = nombreArchivo.lastIndexOf('.');
    if (extensionIndex != -1) {
        String nombreSinExtension = nombreArchivo.substring(0, extensionIndex);
        System.out.println("Nombre del archivo sin extensión: " + nombreSinExtension);
    } else {
        System.out.println("El archivo no tiene extensión.");
    }
}

public static void jjShowAsignaturas (String archivo) throws FileNotFoundException, IOException  {
        ArrayList<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] fila = linea.split(";");
                if (fila.length > 2) {
                    String[] nuevaFila = new String[1];
                    nuevaFila[0] = fila[2];
                    datos.add(nuevaFila);
                }
            }
        }
    }
}