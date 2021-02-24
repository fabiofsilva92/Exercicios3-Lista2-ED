package controller;

import javax.swing.JOptionPane;

public class Ex3 {

	private String [] listaString;
	private int auxTam;
	
	
	public Ex3() {
		listaString = new String [5];
		auxTam = 0;
	}
	
	//Verificar se lista esta vazia
	public boolean verLista() {
		int len = listaString.length;
		int aux = 0;
		
		for(int i = 0; i<len; i++) {
			if(listaString[i] == null) {
				aux++;
			}
			else {
				System.out.println("Lista n�o esta vazia");
				i = len;
			}
		}
		if(aux == len) {
			System.out.println("Lista vazia");
			return true;
		}
		else {
			return false;
		}
	}
	
	//Verificar se lista est� cheia
	public boolean verListaCheia() {
		int len = listaString.length;
		int aux = 0;
		
		for(int i = 0; i<len; i++) {
			if(listaString[i] != null) {
				aux++;
			}
		}
		if (aux == len) {
			System.out.println("Lista cheia");
			return true;
		}
		else {
			System.out.println("Lista n�o esta cheia, temos " +(len-aux) + " posi��es.");
			return false;
		}
	}
	
	//Adicionar no inicio
	public void addInicio() {
		String abc = getString();
		if (auxTam < listaString.length) {
			for(int i = auxTam; i>0; i--) {
				listaString[i] = listaString[i-1];
			}
			auxTam++;
			listaString[0] = abc;
		}
		else {
			System.out.println("Lista cheia, n�o � poss�vel adicionar no in�cio.");
		}
		//System.out.println(auxTam);
	}
	
	//Adicionar no final
	public void addFinal() {
		String abc = getString();
		
		if(auxTam < listaString.length) {
			listaString[auxTam] = abc;
			auxTam++;
		}
		else {
			System.out.println("Lista cheia, n�o � poss�vel adicionar no final.");
		}
		
	}
	//Adicionar em qualquer posi��o
	public void addPosicao() {
		String abc = getString();
		int pos = getPosition();
		
		if(auxTam < listaString.length && pos>=0 && pos<=auxTam+1) {
			for(int i = listaString.length-1; i!=pos; i--) {
					listaString[i] = listaString[i-1];
				}
			auxTam++;
			listaString[pos] = abc;
		}
		else {
			System.out.println("Lista cheia, n�o � poss�vel adicionar");
		}
	}
	

	
	//Remover do inicio da Lista
	public String removeInicio() {
		String removido = null;
		if(auxTam > 0) {
			removido = listaString[0];
			for(int i = 0; i<listaString.length-1; i++) {
				listaString[i] = listaString[i+1];
			}
			listaString[auxTam-1] = null;
			auxTam--;
			return removido;
		}
		else {
			System.out.println("N�o h� elementos na lista");
			return removido;
		}
	}
	
	//Remover do final da Lista
	public String removeFinal() {
		String removido = null;
		
		if(auxTam > 0) {
			removido = listaString[auxTam-1];
			listaString[auxTam-1] = null;
			auxTam--;
			return removido;
		}
		else {
			System.out.println("N�o h� elementos na lista");
			return removido;
		}
	}
	
	//Remover qualquer posi��o da lista
	public String removePosicao() {
		String removido = null;
		if(auxTam>0) {
			int pos = getPosition();
			if (pos>5) {
				System.out.println("Posi��o escolhida maior que o vetor, ser� eliminado a ultima posi��o");
				pos = 4;
			}
			removido = listaString[pos];
			if(pos>=0 && pos<listaString.length) {
				for(int i = pos; i<auxTam; i++) {
					if(i == 4) {
						listaString[i] = listaString[i];
					}
					else {
						listaString[i] = listaString[i+1];
					}
				}
				listaString[auxTam-1] = null;
				auxTam--;
			}
			return removido;
		}
		else {
			System.out.println("Lista vazia!");
			return removido;
		}		
	}
	
	//Printar a lista
	public void printlista(){
		if (auxTam == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			for (int i = 0; i<listaString.length; i++) {
				if(listaString[i] != null) {
					System.out.print(listaString[i]);
					System.out.print(" | ");
				}
			}
			System.out.println("");
		}

	}
	
	//Insere o caractere desejado.
	public String getString() {
		String exString = "";
		exString = JOptionPane.showInputDialog("Digite uma String: ");
		return exString;
	}
	
	//Posi��o de inser��o ou remo��o
	public int getPosition() {
		int position = 0;
		do {
		position = Integer.parseInt(JOptionPane.showInputDialog("Digite a posi��o do vetor que deseja selecionar: \n "
				+ "obs: \n P/ remover , escolha uma posi��o entre a 1� e a " +(auxTam) + "� posi��o \n"
						+ "P/ adicionar escolha entre a 1� e a " +(auxTam + 1) + "� posi��o"));
		}while (position>auxTam+1);
		return position-1;
	}
	//Percorre e atribui a uma string o conte�do do vetor.
	public String percorre() {
		String percorrer = "";
		if (auxTam == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			for(int i = 0; i<auxTam; i++) {
				percorrer = percorrer + listaString[i] + " | ";
			}
		}
		System.out.println(percorrer);
		return percorrer;
	}
	
	
}
