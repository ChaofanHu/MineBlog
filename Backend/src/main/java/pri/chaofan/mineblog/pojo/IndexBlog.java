package pri.chaofan.mineblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexBlog {
    private int id;
    private String title;
    private String introduction;
    private String firstPicture;
    private String createdTime;
    private String updatedTime;
    private String username;
    private int views;
    private String blogType;
    private String iconUrl;
}
