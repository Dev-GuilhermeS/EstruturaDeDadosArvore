package classes;

public class No {
    public No Esquerdo;
    public int valor;
    public No Direito;

    public No(int valor) {
        this.valor = valor;
        Esquerdo = null;
        Direito = null;
    }

    public void insereNo(int valorIsercao) {
        if (valorIsercao < this.valor) {
            if (this.Esquerdo == null) {
                this.Esquerdo = new No(valorIsercao);
            } else {
                this.Esquerdo.insereNo(valorIsercao);
            }
        } else if (valorIsercao > this.valor) {
            if (this.Direito == null) {
                this.Direito = new No(valorIsercao);
            } else {
                this.Direito.insereNo(valorIsercao);
            }
        }
    }
}