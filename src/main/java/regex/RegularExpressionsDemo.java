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

        String input;
        Pattern pattern;
        Matcher matcher;

        // Простые классы символов
        /*
        input = "cave";
        pattern = Pattern.compile("[abc]");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Инвертированные классы символов
        /*
        input = "cave";
        pattern = Pattern.compile("[^abc]");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Диапазонные классы символов
        /*
        input = "clown";
        pattern = Pattern.compile("[a-n]");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Слияние нескольких диапазонов
        /*
        input = "clOwn";
        pattern = Pattern.compile("[a-mA-P]");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Объединение классов символов
        /*
        input = "clown";
        pattern = Pattern.compile("[a-d[m-p]]");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Пересечение классов символов
        /*
        input = "party";
        pattern = Pattern.compile("[a-z&&[d-f]]");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Вычитание классов символов
        /*
        input = "party";
        pattern = Pattern.compile("[a-z&&[^m-t]]");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Предопределенные классы символов
        /*
        input = "aZ.8 _";
        pattern = Pattern.compile("\\w");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Захватываемые группы
        /*
        input = "The Java language language";
        pattern = Pattern.compile("(Java( language)\\2)");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Граничные сопоставители
        /*
        input = "There before";
        pattern = Pattern.compile("^The\\w*");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Квантификаторы
        /*
        // использование жадного квантификатора:
        input = "fox box pox fax";
        pattern = Pattern.compile(".*ox");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);

        // использование ленивого квантификатора:
        input = "fox box pox fax";
        pattern = Pattern.compile(".*?ox");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);

        // использование сверхжадного квантификатора:
        input = "fox box pox fax ox";
        pattern = Pattern.compile(".*+ox");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */

        // Совпадения нулевой длины
        /*
        input = "Java is";
        pattern = Pattern.compile("\\b\\b");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);

        input = "abaa";
        pattern = Pattern.compile("a?");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);
        */


        // Вложенные флаговые выражения:

        // (?i) активирует нечувствительный к регистру поиск по шаблону
        input = "Treehouse";
        pattern = Pattern.compile("(?i)tree");
        matcher = pattern.matcher(input);

        //  последовательность символов Tree соответствует шаблону tree
        whileMatcherFind(input, matcher);


        // (?x) разрешает использование внутри шаблона пробельных символов и комментариев,
        // начинающихся с метасимвола #
        input = "matter";
        pattern = Pattern.compile(".at(?x)#match hat, cat, and so on");
        matcher = pattern.matcher(input);

        //  последовательность символов mat соответствует шаблону .at
        whileMatcherFind(input, matcher);


        // (?s): активирует режим dotall, в котором метасимвол точки соответствует разделителям строк,
        // помимо любого другого символа
        input = "\n";
        pattern = Pattern.compile("(?s)");
        matcher = pattern.matcher(input);

        // найден символ новой строки
        whileMatcherFind(input, matcher);

        // при команде Java RegexDemo "." "\n" символ новой строки найден не будет
        input = "\n";
        pattern = Pattern.compile(".");
        matcher = pattern.matcher(input);

        // символ новой строки не найден
        whileMatcherFind(input, matcher);


        // (?m): активирует многострочный режим, при котором ^ соответствует началу, а $ – концу каждой строки
        input = "abc\nabc";
        pattern = Pattern.compile("(?m)^abc$");
        matcher = pattern.matcher(input);

        //  находит во входном тексте обе последовательности abc
        whileMatcherFind(input, matcher);

        // по умолчанию используется однострочный режим: ^ соответствует началу всего входного текста, а $ — его концу
        input = "abc\nabc";
        pattern = Pattern.compile("^abc$");
        matcher = pattern.matcher(input);

        // возвращает ответ об отсутствии совпадений
        whileMatcherFind(input, matcher);


        // (?u): активирует выравнивание регистра с учетом Unicode
        input = "abCdeFG";
        pattern = Pattern.compile("(?u)(?i)bcd");
        matcher = pattern.matcher(input);

        whileMatcherFind(input, matcher);


        // (?d): активирует режим строк в стиле Unix, при котором сопоставитель распознает в контексте
        // метасимволов ., ^ и $ только разделитель строк \n

    }

    private static void whileMatcherFind(String input, Matcher matcher) {

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Found [" + input.substring(
                    start, end) + "] starting at " + start + " and ending at " + end);
        }
        System.out.println("---------------------------------------------------");
    }
}