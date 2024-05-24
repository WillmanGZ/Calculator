package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Decimals {
    //Metodo para verificar si el numero ingresado tiene mas de 3 cifras decimales
    public static boolean checkDecimalPlaces(String numberString) {
        int decimalIndex = numberString.indexOf('.');
        if (decimalIndex == -1) {
            return true; // No hay parte decimal
        }

        String decimalPart = numberString.substring(decimalIndex + 1);
        if (decimalPart.length() > 3) {
            return false; // Más de tres cifras decimales
        }

        return true; // Menos de tres cifras decimales
    }
    //Metodo para redondear a 3 numeros decimales
    public static double toThreeDecimals(double number) {
        // Convertimos el número a BigDecimal
        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        // Redondeamos el número a 3 decimales sin redondeo
        bigDecimal = bigDecimal.setScale(3, RoundingMode.DOWN);
        // Convertimos el BigDecimal de nuevo a double
        return bigDecimal.doubleValue();
    }
}
