package com.asaunin.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.springframework.util.StringUtils;

@Mapper(componentModel = "spring")
public interface ObjectIdMapper {

    default String fromObjectIdToString(ObjectId id) {
        return id.toHexString();
    }

    default ObjectId fromStringToObjectId(String id) {
        if (id != null && !StringUtils.isEmpty(id)) {
            return new ObjectId(id);
        }
        return null;
    }

}
