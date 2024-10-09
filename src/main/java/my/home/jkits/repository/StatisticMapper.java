package my.home.jkits.repository;

import my.home.jkits.model.Pattern;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface StatisticMapper {
    @Select("select name from public.tags;")
    public List<String> getTags();

    @Insert("insert into public.types(text) values(#{text});")
    public void setType(@PathVariable("text") String text);

    @Select("select text from public.types;")
    public List<String> getTypes();

    @Select("select url from sources where id = #{id};")
    public String getSource(@PathVariable("id") int id);

    @Select("SELECT title, start_tag, end_tag FROM public.get_patterns(#{sourceType});")
    @Results({
            @Result(property = "title", column = "title"),
            @Result(property = "startTag", column = "start_tag"),
            @Result(property = "endTag", column = "end_tag")
    })
    public List<Pattern> getPatterns(@PathVariable("sourceType") String sourceType);
}
