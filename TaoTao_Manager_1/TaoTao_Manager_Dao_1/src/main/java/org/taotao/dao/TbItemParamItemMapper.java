package org.taotao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.taotao.pojo.TbItemParamItem;
import org.taotao.pojo.TbItemParamItemExample;

public interface TbItemParamItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int countByExample(TbItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int deleteByExample(TbItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int insert(TbItemParamItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int insertSelective(TbItemParamItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    List<TbItemParamItem> selectByExampleWithBLOBs(TbItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    List<TbItemParamItem> selectByExample(TbItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    TbItemParamItem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByExampleSelective(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByExample(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByPrimaryKeySelective(TbItemParamItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(TbItemParamItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByPrimaryKey(TbItemParamItem record);
}