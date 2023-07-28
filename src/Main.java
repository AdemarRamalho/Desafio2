import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();

        System.out.print("Digite o nome da pessoa (ou 'sair' para encerrar): ");
        String nome = scanner.nextLine();

        while (!nome.equalsIgnoreCase("sair")) {
            System.out.print("Digite a quantidade de endereços: ");
            int quantidadeEnderecos = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite a idade de " + nome + ": ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            Pessoa pessoa = new Pessoa(nome, idade,enderecos);



            for (int i = 1; i <= quantidadeEnderecos; i++) {
                System.out.println("Endereço " + i + " de " + nome + ":");

                System.out.print("Rua: ");
                String rua = scanner.nextLine();

                System.out.print("Número: ");
                int numero = Integer.parseInt(scanner.nextLine());

                Endereco endereco = new Endereco(rua, numero);
                pessoa.addEndereco(endereco);
            }

            pessoas.add(pessoa);
            System.out.print("\nDigite o nome da pessoa (ou 'sair' para encerrar): ");
            nome = scanner.nextLine();
        }

        System.out.print("\nDigite o nome da pessoa que deseja buscar: ");
        String nomeBuscado = scanner.nextLine();

        Pessoa pessoaEncontrada = buscarPessoa(pessoas, nomeBuscado);
        if (pessoaEncontrada != null) {
            System.out.println("\nDados da pessoa encontrada:");
            System.out.println("Nome: " + pessoaEncontrada.getNome());
            System.out.println("Idade: " + pessoaEncontrada.getIdade());
            System.out.println("Endereços: ");
            for (Endereco endereco : pessoaEncontrada.getEnderecos()) {
                System.out.println("- " + endereco.getRua() + ", " + endereco.getNumero());
            }
        } else {
            System.out.println("\nPessoa não encontrada.");
        }
    }
    private static Pessoa buscarPessoa(List<Pessoa> pessoas, String nomeBuscado) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomeBuscado)) {
                return pessoa;
            }
        }
        return null;
    }
}