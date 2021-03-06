package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordScene;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordSceneInputRequest;
import com.xdht.disease.sys.vo.request.RecordSceneRequest;
import com.xdht.disease.sys.vo.response.RecordSceneDetailResponse;
import com.xdht.disease.sys.vo.response.RecordSceneResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordSceneService extends Service<RecordScene> {

    /**
     * 分页查询
     * @param recordSceneRequest 查询条件
     * @return 返回结果
     */
    PageResult<RecordSceneResponse> queryListPage(RecordSceneRequest recordSceneRequest);

    /**
     * 删除
     * @param id 主键id
     */
    void deleteRecordScene(Long id);

    /**
     * 修改
     * @param recordSceneInputRequest 实体
     */
    void updateRecordScene(RecordSceneInputRequest recordSceneInputRequest);

    /**
     * 添加调查表和调查表是否填写的状态
     * @param recordSceneInputRequest 实体
     */
    void addRecordScene(RecordSceneInputRequest recordSceneInputRequest);

    /**
     * 获取职业卫生现场调查记录表--详细内容
     * @param id 记录表ID
     * @return 返回结果
     */
    RecordSceneDetailResponse queryRecordSceneDetail(Long id);
}
