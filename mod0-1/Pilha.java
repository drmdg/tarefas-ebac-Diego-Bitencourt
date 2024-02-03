public class Pilha {

    public Object[] pilha;
    public int indice;

    public Pilha (){
            this.indice=-1;
            this.pilha = new Object[1000];
    }

    public boolean isEmpty(){
        return this.indice<0;
    }

    public void push(Object objt){
        this.indice++;
        this.pilha[indice]=objt;
    }

    public Object pop(){
        this.indice--;
        return this.pilha[indice+1];
    }

    public Object top(){
        return this.pilha[indice];
    }

    public int size(){
        return this.indice+1;
    }


    public static void main(String[] args) {
        Pilha p1 = new Pilha();
        System.out.println(p1.isEmpty());

        p1.push("Arroz");
        p1.push("Feijão");
        p1.push("Macarrão");
        p1.push("pizza");
        p1.push("batata");
        System.out.println(p1.isEmpty());

        System.out.println(p1.top());
        System.out.println(p1.size());
        System.out.println(p1.pop());


        while (!p1.isEmpty()){
            System.out.println(p1.pop());
        }
        System.out.println(p1.isEmpty());
        System.out.println(p1.size());


    }

}