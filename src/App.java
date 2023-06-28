import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Utilitario.Utility;

public class App {
    static int jjCedula = 1725474447;
    static String jjNombre = "jasmanny david jumbo cordones";
    static String jjCorreo = "JASMANNY.JUMBO@EPN.EDU.EC";
    public static String jjusuario;
    
    public static void main (String[] args) throws Exception {
        Utility.clear();
        System.out.println("\033[0;34m"+"\n-CEDULA: " + jjCedula);
        System.out.println("\033[0;34m"+"-CORREO: " + jjCorreo);
        System.out.println("\033[0;34m"+"-NOMBRE: " + jjNombre);


        App jjAp = new App();
        jjAp.jjLoginDavid();       
        Menu();
            
            // jjShowAsignaturas("src\\Horarios\\202110105-CHUNCHO JIMENEZ ANGEL DAVID.csv");

        // muestraContenido("src\\Horarios\\202110105-CHUNCHO JIMENEZ ANGEL DAVID.csv");
    }

    /**
    * Realiza la autenticacion de usuarios utilizando un nombre de usuario y contraseùa.
    * @return true si la autenticacion es exitosa, false si se agotan los intentos o si la autenticaciùn falla.
    */
    public boolean jjLoginDavid() {
        HashMap<String, String> usuarios = new HashMap<>();
        usuarios.put("jasmanny.jumbo@epn.edu.ec", "1725474447");
        usuarios.put("profe", "1234");

        System.out.println("\n------------------------------------");
        System.out.println("CARGA HORARIA DE ALUMNO");
        System.out.println("------------------------------------");

        java.io.Console console = System.console();
        int jjintentos = 3;

        while (jjintentos > 0) {
            System.out.println("\n\t----------------------");
            System.out.print("\tIngrese su usuario: ");

            jjusuario = console.readLine();

            System.out.print("\tIngrese su contrasena: ");
            char[] claveArray = System.console().readPassword();


            String clave = new String(claveArray);
            System.out.print("\n\t----------------------");


            if (usuarios.containsKey(jjusuario) && usuarios.get(jjusuario).equals(clave)) {
                System.out.println("\nBienvenido " + jjusuario.toUpperCase() + "!");
                return true;
            }

            jjintentos--;
            System.out.println("\nUsuario y clave incorrectos. Intentos restantes: " + jjintentos);
        }
        
        return false;
        
    }


public static void Menu() {
    int jjOpcion;
    Utility.clear();
    Scanner scanner = new Scanner(System.in);
    
    do {
        System.out.println("\n--------------------------");
        System.out.println("Carga Horaria de <Alumnos>");
        System.out.println("--------------------------");
        
        System.out.println("Usuario: " + jjusuario);

        System.out.println("1. Visualizar Alumnos");
        System.out.println("2. Visualizar Asignaturas");
        System.out.println("3. Visualizar Horario");
        System.out.println("4. Visualizar Horario de una asignatura");
        System.out.println("0. SALIR");
        System.out.print("Ingrese su opcion: ");
        jjOpcion = scanner.nextInt();

        switch (jjOpcion) {
            case 1:
                System.out.println("\n[+] Listado de << Alumnos >> :");
                System.out.println("- 202110105-CHUNCHO JIMENEZ ANGEL DAVID");
                System.out.println("- 202111083-HIDALGO CRUZ PABLO ESTEBAN");
                System.out.println("- 202120757-ALEMAN OSORIO CARLOS ALEJANDRO");
                break;
            case 2:
                System.out.println("\n\033[0;36m[+] Listado de << tema-asignado>> :\r");
                System.out.println(" - ICCD323-GRLSW SISTEMAS OPERATIVOS SISTEMAS OPERATIVOS\r");
                System.out.println(" - ICCD343-GR1SW CONTACTO CON LA M\u00DASICA\r");
                System.out.println(" - ICCD343-GR1SW ARQUITECTURA DE COMPUTADORES\r");
                System.out.println(" - MATD223-GR4SW PROBABILIDAD Y ESTADISTiCA BASICAS\r");
                System.out.println(" - CSHD3BL-A3 FUNDAMENTOS DE REDES Y CONECTIVIDAD\r");
                System.out.println(" - ICCD353-GR1SW FUNDAMENTOS DE REDES Y CONECTIVIDAD\r");
                break;
            case 3:
                System.out.println();
                break;
            case 4:
                System.out.println();
                break;
            case 5:
                System.out.println("\033[0;36mSALIR");
                break;
            default:
                System.out.println();
                break;
        }

        System.out.println();
    } while (jjOpcion > 5);

    scanner.close();
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
