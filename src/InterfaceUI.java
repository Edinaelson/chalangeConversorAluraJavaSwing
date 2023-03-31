import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class InterfaceUI extends JFrame {
    final DecimalFormat df = new DecimalFormat("####,#00.00");
    JTextField jTextField = new JTextField();
    JLabel result = new JLabel("Resultado");
    public InterfaceUI() {
        super("Conversor");

        JLabel fieldUSD,fieldEUR,fieldGBP,fieldARS,fieldCLP,fieldBRL;
        JLabel fieldDolar, fieldEuro, fieldLibras, fieldPesoArgentino, fieldPesoChileno, fieldReal;

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

        JComboBox<String> jComboBox = new JComboBox<>(optionCoin);
        JComboBox<String> jComboBox1 = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(15,50,60,20);
        jComboBox1.setBounds(180, 50, 100, 20);

        JButton jButton = new JButton("Selecionar");

        JLabel jLabel = new JLabel();

        jTextField.setBounds(80, 50, 90, 20);
        jButton.setBounds(180, 80, 100, 20);
        result.setBounds(140, 200, 100, 60);
        jLabel.setBounds(90, 100, 400, 100);

        // estilização
        int btnWidth = 100;
        int buttonHeight = 30;
        jComboBox1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jComboBox1.setPreferredSize(new Dimension(btnWidth, buttonHeight));
        jComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jComboBox.setPreferredSize(new Dimension(btnWidth, buttonHeight));

        result.setFont(new Font("Verdana", Font.BOLD, 15));
        result.setForeground(new Color(0, 0, 0));

        jButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton.setPreferredSize(new Dimension(btnWidth, buttonHeight));
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(new Color(0, 0, 0));
        //fim estilizaçã0

        jFrame.add(jButton);
        jFrame.add(jComboBox1);
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(result);
        jFrame.add(jComboBox);

        jFrame.setLayout(null);
        jFrame.setSize(350, 400);
        jFrame.setVisible(true);

        jButton.addActionListener(e -> {
            int choice1 = jComboBox1.getSelectedIndex();
            int choice2 = jComboBox.getSelectedIndex();
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
                result.setText(df.format(res));

            } catch (NumberFormatException exc) {
                jTextField.selectAll();
                jTextField.requestFocus();
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

}
