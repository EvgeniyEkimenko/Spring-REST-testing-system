package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AnswerResultServiceImpl implements AnswerResultService {

    private final AnswerResultRepository resultRepository;
    private final QuestionService questionService;
    private final AnswerVariantService answerVariantService;

    @Autowired
    public AnswerResultServiceImpl(AnswerResultRepository resultRepository, QuestionService questionService, AnswerVariantService answerVariantService) {
        this.resultRepository = resultRepository;
        this.questionService = questionService;
        this.answerVariantService = answerVariantService;
    }

    @Override
    public AnswerResultDto setPoints(AnswerResultDto answerResultDto) {
        Question question = questionService.getQuestionById(answerResultDto.getQuestionId());
        double score;

        if (question.isAllowedParticleAnswer())
            score = calculatePointsWithAllowedParticleAnswer(question
                    , answerResultDto.getAnswerVariantsId());
        else score = calculatePointsWithoutAllowedParticleAnswer(question.getScore()
                , answerResultDto.getAnswerVariantsId());

        answerResultDto.setScore(score);
        return answerResultDto;
    }

/*    public boolean checkCorrectAnswer(Long id) {
        AnswerVariant answerVariant = answerVariantService.getAnswerVariantById(id);
        if (answerVariant.getCorrect()) return true;
        return false;
    }*/

    public double calculatePointsWithAllowedParticleAnswer(Question question  , List<Long> answerVariantsId) {
        double count = 0;
        List<Long> correctnessAnswerVariantListId = new ArrayList<>();
        for (AnswerVariant correctAnswer : question.getAnswerVariants()) {
            if (correctAnswer.getCorrect()) correctnessAnswerVariantListId.add(correctAnswer.getId());
        }

        for (Long correct : answerVariantsId) {
            if (correctnessAnswerVariantListId.contains(correct)) count++;
            else {
                if ((count--)>=0) {
                }
                else count=0;
            }
        }
        int countOfTrueAnswer = correctnessAnswerVariantListId.size();
        return question.getScore()*(count/countOfTrueAnswer);

    }

    public double calculatePointsWithoutAllowedParticleAnswer(double maxScore, List<Long> answerVariantsId) {
        for (Long variant : answerVariantsId) {
            if (answerVariantService.getAnswerVariantById(variant).getCorrect()) return maxScore;
        }
        return 0;
    }

    @Override
    public AnswerResultDto fromAnswerResult(AnswerResult answerResult) {
        AnswerResultDto result = new AnswerResultDto();
        result.setId(answerResult.getId());
        //TODO fill table for using result.setTestResultId(answerResult.getTestResult().getId());
        result.setQuestionId(answerResult.getQuestion().getId());
        result.setScore(answerResult.getScore());
        result.setAnswerVariantsId(ServiceUtil.getIds(answerResult.getAnswerVariants()));
        return result;
    }


    @Override
    public List<AnswerResultDto> getAllAnswerResultDto() {
        List<AnswerResult> results = getAllAnswerResult();

        List<AnswerResultDto> answerResultListDto = new ArrayList<>();
        for (AnswerResult result : results) {
            answerResultListDto.add(fromAnswerResult(result));
        }

        return answerResultListDto;
    }

    @Override
    public AnswerResultDto getAnswerResultDtoById(long id) {
        return fromAnswerResult(getAnswerResultById(id));
    }


    @Override
    public List<AnswerResult> getAllAnswerResult() {
        List<AnswerResult> results = resultRepository.findAll();
        log.info("IN getAllAnswerResult - {} results found", results.size());
        return results;
    }

    @Override
    public AnswerResult getAnswerResultById(long id) {
        AnswerResult result = resultRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN getAnswerResultById - no AnswerResult found by id: {}", id);
            return null;
        }
        log.info("IN getAnswerResultById  - result: {} found by id: {}", result, id);

        return result;
    }

    @Override
    public void addNewAnswerResult(AnswerResult result) {
        resultRepository.save(result);
        //TODO add log info
    }

    @Override
    public void updateAnswerResult(AnswerResult result) {
        resultRepository.save(result);
        //TODO add log info
    }


    @Override
    public void deleteById(long id) {
        resultRepository.deleteById(id);
        log.info("IN deleteById - AnswerResult with id: {} successfully deleted", id);
    }
}
