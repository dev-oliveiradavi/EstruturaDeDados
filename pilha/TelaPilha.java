package pilha;

public class TelaPilha {
	public static void main (String[] args) {
		PilhaInt pilha1 = preencher(1);
		PilhaInt pilha2 = preencher(1);
		PilhaInt pilha3 = preencher(10);
		System.out.println("P1: " + pilha1);
		System.out.println("P2: " + pilha2);
		System.out.println("P3: " + pilha3);
		
		System.out.print("Suas pilhas são: ");
		if(iguais(pilha1,pilha2)) {
			System.out.println("Iguais");
		} else {
			System.out.println("Diferentes");
		}
		
		System.out.println("Pilha com os menores que 10: ");
		maiorQue10(pilha3);
		System.out.println(pilha3);
	}
	
	public static PilhaInt preencher(int tam) {
		PilhaInt pilha = new PilhaInt();
		for(int i=0; i< tam; i++) {
			pilha.push((int) (Math.random()*15)+1);
		}
		return pilha;
	}

	public static void maiorQue10(PilhaInt pilha) {
		PilhaInt aux = new PilhaInt();
		NoInt no;
		while(!pilha.isEmpty()) {
			no = pilha.pop();
			if(no.getElemento() <= 10) {
				aux.push(no.getElemento());
			}
		}
		
		while(!aux.isEmpty()) {
			no = aux.pop();
			pilha.push(no.getElemento());
		}
	}
	
	public static boolean iguais(PilhaInt pilha1, PilhaInt pilha2) {
		PilhaInt aux1 = new PilhaInt();
		PilhaInt aux2 = new PilhaInt();
		int n1,n2;
		
		if(pilha1.size() != pilha2.size()) {
			return false;
		}
		
		while(!pilha1.isEmpty()) {
			n1 = pilha1.pop().getElemento();
			n2 = pilha2.pop().getElemento();
			
			if(n1!=n2) {
				return false;
			}
			
			aux1.push(n1);
			aux2.push(n2);
		}
		
		while(!aux1.isEmpty()) {
			n1 = aux1.pop().getElemento();
			pilha1.push(n1);
			n2 = aux2.pop().getElemento();
			pilha2.push(n2);
		}
		
		return true;
	}
}
