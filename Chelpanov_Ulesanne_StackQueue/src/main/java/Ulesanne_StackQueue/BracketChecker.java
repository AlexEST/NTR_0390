package Ulesanne_StackQueue;

/**
 * 
 * @author Alexander Chelpanov
 * Date: 17.02.2021
 * 
 * Класс для проверки на скобки. Lafore style.
 * 
 */
class BracketChecker {

    private String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);
        boolean isCorrect = true;

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;

                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = (char) theStack.pop();
                        if ((ch == '}' && chx != '{')// если закрывающая скобка другая выводим ошибку и ее индекс
                                || (ch == ']' && chx != '[')
                                || (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + j);
                            isCorrect = false;
                        }  
                    } else {
                        System.out.println("Error: " + ch + " at " + j);
                        isCorrect = false;
                    }
                    break;
                default:
                    break;
            }
        }

        if (!theStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");// при отсутствии закрывающей скобки
            isCorrect = false;
        }
        if (isCorrect == true) {
            System.out.println("Order is correct.");
        }
    }
}
