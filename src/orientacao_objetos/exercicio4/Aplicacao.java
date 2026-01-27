package orientacao_objetos.exercicio4;

public class Aplicacao {
    public static void main(String[] args) {
        Personagem p1 = new Personagem("Altair", 190);

        p1.dadosAtuais();

        p1.tentarAumentarNivelDePoder(20);
        p1.dadosAtuais();

        p1.alterarNome(new Personagem("Bezios", 200));
        p1.dadosAtuais();
    }
}
