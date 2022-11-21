package cc.lijad.blog.exception;

/**
 * @author 李坚达
 * @create 2022/11/16 14:54
 */
public final class RequestParamException extends RuntimeException {

    private Object[] params;


    public RequestParamException() {
        super();
    }

    public RequestParamException(String message) {
        super(message);
    }

    public RequestParamException(String message, Object... params) {
        super(message);
        this.params = params;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
