package my.home.jkits.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StatisticMapper {
    @Select("select name from public.tags;")
    public List<String> getTags();
}
