package com.dkd.manage.mapper;

import java.util.List;

import com.dkd.manage.domain.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 工单员工Mapper接口
 *
 * @author imoyu
 * @date 2024-12-19
 */
public interface EmpMapper {
    /**
     * 查询工单员工
     *
     * @param id 工单员工主键
     * @return 工单员工
     */
    public Emp selectEmpById(Long id);

    /**
     * 查询工单员工列表
     *
     * @param emp 工单员工
     * @return 工单员工集合
     */
    public List<Emp> selectEmpList(Emp emp);

    /**
     * 新增工单员工
     *
     * @param emp 工单员工
     * @return 结果
     */
    public int insertEmp(Emp emp);

    /**
     * 修改工单员工
     *
     * @param emp 工单员工
     * @return 结果
     */
    public int updateEmp(Emp emp);

    /**
     * 删除工单员工
     *
     * @param id 工单员工主键
     * @return 结果
     */
    public int deleteEmpById(Long id);

    /**
     * 批量删除工单员工
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmpByIds(Long[] ids);

    @Update("update tb_emp set region_name = #{regionName} where region_id = #{regionId} ")
    public void updateEmpRegionName(@Param("regionName") String regionName, @Param("regionId") Long regionId);
}
