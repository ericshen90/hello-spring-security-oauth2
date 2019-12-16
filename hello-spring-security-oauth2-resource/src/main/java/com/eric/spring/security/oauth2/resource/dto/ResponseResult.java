package com.eric.spring.security.oauth2.resource.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * 通用的返回对象
 *
 * @author ericshen
 * @param <T>
 */
@Data
@EqualsAndHashCode
public class ResponseResult<T> implements Serializable {

  private static final long serialVersionUID = 4962598873229510415L;
  /**
   * 状态码
   */
  private Integer state;
  /**
   * 消息
   */
  private String message;
  /**
   * 返回对象
   */
  private T data;

  public ResponseResult() {
    super();
  }

  public ResponseResult(Integer state) {
    super();
    this.state = state;
  }

  public ResponseResult(Integer state, String message) {
    super();
    this.state = state;
    this.message = message;
  }

  public ResponseResult(Integer state, Throwable throwable) {
    super();
    this.state = state;
    this.message = throwable.getMessage();
  }

  public ResponseResult(Integer state, T data) {
    super();
    this.state = state;
    this.data = data;
  }

  public ResponseResult(Integer state, String message, T data) {
    super();
    this.state = state;
    this.message = message;
    this.data = data;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}