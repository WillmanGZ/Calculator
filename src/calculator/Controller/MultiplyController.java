package calculator.Controller;

import calculator.View.CalculatorFrame;
import calculator.Model.MultiplyModel;
import calculator.Model.OperationModel;
import static calculator.Model.DecimalsModel.checkDecimalPlaces;
import static calculator.Model.DecimalsModel.toThreeDecimals;

public class MultiplyController {

    private MultiplyModel model;
    private CalculatorFrame view;

    public MultiplyController(MultiplyModel model, CalculatorFrame view) {
        this.model = model;
        this.view = view;
    }

    //Metodo para multiplicar
    public void multiplyOperation() {

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

                if (checkDecimalPlaces(field1) && checkDecimalPlaces(field2)) { //Verifia que no tenga mas de 3 numeros decimales

                    double num1 = Double.parseDouble(field1);
                    double num2 = Double.parseDouble(field2);

                    double result = toThreeDecimals(model.multiply(num1, num2)); //Suma los numeros, luego formatea para maximo 3 digitos decimales y luego lo pasa a double

                    view.setResult(String.valueOf(result)); //Cambia el label del resultado en el view
                    view.addHistory(new OperationModel(num1, num2, "*", result)); //Añade la operacion al historial del view

                } else {  //Hay mas de 3 cifras decimales
                    view.showErrorMessage(1);
                }

            } else { //En caso de que los numeros sean vacios
                view.showErrorMessage(2);
            }
        } catch (NumberFormatException e) { //En caso de que no sean numeros
            view.showErrorMessage(3);
        }

    }
}
