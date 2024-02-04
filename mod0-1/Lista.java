public class Lista {

    Nodo head,tail;
    int size;

    public Lista(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }


    public boolean isEmpty(){
        return this.size<1;
    }

    public void push(Object ob){
        if (this.isEmpty()){
            Nodo n1 = new Nodo(ob);
            this.tail=n1;
            this.head=n1;
            size++;
        }else {
            Nodo n1 = new Nodo(ob);
            this.tail.next=n1;
            n1.previous=this.tail;
            this.tail=n1;
            size++;

        }

    }
    public Object pop(){
        if (this.isEmpty()){
            return null;
        }
        if(size == 1){
            Nodo n1 = new Nodo(this.head.data);
            this.head.data=null;
            this.tail.data=null;
            size--;
            return n1.data;
        }else{
            Nodo n2 = new Nodo(this.head.data);
            this.head=this.head.next;
            size--;
            return n2.data;
        }
    }

    public Object rear(){
        return this.tail.data;
    }

    public Object front(){
        return this.head.data;
    }

    public int getSize(){
        return this.size;
    }

    public void printList() {
        Nodo n1 = this.head;
        while (n1 != null) {
            System.out.print("  " + n1.data + "  ");
            n1 = n1.next;
        }
        System.out.println("");
    }


    public Object elementAt(int index){
        Nodo n1 = new Nodo("a");
        n1=this.head;
        for(int contador=0;contador<index;contador++){
            n1=n1.next;
        }
        return n1.data;

    }

    public void insert(int i,Object ob){
        Nodo n = new Nodo(ob);
        Nodo n1 = new Nodo("0");
        Nodo aux1 = new Nodo("1");


        if (i==0){
            n.next=this.head;
            this.head=n;
        }else if(i==this.size){
            n.previous=this.tail;
            this.tail.next=n;
            tail=n;
        }else{
            n1=this.head;
            for(int contador=0;contador<i;contador++){
                n1=n1.next;
            }
            n.previous=n1.previous;
            n.next=n1;
            aux1=n1.previous;
            aux1.next=n;

        }
        this.size++;
    }

    public Object remove(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        if (i == 0) {
            Nodo removedNode = this.head;
            this.head = this.head.next;
            this.size--;
            return removedNode.data;
        } else if (i == this.size - 1) {
            Nodo removedNode = this.tail;
            this.tail = this.tail.previous;
            this.tail.next = null;
            this.size--;
            return removedNode.data;
        } else {
            Nodo currentNode = this.head;
            for (int contador = 0; contador < i; contador++) {
                currentNode = currentNode.next;
            }

            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
            this.size--;
            return currentNode.data;
        }
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        System.out.println("A fila está vazia: "+lista.isEmpty());

        lista.push("Obj 1");
        lista.push("Obj 2");
        lista.push("Obj 3");
        lista.push("Obj 4");
        lista.push("Obj 5");
        lista.push("Obj 6");

        lista.insert(2,"inserido manualmente 1");
        lista.insert(4,"inserido manualmente 2");
        lista.insert(0,"inserido no começo");
        lista.insert(9,"inserido no final");

        System.out.println("Imprimindo a lista: ");
        lista.printList();
        System.out.println("O último objeto adicionado é: " + lista.rear());
        System.out.println("O primeiro objeto adicionado é: " + lista.front());
        System.out.println("O tamanho da fila é: " + lista.getSize());
        System.out.println("A fila está vazia: "+lista.isEmpty());

        System.out.println("Elemento 3 = " + lista.elementAt(3));
        System.out.println("Elemento 0 = " + lista.elementAt(0));
        System.out.println("Elemento 5 = " + lista.elementAt(5));

        System.out.println("retirando primeiro objeto: " + lista.remove(0));
        System.out.println("retirando o último objeto: " + lista.remove(8));
        System.out.println("retirando objeto do meio: " + lista.remove(2));



        System.out.println("O tamanho da fila é: " + lista.getSize());
        System.out.println("Imprimindo a lista: ");
        lista.printList();

        /*System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
*/


        System.out.println("A fila está vazia: "+lista.isEmpty());
    }
}
