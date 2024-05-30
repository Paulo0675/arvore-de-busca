import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclas = new Scanner(System.in);
        ArvoreNode arvoreNode = new ArvoreNode();

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("[ 1 ] Inserir elemento");
            System.out.println("[ 2 ] Buscar elemento");
            System.out.println("[ 3 ] Exibir árvore (Pré-ordem)");
            System.out.println("[ 4 ] Exibir árvore (Em ordem)");
            System.out.println("[ 5 ] Exibir árvore (Pós-ordem)");
            System.out.println("[ 6 ] Esvaziar árvore");
            System.out.println("[ 7 ] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(teclas.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome = teclas.nextLine();
                    System.out.println("Digite a chave: ");
                    long rgm = Long.parseLong(teclas.nextLine());
                    arvoreNode.inserir(nome,rgm);
                    break;
                case 2:
                    System.out.print("Digite a chave para busca: ");
                    long chaveBusca = Long.parseLong(teclas.nextLine());
                    String resultado = arvoreNode.buscar(chaveBusca);
                    System.out.println("Resultado da busca: " + resultado);
                    break;
                case 3:
                    System.out.println("Exibição Pré-ordem:");
                    arvoreNode.exibirPreOrdem(arvoreNode.getRoot());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exibição Em ordem:");
                    arvoreNode.exibirInOrdem(arvoreNode.getRoot());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exibição Pós-ordem:");
                    arvoreNode.exibirPosOrdem(arvoreNode.getRoot());
                    System.out.println();
                    break;
                case 6:
                    arvoreNode.esvaziar();
                    System.out.println("Árvore esvaziada.");
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 7);

        teclas.close();
    }
}