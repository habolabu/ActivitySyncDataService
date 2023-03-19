package edu.ou.activitysyncdataservice.common.mapper;

import edu.ou.activitysyncdataservice.data.CommentEmotionDocument;
import edu.ou.activitysyncdataservice.data.CommentEmotionDocumentPK;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface CommentEmotionDocumentMapper {
    CommentEmotionDocumentMapper INSTANCE = Mappers.getMapper(CommentEmotionDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to CommentEmotionDocument object
     *
     * @param map represents for CommentEmotionAddRequest object
     * @return CommentEmotionDocument object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    @Mapping(target = "commentId", source = "commentId", qualifiedByName = "objectToInt")
    @Mapping(target = "emotionId", source = "emotionId", qualifiedByName = "objectToInt")
    CommentEmotionDocument fromMap(Map<String, Object> map);

    /**
     * Map Map<String, Object> object to CommentEmotionDocumentPK object
     *
     * @param map represents for CommentEmotionDocumentPK object
     * @return CommentEmotionDocumentPK object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "commentId", source = "commentId", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    @Mapping(target = "emotionId", source = "emotionId", qualifiedByName = "objectToInt")
    CommentEmotionDocumentPK fromMapPK(Map<String, Object> map);

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
