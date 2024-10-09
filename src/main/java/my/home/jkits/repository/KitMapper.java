package my.home.jkits.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface KitMapper {
    @Select("CALL public.tag_add('${title}', null);")
    @Result(property = "tag_id", column = "tag_id")
    int createTag(@PathVariable String title);

    @Select("SELECT public.add_tag('${title}');")
    int createItem(@PathVariable String title);
}
