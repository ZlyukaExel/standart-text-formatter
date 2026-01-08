package text_formatter;

public class TextFormatter {
    public static String formatText(String text, int maxWidth, int padding){
        String[] paragraphs = text.split("\n");
        StringBuilder result = new StringBuilder();

        for(String paragraph : paragraphs){
            result.append(formatParagraph(paragraph, maxWidth, padding));
        }

        return result.toString();
    }

    private static String formatParagraph(String paragraph, int maxWidth, int padding){
        paragraph = paragraph.trim();
        StringBuilder result = new StringBuilder();
        result.append(" ".repeat(padding));
        int lineWidth = 6;
        String[] words = paragraph.split(" ");
        for(String word : words){
            int wordLength = word.length();
            // Пока есть место на этой строке
            if (lineWidth + wordLength <= maxWidth){
                lineWidth += wordLength + 1;
                result.append(word).append(" ");
            }
            // Перенос на новую строку
            else {
                result.append("\n").append(word).append(" ");
                lineWidth = wordLength + 1;
            }
        }
        return result + "\n";
    }
}
