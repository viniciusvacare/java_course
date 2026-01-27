package fluxo;

public class Switch {
    public String retornaDiaPorEscritoComSwitchExpression(int dia) {
        switch (dia) {
            case 1:
                return "Domingo";
            case 2:
                return "Segunda-feira";
            case 3:
                return "Terça-feira";
            case 4:
                return "Quarta-feira";
            case 5:
                return "Quinta-feira";
            case 6:
                return "Sexta-feira";
            case 7:
                return "Sábado";
            default:
                return "Dia não existe";
        }
    }

    public String retornaDiaPorEscritoComSwitchInitialization(int dia) {
        return switch (dia) {
            case 1 -> "Domingo";
            case 2 -> "Segunda-feira";
            case 3 -> "Terça-feira";
            case 4 -> "Quarta-feira";
            case 5 -> "Quinta-feira";
            case 6 -> "Sexta-feira";
            case 7 -> "Sábado";
            default -> "Dia não existe";
        };
    }

    public String validaSeEhDiaUtil(int dia) {
        return switch (dia) {
            case 1, 7 -> "Final de semana";
            case 2, 3, 4, 5, 6 -> "Dia útil";
            default -> "Inexistente";
        };
    }

}
