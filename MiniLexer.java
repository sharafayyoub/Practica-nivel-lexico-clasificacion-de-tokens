import java.util.Scanner;
public class MiniLexer {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto:");
        String instruccion= scanner.nextLine();
        String palabras[]= instruccion.split(" ");
        for(String palabra: palabras){
            Token token = new Token();
            token.lexema = palabra;
            if(palabra.equals("if") || palabra.equals("else") || palabra.equals("while")){
                token.tipo = TipoToken.Palabra_clave;
            } else if(palabra.matches("[a-zA-Z_][a-zA-Z0-9_]*")){
                token.tipo = TipoToken.Identificador;
            } else if(palabra.matches("[0-9]+")){
                token.tipo = TipoToken.Literal_numerico;
            } else if(palabra.equals("+") || palabra.equals("-") || palabra.equals("*") || palabra.equals("/")){
                token.tipo = TipoToken.Operador;
            } else if(palabra.equals(";") || palabra.equals(",") || palabra.equals("(") || palabra.equals(")")){
                token.tipo = TipoToken.Delimitador;
            } else {
                System.out.println("Token desconocido: " + palabra);
                continue;
            }
            System.out.println("Lexema: " + token.lexema + ", Tipo: " + token.tipo);
        }

        



    }

    
}
