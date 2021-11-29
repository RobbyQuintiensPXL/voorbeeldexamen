package be.pxl.je.voorbeeldexamen.Exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }
}