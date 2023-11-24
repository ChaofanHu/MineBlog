package pri.chaofan.mineblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pri.chaofan.mineblog.dao.FlagMapper;
import pri.chaofan.mineblog.pojo.Flag;
import pri.chaofan.mineblog.service.FlagService;

import java.util.List;

@Service
public class FlagServiceImpl implements FlagService {
    @Autowired
    private FlagMapper flagMapper;
    @Override
    public List<Flag> selectAll() {
        List<Flag> flags = flagMapper.selectAll();
        return flags;
    }
}
