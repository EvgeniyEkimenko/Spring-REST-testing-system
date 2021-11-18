package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ServiceUtil {

    public static <T extends EntityWithLongId> List<Long> getIds(Collection<T> entities) {
        if (null == entities) {
            return Collections.emptyList();
        }

        return entities.stream()
                .map(ServiceUtil::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static <T extends EntityWithLongId> Long getId(T entity) {
        if (null == entity) {
            return null;
        }

        try {
            return (Long) entity.getId();
        } catch (Exception ignore) {
            return null;
        }
    }

}
