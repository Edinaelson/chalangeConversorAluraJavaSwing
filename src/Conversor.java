import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Conversor {

    public static BigDecimal converterMoedaBrasileiraEua(BigDecimal dados) throws IOException {
        BigDecimal exchangeRate = new BigDecimal(5.26);
        //Scanner dados = new Scanner(System.in);
        //System.out.println("Informe valor em reais: ");
        BigDecimal real = dados;
        BigDecimal valueInReal = new BigDecimal(String.valueOf(real));
        BigDecimal valueInDollar = valueInReal.divide(exchangeRate, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("O valor em dólar é: $" + valueInDollar);

        return valueInDollar;
    }

    public static BigDecimal converterMoedaEuaBrasileira(BigDecimal dados) throws IOException {
        BigDecimal exchangeRate = new BigDecimal(0.19);
        //Scanner dados = new Scanner(System.in);
        //System.out.println("Informe valor em reais: ");
        BigDecimal real = dados;
        BigDecimal valueInReal = new BigDecimal(String.valueOf(real));
        BigDecimal valueInDollar = valueInReal.divide(exchangeRate, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("O valor em reais é: $" + valueInDollar);

        return valueInDollar;
    }

    public static void converterMoedaBrasileiraEuro() throws IOException {
        BigDecimal exchangeRate = new BigDecimal(5.61);
        Scanner dados = new Scanner(System.in);
        System.out.println("Informe valor em reais: ");
        BigDecimal real = dados.nextBigDecimal();
        BigDecimal valueInReal = new BigDecimal(String.valueOf(real));
        BigDecimal valueInDollar = valueInReal.divide(exchangeRate, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("O valor em Euro é: $" + valueInDollar);

    }
    public static void converterMoedaBrasileiraLibrasEstelinas() throws IOException {
        BigDecimal exchangeRate = new BigDecimal(6.43);
        Scanner dados = new Scanner(System.in);
        System.out.println("Informe valor em reais: ");
        BigDecimal real = dados.nextBigDecimal();
        BigDecimal valueInReal = new BigDecimal(String.valueOf(real));
        BigDecimal valueInDollar = valueInReal.divide(exchangeRate, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("O valor em Libras Estelinas é: $" + valueInDollar);

    }
    public static void converterMoedaBrasileiraPesosArgentinos() throws IOException {
        BigDecimal exchangeRate = new BigDecimal(0.026);
        Scanner dados = new Scanner(System.in);
        System.out.println("Informe valor em reais: ");
        BigDecimal real = dados.nextBigDecimal();
        BigDecimal valueInReal = new BigDecimal(String.valueOf(real));
        BigDecimal valueInDollar = valueInReal.divide(exchangeRate, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("O valor em Pesos Argentinos é: $" + valueInDollar);

    }
    public static void converterMoedaBrasileiraPesoChileno() throws IOException {
        BigDecimal exchangeRate = new BigDecimal(0.0063);
        Scanner dados = new Scanner(System.in);
        System.out.println("Informe valor em reais: ");
        BigDecimal real = dados.nextBigDecimal();
        BigDecimal valueInReal = new BigDecimal(String.valueOf(real));
        BigDecimal valueInDollar = valueInReal.divide(exchangeRate, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("O valor em pesos Chilenos é: $" + valueInDollar);

    }

}
