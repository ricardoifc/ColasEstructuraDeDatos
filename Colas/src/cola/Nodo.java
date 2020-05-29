
package cola;

/**
 *
 * @author ricardoifc
 */
public class Nodo {

    //Datos que guardara el Nodo
    private Object valor;
    //Referencia al nodo siguiente
    private Nodo siguiente;
    //Constructor. Recibe el dato a guardar y el nodo siguiente
    public Nodo(Object val, Nodo sig){
        this.valor = val;
        this.siguiente = sig;
    }
    //Get para tomar y cambiar valores.
    public Object getValor() {
        return valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
