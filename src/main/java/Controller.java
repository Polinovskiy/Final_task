
import Operations.Divider;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    public TextField dividend;
    @FXML
    public TextField divider;
    @FXML
    public TextField result;
    private Divider divide = new Divider();

    @FXML
    private void btnOnClick() {
        result.setText(divide.Divide(dividend.getText(), divider.getText()));
    }


}
