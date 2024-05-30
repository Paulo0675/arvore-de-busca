import java.awt.*;

public class ArvoreNode {
    private Arvore root;

    public ArvoreNode() {
        this.root = null;
    }

    public Arvore getRoot() {
        return root;
    }

    //--- Processo de Inserção:
    // Função Base de inserção
    public void inserir(String nome, long rgm) {
        root = inserirArvore(root, rgm, nome);
    }

    // Operação de inserção
    private Arvore inserirArvore(Arvore root, long rgm, String nome) {
        if (root == null) {
            root = new Arvore(nome, rgm);
            return root;
        }
        if (rgm < root.rgm)
            root.esquerda = inserirArvore(root.esquerda, rgm, nome);
        else if (rgm > root.rgm)
            root.direita = inserirArvore(root.direita, rgm, nome);
        return root;
    }

    //--- Processo de Remoção
    // Função Base de remoção
    public void remover(int rgm) {
        root = removerArvore(root, rgm);
    }

    // Operação de remoção
    private Arvore removerArvore(Arvore root, long rgm) {
        if (root == null) {
            System.out.println("Arvore Vazia");
            return root;
        }
        if (rgm < root.rgm) {
            root = removerArvore(root.esquerda, rgm);
        } else if (rgm > root.rgm) {
            root = removerArvore(root.direita, rgm);
        } else {
            if (root.esquerda == null) {
                return root.direita;
            } else if (root.direita == null) {
                return root.esquerda;
            }
            root.rgm = valorMin(root.direita);
            root.direita = removerArvore(root.direita, root.rgm);
        }
        return root;
    }

    // Captura de valor da posição do rgm
    private long valorMin(Arvore root) {
        long vmin = root.rgm;
        while (root.esquerda != null) {
            vmin = root.esquerda.rgm;
            root = root.esquerda;
        }
        return vmin;
    }

    //--- Processo de Busca:
    // Função de busca
    public String buscar(long rgm) {
        Arvore resultado_de_busca = buscarArvore(root, rgm);
        String reguistro_de_busca;
        if (resultado_de_busca != null) {
            reguistro_de_busca = "Registro de Histórico Encontrado: \n- " + resultado_de_busca.rgm + "\n- " + resultado_de_busca.nome;
            return reguistro_de_busca;
        } else {
            reguistro_de_busca = "Nenhum resultado encontrado";
            return reguistro_de_busca;
        }
    }

    // Operador de busca
    private Arvore buscarArvore(Arvore root, long rgm) {
        if (root == null || root.rgm == rgm) {
            System.out.println("Histórico de arvore disponível");
            return root;
        }
        if (rgm < root.rgm) {
            return root = buscarArvore(root.esquerda, rgm);
        }
        return root = buscarArvore(root.direita, rgm);
    }

    // Função Esvaziar Arvore
    public void esvaziar() {
        root = null;
    }

    //--- Funções de Exibição
    // Função Pre
    public void exibirPreOrdem(Arvore root) {
        if (root != null) {
            System.out.println("---------");
            System.out.println("- RGM: " + root.rgm + "\n- Nome: " + root.nome);
            System.out.println("---------");
            exibirPreOrdem(root.esquerda);
            exibirPreOrdem(root.direita);
        }
    }

    // Função In
    public void exibirInOrdem(Arvore root) {
        if (root != null) {
            exibirInOrdem(root.esquerda);
            System.out.println("---------");
            System.out.println("- RGM: " + root.rgm + "\n- Nome: " + root.nome);
            System.out.println("---------");
            exibirInOrdem(root.direita);
        }
    }

    // Funções Pos
    public void exibirPosOrdem(Arvore root) {
        if (root != null) {
            exibirPosOrdem(root.esquerda);
            exibirPosOrdem(root.direita);
            System.out.println("---------");
            System.out.println("- RGM: " + root.rgm + "\n- Nome: " + root.nome);
            System.out.println("---------");
        }
    }
}