package com.ecnu.achieveit.dao;

import com.ecnu.achieveit.model.ProjectDevice;
import com.ecnu.achieveit.model.ProjectDeviceKey;

public interface ProjectDeviceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_device
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(ProjectDeviceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_device
     *
     * @mbg.generated
     */
    int insert(ProjectDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_device
     *
     * @mbg.generated
     */
    int insertSelective(ProjectDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_device
     *
     * @mbg.generated
     */
    ProjectDevice selectByPrimaryKey(ProjectDeviceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_device
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ProjectDevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_device
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ProjectDevice record);
}