package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public static int opcao;
    public static ArrayList<Fornecedores> lista = new ArrayList();
    public static ArrayList<Produto> listaProd = new ArrayList();
    public static Fornecedores f = new Fornecedores();
    public static FornecedoresController fornecedoresControler = new FornecedoresController();
    public static ProdutoController produtoController = new ProdutoController();
    public static Produto p = new Produto();

    public static void menu() {

        System.out.println("\tCadastros");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Cadastrar Fornecedor");
        System.out.println("3. Visualizar todos os produtos");
        System.out.println("4. Visualizar todos os fornecedores");
        System.out.println("5. Deletar produto");
        System.out.println("6. Deletar fornecedor");
        System.out.println("7. Alterar produto");
        System.out.println("8. Alterar fornecedor");
        System.out.println("9. Sair");
        System.out.println("Opcão: ");

    }
    
    public static void alterarProduto(){
    for (Produto p : produtoController.findAll()) {
            System.out.println("ID: " + p.getId());
            System.out.println("Produto: " + p.getNome());
            System.out.println("----------------------");
        }
        
    Scanner entrada = new Scanner(System.in);
            System.out.println("Use o ID do produto que deseja alterar");
            System.out.println("Id: ");
            int id = Integer.parseInt(entrada.nextLine());
            p.setId(id);
            System.out.println("Nome: ");
            String nome = entrada.nextLine();
            p.setNome(nome);
            System.out.println("Quantidade: ");
            int quantidade = Integer.parseInt(entrada.nextLine());
            p.setQuantidade(quantidade);
            System.out.println("Preço: ");
            Double preco = Double.parseDouble(entrada.nextLine());
            p.setPreco(preco);
            for (Fornecedores f : fornecedoresControler.findAll()) {
                System.out.println("Fornecedores: "+ f.getId() + "-" + f.getNome()  + "/n Por favor selecione o ID do fornecedor desejado: ");
                entrada.next();
                p.setFornecedores(f);
                produtoController.alterar(p);
            }
    
    }
    
    public static void alterarFornecedores(){
            for (Fornecedores f : fornecedoresControler.findAll()) {
            System.out.println("ID: " + f.getId());
            System.out.println("Fornecedor: " + f.getNome());
            System.out.println("----------------------");
        }
              
            Scanner entrada = new Scanner(System.in);
            System.out.println("Use o ID do Fornecedor que deseja alterar");
            System.out.println("Id: ");
            int id = Integer.parseInt(entrada.nextLine());
            f.setId(id);
            System.out.println("Nome: ");
            String nome = entrada.nextLine();
            f.setNome(nome);
            System.out.println("CNPJ: ");
            int cnpj = Integer.parseInt(entrada.nextLine());
            f.setCnpj(cnpj);
            System.out.println("Endereço: ");
            String endereco = entrada.nextLine();
            f.setEndereco(endereco);
            System.out.println("Telefone: ");
            String telefone = entrada.nextLine();
            f.setTelefone(telefone);
            lista.add(f);
           fornecedoresControler.alterar(f);
}

    public static void cadastroProduto() {
        do {

            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Id: ");
            int id = Integer.parseInt(entrada.nextLine());
            p.setId(id);
            System.out.println("Nome: ");
            String nome = entrada.nextLine();
            p.setNome(nome);
            System.out.println("Quantidade: ");
            int quantidade = Integer.parseInt(entrada.nextLine());
            p.setQuantidade(quantidade);
            System.out.println("Preço: ");
            Double preco = Double.parseDouble(entrada.nextLine());
            p.setPreco(preco);
            for (Fornecedores f : fornecedoresControler.findAll()) {
                System.out.println("Fornecedores: "+ f.getId() + "-" + f.getNome()  + "/n Por favor selecione o ID do fornecedor desejado: ");
                entrada.next();
                p.setFornecedores(f);
                produtoController.salvar(p);
            }
            
          

            // verificação de repetição de cadastro
            System.out.println("Deseja realizar mais uma cadastro? Digite 1 para SIM e 2 para NÃO");
            int opcao = entrada.nextInt();

        } while (opcao == 1);
    }

    public static void consultaFornecedores() {
        //Menu de consulta de fornecedores
        
        for (Fornecedores f : fornecedoresControler.findAll()) {
            System.out.println("Fornecedor: " + f.getNome());
            System.out.println("\n CNPJ: " + f.getCnpj());
            System.out.println("\n Endereço: " + f.getEndereco());
            System.out.println("\n Telefone: " + f.getTelefone());
            System.out.println("----------------------");
        }
    }

    public static void cadastroFornecedores() {
        do {
            
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Id: ");
            int id = Integer.parseInt(entrada.nextLine());
            f.setId(id);
            System.out.println("Nome: ");
            String nome = entrada.nextLine();
            f.setNome(nome);
            System.out.println("CNPJ: ");
            int cnpj = Integer.parseInt(entrada.nextLine());
            f.setCnpj(cnpj);
            System.out.println("Endereço: ");
            String endereco = entrada.nextLine();
            f.setEndereco(endereco);
            System.out.println("Telefone: ");
            String telefone = entrada.nextLine();
            f.setTelefone(telefone);
            lista.add(f);
           fornecedoresControler.salvar(f);
            // verificação de repetição de cadastro
            System.out.println("Deseja realizar mais uma cadastro? Digite 1 para SIM e 2 para NÃO");
            int opcao = entrada.nextInt();

        } while (opcao == 1);
    }

    public static void consultaProduto() {
        //Menu de consulta de produtos
     
        for (Produto p : produtoController.findAll()) {
            System.out.println("Produto: " + p.getNome());
            System.out.println("\n Quantidade: " + p.getQuantidade());
            System.out.println("\n Preço: " + p.getPreco());
            System.out.println("\n Fornecedor: " + p.getFornecedores());
            System.out.println("----------------------");
        }
    }
    public static void deletarProduto(){
         for (Produto p : produtoController.findAll()) {
            System.out.println("ID: " + p.getId());
            System.out.println("\n Nome: " + p.getNome());
            System.out.println("Digite o ID do produto que deseja excluir: ");
            Scanner entrada = new Scanner(System.in);
            int id = entrada.nextInt();
            p.setId(id);
            produtoController.remove(id);
            
        
        }
      
    }
    public static void deletarFornecedor(){
         for (Fornecedores f : fornecedoresControler.findAll()) {
            System.out.println("ID: " + f.getId());
            System.out.println("\n Nome: " + f.getNome());
            System.out.println("Digite o ID do fornecedor que deseja excluir: ");
            Scanner entrada = new Scanner(System.in);
            int id = entrada.nextInt();
            f.setId(id);
            fornecedoresControler.remove(id);
            
        
        }
    }

    public static void saidaSistema() {
        System.out.println("Menu finalizado!");
        System.exit(0);
    }

    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            menu();
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastroProduto();
                    break;

                case 2:
                    cadastroFornecedores();
                    break;

                case 3:
                    consultaProduto();
                    break;
                case 4:
                    consultaFornecedores();
                    break;
                case 5:
                    deletarProduto();
                    break;
                case 6:
                   deletarFornecedor();
                   break;
                case 7:
                    alterarProduto();
                    break;
                case 8:    
                    alterarFornecedores();
                case 9:
                    saidaSistema();
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

    }
    
}
