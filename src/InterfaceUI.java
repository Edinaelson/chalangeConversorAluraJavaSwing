import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class InterfaceUI extends JFrame{
    private JTextField tfValor1, tfValor2,tfValor3,tfValor4,tfValor5,tfValor6;
    private JButton bLimpar, bConverter;
    private JLabel jUnidade1, jUnidade2,jUnidade3, jUnidade4, jUnidade5,jUnidade6;
    private DecimalFormat df = new DecimalFormat("###,#0.00");

    public InterfaceUI(){
        super("Conversor");

        jUnidade1 = new JLabel("Real");
        jUnidade2 = new JLabel("Dólar");
        jUnidade3 = new JLabel("Euro");
        jUnidade4 = new JLabel("Libras Esterlinas");
        jUnidade5 = new JLabel("Peso Argentino");
        jUnidade6 = new JLabel("Peso Chileno");

        tfValor1 = new JTextField(10);
        tfValor2 = new JTextField(10);
        tfValor3 = new JTextField(10);
        tfValor4 = new JTextField(10);
        tfValor5 = new JTextField(10);
        tfValor6 = new JTextField(10);

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

        c.gridx = 2;
        panel.add(jUnidade3, c);

        c.gridx = 3;
        panel.add(jUnidade4, c);

        c.gridx = 4;
        panel.add(jUnidade5, c);

        c.gridx = 5;
        panel.add(jUnidade6, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(tfValor1, c);

        c.gridx = 1;
        panel.add(tfValor2, c);

        c.gridx = 2;
        panel.add(tfValor3, c);

        c.gridx = 3;
        panel.add(tfValor4, c);

        c.gridx = 4;
        panel.add(tfValor5, c);

        c.gridx = 5;
        panel.add(tfValor6, c);

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

                BigDecimal euro = Conversor.converterMoedaBrasileiraEuro(tfValor1Big);
                tfValor3.setText("" + df.format(euro));

                BigDecimal librasEstelinas = Conversor.converterMoedaBrasileiraLibrasEstelinas(tfValor1Big);
                tfValor4.setText(""+ df.format(librasEstelinas));

                BigDecimal pesoArgentinos = Conversor.converterMoedaBrasileiraPesosArgentinos(tfValor1Big);
                tfValor5.setText("" + df.format(pesoArgentinos));

                BigDecimal pesoChileno = Conversor.converterMoedaBrasileiraPesoChileno(tfValor1Big);
                tfValor6.setText("" + df.format(pesoChileno));



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

}
