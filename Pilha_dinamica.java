package aed_pilha_dinamica;

import java.util.EmptyStackException;

public class Pilha_dinamica<T> {

    private Celula topo;
    private long size;

    class Celula {

        T item;
        Celula prox;
    }

    public void push(T item) { // empilhar inserir
        if (item == null) {
            throw new NullPointerException("ITEM NULO");
        } else {
            Celula novo = new Celula();
            novo.item = item;
            novo.prox = topo;
            topo = novo;
            size++;
        }
    }

    public T pop() throws PilhavaziaExcepion { //desimpilhar retirar
        if (isvazia()){
            throw new PilhavaziaExcepion("PILHA VAZIA");
        } else {
            T aux = topo.item;
            topo = topo.prox;
            size--;
            return aux;
        }

    }

    public boolean isvazia() {
        //operador ternário
        //<condição> ? se true: se false:          
        return (topo == null ? true : false);
    }

    @Override
    public String toString() {
        // Na pratica substituir String s por StringBuilder
        StringBuilder sb = new StringBuilder("TOPO->");
        // String s = "[";
        Celula aux = topo;
        while (aux != null) {
            sb.append("[");
            sb.append(aux.item);
            sb.append("]->");
            aux = aux.prox;
        }
        /*if (sb.length() > 2)
			sb.delete(sb.length() - 2, sb.length()); // apagar o ", " do final*/
        sb.append(" || "); // SIMBOLIZANDO NULO NA PILHA
        return sb.toString();
    }

}
