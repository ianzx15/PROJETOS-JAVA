package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Ian Evangelista Rodrigues
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(S)air\n" + 
						"(R)emover Favorito\n" +
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "F":
			listarFavoritos(agenda);
			break;
		case "R":
			removeFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato contato = new Contato();
		System.out.println(contato.toString(agenda, false));
	}
	
	private static void removeFavorito(Agenda agenda, Scanner sc) {
		System.out.println("\nPosicao> ");
		agenda.removeFavorito(sc.nextInt());
	}
	
	private static void adicionaFavorito(Agenda agenda, Scanner sc) {
		Validacao valid = new Validacao();
		System.out.println("\nContato> ");
		Contato contato = agenda.getContato(sc.nextInt());
		System.out.println("\nPosicao> ");
		int posicaoLista = sc.nextInt();
		if(valid.validaContato(agenda, contato, true)) {
			System.out.println("CONTATO JÁ CADASTRADO");
		} else {
		agenda.adicionaFavorito(contato, posicaoLista);
		System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicaoLista);
	  }
	}

	private static void listarFavoritos(Agenda agenda) {
		Contato contato = new Contato();
		System.out.println(contato.toString(agenda, true));
	}
	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		Validacao valid = new Validacao();
		while(true) {
		System.out.print("\nContato> ");
		int posicao = scanner.nextInt();
		if (!valid.validaPosicaoLista(posicao, 100)) {
			System.out.println("POSIÇÃO INVÀLIDA");
		
		} else if (agenda.getContato(posicao) == null) {
			System.out.println("POSIÇÃO INVÀLIDA!");
		} else {
			System.out.println(agenda.imprimeContato(posicao));
			break;
		}
	  }
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		Validacao valid = new Validacao();
		while (true){
			System.out.print("\nPosição na agenda> ");
			int posicao = scanner.nextInt();
			if (valid.validaPosicaoLista(posicao, 100)) {
				scanner.nextLine();
				System.out.print("\nNome> ");
				String nome = scanner.nextLine();
				if (nome.isEmpty()) {
					System.out.println("CONTATO INVÁLIDO");
				} else {
					System.out.print("\nSobrenome> ");
					String sobrenome = scanner.nextLine();
					if (sobrenome.isEmpty()) {
						System.out.println("CONTATO INVÁLIDO");
					} else {
						System.out.print("\nTelefone> ");
						String telefone = scanner.nextLine();
						Contato contato = new Contato(nome, sobrenome, telefone);
						if (valid.validaContato(agenda, contato, false)) {
							System.out.println("CONTATO JÁ CADASTRADO");
							break;
						} else {
							agenda.cadastraContato(posicao, contato);
							System.out.println("CADASTRO REALIZADO");
							break;
						}
					}
				}
			 
			} else {
				System.out.println("POSIÇÃO INVÁLIDA");
			}
		
			}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
