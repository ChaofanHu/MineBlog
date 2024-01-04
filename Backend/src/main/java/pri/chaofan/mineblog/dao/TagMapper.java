package pri.chaofan.mineblog.dao;

import pri.chaofan.mineblog.pojo.Tag;

import java.util.List;

public interface TagMapper {
    List<Tag> selectAll();
}
