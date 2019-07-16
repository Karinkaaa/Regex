package main.java.web.exceptions;

public class ErrorResponse<T> extends BaseResponse {

    private String errorCode;
    private String errorMessage;

    public ErrorResponse() {
        this.isSuccess = false;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
