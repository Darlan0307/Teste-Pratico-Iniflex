import java.time.LocalDate;

public class Funcionario extends Pessoa {
	 private double salario;
	 private String funcao;
	 
	 Funcionario(String nome,LocalDate dataNascimento, double salario, String funcao){
		 super(nome,dataNascimento);
		 this.salario = salario;
		 this.funcao = funcao;
	 }
	 
	 public double getSalario() {
	        return salario;
	    }

	    public void setSalario(double salario) {
	        this.salario = salario;
	    }

	    public String getFuncao() {
	        return funcao;
	    }

	    public void setFuncao(String funcao) {
	        this.funcao = funcao;
	    }
	    
	    @Override
	    public String toString() {
	        return "Funcionario{" +
	                "nome='" + getNome() + '\'' +
	                ", dataNascimento=" + getDataNascimento() +
	                ", salario=" + salario +
	                ", funcao='" + funcao + '\'' +
	                '}';
	    }
}
