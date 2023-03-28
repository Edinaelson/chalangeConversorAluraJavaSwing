import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conversor {

   public static BigDecimal brasileira(int x){

       List<BigDecimal> real = new ArrayList<>();

       real.add(new BigDecimal("5.26"));        //0 EUA
       real.add(new BigDecimal("5.61"));        //1 EURO
       real.add(new BigDecimal("6.43"));        //2 LIBRA
       real.add(new BigDecimal("0.025"));       //3 PESO ARGENTINO
       real.add(new BigDecimal("0.0065"));      //4 PESO CHILENO
       real.add(new BigDecimal("1.00"));        //5 REAL

       return real.get(x);
   }
   public static BigDecimal moeda(int x){

       List<BigDecimal> value = new ArrayList<>();

       value.add(new BigDecimal("0.19"));       //0 EUA
       value.add(new BigDecimal("0.18"));       //1 EURO
       value.add(new BigDecimal("0.16"));       //2 LIBRA
       value.add(new BigDecimal("40.19"));      //3 PESO ARGENTINO
       value.add(new BigDecimal("154.76"));     //4 PESO CHILENO
       value.add(new BigDecimal("1.00"));       //5 REAL

       return value.get(x);
   }
    public static BigDecimal converterMoedaBrasileiraEua(BigDecimal dados, int x, int y) throws IOException {

        System.out.println("valor x:" + x);
        System.out.println("valor y:" + y);

        BigDecimal valueTeclado = new BigDecimal(String.valueOf(dados));
        BigDecimal converterParaMoedaBrasileira = valueTeclado.divide(brasileira(x), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal valueFInalConvertido = converterParaMoedaBrasileira.divide(moeda(y), 2, BigDecimal.ROUND_HALF_UP);

        System.out.println("O valor da moeda " + valueFInalConvertido);

        return valueFInalConvertido;
    }
}
