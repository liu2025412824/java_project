package qqcommon;

import java.io.Serializable;

/**
 * @author Lzy
 * @version 1.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String passwd;

    public User(){} //无参构造器
    public User(String userId,String passwd){
        this.userId = userId;
        this.passwd = passwd;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
