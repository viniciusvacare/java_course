package orientacao_objetos.exercicio3;

public class Aplicacao {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();

        p1.nome = "Fulano";
        p1.setIdade(25);
        p1.endereco = "Rua de Bosta, 195";
        p1.telefone = 1982039293;
        p1.setTelefone(182938293);

        System.out.println(p1.nome);
        System.out.println(p1.getIdade());
        System.out.println(p1.getEndereco());
        System.out.println(p1.getTelefone());
    }
}
