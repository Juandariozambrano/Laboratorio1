import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class Node {
    char value;
    Node left;
    Node right;

    Node(char value) {
        this.value = value;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una expresion matematica con espacios entre numeros y operadores:");
        String input = scanner.nextLine();
        scanner.close();
        runTests();

        Node root = buildTree(input);
        if (root != null) {
            int result = evalTree(root);
            System.out.println("El resultado es: " + result);
        } else {
            System.out.println("Error: caracteres invalidos detectados.");
        }

    }

    private static void runTests() {
        try {
            BufferedReader inputReader = new BufferedReader(new FileReader("test1.input"));
            BufferedReader outputReader = new BufferedReader(new FileReader("test1.output"));

            String inputLine;
            while ((inputLine = inputReader.readLine()) != null) {
                int expectedOutput = Integer.parseInt(outputReader.readLine());
                Node root = buildTree(inputLine);
                int result = evalTree(root);
                if (result != expectedOutput) {
                    System.out.println("Error: resultado incorrecto para la expresion: " + inputLine);
                    System.out.println("Resultado esperado: " + expectedOutput);
                    System.out.println("Resultado obtenido: " + result);
                }
            }

            inputReader.close();
            outputReader.close();
        } catch (IOException e) {
            System.out.println("Error: no se pudo leer el archivo de entrada o salida.");
        }
    }

    private static Node buildTree(String postfix) {
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(new Node(c));
            } else {
                Node right = stack.pop();
                Node left = stack.pop();
                Node parent = new Node(c);
                parent.left = left;
                parent.right = right;
                stack.push(parent);
            }
        }

        if (stack.size() != 1) {
            return null;
        }

        return stack.peek();
    }

    private static int evalTree(Node node) {
        if (node.left == null && node.right == null) {
            return Character.getNumericValue(node.value);
        }

        int leftValue = evalTree(node.left);
        int rightValue = evalTree(node.right);

        switch (node.value) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                if (rightValue == 0) {
                    throw new ArithmeticException("Division entre cero");
                }
                return leftValue / rightValue;
            default:
                throw new AssertionError("Operador desconocido: " + node.value);
        }
    }
}
