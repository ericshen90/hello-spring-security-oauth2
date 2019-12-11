package com.eric.spring.security.oauth2.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色权限
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_role_permission")
public class TbRolePermission extends Model<TbRolePermission> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色 ID
     */
    private Long roleId;

    /**
     * 权限 ID
     */
    private Long permissionId;


    public static final String ID = "id";

    public static final String ROLE_ID = "role_id";

    public static final String PERMISSION_ID = "permission_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
