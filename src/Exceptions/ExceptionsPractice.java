package Exceptions;

import java.io.IOException;

public class ExceptionsPractice {

    public static void divisionError(){
        int a = 0;
        int b = 300;

        int i = b / a;
    }

    public static void main(String[] args) {
        try(ExampleRepository repository = new ExampleRepository()){
            //divisionError();
            repository.save();
        }catch (ArithmeticException e){
            throw new CustomException("Não pode ser dividido por zero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
