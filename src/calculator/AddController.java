package calculator;

import java.text.DecimalFormat;

public class AddController {

    private Calculator model;
    private CalculatorFrame view;

    public AddController(Calculator model, CalculatorFrame view) {
        this.model = model;
        this.view = view;
    }

    //Metodo para sumar
    public void addOperation() {

        //Try en caso de que pongan algo que no sea un numero
        try {

            if (!view.getNumber1().isEmpty() && !view.getNumber2().isEmpty()) { //Verifica que no sean números vacios

                String field1 = view.getNumber1();
                String field2 = view.getNumber2();
                
                //Si el usuario usa "," lo remplaza con "."
                if (field1.contains(",")) {
                    field1 = field1.replace(",", ".");
                } 
                if (field2.contains(",")) {
                    field2 = field2.replace(",", ".");
                }

                //Maximo 3 digitos enteros, de lo contrarío se pontra en formato 1.1...e1 al multiplicar si son mas
                if (String.valueOf((int) Double.parseDouble(field1)).length() > 3 || String.valueOf((int) Double.parseDouble(field2)).length() > 3) {
                    view.showErrorMessage(4);
                } else {

                    if (checkDecimalPlaces(field1) && checkDecimalPlaces(field2)) { //Verifia que no tenga mas de 3 numeros decimales

                        double num1 = Double.parseDouble(field1);
                        double num2 = Double.parseDouble(field2);

                        double result = model.add(num1, num2); //Suma los numeros, luego formatea para maximo 3 digitos decimales y luego lo pasa a double

                        view.setResult(String.valueOf(result)); //Cambia el label del resultado en el view
                        view.addHistory(new Operation(num1, num2, "+", result)); //Añade la operacion al historial del view

                    } else {  //Hay mas de 3 cifras decimales
                        view.showErrorMessage(1);
                    }
                }

            } else { //En caso de que los numeros sean vacios
                view.showErrorMessage(2);
            }
        } catch (NumberFormatException e) { //En caso de que no sean numeros
            view.showErrorMessage(3);
        }

    }

    //Metodo para verificar si el numero ingresado tiene mas de 3 cifras decimales
    private static boolean checkDecimalPlaces(String numberString) {
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

}
