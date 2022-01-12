package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs(outputDir = "target/generated-snippets/lesson-step")
@SpringBootTest
@AutoConfigureMockMvc
class LessonStepRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LessonStepService lessonStepService;

    @Test
    void getLessonStepById() throws Exception {
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(1L);

        Lesson lesson = new Lesson();
        lesson.setId(1L);

        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setTestId(1L);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setTheoreticalStepId(1L);
        expectedLessonStepDto.setLessonId(1L);

        when(lessonStepService
                .getLessonStepDtoById(1L))
                .thenReturn(expectedLessonStepDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/lesson-step/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("lesson-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Lesson Step Unique Identifier"))));
    }

    @Test
    void getLessonStepByIdResponseFieldDocumentation() throws Exception {
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(1L);

        Lesson lesson = new Lesson();
        lesson.setId(1L);

        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setTestId(1L);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setTheoreticalStepId(1L);
        expectedLessonStepDto.setLessonId(1L);

        when(lessonStepService
                .getLessonStepDtoById(1L))
                .thenReturn(expectedLessonStepDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/lesson-step/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("lesson-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Lesson Step Unique Identifier")), responseFields(fieldWithPath("id")
                                        .description("Lesson Step Unique Identifier"),
                                fieldWithPath("positionInLesson").description("Position of the lesson step in the lesson"),
                                fieldWithPath("complete").description("logical value of execution"),
                                fieldWithPath("theoreticalStepId").description("Theoretical Step Unique Identifier"),
                                fieldWithPath("testId").description("Test Unique Identifier"),
                                fieldWithPath("lessonId").description("Lesson Unique Identifier"))));
    }

    @Test
    void getAllLessonSteps() throws Exception {
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(1L);

        Lesson lesson = new Lesson();
        lesson.setId(1L);

        List<LessonStepDto> expectedLessonStepDtoList = new ArrayList<>();

        LessonStepDto lessonStepDto = new LessonStepDto();
        lessonStepDto.setId(1L);
        lessonStepDto.setTestId(1L);
        lessonStepDto.setComplete(false);
        lessonStepDto.setPositionInLesson(1);
        lessonStepDto.setTheoreticalStepId(1L);
        lessonStepDto.setLessonId(1L);

        expectedLessonStepDtoList.add(lessonStepDto);

        when(lessonStepService
                .getAllLessonStepsDto())
                .thenReturn(expectedLessonStepDtoList);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/lesson-step/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("lesson-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void addNewLessonStep() throws Exception {
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(1L);

        Lesson lesson = new Lesson();
        lesson.setId(1L);

        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setTestId(1L);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setTheoreticalStepId(1L);
        expectedLessonStepDto.setLessonId(1L);

        LessonStep lessonStep = new LessonStep();
        lessonStep.setTest(test);
        lessonStep.setComplete(false);
        lessonStep.setPositionInLesson(1);
        lessonStep.setTheoreticalStep(theoreticalStep);
        lessonStep.setLesson(lesson);

        LessonStepDto inputLessonStepDto = new LessonStepDto();
        inputLessonStepDto.setId(1L);
        inputLessonStepDto.setTestId(1L);
        inputLessonStepDto.setComplete(false);
        inputLessonStepDto.setPositionInLesson(1);
        inputLessonStepDto.setTheoreticalStepId(1L);
        inputLessonStepDto.setLessonId(1L);

        when(lessonStepService.
                toLessonStep(inputLessonStepDto))
                .thenReturn(lessonStep);

        when(lessonStepService
                .addNewLessonStep(lessonStep))
                .thenReturn(expectedLessonStepDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .post("/api/v1/lesson-step")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputLessonStepDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("lesson-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));

    }

    @Test
    void updateLessonStep() throws Exception {
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(1L);

        Lesson lesson = new Lesson();
        lesson.setId(1L);

        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setTestId(1L);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setTheoreticalStepId(1L);
        expectedLessonStepDto.setLessonId(1L);

        LessonStep lessonStep = new LessonStep();
        lessonStep.setId(1L);
        lessonStep.setTest(test);
        lessonStep.setComplete(false);
        lessonStep.setPositionInLesson(1);
        lessonStep.setTheoreticalStep(theoreticalStep);
        lessonStep.setLesson(lesson);

        LessonStepDto inputLessonStepDto = new LessonStepDto();
        inputLessonStepDto.setId(1L);
        inputLessonStepDto.setTestId(1L);
        inputLessonStepDto.setComplete(false);
        inputLessonStepDto.setPositionInLesson(1);
        inputLessonStepDto.setTheoreticalStepId(1L);
        inputLessonStepDto.setLessonId(1L);

        when(lessonStepService.
                toLessonStep(inputLessonStepDto))
                .thenReturn(lessonStep);

        when(lessonStepService
                .updateLessonStep(lessonStep))
                .thenReturn(expectedLessonStepDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .put("/api/v1/lesson-step")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputLessonStepDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("lesson-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));

    }

    @Test
    void deleteLessonStepByID() throws Exception {
        mvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/lesson-step/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("lesson-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Lesson Step Unique Identifier"))));
    }
}