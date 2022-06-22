package com.baixin.common.lang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 传给前端的PV和UV的视图对象
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class VisitorNum  implements Serializable {
    private static final long serialVersionUID = 1L;
    int uv;
    int pv;
}