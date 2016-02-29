import java.io.IOException;

import tudo.*;
public class main {

	public static void main(String[] args) throws IOException {
		GravandoLendo gravar = new GravandoLendo();
		gravar.gravar();
		gravar.lerArquivo();
	}

}
