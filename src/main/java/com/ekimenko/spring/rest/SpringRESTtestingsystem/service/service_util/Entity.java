package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util;

import java.io.Serializable;

public interface Entity<S> extends Serializable {
    S getId();
}
