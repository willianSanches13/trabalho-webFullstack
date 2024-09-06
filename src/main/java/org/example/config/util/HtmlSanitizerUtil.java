package org.example.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.apache.commons.text.StringEscapeUtils;

public class HtmlSanitizer {
    public static String sanitize(String input) {
        return Jsoup.clean(input, Safelist.basic());
    }
}

public class HtmlEscapeUtil {
    public static String escapeHtml(String input) {
        return StringEscapeUtils.escapeHtml4(input);
    }
}