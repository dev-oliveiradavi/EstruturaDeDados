package pilha;

public class TelaFila {

	public static void main(String[] args) { 
		FilaInt fila1 = preencher(8);
		FilaInt fila2 = preencher(8);
		
		System.out.println("L1 : " + fila1);
		System.out.println("L2 : " + fila2);
		
		FilaInt	soma = soma(fila1,fila2);
		System.out.print("Soma: ");
		System.out.println(soma);
		System.out.print("Media l1: ");
		media(fila1);
		
		if(iguais(fila1,fila2)) {
			System.out.println("Iguais");
		} else {
			System.out.println("Diferentes");
		}
		
		System.out.print("Menores que 10: ");
		maiorQue10(fila1);
		System.out.println(fila1);
	}
	
	public static FilaInt preencher(int tam) {
		FilaInt fila = new FilaInt();
		for(int i=0; i<tam; i++) {
			fila.enqueue((int) (Math.random()*20)+1);
		}
		return fila;
	}
	
	public static FilaInt soma(FilaInt fila1, FilaInt fila2) {
		FilaInt fila3 = new FilaInt();
		FilaInt aux1 = new FilaInt();
		FilaInt aux2 = new FilaInt();
		int n1,n2;
		while(!fila1.isEmpty()) {
			n1 = fila1.dequeue().getElemento();
			aux1.enqueue(n1);
			n2 = fila2.dequeue().getElemento();
			aux2.enqueue(n2);	
			fila3.enqueue(n1+n2);
		}
		
		while(!aux1.isEmpty()) {
			n1 = aux1.dequeue().getElemento();
			fila1.enqueue(n1);
		}
		
		while(!aux2.isEmpty()) {
			n2 = aux2.dequeue().getElemento();
			fila2.enqueue(n2);
		}
		return fila3;
	}
	
	public static void media(FilaInt fila1) {
		FilaInt aux = new FilaInt();
		double media = 0;
		int tamanho = fila1.size();
		int n1;
		
		while(!fila1.isEmpty()) {
		n1 = fila1.dequeue().getElemento();
		aux.enqueue(n1);
		media += n1;
		}
		
		while(!aux.isEmpty()) {
			n1 = aux.dequeue().getElemento();
			fila1.enqueue(n1);
		}
		media /= tamanho;
		System.out.println(media);
	}
	
	public static boolean iguais(FilaInt fila1, FilaInt fila2) {
		FilaInt aux1 = new FilaInt();
		FilaInt aux2 = new FilaInt();
		int n1,n2;
		
		if(fila1.size() != fila2.size()) {
			return false;
		}
		
		while(!fila1.isEmpty()) {
			n1 = fila1.dequeue().getElemento();
			n2 = fila2.dequeue().getElemento();
			
			if (n1 != n2) {
	            return false;
	        }
			
			aux1.enqueue(n1);
			aux2.enqueue(n2);
		}
		
		while(!aux1.isEmpty()) {
			n1 = aux1.dequeue().getElemento();
			fila1.enqueue(n1);
			n2 = aux2.dequeue().getElemento();
			fila2.enqueue(n2);
		}
		
		return true;
	}
	
	public static void maiorQue10(FilaInt fila) {
		FilaInt aux = new FilaInt();
		NoInt no;
		while(!fila.isEmpty()) {
			no = fila.dequeue();
			if(no.getElemento() <= 10) {
				aux.enqueue(no.getElemento());
			}
		}
		
		while(!aux.isEmpty()) {
			no = aux.dequeue();
			fila.enqueue(no.getElemento());
		}
	}
}
