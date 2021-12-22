import java.util.Arrays;
import java.util.List;

public class NotationConverter {

    private final List<String> units = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");
    private final List<String> tens = Arrays.asList("X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC");
    private final List<String> hundreds = Arrays.asList("C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM");
    private final List<String> thousands = Arrays.asList("M", "MM", "MMM");

    public int toArabic(String romanNotaion) throws InvalidValueException {
        if (!romanNotaion.matches("[IVXLCDM]+")) {
            throw new InvalidValueException();
        }

        int arabicNotation = 0;
        for (int i = thousands.size(); i > 0; i--) {
            if (romanNotaion.startsWith(thousands.get(i-1))){
               romanNotaion = romanNotaion.replaceFirst(thousands.get(i-1),"");
                arabicNotation =  1000 * i;
            }
        }
        for (int i = hundreds.size(); i > 0; i--) {
            if (romanNotaion.startsWith(hundreds.get(i-1))){
                romanNotaion = romanNotaion.replaceFirst(hundreds.get(i-1),"");
                arabicNotation = arabicNotation + 100 * i;
                break;
            }
        }
        for (int i = tens.size(); i > 0; i--) {
            if (romanNotaion.startsWith(tens.get(i-1))){
                romanNotaion = romanNotaion.replaceFirst(tens.get(i-1),"");
                arabicNotation = arabicNotation + 10 * i;
                break;
            }
        }
        for (int i = units.size(); i > 0; i--) {
            if (romanNotaion.startsWith(units.get(i-1))){
                romanNotaion = romanNotaion.replaceFirst(units.get(i-1),"");
                arabicNotation = arabicNotation +  i;
                break;
            }
        }

      if (!romanNotaion.isEmpty()){
         throw new InvalidValueException();
      }

        return arabicNotation;
    }

}
