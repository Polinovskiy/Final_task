
import Operations.Divider;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller  {
  @FXML  public TextField a;
  @FXML  public TextField b;
  @FXML  public TextField c;
         private Divider divider=new Divider();

    @FXML
    private void btnOnClick()  {
        c.setText(divider.Divide(a.getText(),b.getText()));
    }



}
