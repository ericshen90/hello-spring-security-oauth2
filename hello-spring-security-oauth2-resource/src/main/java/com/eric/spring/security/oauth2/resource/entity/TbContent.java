package com.eric.spring.security.oauth2.resource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * <p>
 *
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_content")
public class TbContent extends Model<TbContent> {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 内容类目ID
   */
  private Long categoryId;

  /**
   * 内容标题
   */
  private String title;

  /**
   * 子标题
   */
  private String subTitle;

  /**
   * 标题描述
   */
  private String titleDesc;

  /**
   * 链接
   */
  private String url;

  /**
   * 图片绝对路径
   */
  private String pic;

  /**
   * 图片2
   */
  private String pic2;

  /**
   * 内容
   */
  private String content;

  private Date created;

  private Date updated;


  public static final String ID = "id";

  public static final String CATEGORY_ID = "category_id";

  public static final String TITLE = "title";

  public static final String SUB_TITLE = "sub_title";

  public static final String TITLE_DESC = "title_desc";

  public static final String URL = "url";

  public static final String PIC = "pic";

  public static final String PIC2 = "pic2";

  public static final String CONTENT = "content";

  public static final String CREATED = "created";

  public static final String UPDATED = "updated";

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
