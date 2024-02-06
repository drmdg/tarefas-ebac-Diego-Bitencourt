public class Lista {

    private Nodo head;
    private Nodo tail;
    private int size;

    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size < 1;
    }

    public void push(Object ob) {
        Nodo newNode = new Nodo(ob);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Cannot pop from an empty list.");
            return null;
        }

        Nodo removedNode = head;
        head = head.next;

        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }

        size--;
        return removedNode.data;
    }

    public Object rear() {
        return isEmpty() ? null : tail.data;
    }

    public Object front() {
        return isEmpty() ? null : head.data;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Nodo current = head;
        while (current != null) {
            System.out.print("  " + current.data + "  ");
            current = current.next;
        }
        System.out.println();
    }

    public Object elementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        Nodo current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void insert(int index, Object ob) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        Nodo newNode = new Nodo(ob);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.previous = newNode;
            }
            head = newNode;
        } else if (index == size) {
            newNode.previous = tail;
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
        } else {
            Nodo current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;
        }

        size++;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        Nodo removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            Nodo current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            removedNode = current;
        }

        size--;
        return removedNode.data;
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        System.out.println("A lista está vazia: " + lista.isEmpty());

        lista.push("Obj 1");
        lista.push("Obj 2");
        lista.push("Obj 3");
        lista.push("Obj 4");
        lista.push("Obj 5");
        lista.push("Obj 6");

        lista.insert(2, "Inserido manualmente 1");
        lista.insert(4, "Inserido manualmente 2");
        lista.insert(0, "Inserido no começo");
        lista.insert(9, "Inserido no final");

        System.out.println("Imprimindo a lista: ");
        lista.printList();
        System.out.println("O último objeto adicionado é: " + lista.rear());
        System.out.println("O primeiro objeto adicionado é: " + lista.front());
        System.out.println("O tamanho da lista é: " + lista.getSize());
        System.out.println("A lista está vazia: " + lista.isEmpty());

        System.out.println("Elemento 3 = " + lista.elementAt(3));
        System.out.println("Elemento 0 = " + lista.elementAt(0));
        System.out.println("Elemento 5 = " + lista.elementAt(5));

        System.out.println("Removendo primeiro objeto: " + lista.remove(0));
        System.out.println("Removendo o último objeto: " + lista.remove(8));
        System.out.println("Removendo objeto do meio: " + lista.remove(3));

        System.out.println("O tamanho da lista é: " + lista.getSize());
        System.out.println("Imprimindo a lista: ");
        lista.printList();

        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());
        System.out.println(lista.pop());

        System.out.println("A lista está vazia: " + lista.isEmpty());
    }
}
