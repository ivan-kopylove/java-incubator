package e798;

import org.springframework.http.HttpStatusCode;

class CustomException extends RuntimeException
{

    private final HttpStatusCode statusCode;

    CustomException(String message, HttpStatusCode statusCode)
    {
        super(message);
        this.statusCode = statusCode;
    }

    HttpStatusCode getStatusCode()
    {
        return statusCode;
    }
}
