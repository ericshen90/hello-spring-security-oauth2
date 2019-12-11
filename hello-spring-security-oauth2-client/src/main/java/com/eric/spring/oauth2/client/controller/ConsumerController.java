package com.eric.spring.oauth2.client.controller;

import javax.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
public class ConsumerController {


  @Resource
  private RestTemplate restTemplate;

  @GetMapping("redirect")
  public String redirect(@RequestParam String code) {
    System.out.println("code = " + code);
    MultiValueMap<Object, Object> postParams = new LinkedMultiValueMap<>();
    postParams.add("grant_type", "authorization_code");
    postParams.add("code", code);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setBasicAuth("client","secret");
    httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    HttpEntity<MultiValueMap<Object, Object>> entity = new HttpEntity<>(postParams,
        httpHeaders);
    String result = restTemplate
        .postForObject("http://localhost:8080/oauth/token", entity, String.class);
    System.out.println("result = " + result);
    return result;
  }


}
