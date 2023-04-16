package userInterface;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class NumberFormatter {

    public TextFormatter<Integer> numberFormatter() {

        NumberFormat format = NumberFormat.getInstance();
        format.setParseIntegerOnly(true);

        TextFormatter<Integer> formatter = new TextFormatter<>(
                c -> {
                    if (c.getControlNewText().isEmpty()) {
                        return c;
                    }

                    ParsePosition parsePosition = new ParsePosition(0);
                    Object object = format.parse(c.getControlNewText(), parsePosition);

                    if (object == null || parsePosition.getIndex() != c.getControlNewText().length()) {
                        return null;
                    } else {
                        return c;
                    }
                });

        return formatter;

    }

    public TextFormatter<Double> decimalFormatter() {
        StringConverter<Double> converter = new DoubleStringConverter();
        TextFormatter<Double> formatter = new TextFormatter<>(converter, null,
                change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("-?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)")) {
                        return change;
                    } else {
                        return null;
                    }
                });
        return formatter;
    }

}
