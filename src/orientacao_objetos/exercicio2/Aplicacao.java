package orientacao_objetos.exercicio2;

public class Aplicacao {
    public static void main(String[] args) {
        Livro l1 = new Livro();
        Livro l2 = new Livro("O Homem Mais Rico da Babilônia", "George Samuel Clason");
        Livro l3 = new Livro("Pai Rico, Pai Pobre", "Robert Kiyosaki e Sharon L. Lechter", 1997, 35.11);

        System.out.println(l2.titulo);
    }
}
