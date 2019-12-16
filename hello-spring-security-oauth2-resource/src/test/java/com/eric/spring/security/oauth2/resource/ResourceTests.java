package com.eric.spring.security.oauth2.resource;

import com.eric.spring.security.oauth2.resource.entity.TbContent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.Date;
import java.util.TimeZone;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * @author EricShen
 * @date 2019-12-13
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OAuth2ResourceApplication.class)
@AutoConfigureMockMvc
public class ResourceTests {

  @Resource
  private MockMvc mockMvc;

  private String token = "Bearer 44e925fb-dae1-435a-bb9f-7361b7903b3b";

  private ObjectMapper objectMapper = new ObjectMapper().setTimeZone(TimeZone.getDefault());

  @Test
  public void testList() throws Exception {
    int status = this.mockMvc.perform(MockMvcRequestBuilders.get("/")
        .header("Authorization", token))
        .andDo(MockMvcResultHandlers.print())
        .andReturn().getResponse().getStatus();
    if (status == HttpStatus.OK.value()) {
      log.info("request success");
    } else {
      log.info("request failed, status code: {}", status);
    }
    Assert.assertEquals(status, HttpStatus.OK.value());
  }

  @Test
  public void testView() throws Exception {
    int status = this.mockMvc.perform(MockMvcRequestBuilders.get("/view/42")
        .header("Authorization", token))
        .andDo(MockMvcResultHandlers.print())
        .andReturn().getResponse().getStatus();
    if (status == HttpStatus.OK.value()) {
      log.info("request success");
    } else {
      log.info("request failed, status code: {}", status);
    }
    Assert.assertEquals(status, HttpStatus.OK.value());
  }

  @Test
  public void testDelete() throws Exception {
    int status = this.mockMvc.perform(MockMvcRequestBuilders.delete("/delete/49")
        .header("Authorization", token))
        .andDo(MockMvcResultHandlers.print())
        .andReturn().getResponse().getStatus();
    if (status == HttpStatus.OK.value()) {
      log.info("request success");
    } else {
      log.info("request failed, status code: {}", status);
    }
    Assert.assertEquals(status, HttpStatus.OK.value());
  }

  @Test
  public void testInsert() throws Exception {
    TbContent tbContent = new TbContent();
    tbContent.setCategoryId(89L);
    tbContent.setTitle("测试标题。。jkjkjk。。。");
    tbContent.setCreated(new Date());
    String value = objectMapper.writeValueAsString(tbContent);
    System.out.println("value = " + value);
    int status = this.mockMvc.perform(MockMvcRequestBuilders.post("/insert")
        .header("Authorization", token)
        .contentType(MediaType.APPLICATION_JSON)
        .content(value))
        .andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getStatus();
    if (status == HttpStatus.OK.value()) {
      log.info("request success");
    } else {
      log.info("request failed, status code: {}", status);
    }
    Assert.assertEquals(status, HttpStatus.OK.value());
  }

  @Test
  public void testUpdate() throws Exception {
    TbContent tbContent = new TbContent();
    tbContent.setId(45L);
    tbContent.setTitle("update title");
    tbContent.setUrl("https://ericshen.coding.me");
    tbContent.setUpdated(new Date());
    String valueAsString = objectMapper.writeValueAsString(tbContent);
    int status = this.mockMvc.perform(MockMvcRequestBuilders.put("/update")
        .header("Authorization", token)
        .contentType(MediaType.APPLICATION_JSON)
        .content(valueAsString))
        .andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getStatus();
    if (status == HttpStatus.OK.value()) {
      log.info("request success");
    } else {
      log.info("request failed, status code: {}", status);
    }
    Assert.assertEquals(status, HttpStatus.OK.value());
  }


}
