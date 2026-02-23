package interfaces;

public interface Objeto {
    // Método abstrato
    void exibeObjeto();

    // Método default
    default void exibeObjetoComDefault() {
        System.out.println("Exibindo objeto com default");
    }

    // Método static
    static void exibeObjetoComStatic() {
        System.out.println("Exibindo objeto com static");
    }
}
