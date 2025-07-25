package pilha;

public class PilhaInt {	
	private NoInt top;
	private int quant;
	
	public PilhaInt () {
		this.top = null;
		this.quant = 0;
	}
	
	public boolean isEmpty() {
		return (this.top==null);
	}
	
	// tamanho
	public int size() {
		return this.quant;
	}
	
	public NoInt top(){
		return this.top;
	}
	
	// colocar no top
	public void push (int num) {
		NoInt novo = new NoInt(num);
		novo.setProx(this.top);
		this.top = novo;
		this.quant++;
	}
	
	// remover o top
	public NoInt pop() {
		NoInt removido = this.top;
		if (!isEmpty()) {
			this.top = this.top.getProx();
			this.quant--;
		}
		return removido;
	}
	
	public String toString() {
		NoInt aux = this.top;
		String str = "";
		while (aux != null) {
			str += aux.getElemento()+" |";
			aux = aux.getProx();
		}
		return str;
	}	
}
