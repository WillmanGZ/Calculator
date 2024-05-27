package calculator.Controller;

import calculator.View.CalculatorFrame;
import calculator.Model.OperationModel;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

public class HistoryController {

    private CalculatorFrame view;

    public HistoryController(CalculatorFrame view) {
        this.view = view;
    }

    public void updateHistory() {
        ArrayList<OperationModel> operationHistory = view.getHistory().getOperations();
        Collections.reverse(operationHistory);

        DefaultListModel model = new DefaultListModel();
        model.addAll(operationHistory);
        view.setHistoryModel(model);
    }
}
