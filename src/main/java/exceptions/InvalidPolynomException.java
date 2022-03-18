package exceptions;

public class InvalidPolynomException extends Throwable {


    public InvalidPolynomException(String invalid_format_for_polynom) {
        super(invalid_format_for_polynom);
    }

    public String getInvalidPolynomException(){
        return super.toString();
    }


}
