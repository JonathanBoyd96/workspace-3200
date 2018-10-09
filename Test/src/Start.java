public class Start {
    public static void main(String s[]) {
        Lexer lexer = new Lexer("/Users/jonathanboyd/Desktop/Test/Font.txt");

        while (!lexer.isExausthed()) {
            System.out.printf("%-18s %s\n", lexer.currentToken(), lexer.currentLexema());
            lexer.moveAhead();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
}