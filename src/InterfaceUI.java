import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class InterfaceUI extends JFrame {
    private JLabel jUnidade1, jUnidade2, jUnidade3, jUnidade4, jUnidade5, jUnidade6;
    private JLabel junit1,junit2,junit3,junit4,junit5,junit6;
    private DecimalFormat df = new DecimalFormat("####,#00.00");

    JTextField jTextField = new JTextField();
    JLabel resultado = new JLabel("Resultado");

    public InterfaceUI() {

        super("Conversor");

        jUnidade1 = new JLabel("Dólar");
        jUnidade2 = new JLabel("Euro");
        jUnidade3 = new JLabel("Libras Esterlinas");
        jUnidade4 = new JLabel("Peso Argentino");
        jUnidade5 = new JLabel("Peso Chileno");
        jUnidade6 = new JLabel("Real");

        junit1 = new JLabel("USD");
        junit2 = new JLabel("EUR");
        junit3 = new JLabel("GBP");
        junit4 = new JLabel("ARS");
        junit5 = new JLabel("CLP");
        junit6 = new JLabel("BRL");

        String[] optionMoedas = {
                junit1.getText(),
                junit2.getText(),
                junit3.getText(),
                junit4.getText(),
                junit5.getText(),
                junit6.getText()
        };

        String[] optionsToChoose = {
                jUnidade1.getText(),
                jUnidade2.getText(),
                jUnidade3.getText(),
                jUnidade4.getText(),
                jUnidade5.getText(),
                jUnidade6.getText()
        };

        JFrame jFrame = new JFrame();

        JComboBox<String> jComboBox1 = new JComboBox<>(optionsToChoose);
        jComboBox1.setBounds(180, 50, 100, 20);

        JComboBox<String> jComboBox2 = new JComboBox<>(optionMoedas);
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
        //jButton.setFont(new Font("verdana", Font.BOLD, 22));
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

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int choice1 = jComboBox1.getSelectedIndex();
                int choice2 = jComboBox2.getSelectedIndex();

                try {
                    bConverterClick(choice1,choice2);
                } catch (NumberFormatException | IOException exc) {
                    jTextField.selectAll();
                    jTextField.requestFocus();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }

    private void bConverterClick(int vrl1, int vrl2) throws IOException {
        if (!jTextField.getText().equals("")) {
            try {
                BigDecimal tfValor1Big = new BigDecimal(jTextField.getText());
                BigDecimal res = Conversor.converterMoedaBrasileiraEua(tfValor1Big,vrl1,vrl2);
                jTextField.setText("");
                resultado.setText("" + df.format(res));

            } catch (NumberFormatException exc) {
                jTextField.selectAll();
                jTextField.requestFocus();
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

}
