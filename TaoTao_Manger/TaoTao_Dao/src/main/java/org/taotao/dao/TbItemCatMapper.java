package org.taotao.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.taotao.pojo.TbItemCat;
import org.taotao.pojo.TbItemCatExample;

public interface TbItemCatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int countByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int deleteByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int insert(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int insertSelective(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    List<TbItemCat> selectByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    TbItemCat selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByPrimaryKeySelective(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    int updateByPrimaryKey(TbItemCat record);
}