package com.gaohx.web.exception;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
public class MyErrorViewResolver implements ErrorViewResolver {

    public static final String DEFAULT_ERROR_PAGE = "error";

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("status",status.value());
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName(DEFAULT_ERROR_PAGE);
        return modelAndView;
    }
}
