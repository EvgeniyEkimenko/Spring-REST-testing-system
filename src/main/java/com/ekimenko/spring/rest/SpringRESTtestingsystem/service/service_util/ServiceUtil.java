package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util;

import org.springframework.stereotype.Service;

import java.util.*;
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
        }
        catch (Exception ignore) {
            return null;
        }
    }

}
