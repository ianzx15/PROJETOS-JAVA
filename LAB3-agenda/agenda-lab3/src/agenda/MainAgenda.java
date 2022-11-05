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
	 * Imprime uma representação em lista de todos os contatos..
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato contato;
		for (int i = 0; i < 101; i++ ) {
			contato = agenda.getContato(i);
			if (contato != null) {
				System.out.println(i + " - " + contato.toString());
			}
		}
	}
	
	
	/**
	 * Remove um contato da lista de favoritos.
	 * @param agenda O objeto que possui a lista de 
	 * contatos favoritos
	 * @param sc O objeto que permite capturar
	 * a posição para remover o contato dos favoritos.
	 */
	private static void removeFavorito(Agenda agenda, Scanner sc) {
		System.out.println("\nPosicao> ");
		agenda.removeFavorito(sc.nextInt());
	}
	
	
	/**
	 * Adiciona um contato à lista de favoritos.
	 * @param agenda O objeto que possui a lista de
	 *  contatos favoritos.
	 * @param sc O objeto que permite capturar o contato
	 * e a posição em que ele será colocado.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner sc) {
		System.out.println("\nContato> ");
		Contato contato = agenda.getContato(sc.nextInt());
		System.out.println("\nPosicao> ");
		int posicaoLista = sc.nextInt();
		if (posicaoLista > 10 || posicaoLista < 1) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		} else if(contato.existeIguais(agenda.getListaFavoritos())) {
			System.out.println("CONTATO JÁ CADASTRADO");
			return;
		} 
		agenda.adicionaFavorito(contato, posicaoLista);
		System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicaoLista);
	}

	
	/**
	 * Imprime uma representação em lista de todos
	 * os contatos favoritados.
	 * @param agenda O objeto que possui a lista de
	 * contatos favoritos.
	 */
	private static void listarFavoritos(Agenda agenda) {
		Contato contato = new Contato();
		for (int i = 0; i < 11; i++ ) {
			contato = agenda.getContatoFavorito(i);
			if (contato != null) {
				System.out.println(i + " - " + contato.toString());
			}
		}
	}
	
	
	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda O objeto que possui a lista de 
	 * contatos.
	 * @param sc O objeto que permite capturar o contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
			System.out.print("\nContato> ");
			int posicao = scanner.nextInt();
			if (posicao >= 101 || posicao < 1 || agenda.getContato(posicao) == null) {
				System.out.println("POSIÇÃO INVÁLIDA");
				return;
			}
			System.out.println(agenda.imprimeContato(posicao));
	}
			

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda O objeto que possui a lista de contatos.
	 * @param scanner O objeto que permite capturar os atributos
	 * do contato a ser criado.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		while (true){
			System.out.print("\nPosição na agenda> ");
			int posicao = scanner.nextInt();
			if (posicao > 100|| posicao < 1) {
				System.out.println("POSIÇÃO INVÁLIDA");
				return;
			}
			scanner.nextLine();
			System.out.print("\nNome> ");
			String nome = scanner.nextLine();
			if (nome.isEmpty()) {
				System.out.println("CONTATO INVÁLIDO");
				return;
			}
			System.out.print("\nSobrenome> ");
			String sobrenome = scanner.nextLine();
			System.out.print("\nTelefone> ");
			String telefone = scanner.nextLine();
			Contato contato = new Contato(nome, sobrenome, telefone);
			
			if (contato.existeIguais(agenda.getListaContatos())) {
				System.out.println("CONTATO JÁ CADASTRADO");
				return;
			} 
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
			System.out.println("CADASTRO REALIZADO");
			break;
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
