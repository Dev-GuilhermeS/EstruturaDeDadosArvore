package teste;
import java.util.Random;
import classes.*;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("\n<<---------->>\n");

        System.out.println("Pré-ordem: 4, 5, 8, 24, 33, 12, 76, 8, 9, 13, 12, 1, 3, 6, 5, 18, 10, 15, 17, 16, 65");

        System.out.println("In-ordem: 19, 15, 11, 21, 20, 9, 2, 3, 7, 1, 8, 13, 4, 6, 14, 10, 5, 16, 14, 12, 65");

        System.out.println("Pós-ordem: 33, 12, 15, 13, 4, 12, 1, 5, 10, 18, 76, 9, 10, 3, 24, 65, 12, 5, 8");

        System.out.println("\n<<---------->>\n");

        Arvore arvore = new Arvore();
        int valor;
        Random rand = new Random();
        int valorBusca = 0;

        System.out.print("Valores da Arvore: ");
        for (int i = 0; i < 10; i++) {
            valor = rand.nextInt(100);
            System.out.print(valor + " ");
            arvore.insereNo(valor);
            if (i == 5) {
                valorBusca = valor;
            }
        }

        System.out.print("\n\nPreOrdem Transversal: ");
        arvore.preOrdemRecursivoTransversal();

        System.out.print("\n\nInOrdem Transversal: ");
        arvore.inOrdemRecursivoTransversal();

        System.out.print("\n\nPosOrdem Transversal: ");
        arvore.posOrdemRecursivoTransversal();

        System.out.println("\n<<---------->>\n");

        No aux = arvore.buscar(valorBusca);
        arvore.buscar(valorBusca);
        if (aux != null) {
            System.out.printf("\nValor %d esxiste na arvore\n", aux.valor);
        } else {
            System.out.println("\nNão encontrado na arvore\n");
        }

        No aux2 = arvore.buscar(101);
        arvore.buscar(101);
        if (aux2 != null) {
            System.out.printf("\nValor %d existe na arvore\n", aux2.valor);
        } else {
            System.out.println("\nNão encontrado na arvore\n");
        }
        System.out.println("\n<<-----Desafio----->>\n");
    }
}