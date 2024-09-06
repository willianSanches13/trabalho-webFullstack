import org.apache.commons.lang3.StringUtils;

public class InputValidator {
    public static String sanitizeInput(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }
        return input.replaceAll("[<>\"'%;()&+]", "");
    }
    
}