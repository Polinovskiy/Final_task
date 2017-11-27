package Operations;

public class Divider {
    private Double a;
    private Double b;

    public String Divide(String aa, String bb){
        a=parseTextField(aa);
        b=parseTextField(bb);
        if (a==null){
            return "Error: dividend is incorrect or null!";
        }
        if (b==null){
            return "Error: divider is incorrect or null!";
        }
        if (b.equals(0.0)&& !a.equals(0.0)){
                return "Error: Division by zero!";
        }
        if ((a/b)%1==0){
            return Integer.valueOf((int)(a/b)).toString();
        }

        else {
            return Double.toString(a / b);
        }
    }

    private Double parseTextField(String val){
        Double result=0.0;
        try {
            result=Double.parseDouble(val);
            if (val.toLowerCase().contains("d")||val.toLowerCase().contains("f")||val.contains(" ")){
                return null;
            }
        }
        catch (NumberFormatException nfe){
            return null;
        }
        return result;
    }
}
