package pri.chaofan.mineblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pri.chaofan.mineblog.dao.TagMapper;
import pri.chaofan.mineblog.pojo.Tag;
import pri.chaofan.mineblog.service.TagService;

import java.util.List;

@Service
public class TagServiceImp implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectAll() {
        List<Tag> tags = tagMapper.selectAll();
        return tags;
    }
}
