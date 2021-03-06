package com.gaohx.springbootlearningjdbc.dao;

import com.gaohx.springbootlearningjdbc.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface CityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CITY
     *
     * @mbg.generated Tue Nov 13 11:36:04 CST 2018
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CITY
     *
     * @mbg.generated Tue Nov 13 11:36:04 CST 2018
     */
    int insert(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CITY
     *
     * @mbg.generated Tue Nov 13 11:36:04 CST 2018
     */
    int insertSelective(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CITY
     *
     * @mbg.generated Tue Nov 13 11:36:04 CST 2018
     */
    City selectByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CITY
     *
     * @mbg.generated Tue Nov 13 11:36:04 CST 2018
     */
    int updateByPrimaryKeySelective(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_CITY
     *
     * @mbg.generated Tue Nov 13 11:36:04 CST 2018
     */
    int updateByPrimaryKey(City record);

    @Select("select name from t_city where id = #{id}")
    List<City> getCityList(String id);
}