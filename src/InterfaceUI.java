import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class InterfaceUI extends JFrame {

    final DecimalFormat df = new DecimalFormat("####,#00.00");
    JTextField jTextField = new JTextField();
    JLabel resultado = new JLabel("Resultado");

    public InterfaceUI() {

        super("Conversor");
        JLabel fieldDolar, fieldEuro, fieldLibras, fieldPesoArgentino, fieldPesoChileno, fieldReal;
        JLabel fieldUSD,fieldEUR,fieldGBP,fieldARS,fieldCLP,fieldBRL;

        fieldDolar = new JLabel("Dólar");
        fieldEuro = new JLabel("Euro");
        fieldLibras = new JLabel("Libras Esterlinas");
        fieldPesoArgentino = new JLabel("Peso Argentino");
        fieldPesoChileno = new JLabel("Peso Chileno");
        fieldReal = new JLabel("Real");

        fieldUSD = new JLabel("USD");
        fieldEUR = new JLabel("EUR");
        fieldGBP = new JLabel("GBP");
        fieldARS = new JLabel("ARS");
        fieldCLP = new JLabel("CLP");
        fieldBRL = new JLabel("BRL");

        String[] optionCoin = {
                fieldUSD.getText(),
                fieldEUR.getText(),
                fieldGBP.getText(),
                fieldARS.getText(),
                fieldCLP.getText(),
                fieldBRL.getText()
        };

        String[] optionsToChoose = {
                fieldDolar.getText(),
                fieldEuro.getText(),
                fieldLibras.getText(),
                fieldPesoArgentino.getText(),
                fieldPesoChileno.getText(),
                fieldReal.getText()
        };

        JFrame jFrame = new JFrame();

        JComboBox<String> jComboBox1 = new JComboBox<>(optionsToChoose);
        jComboBox1.setBounds(180, 50, 100, 20);

        JComboBox<String> jComboBox2 = new JComboBox<>(optionCoin);
        jComboBox2.setBounds(15,50,60,20);

        JButton jButton = new JButton("Selecionar");
        JLabel jLabel = new JLabel();

        jTextField.setBounds(80, 50, 90, 20);
        jButton.setBounds(180, 80, 100, 20);
        resultado.setBounds(140, 200, 100, 60);
        jLabel.setBounds(90, 100, 400, 100);

        // estilização
        int buttonWidth = 100;
        int buttonHeight = 30;

        jComboBox1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jComboBox1.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        jComboBox2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jComboBox2.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        resultado.setFont(new Font("Verdana", Font.BOLD, 15));
        resultado.setForeground(new Color(0, 0, 0));

        jButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(new Color(0, 0, 0));
        //fim estilizaçã0

        jFrame.add(jButton);
        jFrame.add(jComboBox1);
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(resultado);
        jFrame.add(jComboBox2);

        jFrame.setLayout(null);
        jFrame.setSize(350, 400);
        jFrame.setVisible(true);

        jButton.addActionListener(e -> {

            int choice1 = jComboBox1.getSelectedIndex();
            int choice2 = jComboBox2.getSelectedIndex();

            try {
                bConverterClick(choice1,choice2);
            } catch (NumberFormatException | IOException exc) {
                jTextField.selectAll();
                jTextField.requestFocus();
                Toolkit.getDefaultToolkit().beep();
            }
        });
    }

    private void bConverterClick(int vrl1, int vrl2) throws IOException {
        if (!jTextField.getText().equals("")) {
            try {
                BigDecimal tfValor1Big = new BigDecimal(jTextField.getText());
                BigDecimal res = Converter.convertCurrency(tfValor1Big,vrl1,vrl2);
                jTextField.setText("");
                resultado.setText(df.format(res));

            } catch (NumberFormatException exc) {
                jTextField.selectAll();
                jTextField.requestFocus();
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

}
