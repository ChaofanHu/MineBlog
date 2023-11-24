package pri.chaofan.mineblog.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String nickname;
    private String username;
    private String email;
    private String password;
    private int type;
    private String iconUrl;
    private Date createTime;
    private Date updateTime;





}
