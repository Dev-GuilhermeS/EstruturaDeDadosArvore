package classes;

public class Arvore {

    private No raiz;
    public Arvore() {
        this.raiz = null;
    }

    public void insereNo(int valorIsercao) {
        if (this.raiz == null) {
            this.raiz = new No(valorIsercao);
        } else {
            this.raiz.insereNo(valorIsercao);
        }
    }

    public No buscarRecursivo(int valorBusca) {
        return buscar(this.raiz, valorBusca);
    }

    public No buscar(int valorBusca) {
        if (raiz == null)
            return null; 
        No atual = raiz; 
        while (atual.valor != valorBusca) { 
            if (valorBusca < atual.valor)
                atual = atual.Esquerdo;
            else
                atual = atual.Direito; 
            if (atual == null)
                return null; 
        } 
        return atual; 
    }

    public No buscar(No raiz, int valorBusca) {
        No aux = raiz;
        if (aux == null) {
            return null;
        } else if (aux.valor != valorBusca) {
            if (valorBusca < aux.valor) {
                aux = aux.Esquerdo;
                aux = buscar(aux, valorBusca);
            } else {
                aux = aux.Direito;
                aux = buscar(aux, valorBusca);
            }
        }
        return aux;
    }

    public No remover(int valorRemocao) {
        if (this.raiz == null) {
            return null;
        }
        No atual = this.raiz;
        No pai = this.raiz;
        boolean filho_esq = true;

        while (atual.valor != valorRemocao) { 
            pai = atual;
            if (valorRemocao < atual.valor) {
                atual = atual.Esquerdo;
                filho_esq = true;
            } else { 
                atual = atual.Direito;
                filho_esq = false;
            }
            if (atual == null)
                return null;
        }
        if (atual.Esquerdo == null && atual.Direito == null) {
            if (atual == this.raiz)
                this.raiz = null;
            else if (filho_esq)
                pai.Esquerdo = null;
            else
                pai.Direito = null;
        }
        else if (atual.Direito == null) {
            if (atual == this.raiz)
                this.raiz = atual.Esquerdo;
            else if (filho_esq)
                pai.Esquerdo = atual.Esquerdo;
            else
                pai.Direito = atual.Direito;
        }
        else if (atual.Esquerdo == null) {
            if (atual == this.raiz)
                this.raiz = atual.Direito;
            else if (filho_esq)
                pai.Esquerdo = atual.Direito;
            else
                pai.Direito = atual.Direito;
        }
        else {
            No sucessor = no_sucessor(atual);
            if (atual == this.raiz)
                this.raiz = sucessor;
            else if (filho_esq)
                pai.Esquerdo = sucessor;
            else
                pai.Direito = sucessor;
            sucessor.Esquerdo = atual.Esquerdo; 
        }

        return atual;
    }

    public No no_sucessor(No apaga) {
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.Direito;

        while (atual != null) {
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.Esquerdo;
        }
        if (sucessor != apaga.Direito) {
            paidosucessor.Esquerdo = sucessor.Direito;
            sucessor.Direito = apaga.Direito; 
        }
        return sucessor;
    }

    public void preOrdemTransversal() {
        preOrdemAuxiliar(this.raiz);
    }

    private void preOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        System.out.printf(" %d ", no.valor);
        preOrdemAuxiliar(no.Esquerdo);
        preOrdemAuxiliar(no.Direito);
    }

    public void inOrdemTransversal() {
        inOrdemAuxiliar(this.raiz);
    }

    private void inOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        inOrdemAuxiliar(no.Esquerdo);
        System.out.printf(" %d ", no.valor);
        inOrdemAuxiliar(no.Direito);
    }

    public void posOrdemTransversal() {
        posOrdemAuxiliar(this.raiz);
    }

    private void posOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        posOrdemAuxiliar(no.Esquerdo);
        posOrdemAuxiliar(no.Direito);
        System.out.printf(" %d ", no.valor);
    }

    public void preOrdemRecursiva(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdemRecursiva(no.Esquerdo);
            preOrdemRecursiva(no.Direito);
        }
    }

    public void posOrdemRecursiva(No no) {
        if (no != null) {
            posOrdemRecursiva(no.Esquerdo);
            posOrdemRecursiva(no.Direito);
            System.out.print(no.valor + " ");
        }
    }

    public void inOrdemRecursivo(No no) {
        if (no != null) {
            inOrdemRecursivo(no.Esquerdo);
            System.out.print(no.valor + " ");
            inOrdemRecursivo(no.Direito);
        }
    }

    public void preOrdemRecursivoTransversal() {
        preOrdemRecursiva(this.raiz);
    }

    public void inOrdemRecursivoTransversal() {
        inOrdemRecursivo(this.raiz);
    }

    public void posOrdemRecursivoTransversal() {
        posOrdemRecursiva(this.raiz);
    }
}