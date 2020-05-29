package cola;

/**
 *
 * @author ricardoifc
 */
public class Cola {
    public void encolar(Object dato){
        insertarUltimo(dato);
    }
    public Object desencolar(){
        Object dato = getElementos()[0];
        eliminarPrimero();
        return dato;
    }
    public Object frente(){
        return getElementos()[0];
    }
    public int size(){
        return getTamaño();
    }
    public Object[] getElementos(){
        return getElementos1();
    }
    // Creamos dos Nodos, que seran el primero y el ultimo nodo de nuestra lista
    private Nodo primero,ultimo;
    // Variable que llevara el tamaño de la lista
    private int tamaño;
    // La función que inserta un dato al principio de la lista, recibe como parámetro el dato a insertar
    public void insertarUltimo(Object valor){
        if(tamaño == 0){
            primero = new Nodo(valor,null); // Nodo
            ultimo = primero;
            tamaño++;
        }
        else{
            Nodo temporal = ultimo;
            ultimo = new Nodo(valor, null); // Nodo
            temporal.setSiguiente(ultimo); // Nodo
            tamaño++;
        }
    }

    // Funcion que elimina el primer nodo de la lista

    public void eliminarPrimero(){
        if(tamaño == 0)return;
        Nodo temporal = primero;
        temporal = primero.getSiguiente();
        primero = null;
        primero = temporal;
        tamaño--;
    }
    public int getTamaño(){
        return tamaño;
    }

    // Funcion que devuelve un array con los elementos de la lista
    public Object[] getElementos1(){
        if(tamaño == 0)return new Object[0];
        Object[] elementos = new Object[tamaño];
        int i = 0;
        Nodo temporal = primero;
        while(temporal != null){
            System.out.print(temporal.getValor().toString()+"  ");
            elementos[i++] = temporal.getValor();
            temporal = temporal.getSiguiente();
        }
        System.out.println("");
        return elementos;
    }
}
