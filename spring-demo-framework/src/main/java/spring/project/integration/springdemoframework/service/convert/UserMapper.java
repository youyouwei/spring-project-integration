package spring.project.integration.springdemoframework.service.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:09 2020/7/8
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    default String getName() {
        return "tom";
    }
}
