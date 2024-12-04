package com.dkd.manage.domain.vo;

import com.dkd.common.annotation.Excel;
import com.dkd.common.core.domain.BaseEntity;
import com.dkd.manage.domain.Region;
import lombok.Data;

@Data
public class RegionVo extends Region {

    /** 点位数 */
    private Integer nodeCount;
}
