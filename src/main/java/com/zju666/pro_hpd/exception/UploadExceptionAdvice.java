package com.zju666.pro_hpd.exception;

import org.springframework.web.multipart.MaxUploadSizeExceededException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UploadExceptionAdvice {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public String handleMaxSizeException(Model model, MaxUploadSizeExceededException e) {
    model.addAttribute("message", "File is too large, the max size is 1M");

    return "upload_form";
  }
}