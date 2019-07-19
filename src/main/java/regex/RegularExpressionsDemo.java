package main.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsDemo {
    public static void main(String[] args) {

        // Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);

        /*
        String text = "Егор Алла Александр";
        Pattern pattern = Pattern.compile("А.+?л");      // Алл
        // Pattern pattern = Pattern.compile("А.++а");   // совпадений не найдено
        // Pattern pattern = Pattern.compile("А.+л");    // Алла Алл
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
        */

        /*
        String str1 = "The root directory is\nWindows";         // перенос Windows на новую строку
        System.out.println("str1: " + str1);

        String str2 = "The root directory is \u00A7Windows";    // вставка символа параграфа перед Windows
        System.out.println("\nstr2: " + str2);

        String regex1 = "\\s";           // шаблон для поиска символов пробела
        System.out.println("\nregex1: " + regex1);

        String regex2 = "\\Windows\\";   // шаблон для поиска строки ”Windows”
        System.out.println("\nregex2: " + regex2);
        */

        /*
        System.out.println(Pattern.matches("А.+а", "Алла"));                 // true
        System.out.println(Pattern.matches("А.+а", "Егор Алла Александр"));  // false

        String text = "Егор Алла Анна";
        Pattern pattern = Pattern.compile("А.+?а");

        Matcher matcher = pattern.matcher(text);
        whileMatcherFind(input, matcher);
        System.out.println(matcher.replaceFirst("Ира"));
        System.out.println(matcher.replaceAll("Ольга"));
        System.out.println(text);
        */

        // Простые классы символов
        /*
        String input = "cave";
        Pattern pattern = Pattern.compile("[abc]");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Инвертированные классы символов
        /*
        String input = "cave";
        Pattern pattern = Pattern.compile("[^abc]");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Диапазонные классы символов
        /*
        String input = "clown";
        Pattern pattern = Pattern.compile("[a-n]");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Слияние нескольких диапазонов
        /*
        String input = "clOwn";
        Pattern pattern = Pattern.compile("[a-mA-P]");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Объединение классов символов
        /*
        String input = "clown";
        Pattern pattern = Pattern.compile("[a-d[m-p]]");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Пересечение классов символов
        /*
        String input = "party";
        Pattern pattern = Pattern.compile("[a-z&&[d-f]]");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Вычитание классов символов
        /*
        String input = "party";
        Pattern pattern = Pattern.compile("[a-z&&[^m-t]]");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Предопределенные классы символов
        /*
        String input = "aZ.8 _";
        Pattern pattern = Pattern.compile("\\w");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Захватываемые группы
        /*
        String input = "The Java language language";
        Pattern pattern = Pattern.compile("(Java( language)\\2)");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Граничные сопоставители
        /*
        String input = "There before";
        Pattern pattern = Pattern.compile("^The\\w*");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Совпадения нулевой длины

        String input = "Java is";
        Pattern pattern = Pattern.compile("\\b\\b");
        Matcher matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);



    }

    private static void whileMatcherFind(String input, Matcher matcher) {

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Found [" + input.substring(
                    start, end) + "] starting at " + start + " and ending at " + end);
        }
    }
}