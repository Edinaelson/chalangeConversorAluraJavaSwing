import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Main extends JFrame {

    private JTextField tfValor1, tfValor2;
    private JButton bLimpar, bConverter;
    private JLabel jUnidade1, jUnidade2;
    private DecimalFormat df = new DecimalFormat("###,#0.00");

    public Main() {
        super("Conversor");

        jUnidade1 = new JLabel("Real");
        jUnidade2 = new JLabel("Dólar");

        tfValor1 = new JTextField(10);
        tfValor2 = new JTextField(10);

        bLimpar = new JButton("Limpar");
        bConverter = new JButton("Converter");

        bConverter.setToolTipText("Efetua a conversão do valor dado");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(jUnidade1, c);

        c.gridx = 1;
        panel.add(jUnidade2, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(tfValor1, c);

        c.gridx = 1;
        panel.add(tfValor2, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(bLimpar, c);

        c.gridx = 1;
        panel.add(bConverter, c);

        add(panel);

        bLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bLimparClick();
            }
        });

        bConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bConverterClick();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        getContentPane().setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void bLimparClick() {
        tfValor1.setText("");
        tfValor2.setText("");
    }

    private void bConverterClick() throws IOException {
        if (tfValor2.getText().equals("") && !tfValor1.getText().equals("")) {
            try {
                BigDecimal tfValor1Big = new BigDecimal(tfValor1.getText());
                BigDecimal res = Conversor.converterMoedaBrasileiraEua(tfValor1Big);
                tfValor1.setText("");
                tfValor2.setText("" + df.format(res));

            } catch (NumberFormatException exc) {
                tfValor1.selectAll();
                tfValor1.requestFocus();
                Toolkit.getDefaultToolkit().beep();
            }
        } else if (tfValor1.getText().equals("") && !tfValor2.getText().equals("")) {
            try {
                BigDecimal tfValor2Big = new BigDecimal(tfValor2.getText());
                BigDecimal res = Conversor.converterMoedaEuaBrasileira(tfValor2Big);
                tfValor2.setText("");
                tfValor1.setText("" + df.format(res));
            } catch (NumberFormatException exc) {
                tfValor2.selectAll();
                tfValor2.requestFocus();
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
