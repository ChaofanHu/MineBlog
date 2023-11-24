package pri.chaofan.mineblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private int id;
    private String title;
    private String introduction;
    private String content;
    private String firstPicture;
    private int views;
    private String createTime;
    private String updateTime;
    private int categoryType;
//    private int tagId;
    private int userId;
    private int commentCount;
    private String blogType;
}
