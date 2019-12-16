package com.eric.spring.oauth2.client.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author EricShen
 * @date 2019-12-10
 */
@RestController
@RequestMapping("/consume")
@Slf4j
public class ConsumerController {

  @Resource
  private RestTemplate restTemplate;

  @GetMapping("auth")
  public void auth(HttpServletResponse response) throws IOException {
    response
        .sendRedirect("http://localhost:8080/oauth/authorize?client_id=client&response_type=code");
  }

  @GetMapping("redirect")
  public ResponseEntity<String> redirect(@RequestParam String code) {
    log.debug("code = " + code);
    MultiValueMap<Object, Object> postParams = new LinkedMultiValueMap<>();
    postParams.add("grant_type", "authorization_code");
    postParams.add("code", code);
    return getStringResponseEntity(postParams);
  }

  @GetMapping("refresh")
  public ResponseEntity<String> refresh(@RequestParam String refreshToken) {
    log.debug("refreshToken = " + refreshToken);
    MultiValueMap<Object, Object> postParams = new LinkedMultiValueMap<>();
    postParams.add("grant_type", "refresh_token");
    postParams.add("refresh_token", refreshToken);
    return getStringResponseEntity(postParams);
  }

  private ResponseEntity<String> getStringResponseEntity(MultiValueMap<Object, Object> postParams) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setBasicAuth("client", "secret");
    httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    HttpEntity<MultiValueMap<Object, Object>> entity = new HttpEntity<>(postParams, httpHeaders);
    ResponseEntity<String> responseEntity = restTemplate
        .postForEntity("http://localhost:8080/oauth/token", entity, String.class);
    log.debug("responseEntity = " + responseEntity.getBody());
    return responseEntity;
  }


}
