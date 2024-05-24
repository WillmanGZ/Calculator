package calculator;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

public class HistoryController {

    private Calculator model;
    private CalculatorFrame view;

    public HistoryController(Calculator model, CalculatorFrame view) {
        this.model = model;
        this.view = view;
    }

    public void updateHistory() {
        ArrayList<Operation> operationHistory = view.getHistory().getOperations();
        Collections.reverse(operationHistory);

        DefaultListModel model = new DefaultListModel();
        model.addAll(operationHistory);
        view.setHistoryModel(model);
    }
}
