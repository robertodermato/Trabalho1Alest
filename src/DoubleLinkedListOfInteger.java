
public class DoubleLinkedListOfInteger {

    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Contador do numero de elementos da lista.
    private int count;

    private class Node {

        public Integer element;
        public Node next;
        public Node prev;

        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        Node n = new Node(element);
        Node last = trailer.prev;
        n.prev = last;
        n.next = trailer;
        last.next = n;
        trailer.prev = n;
        count++;
    }

    /**
     * Insere um elemento em uma determinada posicao da lista.
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) throws IndexOutOfBoundsException {
        if (index < 0 || index > count) // indice invalido
            throw new IndexOutOfBoundsException();

        Node aux = null;
        Node n = new Node(element);

        if (index <= count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        if (index == count && count > 0) {
            n.prev = aux;
            n.next = trailer;
            aux.next = n;
            trailer.prev = n;
        } else {
            n.prev = aux.prev;
            n.next = aux;
            aux.prev.next = n;
            aux.prev = n;
        }
        count++;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        boolean achou = false;
        Node aux = header.next;

        while (achou != true && aux != null) {
            if (element.equals(aux.element)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                achou = true;
            } else {
                aux = aux.next;
            }
        }
        return achou;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer remove(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node aux = null;
        if (index <= count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        Integer item = aux.element;
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
        return item;
    }

    /**
     * Retorna true se a lista contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return (true);
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        if ((index < 0) || (index >= count))
            throw new IndexOutOfBoundsException();

        Node aux = null;
        if (index <= count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        return aux.element;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista não contém o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return (i);
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = header.next;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        Integer tmp = aux.element;
        aux.element = element;
        return tmp;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Retorna true se a lista estiver vazia.
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

/////////////////////////////////////////////////////////////////////////////
//
// I M P O R T A N T E !!!!!!!
//
// Faça os algoritmos para os dois metodos abaixo e inicialize os atributos
// a seguir. E´ obrigatorio seguir as instrucoes dos comentarios.
// NAO ALTERE NENHUM OUTRO METODO OU ATRIBUTO DESTA CLASSE.
// NAO INCLUA NOVOS METODOS. NÃO INCLUA NOVOS ATRIBUTOS.
//
/////////////////////////////////////////////////////////////////////////////

    /**
     * Remove da lista os elementos maiores que o numero recebido por
     * parametro. Nao pode chamar nenhum outro metodo desta classe,
     * ou seja, para percorrer a lista e remover os elementos maiores
     * que num e´ obrigatorio usar os atributos da classe, alem de
     * variaveis locais que venham a ser criadas.
     * @param  num usado para comparacao para verificar se e´ ou nao
     * e´ para fazer a remocao.
     * @return true se foi feita alguma remocao e false caso contrario.
     */
    public boolean removeIfBigger(Integer num) {
        Node aux = header.next;
        int contador=0;


        for (int i = 0; i < count; i++) {
            if (aux.element>num) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                contador++;
            }
            aux = aux.next;

        }
        count=count-contador;
        if (contador>0) return true; else return false;

    }

    /**
     * Metodo que recebe duas listas de inteiros por parametro, l1 e l2, e
     * retorna o maior valor que aparece simultaneamente nas duas listas.
     * Caso as listas nao possuam valores em comum, o metodo retorna zero.
     * Nao podem ser usados os atributos da lista, isto e´, apenas os seus
     * metodos podem ser chamados. Exemplo:
     *      lista1 = {1,2,3,4,5,6,7,8}
     *      lista2 = {0,2,4,6,8,10}
     *      Integer n = getBiggestComumValue(lista1,lista2)
     *      Conteúdo de n = 8
     *
     * @param l1 lista a ser verificada
     * @param l2 lista a ser verificada
     * @return Integer maior valor que aparece simultaneamente nas duas listas
     */
    public static Integer getBiggestComumValue (DoubleLinkedListOfInteger l1, DoubleLinkedListOfInteger l2) {
        int maior = Integer.MIN_VALUE;
        for (int i=0; i<l1.size();i++){
           int value = l1.get(i);
           if (l2.contains(value) && value>maior) maior=value;
        }
        if (maior == Integer.MIN_VALUE) return 0;
        return maior;
    }


    /**
     * Atribua os NOMES DA DUPLA QUE DESENVOLVEU O TRABALHO nos atributos abaixo.
     */
    public String nome1 = "Roberto Luís Rezende";
    public String nome2 = "Guilherme Luz";

    /**
     * Atribua o A NOTACAO O PARA CADA UM DOS ALGORITMOS IMPLEMENTADOS nos
     * atributos abaixo. Para classe de complexidade logaritmica
     * use "O (log n)"; para classe de complexidade linear use "O(n)"; para
     * classe de complexidade quadratica use "O(n^2)"; e assim por diante.
     */
    public String complexidadeMetodoRemoveIfBigger = "O(n)";
    public String complexidadeMetodoGetBiggestComumValue = "O(n^2)";

}
