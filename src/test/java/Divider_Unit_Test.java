import Operations.Divider;
import org.junit.Test;
import org.junit.Assert;


public class Divider_Unit_Test {
    private Divider divider=new Divider();
    private final double eps=1e-10;


    @Test
    public void IntegerNumber(){
        //assert
        Assert.assertEquals(divider.Divide("30","2"),"15");
    }
    @Test
    public void InfiniteFraction(){
        //run
        final double actual=1.11111111111111111111111;
        double res= Double.parseDouble(divider.Divide("10","9"));
        //assert
        Assert.assertTrue(Math.abs(res-actual)<eps);
    }
    @Test
    public void FinalFraction(){
        //assert
        Assert.assertEquals(divider.Divide("220","40"),"5.5");
    }
    @Test
    public void DivisionWithSign(){
        //assert
        Assert.assertEquals(divider.Divide("-50","10"),"-5");
        Assert.assertEquals(divider.Divide("33","-3.3"),"-10");
        Assert.assertEquals(divider.Divide("-8","-4"),"2");
    }
    @Test
    public void EmptyValues(){
        //assert
        Assert.assertEquals(divider.Divide("","12").charAt(0),'E');
        Assert.assertEquals(divider.Divide("22","").charAt(0),'E');
        Assert.assertEquals(divider.Divide("","").charAt(0),'E');
    }
    @Test
    public void IncorrectValues() {
        //assert
        for (int i = 32; i < 255; i++) {
            switch (i){
                case 43:break; //'+'
                case 45:break; //'-'
                case 46:break; //'.'
                case 48: i=58; //'0'..'9'
                break;
                default:{
                    Assert.assertEquals(divider.Divide(Character.toString((char) i), "25").charAt(0), 'E');
                    Assert.assertEquals(divider.Divide(Character.toString((char) i)+"5.4", "50").charAt(0), 'E');
                    Assert.assertEquals(divider.Divide("60", Character.toString((char) i)).charAt(0), 'E');
                    Assert.assertEquals(divider.Divide("30", "2.3"+ Character.toString((char) i)).charAt(0), 'E');
                }
            }
        }
    }
    @Test
    public void ZeroDivision(){
        //assert
        Assert.assertEquals(divider.Divide("16","0").charAt(0),'E');
        Assert.assertEquals(divider.Divide("0","6"),"0");
        Assert.assertEquals(divider.Divide("0","0"),"NaN");
    }
    @Test
    public void MultiFloatPoints(){
        //assert
        Assert.assertEquals(divider.Divide("2..5","25").charAt(0),'E');
        Assert.assertEquals(divider.Divide("44",".5.65.7").charAt(0),'E');
        Assert.assertEquals(divider.Divide("4.56.7","4.56.7").charAt(0),'E');
    }
}
