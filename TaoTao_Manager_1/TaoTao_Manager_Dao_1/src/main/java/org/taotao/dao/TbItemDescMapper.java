package org.taotao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.taotao.pojo.TbItemDesc;
import org.taotao.pojo.TbItemDescExample;

public interface TbItemDescMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int countByExample(TbItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int deleteByExample(TbItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int deleteByPrimaryKey(Long itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int insert(TbItemDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int insertSelective(TbItemDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    List<TbItemDesc> selectByExampleWithBLOBs(TbItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    List<TbItemDesc> selectByExample(TbItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    TbItemDesc selectByPrimaryKey(Long itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByExampleSelective(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByExample(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByPrimaryKeySelective(TbItemDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(TbItemDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_desc
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByPrimaryKey(TbItemDesc record);
}