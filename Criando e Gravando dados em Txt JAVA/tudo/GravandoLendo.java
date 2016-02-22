package tudo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GravandoLendo {

	public void gravar() throws IOException {
		System.out.println("Digite um número para saber a tabuada");
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		FileWriter criandoarquivo = new FileWriter("C:\\tabuada2.txt");
		PrintWriter escrevendoNoArquivo = new PrintWriter(criandoarquivo);
		for (int i = 1; i <= 10; i++) {
			escrevendoNoArquivo.printf("%d x %d = %d %n", i, n, (i * n));
		}
		escrevendoNoArquivo.close();
		scanner.close();
	}

	public void lerArquivo() {
		Scanner ler = new Scanner(System.in);
		System.out.printf("Informe o nome de arquivo texto:\n");
		String nome = ler.nextLine();
		ler. close();
		System.out.printf("\nConteúdo do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				System.out.printf("%s\n", linha);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		System.out.println();
	}

}
