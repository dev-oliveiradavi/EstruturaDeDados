package listacontigua;

import java.util.Random;
import java.util.Scanner;

public class TelaLCInteiro {	
	static Scanner sc =  new Scanner(System.in);
	
	public static void main(String[] args) {
		LCInteiro lista1 = new LCInteiro();
		LCInteiro lista2 = new LCInteiro();
		
		
		preenche(lista1);
		System.out.println(lista1);
		System.out.println("O maior elemento: [" + maior(lista1) + "]");
		
		preenche(lista2);
		System.out.println(lista2);
		System.out.println("O maior elemento: [" + maior(lista2) + "]");
		System.out.println( "Números repetidos: | "+ repetidos(lista1,lista2));
		
		int somarPar = somaPares(lista1);
		System.out.println("A soma de todos os pares da 1 lista: [" + somarPar + "]");
		sc.close();
	}
	
	public static int somaPares(LCInteiro lista) {
		int soma = 0;
		for(int i=0; i<lista.getQuant(); i++) {
			if(lista.get(i) % 2 ==0) {
				soma += lista.get(i);
			}
		}
		return soma;
	}

		
	
	public static LCInteiro repetidos(LCInteiro lista1, LCInteiro lista2) {
		LCInteiro lista3 = new LCInteiro();
		
		for(int i=0; i<lista1.getQuant(); i++) {
			for(int j=0; j<lista2.getQuant(); j++) {
				if(lista1.get(i) == lista2.get(j) && (lista3.pesquisa(i)==-1)) {
					lista3.insereFinal(lista1.get(i));
				}
			}
		}
		
		return lista3;
	}

	public static void preenche(LCInteiro lista) {
		Random random = new Random();
		for(int i = 0; i < lista.getLista().length; i++) {
			lista.insereFinal(random.nextInt(30) + 1); 
		}
	}
	
	public static int maior(LCInteiro lista) {
		int maior = lista.get(0);
		for(int i=0; i<lista.getQuant(); i++) {
			if(lista.get(i)>maior) {
				maior = lista.get(i);
			}
		}
		
		return maior;
	}
}
