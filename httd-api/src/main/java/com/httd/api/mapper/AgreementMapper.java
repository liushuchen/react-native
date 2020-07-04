package com.httd.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.httd.api.mapper.po.Agreement;
import com.httd.api.business.config.entity.FindAgreementDTO;
import com.httd.api.business.config.entity.UpdateAgreementVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 协议列表 Mapper 接口
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-02
 */
public interface AgreementMapper extends BaseMapper<Agreement> {

    //获取协议列表
    FindAgreementDTO findAgreement(@Param("type") Integer type);

    //修改协议
    void updateAgreement(UpdateAgreementVO vo);
}
