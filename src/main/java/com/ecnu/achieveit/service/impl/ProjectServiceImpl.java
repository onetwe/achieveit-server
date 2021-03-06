package com.ecnu.achieveit.service.impl;

import com.ecnu.achieveit.constant.ProjectState;
import com.ecnu.achieveit.dao.AssetItemMapper;
import com.ecnu.achieveit.dao.ProjectBasicInfoMapper;
import com.ecnu.achieveit.dao.ProjectMemberMapper;
import com.ecnu.achieveit.model.AssetItem;
import com.ecnu.achieveit.model.ProjectBasicInfo;
import com.ecnu.achieveit.model.ProjectId;
import com.ecnu.achieveit.model.ProjectMemberKey;
import com.ecnu.achieveit.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    @Autowired(required = false)
    private ProjectBasicInfoMapper projectBasicInfoMapper;

    @Autowired(required = false)
    private ProjectMemberMapper projectMemberMapper;

    @Autowired(required = false)
    private AssetItemMapper assetItemMapper;

    @Override
    public boolean addProject(ProjectBasicInfo projectBasicInfo) {
        Integer result = projectBasicInfoMapper.insertSelective(projectBasicInfo);

        return !result.equals(0);
    }

    @Override
    public boolean updateProject(ProjectBasicInfo projectBasicInfo) {
        Integer result = projectBasicInfoMapper.updateByPrimaryKeySelective(projectBasicInfo);

        return result!=0;
    }

    @Override
    public boolean updateProjectState(ProjectBasicInfo projectBasicInfo,String projectState) {
        if(!ProjectState.checkState(projectState)) return false;
        String projectId = projectBasicInfo.getProjectId();
        int result = projectBasicInfoMapper.updateStateById(projectId, projectState);

        return result!=0;
    }

    @Override
    public boolean updateProjectStateById(String projectId, String projectState) {
        if(!ProjectState.checkState(projectState)) return false;
        int result = projectBasicInfoMapper.updateStateById(projectId.toString(),projectState);

        return result!=0;
    }

    @Override
    public boolean updateOutputLinkOfProjectInfo(String projectId, String outputLink) {
        int result = projectBasicInfoMapper.updateOutputLinkOfProjectInfo(projectId,outputLink);

        return result!=0;
    }

    @Override
    public ProjectBasicInfo querryProjectByPrimaryKey(String projectId) {
        ProjectBasicInfo result = projectBasicInfoMapper.selectByPrimaryKey(projectId);
        return result;
    }

    @Override
    public List<ProjectBasicInfo> queryProjectByEmployeeId(String employeeId) {
        List<ProjectBasicInfo> result = projectBasicInfoMapper.selectByEmployeeId(employeeId);

        return result;
    }

    @Override
    public List<ProjectBasicInfo> queryProjectByClientId(String clientId) {
        List<ProjectBasicInfo> result = projectBasicInfoMapper.selectByClientId(clientId);

        return result;
    }

    @Override
    public List<ProjectBasicInfo> queryProjectByState(String state) {
        List<ProjectBasicInfo> result = projectBasicInfoMapper.selectByState(state);

        return result;
    }

    @Override
    public List<ProjectBasicInfo> queryProjectByBossId(String bossId) {
        List<ProjectBasicInfo> result = projectBasicInfoMapper.selectByBossId(bossId);

        return  result;
    }

    @Override
    public List<ProjectBasicInfo> queryProjectByKeyWord(String keyWord,String employeeId){
        List<ProjectBasicInfo> result = projectBasicInfoMapper.selectByKeyWord(keyWord,employeeId);

        return  result;
    }

    @Override
    public List<AssetItem> queryAssetItem() {
        List<AssetItem> result = assetItemMapper.selectAll();

        return result;
    }

    @Override
    public boolean deleteProjectMemberByKey(ProjectMemberKey projectMemberKey) {
        int result = projectMemberMapper.deleteByPrimaryKey(projectMemberKey);

        return result!=0;
    }

    @Override
    public boolean deleteProjectInfoByKey(String projectId) {
        int result = projectBasicInfoMapper.deleteByPrimaryKey(projectId);

        return result!=0;
    }

}
