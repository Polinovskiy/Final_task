package Operations;

/**
 * Реализует операцию деления
 */
public class Divider {
    private Double dividend;  //делимое
    private Double divider;   //делитель

    /**
     * Операция деления
     *
     * @param dividendA делимое
     * @param dividerB  делитель
     * @return Результат деления или ошибку вида "Error: <Тип ошибки>"
     */
    public String Divide(String dividendA, String dividerB) {
        dividend = parseTextField(dividendA);
        divider = parseTextField(dividerB);
        if (dividend == null) {
            return "Error: dividend is incorrect or null!";
        }
        if (divider == null) {
            return "Error: divider is incorrect or null!";
        }
        if (divider.equals(0.0) && !dividend.equals(0.0)) {
            return "Error: Division by zero!";
        }
        if ((dividend / divider) % 1 == 0) {
            return Integer.valueOf((int) (dividend / divider)).toString();
        } else {
            return Double.toString(dividend / divider);
        }
    }

    /**
     * Конвертор строки в число
     *
     * @param val строка
     * @return число или null
     */
    private Double parseTextField(String val) {
        Double result;
        try {
            result = Double.parseDouble(val);
            if (val.toLowerCase().contains("d") || val.toLowerCase().contains("f") || val.contains(" ")) {
                return null;
            }
        } catch (NumberFormatException nfe) {
            return null;
        }
        return result;
    }
}
