import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<>();
		// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18),2009.44, "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12),2284.38, "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2),9836.14, "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14),19119.88, "Diretor"));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5),2234.68, "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19),1582.72, "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31),4071.84, "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8),3017.45, "Gerente"));
		funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24),1606.85, "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2),2799.93, "Gerente"));
		
		// 3.2 – Remover o funcionário “João” da lista.
		Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getNome().contains("João")) {
                iterator.remove();
                System.out.println("Joao removido com sucesso!");
            }
        }
        
        // 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        // informação de data deve ser exibido no formato dd/mm/aaaa;
        // informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Funcionario funcionario : funcionarios) {
            String dataFormatada = funcionario.getDataNascimento().format(formatter);
            String salarioFormatado = formatarSalario(funcionario.getSalario());
            System.out.println("Nome: " + funcionario.getNome() +
                    ", Data de Nascimento: " + dataFormatada +
                    ", Salário: " + salarioFormatado +
                    ", Função: " + funcionario.getFuncao());
        }
	
        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        for (Funcionario funcionario : funcionarios) {
            double novoSalario = funcionario.getSalario() * 1.1;
            funcionario.setSalario(novoSalario);
        }
        
        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        // não tive oportunidade de estudar o Map
        
        // 3.6 – Imprimir os funcionários, agrupados por função.
        // não tive oportunidade de estudar o Map
        
        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("\nFuncionários que fazem aniversário nos meses 10 e 12:");
        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            if (mesAniversario == 10 || mesAniversario == 12) {
                String dataFormatada = funcionario.getDataNascimento().format(formatter);
                String salarioFormatado = formatarSalario(funcionario.getSalario());
                System.out.println("Nome: " + funcionario.getNome() +
                        ", Data de Nascimento: " + dataFormatada +
                        ", Salário: " + salarioFormatado +
                        ", Função: " + funcionario.getFuncao());
            }
        }
        
        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        Date dataAtual = new Date();
        int ano = 0,idade = 0;
        String nome = "";
        
        for(Funcionario funcionario : funcionarios) {
        	ano = funcionario.getDataNascimento().getYear();
//        	int idadeFuncionario = dataAtual.getYear() - ano;
        	int idadeFuncionario = 2024 - ano;
        	if(idadeFuncionario > idade) {
        		idade = idadeFuncionario;
        		nome = funcionario.getNome();
        	}
        	
        }
        System.out.println("\nFuncionário com a maior idade:");
        System.out.println("Nome: " + nome + ", Idade: " + idade + " anos");
        
        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        // não consegui implementar essa funcionalidade
        
        // 3.11 – Imprimir o total dos salários dos funcionários.
        double totalSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios += funcionario.getSalario();
        }
        String totalSalariosFormatado = formatarSalario(totalSalarios);
        System.out.println("\nTotal dos salários dos funcionários: " + totalSalariosFormatado);
        
        
        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        double salarioMinimo = 1212.00;
        System.out.println("\nQuantidade de salários mínimos por funcionário:");
        for (Funcionario funcionario : funcionarios) {
            int quantidadeSalariosMinimos = (int) Math.round(funcionario.getSalario() / salarioMinimo);
            System.out.println("Nome: " + funcionario.getNome() +
                    ", Salário: " + formatarSalario(funcionario.getSalario()) +
                    ", Salários Mínimos: " + quantidadeSalariosMinimos);
        }
        
        
	}	
	private static String formatarSalario(double salario) {
        return String.format("%,.2f", salario).replace(",", "v").replace(".", ",").replace("v", ".");
    }
}
