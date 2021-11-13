package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.test_result_service_util;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultServiceUtil {

    public static List<Long> getAllIdFromTestResultList(List<TestResult> testResultList) {
        List<Long> listId = new ArrayList<>();

        for (TestResult t : testResultList) {
            listId.add(t.getId());
        }
        return listId;
    }

}
