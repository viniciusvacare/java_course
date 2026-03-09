import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC extends JFrame {
    private JTextField campoIdade;
    private JTextField campoPeso;
    private JTextField campoAltura;
    private JButton botaoCalcular;
    private JButton botaoLimpar;
    private JLabel labelResultado;
    private JLabel labelClassificacao;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel principal com padding
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titulo = new JLabel("Calculadora de IMC");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPrincipal.add(titulo);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        // Painel de inputs
        JPanel painelInputs = new JPanel(new GridLayout(3, 2, 10, 10));
        
        JLabel labelIdade = new JLabel("Idade:");
        campoIdade = new JTextField(10);
        
        JLabel labelPeso = new JLabel("Peso (kg):");
        campoPeso = new JTextField(10);
        
        JLabel labelAltura = new JLabel("Altura (m):");
        campoAltura = new JTextField(10);

        painelInputs.add(labelIdade);
        painelInputs.add(campoIdade);
        painelInputs.add(labelPeso);
        painelInputs.add(campoPeso);
        painelInputs.add(labelAltura);
        painelInputs.add(campoAltura);

        painelPrincipal.add(painelInputs);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        botaoCalcular = new JButton("Calcular IMC");
        botaoLimpar = new JButton("Limpar");
        
        botaoCalcular.setPreferredSize(new Dimension(120, 30));
        botaoLimpar.setPreferredSize(new Dimension(120, 30));
        
        painelBotoes.add(botaoCalcular);
        painelBotoes.add(botaoLimpar);
        
        painelPrincipal.add(painelBotoes);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        // Painel de resultado
        JPanel painelResultado = new JPanel();
        painelResultado.setLayout(new BoxLayout(painelResultado, BoxLayout.Y_AXIS));
        painelResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        
        labelResultado = new JLabel("IMC: --");
        labelResultado.setFont(new Font("Arial", Font.BOLD, 16));
        labelResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        labelClassificacao = new JLabel("Classificação: --");
        labelClassificacao.setFont(new Font("Arial", Font.PLAIN, 14));
        labelClassificacao.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        painelResultado.add(labelResultado);
        painelResultado.add(Box.createRigidArea(new Dimension(0, 5)));
        painelResultado.add(labelClassificacao);
        
        painelPrincipal.add(painelResultado);

        add(painelPrincipal, BorderLayout.CENTER);

        // Eventos dos botões
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
    }

    private void calcularIMC() {
        try {
            int idade = Integer.parseInt(campoIdade.getText().trim());
            double peso = Double.parseDouble(campoPeso.getText().trim().replace(",", "."));
            double altura = Double.parseDouble(campoAltura.getText().trim().replace(",", "."));

            if (idade <= 0 || peso <= 0 || altura <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor, insira valores positivos!", 
                    "Erro de Validação", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (altura > 3) {
                JOptionPane.showMessageDialog(this, 
                    "Altura deve ser em metros (ex: 1.75)", 
                    "Erro de Validação", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            double imc = peso / (altura * altura);
            String classificacao = obterClassificacao(imc);
            
            labelResultado.setText(String.format("IMC: %.2f", imc));
            labelClassificacao.setText("Classificação: " + classificacao);
            
            // Colorir o resultado baseado na classificação
            if (classificacao.contains("Normal")) {
                labelClassificacao.setForeground(new Color(0, 150, 0));
            } else if (classificacao.contains("Sobrepeso") || classificacao.contains("Abaixo")) {
                labelClassificacao.setForeground(new Color(255, 140, 0));
            } else {
                labelClassificacao.setForeground(new Color(200, 0, 0));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, insira valores numéricos válidos!", 
                "Erro de Formato", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private String obterClassificacao(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso Normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade Grau I";
        } else if (imc < 40) {
            return "Obesidade Grau II";
        } else {
            return "Obesidade Grau III";
        }
    }

    private void limparCampos() {
        campoIdade.setText("");
        campoPeso.setText("");
        campoAltura.setText("");
        labelResultado.setText("IMC: --");
        labelClassificacao.setText("Classificação: --");
        labelClassificacao.setForeground(Color.BLACK);
        campoIdade.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculadoraIMC app = new CalculadoraIMC();
                app.setVisible(true);
            }
        });
    }
}
