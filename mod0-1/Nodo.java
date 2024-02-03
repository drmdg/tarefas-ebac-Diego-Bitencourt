public class Nodo {
    Object data;
    Nodo next,previous;

    public Nodo(Object ob) {
        this.data = ob;
        this.next = null;
        this.previous=null;
    }
}