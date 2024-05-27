package calculator.Model;
import calculator.Model.OperationModel;
import java.util.ArrayList;

public class HistoryModel {
    
    private ArrayList<OperationModel> operations;

    public HistoryModel() {
        this.operations = new ArrayList<>();
    }
    
    public void addOperation(OperationModel operation) {
        this.operations.add(operation);
    }

    public ArrayList<OperationModel> getOperations() {
        return operations;
    }
    
}
