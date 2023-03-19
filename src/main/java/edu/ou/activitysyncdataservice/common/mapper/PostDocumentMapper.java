package edu.ou.activitysyncdataservice.common.mapper;

import edu.ou.activitysyncdataservice.data.PostDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Map;

@Mapper
public interface PostDocumentMapper {
    PostDocumentMapper INSTANCE = Mappers.getMapper(PostDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to PostDocument object
     *
     * @param map represents for PostAddRequest object
     * @return PostDocument object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "title", source = "title", qualifiedByName = "objectToString")
    @Mapping(target = "slug", source = "slug", qualifiedByName = "objectToString")
    @Mapping(target = "content", source = "content", qualifiedByName = "objectToString")
    @Mapping(target = "totalComment", source = "totalComment", qualifiedByName = "objectToInt")
    @Mapping(target = "totalEmotion", source = "totalEmotion", qualifiedByName = "objectToInt")
    @Mapping(target = "edited", source = "isEdited", qualifiedByName = "objectToBoolean")
    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "objectToDate")
    PostDocument fromMap(Map<String, Object> map);

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

    /**
     * Convert object to boolean
     *
     * @param object object will be converted
     * @return boolean value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToBoolean")
    static boolean objectToBoolean(Object object) {
        return (boolean) object;
    }
}
