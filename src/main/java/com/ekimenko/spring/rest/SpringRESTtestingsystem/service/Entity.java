package com.ekimenko.spring.rest.SpringRESTtestingsystem.service;

import java.util.List;

public interface Entity {

    <T> List<T> getSet(List<T> modelList);

}
