package cc.lijad.blog.exception;

/**
 * @author 李坚达
 * @create 2022/11/14 15:06
 */
public final class LoginException extends RuntimeException {
    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }
}
