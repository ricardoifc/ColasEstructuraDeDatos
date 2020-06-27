
import java.util.Scanner;

class Nodo{
    public  int valor;
    public Nodo sgt;

    public Nodo(int valor) {
        this.valor = valor;
        this.sgt = null;
    }
    public Nodo(int valor, Nodo n) {
        this.valor = valor;
        this.sgt = n;
    }
}
public class ListasEnlazadas{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nodo np = null; // inicializo primer nodo
        Nodo nu = np;

        int salir=0, opcion = 0, menu = 0, valor;
        while (menu == 0) {
            imprimirListaEnlazada(np);
            System.out.printf("Escriba la opcion:\n1:nuevo nodos\n2:Eliminar Final\n3:Eliminar Especifico\n4:Salir\n");
            salir = 0;
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (np == null){ // lista vacia se agrega el primer nodo
                        System.out.println("Ingrese primer nodo");
                        np = new Nodo(sc.nextInt());
                        nu = np;
                    }else {// se ingresa el nodo siguente
                        System.out.println("Ingrese un nuevo nodo");
                        valor = sc.nextInt();
                        if (valor > nu.valor) { // si el valor del nodo es menor al nodo anterior no lo agrega
                            nu = nu.sgt = new Nodo(valor);
                        } else {
                            System.out.println("El valor debe ser mayor al ultimo nodo");
                        }
                    }
                    break;
                case 2:
                    np = edliminarOrdenados(np); // se elimina los nodos ordenadamente
                    break;
                case 3:
                    System.out.println("Ingrese el valor de nodo especifico a eliminar");
                    // Envio el valor especifico que quiero eliminar y los nodos
                    np = eliminarEspecifico(sc.nextInt(),np);
                    break;
                case 4:
                    menu = 1; // salir
                    break;
                default:
                    System.out.println("error Ingrese de nuevo");
                    break;
            }
        }
    }
    public static void imprimirListaEnlazada(Nodo np){
        Nodo na = np;

        System.out.println("Nodos-----------------------------");
        while(na != null){ // Imprimpo los nodos de 1 en 1
            System.out.printf("Valor %d \t Nodo = %s \n",na.valor, na);
            na = na.sgt; // avanzo al siguente nodo
        }
        System.out.println("---------------------------------");

    }
    public static Nodo edliminarOrdenados(Nodo na){
        while(na != null){ // eliminacion de nodos de uno en uno
            System.out.printf("Nodo eliminado: %d\n",na.valor);
            na = na.sgt;
        }
        return na; // retorno nodos eliminados
    }

    public static Nodo eliminarEspecifico(int buscar, Nodo nodoOriginal){
        System.out.println("El nodo a eliminar debe ser: " + buscar);
        Nodo npTemp = null; // Inicializo
        Nodo nuTemp = null; // Inicializo
        int c = 1; // Contador para saber si es primer nodo
        while(nodoOriginal != null){
            if (c == 1){ // la primera interaccion para saber que es el primero
                if (buscar == nodoOriginal.valor) { // verifico si es el numero que quiero elminar
                    nodoOriginal = nodoOriginal.sgt; // En el caso que si es el numero paso al siguente nodo
                    npTemp = new Nodo(nodoOriginal.valor); // ahora Segundo nodo es el primer nodo temporal
                    nuTemp = npTemp;
                }else {
                    npTemp = new Nodo(nodoOriginal.valor); // En caso que no sea el que buscamos
                    nuTemp = npTemp;
                }
            }else { // En caso que ya no sea la primera interaccion entra aqui
                if (buscar == nodoOriginal.valor) { // Buscamos si es el nodo a eliminar
                    nodoOriginal = nodoOriginal.sgt; // En caso de que si es saltamos al sioguente nodo
                    nuTemp = nuTemp.sgt = new Nodo(nodoOriginal.valor); // El nodo saltado va a ser el nodo temporal
                }else {
                    nuTemp = nuTemp.sgt = new Nodo(nodoOriginal.valor); // Asignamos en caso de no ser el nodo
                }
            }
            nodoOriginal = nodoOriginal.sgt; // Avanzamos otro nodo mas
            c++; // contado para saltar que no sea primer nodo
        }
        return npTemp; // Retornamos el Nodo Temporal para remplazar los nodos ya existentes
    }
}
