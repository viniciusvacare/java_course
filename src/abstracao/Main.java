package abstracao;
// @title: Classe main da aula de abstração
// @desc: Descrição do que o exercício demonstra
// @tags: abstracao
// @output:
// linha 1 do output
// linha 2 do output

public class Main {
    public static void main(String[] args) {
        CarroDeCorrida carroDeCorrida = new CarroDeCorrida("Ferrari");
        carroDeCorrida.ligar();
        carroDeCorrida.acelerar();
        carroDeCorrida.frear();
    }
}
