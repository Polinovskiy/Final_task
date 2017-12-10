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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class Parameterized_UI_Test extends ApplicationTest {
    private TextField dividend;
    private TextField divider;
    private TextField result;
    private Button btnClck;
    private Parent mainNode;
    private String expected;
    private String dividendS;
    private String dividerS;

    @Override
    public void start(Stage stage) throws Exception {
        mainNode = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    public Parameterized_UI_Test(String dividend, String divider, String expected) {
        this.dividendS = dividend;
        this.dividerS = divider;
        this.expected = expected;

    }

    @Before
    public void setUp() {
        dividend = find("#dividend");
        divider = find("#divider");
        result = find("#result");
        btnClck = find("#btnCalck");
    }

    private  <T extends Node> T find(final String query) {
        return lookup(query).query();
    }

    @Parameterized.Parameters(name = "{index}:division({0}/{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"12", "6", "2"},
                {"120", "0.12", "1000"},
                {"", "", "Error: dividend is incorrect or null!"},
                {"", "22", "Error: dividend is incorrect or null!"},
                {"35", "", "Error: divider is incorrect or null!"},
                {"20", "0", "Error: Division by zero!"}
        });
    }

    @Test
    public void paramTest() {
        //set
        dividend.setText(dividendS);
        divider.setText(dividerS);
        //run
        btnClck.fire();
        //assert
        Assert.assertEquals(expected, result.getText());
    }
}
