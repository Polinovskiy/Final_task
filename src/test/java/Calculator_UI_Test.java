import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;


public class Calculator_UI_Test extends ApplicationTest {
    TextField a;
    TextField b;
    TextField c;
    Button btnClck;
    Parent mainNode;

    @Override
    public void start(Stage stage) throws Exception {
        mainNode = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Before
    public void setUp() {
        a = find("#a");
        b = find("#b");
        c = find("#c");
        btnClck = find("#btnCalck");
    }

    public <T extends Node> T find(final String query) {
        return lookup(query).query();
    }

    @Test
    public void DivisionByInteger(){
    //given
        a.setText("12");
        b.setText("6");
    //run
        btnClck.fire();
    //assert
        Assert.assertEquals(c.getText(),"2");
    }
    @Test
    public void DivisionByFraction(){
        //given
        a.setText("120");
        b.setText("0.12");
        //run
        btnClck.fire();
        //assert
        Assert.assertEquals(c.getText(),"1000");
    }

    @Test
    public void emptyAB(){
        //given
        a.setText("");
        b.setText("");
        //run
        btnClck.fire();
        //assert
        Assert.assertEquals(c.getText().charAt(0),'E');
    }

    @Test
    public void emptyA(){
        //given
        a.setText("");
        b.setText("33");
        //run
        btnClck.fire();
        //assert
        Assert.assertEquals(c.getText().charAt(0),'E');
    }

    @Test
    public void emptyB(){
        //given
        a.setText("35");
        b.setText("");
        //run
        btnClck.fire();
        //assert
        Assert.assertEquals(c.getText().charAt(0),'E');
    }
    @Test
    public void divisionByZero(){
        //given
        a.setText("35");
        b.setText("0");
        //run
        btnClck.fire();
        //assert
        Assert.assertEquals(c.getText().charAt(0),'E');
    }
}
