package edu.ou.activitysyncdataservice.common.mapper;

import edu.ou.activitysyncdataservice.data.CommentDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Map;

@Mapper
public interface CommentDocumentMapper {
    CommentDocumentMapper INSTANCE = Mappers.getMapper(CommentDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to CommentDocument object
     *
     * @param map represents for CommentAddRequest object
     * @return CommentDocument object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "content", source = "content", qualifiedByName = "objectToString")
    @Mapping(target = "totalEmotion", source = "totalEmotion", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    @Mapping(target = "postId", source = "postId", qualifiedByName = "objectToInt")
    @Mapping(target = "commentId", source = "commentId", qualifiedByName = "objectToInt")
    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "objectToDate")
    CommentDocument fromMap(Map<String, Object> map);

    /**
     * Convert object to String
     *
     * @param object object will be converted
     * @return String object
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToString")
    static String objectToString(Object object) {
        return (String) object;
    }

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

    /**
     * Convert object to Date
     *
     * @param object object will be converted
     * @return Date object
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToDate")
    static Date objectToDate(Object object) {
        return new Date((long) object);
    }
}
