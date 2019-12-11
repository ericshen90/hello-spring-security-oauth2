package com.eric.spring.security.oauth2.server.entity;

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
 * 权限
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_permission")
public class TbPermission extends Model<TbPermission> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父权限
     */
    private Long parentId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限英文名称
     */
    private String enname;

    /**
     * 授权路径
     */
    private String url;

    /**
     * 备注
     */
    private String description;

    private Date created;

    private Date updated;


    public static final String ID = "id";

    public static final String PARENT_ID = "parent_id";

    public static final String NAME = "name";

    public static final String ENNAME = "enname";

    public static final String URL = "url";

    public static final String DESCRIPTION = "description";

    public static final String CREATED = "created";

    public static final String UPDATED = "updated";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
