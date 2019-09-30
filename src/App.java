
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();

        lista.add(9);
        lista.add(1);
        lista.add(2);
        lista.add(5);
        lista.add(7);
        lista.add(4);
        lista.add(6);
        lista.add(3);
        lista.add(8);

        System.out.println(lista);

        System.out.println("Removeu maiores que 10 (false)? "+lista.removeIfBigger(10));
        System.out.println("Removeu maiores que 6 (true)? "+lista.removeIfBigger(6));

        System.out.println(lista);


        DoubleLinkedListOfInteger l1 = new DoubleLinkedListOfInteger();
        l1.add(1); l1.add(2); l1.add(3);
        DoubleLinkedListOfInteger l2 = new DoubleLinkedListOfInteger();
        l2.add(10); l2.add(20); l2.add(30);
        Integer maior = DoubleLinkedListOfInteger.getBiggestComumValue(l1,l2);
        System.out.println("Maior (0) = "+maior);

        l1.clear();
        l1.add(-1); l1.add(2); l1.add(-2); l1.add(0); l1.add(5);
        l2.clear();
        l2.add(-1); l2.add(8); l2.add(-2); l2.add(3); l2.add(6);
        maior = DoubleLinkedListOfInteger.getBiggestComumValue(l1,l2);
        System.out.println("Maior (-1) = "+maior);

        l1.clear();
        l1.add(-1); l1.add(2); l1.add(-2); l1.add(6); l1.add(5);
        l2.clear();
        l2.add(-1); l2.add(8); l2.add(-2); l2.add(3); l2.add(6);
        maior = DoubleLinkedListOfInteger.getBiggestComumValue(l1,l2);
        System.out.println("Maior (6) = "+maior);

    }

}
