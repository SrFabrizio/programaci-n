package esquizo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class TiendaHierba {
    public static String[] hierba = { "Maria Juana", "Hierba de los bosques", "La seta feliz", "El oro verde" };
    public static String[] origen = { "Mexico", "Andorra", "Marruecos", "Palestina" };
    public static double[] precio = { 1.70, 4.20, 2.47, 1.33 };
    public static Scanner scan_n = new Scanner(System.in);
    public static Scanner scan_l = new Scanner(System.in);

    // Variables publicas extra que considereis
    public static void main(String[] args) {
        boolean rep = true;
        boolean merep = true;
        String nombre, lugar;
        double cantidad;
        int res=0;
        ArrayList<Integer> carrito = new ArrayList<Integer>();
        int elecarrito = 0;
        int borrar= 0;
        double total= 0;

        System.out.println("Buenos días! Que quieres hacer hoy?");
        System.out.println("---------------------------------------");
        while (rep== true) {
            System.out.println("Selecciona una opción mediante los números");
            System.out.println("1.)Buscar por nombre");
            System.out.println("2.)Buscar por origen");
            System.out.println("3.)Ordenar por precio de mayor a menor");
            System.out.println("4.)Ordenar por precio de menor a mayor");
            System.out.println("5.)Ver carrito");
            System.out.println("6.)Añadir al carrito");
            System.out.println("7.)Eliminar producto del carrito");
            System.out.println("8.)Finalizar compra");
            System.out.println("9.)Salir");
            // Codigo para seleccionar primer producto
            nombre = "Hierba de los bosques";
            cantidad = 3;
            // Codigo para seleccionar segundo producto
            nombre = "El oro verde";
            cantidad = 1;
            // Codigo para seleccionar tercer producto
            nombre = "La seta feliz";
            cantidad = 2.5;
            System.out.println("Usuario elimina el segundo elemento de su carrito");
            // Codigo para eliminar elemento del carrito
            System.out.println("Usuario finaliza la compra");
            // Codigo para finalizar la compra y que salga el total de la compra

            merep = true;
                while (merep== true) {
                    int elec = scan_n.nextInt();
                    System.out.println();

                    if (elec == 1) {
                        System.out.println("Has elegido: Buscar por nombre");
                        System.err.println();
                        System.err.println();
                        merep =false;
                        buscnomb();
                        System.out.println("");
                    }
                    else if (elec == 2) {
                        System.out.println("Has elegido: Buscar por origen");
                        System.err.println();
                        System.err.println();
                        merep =false;
                        buscori();
                        System.out.println("");
                    }
                    else if (elec == 3) {
                        System.out.println("Has elegido: Ordenar por precio de mayor a menor");
                        System.err.println();
                        System.err.println();
                        merep =false;
                        mayamen(precio);
                    }
                    else if (elec == 4) {
                        System.out.println("Has elegido: Ordenar por precio de menor a mayor");
                        System.err.println();
                        System.err.println();
                        merep =false;
                        menamay(precio);
                    }
                    else if (elec == 5) {
                        System.out.println("Has elegido: Ver carrito ");
                        System.err.println();
                        System.err.println();
                        merep =false;
                        for(int i = 0; i < carrito.size(); i++){
                            System.out.println(i + 1 + ". " + hierba[carrito.get(i)] + " desde " + origen[carrito.get(i)] + ": " + precio[carrito.get(i)] + "€");
                        }
                    }
                    else if (elec == 6) {
                        System.out.println("Has elegido: Añadir al carrito");
                        System.err.println();
                        System.err.println();
                        merep =false;
                        res=selec();
                        carrito.add(res);
                    }
                    else if (elec == 7) {
                        System.out.println("Has elegido: Eliminar producto del carrito");
                        merep =false;
                        for(int i = 0; i < carrito.size(); i++){
                            System.out.println(i + 1 + ". " + hierba[carrito.get(i)] + ": " + precio[carrito.get(i)] + "€");
                        }
                        borrar=elicarr();
                        carrito.remove(borrar);
                    }
                    else if (elec == 8) {
                        System.out.println("Has elegido: Finalizar compra ");
                        System.err.println();
                        System.err.println();
                        merep =false;
                        System.out.println("Tu carrito:");
                        for(int i = 0; i < carrito.size(); i++){
                            System.out.println(i + 1 + ". " + hierba[carrito.get(i)] + ": " + precio[carrito.get(i)] + "€");
                            total= total + precio[carrito.get(i)];
                        }
                        System.out.println("EL total es de: " + total);
                        System.out.println("Inserte su numero de tarjeta para validar su compra");
                        String caching=scan_l.nextLine();
                        System.out.println("Gracias por comprar con nostros, todo el dinero de la cuenta " + caching + " ha sido drenado");
                        rep=false;
                    }
                    else if (elec == 9) {
                        System.out.println("Has elegido: Salir ");
                        System.err.println();
                        System.err.println();
                        merep =false;
                        System.out.println("Saludos");
                        rep=false;
                    }
                    else {
                        System.out.println("Ha de ser un número del 1 al 9");
                    }
            }
        }
    }



    //Funciones extra que considereis necesarias

    public static void buscnomb() {
        String resul="";
        String pala="";
        String pali="";
        int coin=0;
        System.out.println("¿Qué quieres buscar?");
        String busco= scan_l.nextLine();
        for (int vu=0; vu<hierba.length; vu++) {
            pala=hierba[vu];
            pali=pala.toLowerCase();
            if (pali.contains(busco)) {
                if(resul=="") {
                    resul=pala;
                }
                else {
                    resul=resul + (", ") + pala;
                }
            }
        }
        System.out.println("Resultados: " + resul);
        System.err.println();
        System.err.println();
        System.err.println();
    }

    public static void buscori() {
        String resul="";
        String pala="";
        String pali="";
        int coin=0;
        System.out.println("¿Qué quieres buscar?");
        String busco= scan_l.nextLine();
        for (int vu=0; vu<origen.length; vu++) {
            pala=origen[vu];
            pali=pala.toLowerCase();
            if (pali.contains(busco)) {
                if(resul=="") {
                    resul=pala;
                }
                else {
                    resul=resul + (", ") + pala;
                }
            }
        }
        System.out.println("Resultados: " + resul);
        System.err.println();
        System.err.println();
        System.err.println();
    }

    public static void mayamen(double[]precio) {
        double[] a = new double[precio.length];

        for (int i = 0; i < a.length; i++) {
            a[i] = precio[i];
        }
        Scanner scan_n = new Scanner(System.in);
        Scanner scan_l = new Scanner(System.in);

        double menor;
        int [] orden = new int[hierba.length];
        
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length ; j++) {
                if (a[j]>a[i]){
                    double au = a[j];
                    a[j] = a[i];
                    a[i] = au;
                }
            }
        }
        
        for(int i = 0; i < a.length; i++){
            for(int e = 0; e < precio.length; e++){
                if (a[i]==precio[e]) {
                    orden[i]=e;
                }
            }
        }
        
        for(int i = 0; i < a.length; i++){
            System.out.println(hierba[orden[i]] + ": " + precio[orden[i]] + "€");
        }
        
        System.out.println();
        System.err.println();
        System.err.println();
        System.err.println();
    }

    public static void menamay(double[]precio) {
    double[] a = new double[precio.length];

    for (int i = 0; i < a.length; i++) {
        a[i] = precio[i];
    }
    Scanner scan_n = new Scanner(System.in);
    Scanner scan_l = new Scanner(System.in);

    double menor;
    int [] orden = new int[hierba.length];
    
    for (int i = 0; i < a.length-1; i++) {
        for (int j = i+1; j < a.length ; j++) {
            if (a[j]<a[i]){
                double au = a[j];
                a[j] = a[i];
                a[i] = au;
            }
        }
    }
    
    for(int i = 0; i < a.length; i++){
        for(int e = 0; e < precio.length; e++){
            if (a[i]==precio[e]) {
                orden[i]=e;
            }
        }
    }
    
    for(int i = 0; i < a.length; i++){
        System.out.println(hierba[orden[i]] + ": " + precio[orden[i]] + "€");
    }
    
    System.out.println();
    System.err.println();
    System.err.println();
    System.err.println();
    }
    public static int selec() {
        int respuesta=0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        String pala="";
        String pali="";
        int coin=0;
        System.out.println("¿Cual quieres seleccionar?");
        String busco= scan_l.nextLine();
        for (int vu=0; vu<hierba.length; vu++) {
            pala=hierba[vu];
            pali=pala.toLowerCase();
            if (pali.contains(busco)) {
                a.add(vu);
            }
        }

        System.out.println("Selecciona el producto que quieres comprar mediante los números");
        for(int i = 0; i < a.size(); i++){
            System.out.println(i + 1 + ". " + hierba[a.get(i)]);
        }
        int ele=scan_n.nextInt() -1;
        respuesta = a.get(ele);
        System.out.println("Se ha añadido al carrito: " + hierba[respuesta]);
        System.err.println();
        System.err.println();
        System.err.println();
        return respuesta;
    }

    public static int elicarr() {
        System.out.println("Selecciona el producto que quieres eliminar del carrito mediante los números");
        int eleccion = scan_n.nextInt() -1;
        return eleccion;
    }
}
