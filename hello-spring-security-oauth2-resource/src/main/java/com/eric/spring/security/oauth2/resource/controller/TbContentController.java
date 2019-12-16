package com.eric.spring.security.oauth2.resource.controller;


import com.eric.spring.security.oauth2.resource.dto.ResponseResult;
import com.eric.spring.security.oauth2.resource.entity.TbContent;
import com.eric.spring.security.oauth2.resource.service.TbContentService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-13
 */
@RestController
public class TbContentController {

  @Resource
  private TbContentService tbContentService;

  @GetMapping("/")
  public ResponseResult<List<TbContent>> list() {
    List<TbContent> list = tbContentService.list();
    return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), list);
  }

  @GetMapping("/view/{id}")
  public ResponseResult<TbContent> getById(@PathVariable String id) {
    TbContent tbContent = tbContentService.getById(id);
    return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), tbContent);
  }

  @PostMapping("/insert")
  public ResponseResult<Integer> insert(@RequestBody TbContent tbContent) {
    if (tbContentService.save(tbContent)) {
      return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
    return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.getReasonPhrase());
  }

  @PutMapping("/update")
  public ResponseResult<Integer> update(@RequestBody TbContent tbContent) {
    if (tbContentService.updateById(tbContent)) {
      return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
    return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.getReasonPhrase());
  }

  @DeleteMapping("/delete/{id}")
  public ResponseResult<TbContent> delete(@PathVariable String id) {
    if (tbContentService.removeById(id)) {
      return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
    return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.getReasonPhrase());
  }


}

