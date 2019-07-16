package main.java.web.exceptions;

public class BaseResponse<T> {

    protected boolean isSuccess = true;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
