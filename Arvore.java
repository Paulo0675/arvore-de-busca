public class Arvore {
    String nome;
    long rgm;
    Arvore esquerda;
    Arvore direita;

    public Arvore(String nome, long rgm){
        this.nome = nome;
        this.rgm = rgm;
        this.esquerda = null;
        this.direita = null;
    }

    //Getters e Setters//
    //Get e Set Nome
    /*public void setNome(){
        this.nome = nome;
    }*/

}
