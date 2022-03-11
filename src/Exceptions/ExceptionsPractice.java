package Exceptions;

public class ExceptionsPractice {

    public static void divisionError(){
        int a = 0;
        int b = 300;

        int i = b / a;
    }

    public static void main(String[] args) {
        try{
            divisionError();
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("Não pode ser dividido por zero");
        }
    }
}
