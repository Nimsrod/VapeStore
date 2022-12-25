package VapeStore;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateValidatorUsingDateTimeFormatter implements DateValidator {
    private DateTimeFormatter dateFormatter;

    //https://www.baeldung.com/java-string-valid-date

    //constructor , no attribute, takes the same pattern of the orders' dates
    public DateValidatorUsingDateTimeFormatter(){
        this.dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    public DateValidatorUsingDateTimeFormatter(DateTimeFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public boolean isValid(String dateStr) {
        try {
            this.dateFormatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}