package com.eric.spring.security.oauth2.resource.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 内容分类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_content_category")
public class TbContentCategory extends Model<TbContentCategory> {

  private static final long serialVersionUID = 1L;

  /**
   * 类目ID
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 父类目ID=0时，代表的是一级的类目
   */
  private Long parentId;

  /**
   * 分类名称
   */
  private String name;

  /**
   * 状态。可选值:1(正常),2(删除)
   */
  private Integer status;

  /**
   * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
   */
  private Integer sortOrder;

  /**
   * 该类目是否为父类目，1为true，0为false
   */
  @TableField("is_parent")
  private Boolean parent;

  /**
   * 创建时间
   */
  private Date created;

  /**
   * 创建时间
   */
  private Date updated;


  public static final String ID = "id";

  public static final String PARENT_ID = "parent_id";

  public static final String NAME = "name";

  public static final String STATUS = "status";

  public static final String SORT_ORDER = "sort_order";

  public static final String IS_PARENT = "is_parent";

  public static final String CREATED = "created";

  public static final String UPDATED = "updated";

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
