import java.util.Scanner;

public class Televisao {
	protected String Marca = "Stuart Hughes",
			Modelo = "HD Supreme Rose Edition",
			Status = "Desligada";
	protected int Volume = 50,
			Canal = 1;
	public void manual(){
		System.out.println(
		  "Digite l ou d para ligar / desligar a televisão"
		+ "\nDigite +v ou -v para aumentar / abaixar volume"
		+ "\nDigite +c ou -c para aumentar / abaixar canal"
		+ "\nDigite m para ver o menu");	
	}
	public void televisao() {
		System.out.println(
				"Manual da televisão "
				+ "\nDigite l ou d para ligar / desligar a televisão"
				+ "\nDigite +v ou -v para aumentar / diminuir volume"
				+ "\nDigite +c ou -c para aumentar / diminuir canal");
		Scanner sc = new Scanner(System.in);
		informacao();
		executarComando(sc.nextLine());
		while (Status.equals("Ligada")) {
			System.out.println("Aguardando comando.(\"m\" para Menu)");
			informacao();
			executarComando(sc.nextLine());
		}
		sc.close();
	}
	public void informacao(){
		System.out.println(
				"Marca: "+Marca
				+"\nModelo: "+Modelo
				+"\nStatus: "+Status);
		if(Status.equals("Ligada")){
		System.out.println(
				"\nVolume: "+Volume
				+"\nCanal: "+Canal);
		}
	}
	public void executarComando(String sinal) {
		if (sinal.equals("m")) {
			manual();
		}
		if (sinal.equals("l")|| sinal.equals( "d")) {
			ligarDesligar(sinal);
		} else if (sinal.equals("+v") || sinal.equals("-v")) {
			volume(sinal);
		} else if (sinal.equals("+c") || sinal.equals("-c")) {
			canal(sinal);
		}
		
	}
	public void ligarDesligar(String comando) {
		if (Status.equals("Desligada")) {
			if (comando.equals("l")) {
				Status = "Ligada";
				System.out.println("Ligou");
				if (comando.equals("d")) {
					System.out.println("A tv já está desligada");
				}
			} else if (comando.equals("d")) {
				Status = "Desligada";
				System.out.println("Desligou");
			}
		} else {
			System.out.println("A tv já está ligada");
		}

	}
	public void volume(String comando) {
		if (Status.equals("Ligada")) {
			if (comando.equals("+v")) {
				if (Volume < 100) {
					Volume += 1;
					System.out.println("Volume: " + Volume);
				} else {
					System.out.println("O volume já está no mínimo");
				}
			} else if (comando.equals("-v")) {
				if (Volume > 0) {
					Volume -= 1;
					System.out.println("Volume: " + Volume);
				} else {
					System.out.println("O volume já está no mínimo");
				}
			}
		} else {
			System.out.println("É nescessário ligar a televisão");
		}
	}
	public void canal(String comando) {
		if (Status.equals("Ligada")) {
			if (comando.equals("+c")) {
				if (Canal == 59) {
					Canal = 1;
				} else {
					Canal += 1;
				}
				System.out.println("Canal: " + Canal + ".");
			} else if (comando.equals("-c")) {
				if (Canal == 1) {
					Canal = 59;
				} else {
					Canal -= 1;
				}
				System.out.println("Canal: " + Canal + ".");
			}
		} else {
			System.out.println("É nescessário ligar a televisão");
		}
	}
}