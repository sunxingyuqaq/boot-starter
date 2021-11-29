package com.boot.study.vip.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/14 11:25
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Data
@TableName("frame_user")
public class FrameUser implements Serializable {

    private static final long serialVersionUID = -4401296989563000714L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("login_id")
    private String loginId;

    @TableField("login_key")
    private String loginKey;

    private String password;

    private String sex;

    @TableField("login_key")
    private Boolean isDelete;

    @TableField("is_enable")
    private Boolean isEnable;

    @TableField("is_lock")
    private Boolean isLock;
}
