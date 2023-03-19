package edu.ou.activitysyncdataservice.common.mapper;

import edu.ou.activitysyncdataservice.data.PostEmotionDocument;
import edu.ou.activitysyncdataservice.data.PostEmotionDocumentPK;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface PostEmotionDocumentMapper {
    PostEmotionDocumentMapper INSTANCE = Mappers.getMapper(PostEmotionDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to PostEmotionDocument object
     *
     * @param map represents for PostEmotionAddRequest object
     * @return PostEmotionDocument object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    @Mapping(target = "postId", source = "postId", qualifiedByName = "objectToInt")
    @Mapping(target = "emotionId", source = "emotionId", qualifiedByName = "objectToInt")
    PostEmotionDocument fromMap(Map<String, Object> map);

    /**
     * Map Map<String, Object> object to PostEmotionDocumentPK object
     *
     * @param map represents for PostEmotionDocumentPK object
     * @return PostEmotionDocumentPK object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "postId", source = "postId", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    @Mapping(target = "emotionId", source = "emotionId", qualifiedByName = "objectToInt")
    PostEmotionDocumentPK fromMapPK(Map<String, Object> map);

    /**
     * Convert object to in
     *
     * @param object object will be converted
     * @return int value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToInt")
    static int objectToInt(Object object) {
        return (int) object;
    }
}
