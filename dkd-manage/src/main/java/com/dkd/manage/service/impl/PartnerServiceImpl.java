package com.dkd.manage.service.impl;

import java.util.List;

import com.dkd.common.utils.DateUtils;
import com.dkd.common.utils.SecurityUtils;
import com.dkd.manage.domain.vo.PartnerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.PartnerMapper;
import com.dkd.manage.domain.Partner;
import com.dkd.manage.service.IPartnerService;

/**
 * 合作商管理Service业务层处理
 *
 * @author imoyu
 * @date 2024-12-03
 */
@Service
public class PartnerServiceImpl implements IPartnerService {
    @Autowired
    private PartnerMapper partnerMapper;

    /**
     * 查询合作商管理
     *
     * @param id 合作商管理主键
     * @return 合作商管理
     */
    @Override
    public Partner selectPartnerById(Long id) {
        return partnerMapper.selectPartnerById(id);
    }

    /**
     * 查询合作商管理列表
     *
     * @param partner 合作商管理
     * @return 合作商管理
     */
    @Override
    public List<Partner> selectPartnerList(Partner partner) {
        return partnerMapper.selectPartnerList(partner);
    }

    /**
     * 新增合作商管理
     *
     * @param partner 合作商管理
     * @return 结果
     */
    @Override
    public int insertPartner(Partner partner) {
        partner.setPassword(SecurityUtils.encryptPassword(partner.getPassword()));
        partner.setCreateTime(DateUtils.getNowDate());
        return partnerMapper.insertPartner(partner);
    }

    /**
     * 修改合作商管理
     *
     * @param partner 合作商管理
     * @return 结果
     */
    @Override
    public int updatePartner(Partner partner) {
        partner.setUpdateTime(DateUtils.getNowDate());
        return partnerMapper.updatePartner(partner);
    }

    /**
     * 批量删除合作商管理
     *
     * @param ids 需要删除的合作商管理主键
     * @return 结果
     */
    @Override
    public int deletePartnerByIds(Long[] ids) {
        return partnerMapper.deletePartnerByIds(ids);
    }

    /**
     * 删除合作商管理信息
     *
     * @param id 合作商管理主键
     * @return 结果
     */
    @Override
    public int deletePartnerById(Long id) {
        return partnerMapper.deletePartnerById(id);
    }

    /**
     * 查询合作商列表
     *
     * @param partner
     * @return partnerVo
     */
    @Override
    public List<PartnerVo> selectPartnerVoList(Partner partner) {
        return partnerMapper.selectPartnerVoList(partner);
    }

    /**
     * 重置合作商密码
     * @param id
     * @return
     */
    @Override
    public int resetPartnerPassword(Long id) {
        Partner partner = new Partner();
        partner.setId(id);
        partner.setPassword(SecurityUtils.encryptPassword("123456"));
        return partnerMapper.updatePartner(partner);
    }
}