package modelo;

import java.util.LinkedList;
import java.util.Scanner;

public class TestarCodigo {
	
	static Scanner sc1 = new Scanner(System.in);
	public static void main(String[] args) {
		
		BicicletaNormal[] bikeN  = new BicicletaNormal[5]; //Cria o array de bicicletaNormal com 5 lugares
		BicicletaEletrica[] bikeE = new BicicletaEletrica[5]; //Cria o array de bicicletaEletrica com 5 lugares
		Posto posto = new Posto("", 0);
		
		bikeN[0] = new BicicletaNormal(1, true, 34.0, 4, 0, posto); //idBicicleta, estadoUso, tempoUso, idadeBicicleta, tipoBicicleta, Posto
		bikeN[1] = new BicicletaNormal(2, true, 34.0, 4, 0, posto); // ""
		bikeN[2] = new BicicletaNormal(3, true, 34.0, 4, 0, posto); // ""
		bikeN[3] = new BicicletaNormal(4, true, 34.0, 4, 0, posto); // ""
		bikeN[4] = new BicicletaNormal(5, true, 34.0, 4, 0, posto); // ""
		
		bikeE[0] = new BicicletaEletrica(6, true, 34.0, 4, 1, 100, posto); //idBicicleta, estadoUso, tempoUso, idadeBicicleta, tipoBicicleta, energia restante, Posto
		bikeE[1] = new BicicletaEletrica(7, true, 34.0, 4, 1, 100, posto); // ""
		bikeE[2] = new BicicletaEletrica(8, true, 34.0, 4, 1, 100, posto); // ""
		bikeE[3] = new BicicletaEletrica(9, true, 34.0, 4, 1, 100, posto); // ""
		bikeE[4] = new BicicletaEletrica(10, true, 34.0, 4, 1, 100, posto); // ""
		
		Posto posto1 = new Posto("Belford Roxo", bikeN.length + bikeE.length );
		
		LinkedList<Usuario> usr = new LinkedList<Usuario>();
	
		int escolha = 0;
		while (escolha != 3) {
			System.out.println("Bem vindo ao Aluguel de bicicletas compartilhadas");
			System.out.println("1. Cadastrar");
			System.out.println("2. Logar");
			System.out.println("3. Encerrar programa");
			System.out.print("Digite a opcao (1 ou 2): ");
			escolha = sc1.nextInt();
			
			switch (escolha) {			
			case 1: //Cadastrar
				
				System.out.println("------------Dados Pessoais------------"); //Dados pessoais
				System.out.println("Digite o e-mail:");
				String email = sc1.next();
				System.out.println("Digite a senha:");
				String senha = sc1.next();
				System.out.println("Digite o nome completo:");
				String nome = sc1.next();
				sc1.nextLine();
				System.out.println("Digite a nacionalidade:");
				String nacionalidade = sc1.next();
				
				System.out.println("---------------Telefone----------------"); //Telefone
				System.out.println("digite seu DDI (identificador internacional): ");
				Integer ddi = sc1.nextInt();
				System.out.println("Digite seu DDD (identificador nacional):");
				Integer ddd = sc1.nextInt();
				System.out.println("Digite seu telefone:");
				Integer tel = sc1.nextInt();
				
				
				System.out.println("Voce prefere o plano de:");
				System.out.println("1- Bicicletas Eletricas");
				System.out.println("2- Bicicletas normais");
				Integer escolhaPlano = sc1.nextInt();
				switch (escolhaPlano) {
				case 1: //Plano Bicicleta eletrica
					
					PlanoAssinatura planoEletrico = new PlanoAssinatura(40, "Plano de Bicicleta Eletrica", "Cartao ou PIX");
					Telefone t1 = new Telefone(ddi, ddd, tel);
					Usuario u1 = new Usuario(email, senha, nome, nacionalidade, planoEletrico, t1);
					
					usr.add(u1);
					System.out.println("Usuario "+ u1.getNomeCompleto() + " Cadastrado com sucesso");
					break; 
				case 2:	//Plano Bicicleta normal
					PlanoAssinatura planoNormal = new PlanoAssinatura(40, "Plano de Bicicleta Normal", "Cartao ou PIX");
					Telefone t2 = new Telefone(ddi, ddd, tel);
					Usuario u2 = new Usuario(email, senha, nome, nacionalidade, planoNormal, t2);
					usr.add(u2);
					System.out.println("Usuario "+ u2.getNomeCompleto() + " Cadastrado com sucesso");
					break;
				case 3: //Escolher depois
					break;
				default: //Outra opcao
					escolhaPlano = 0;
					System.out.println("Opcao escolhida diferente ");
					break;
				}
				
				break;
			case 2: //Login
				System.out.println("");
				System.out.println("Digite seu login:");
				String login = sc1.next();
				System.out.println("Digite sua senha:");
				String passwd = sc1.next();
				
				
				for(Integer i = 0; i < usr.size(); i++) {
					if(usr.get(i).getEmail().equals(login)) {//verificador de login
						Integer escolhaAcao = 0;
						while(escolhaAcao != 5) {
							System.out.println("Usuario logado com sucesso");
							System.out.println("");
							System.out.println("O que voc� deseja fazer?");
							System.out.println("1- Retirar bicicleta");
							System.out.println("2- Devolver bicicleta");
							System.out.println("3- Informa��es da sua conta");
							System.out.println("4- Deletar conta");
							escolhaAcao = sc1.nextInt();
							
							switch (escolhaAcao) {//acao bicicleta
								case 1: //Retirar bicicleta do posto
									posto1.retirarBicicleta();
		
									break;
								case 2: //Devolver bicicleta ao posto
									posto1.devolverBicicleta();
									
									break;
								case 3: //Informacoes do usuario
									System.out.println("Você deseja saber suas informa��es:");
									System.out.println("1- De cadastro");
									System.out.println("2- De telefone");
									Integer escolhaInfo = sc1.nextInt();
									switch (escolhaInfo) {
										case 1: //Informacoes de cadastro (***)
											usr.get(i).informacoesUsuario(1);
											break;
										case 2: //Informacoes de telefone do usuario (***)
											usr.get(i).informacoesUsuario();
											break;
										default: //Opcao invalida
											System.out.println("Opcao invalida");
											System.out.println("");
											break;
									}
									break;
								case 4:// Deletar conta (***)
									
									usr.remove(i);
									System.out.println("Conta deletada");
									break;
								case 5:
									break;
								default:
									break;
							}						
						}
	
					}else {
						System.out.println("usuario inexistente");
					}
				}
				break;
			case 3: //Encerrar programa
				break;
			default: //Outra opcao
				escolha = 0;
				break;
			}			
		}
			
	}

}