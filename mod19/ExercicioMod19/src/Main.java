import java.lang.annotation.Annotation;

@Tabela("Nome da Tabela")
public class Main {
    public static void main(String[] args) {

        ClasseComAnotacao classeComAnotacao=new ClasseComAnotacao();
        Annotation[] annotations = classeComAnotacao.getClass().getAnnotations();
        for(Annotation an : annotations){
            System.out.println(an);
        }
        Tabela tabela = classeComAnotacao.getClass().getAnnotation(Tabela.class);
        System.out.println("Valor da anotação: "+tabela.value());
    }
}