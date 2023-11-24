package pri.chaofan.mineblog.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Comment {
    private int id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private int blogId;
    private int parentCommentId;
    private String parentCommentNickname;
    private boolean adminComment;
    private List<Comment> replyComments=new ArrayList<>();
}
