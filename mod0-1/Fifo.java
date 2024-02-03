public class Fifo {

    Nodo head,tail;
    int size;

    public Fifo(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }


    public boolean isEmpty(){
        return this.size<1;
    }

    public void enqueue(Object ob){
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
    public Object dequeue(){
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
    public static void main(String[] args) {
        Fifo fifo = new Fifo();

        System.out.println("A fila está vazia: "+fifo.isEmpty());

        fifo.enqueue("Obj 1");
        fifo.enqueue("Obj 2");
        fifo.enqueue("Obj 3");
        fifo.enqueue("Obj 4");
        fifo.enqueue("Obj 5");
        fifo.enqueue("Obj 6");

        System.out.println("O último objeto adicionado é: " + fifo.rear());
        System.out.println("O primeiro objeto adicionado é: " + fifo.front());
        System.out.println("O tamanho da fila é: " + fifo.getSize());
        System.out.println("A fila está vazia: "+fifo.isEmpty());

        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
    }
}

