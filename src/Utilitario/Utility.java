package Utilitario;

import java.util.Scanner;

public class Utility {

    /**Pide un número
     * @param mensage
     * @return
     * verifica si el numero es positivo y lo guarda
     */
    public static int getNumeroPositivo(String mensage) {
        int numero;
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensage);
        do {
            numero = scanner.nextInt();  
        } while (numero <= 0);
        return numero;
    }

    /**
     * Limpia la consola
     */
    public static final void clear(){
        try {
            String operatingSystem = System.getProperty("os.name");     //Check the current operating system
            if(operatingSystem.contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch(Exception e){
            System.out.println(e);
        }
    }


    /**De acuerdo al tamaño deseado
     * @param sizeBarra
     * @throws InterruptedException
     * Crea una barra de carga según el tiempo que se requiera
     */
    public static void showloadingBarra(int sizeBarra) throws InterruptedException {
        int delay = 50;
    char[] barra = new char[sizeBarra];
    float pocentaje = (float)100/(float)sizeBarra;
    for(int i = 0; i < sizeBarra; i++)
        barra[i]=' ';
    for(int i = 0; i <= sizeBarra; i++) {
        if(i< (sizeBarra-1))
            barra[i]='=';
        StringBuilder sbBarra = new StringBuilder("").append(barra);
        System.out.print(String.format("\r[%s] %3.0f %%", sbBarra, i*pocentaje));
        Thread.sleep(delay);
    }
    System.out.println("");
    }

}
