
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeroDoVoo = new int[10];
        String[] origemDoVoo = new String[10];
        String[] destinoDoVoo = new String[10];
        int[] numeroDeLugares = new int[10];
        int escolha;
        int numeroDeVoosCadastrado = 0;
        int nmrVoo;
        int validacao;
        do {
            System.out.printf("%nMenu%n1->Cadastrar voo%n2->Consultar voo por número%n3->Consultar voo por origem%n4->efetuar reserva%n5->Sair%n");
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 1:
                    if (numeroDeVoosCadastrado <= 9) {
                        System.out.print("Digite o número do voo: ");
                        nmrVoo = sc.nextInt();
                        sc.nextLine();
                        validacao = 0;
                        for (int i = 0; i <= numeroDeVoosCadastrado; i++) {
                            if (nmrVoo == numeroDoVoo[i]) {
                                System.out.println("Número de voo já cadastrado");
                                validacao = 1;
                            }
                        }
                        if (validacao != 1) {
                            numeroDoVoo[numeroDeVoosCadastrado] = nmrVoo;
                            System.out.print("Digite a origem do voo: ");
                            origemDoVoo[numeroDeVoosCadastrado] = sc.nextLine();
                            System.out.print("Digite o destino do voo: ");
                            destinoDoVoo[numeroDeVoosCadastrado] = sc.nextLine();
                            System.out.print("Quantos lugares possui o voo: ");
                            numeroDeLugares[numeroDeVoosCadastrado] = sc.nextInt();
                            sc.nextLine();
                            numeroDeVoosCadastrado++;
                        }
                    } else {
                        System.out.println("Numero de cadastro de voo atingiu o limite");
                    }
                    break;

                case 2:
                    System.out.print("Digite o número do voo para realizar a pesquisa: ");
                    int pesquisaPorNumero = sc.nextInt();
                    sc.nextLine();
                    int vooSemCadastro = 0;
                    for (int i = 0; i <= numeroDeVoosCadastrado; i++) {
                        if (numeroDoVoo[i] == pesquisaPorNumero) {
                            System.out.printf("Voo com destino a %s existente -> ", destinoDoVoo[i].toUpperCase());
                            if (numeroDeLugares[i] > 0) {
                                System.out.printf("Disponibilidade ok, quantidade de lugares restantes -> %d%n", numeroDeLugares[i]);
                            } else {
                                System.out.println("Não há lugares restantes no voo.");
                            }
                            vooSemCadastro = 1;
                        }
                    }

                    if (numeroDeVoosCadastrado <= 0) {
                        System.out.println("Nenhum dado foi inserido ainda.");
                    } else if (vooSemCadastro != 1) {
                        System.out.println("Voo nao cadastrado");
                    }

                    break;

                case 3:
                    System.out.print("Digite a origem: ");
                    String origemParaPesquisar = sc.nextLine();
                    int verificarCadastroOrigem = 0;
                    for (int i = 0; i < numeroDeVoosCadastrado; i++) {
                        if (origemDoVoo[i].equals(origemParaPesquisar)) {
                            System.out.printf("Voo de origem %s e com destino a %s existente -> ", origemDoVoo[i].toUpperCase(), destinoDoVoo[i].toUpperCase());
                            if (numeroDeLugares[i] > 0) {
                                System.out.printf("Disponibilidade ok, quantidade de lugares restantes -> %d%n", numeroDeLugares[i]);
                            } else {
                                System.out.println("Não há lugares restantes no voo");
                            }
                            verificarCadastroOrigem = 1;
                        }
                    }
                    if (numeroDeVoosCadastrado <= 0) {
                        System.out.println("Nenhum dado foi inserido");
                    } else if (verificarCadastroOrigem != 1) {
                        System.out.println("Voo não cadastrado");
                    }

                    break;

                case 4:
                    System.out.print("Qual o número do voo desejado?: ");
                    int numeroReserva = sc.nextInt();
                    sc.nextLine();
                    int achou = 0;
                    if (numeroDeVoosCadastrado > 0) {
                        for (int i = 0; i <= numeroDeVoosCadastrado; i++) {
                            if (numeroReserva == numeroDoVoo[i]) {
                                if (numeroDeLugares[i] <= 0) {
                                    System.out.println("Voo lotado não possui mais lugares.");
                                } else {
                                    System.out.printf("Voo disponivel quantidade de lugares -> %d%ndeseja confirmar a reserva? : S-Sim N-Não%n", numeroDeLugares[i]);
                                    char escolhaReserva = sc.next().charAt(0);
                                    if (escolhaReserva == 'S') {
                                        System.out.println("Reserva confirmada");
                                        int lugaresRemover = numeroDeLugares[i] - 1;
                                        numeroDeLugares[i] = lugaresRemover;
                                    }
                                }
                                achou = 1;
                            }
                        }
                        if (achou != 1){
                            System.out.println("Voo inexistente");
                        }
                    } else {
                        System.out.println("Nenhum valor inserido");
                    }


                    break;
            }
        } while (escolha != 5);
    }
}