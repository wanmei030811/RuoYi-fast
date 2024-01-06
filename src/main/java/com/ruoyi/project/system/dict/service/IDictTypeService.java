package com.ruoyi.project.system.dict.service;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dict.domain.DictData;
import com.ruoyi.project.system.dict.domain.DictType;

import java.util.List;

/**
 * 字典 业务层
 *
 * @author ruoyi
 */
public interface IDictTypeService {
  /**
   * 根据条件分页查询字典类型
   *
   * @param dictType 字典类型信息
   * @return 字典类型集合信息
   */
  List<DictType> selectDictTypeList(DictType dictType);

  /**
   * 根据所有字典类型
   *
   * @return 字典类型集合信息
   */
  List<DictType> selectDictTypeAll();

  /**
   * 根据字典类型查询字典数据
   *
   * @param dictType 字典类型
   * @return 字典数据集合信息
   */
  List<DictData> selectDictDataByType(String dictType);

  /**
   * 根据字典类型ID查询信息
   *
   * @param dictId 字典类型ID
   * @return 字典类型
   */
  DictType selectDictTypeById(Long dictId);

  /**
   * 根据字典类型查询信息
   *
   * @param dictType 字典类型
   * @return 字典类型
   */
  DictType selectDictTypeByType(String dictType);

  /**
   * 批量删除字典类型
   *
   * @param ids 需要删除的数据
   */
  void deleteDictTypeByIds(String ids);

  /**
   * 加载字典缓存数据
   */
  void loadingDictCache();

  /**
   * 清空字典缓存数据
   */
  void clearDictCache();

  /**
   * 重置字典缓存数据
   */
  void resetDictCache();

  /**
   * 新增保存字典类型信息
   *
   * @param dictType 字典类型信息
   * @return 结果
   */
  int insertDictType(DictType dictType);

  /**
   * 修改保存字典类型信息
   *
   * @param dictType 字典类型信息
   * @return 结果
   */
  int updateDictType(DictType dictType);

  /**
   * 校验字典类型称是否唯一
   *
   * @param dictType 字典类型
   * @return 结果
   */
  boolean checkDictTypeUnique(DictType dictType);

  /**
   * 查询字典类型树
   *
   * @param dictType 字典类型
   * @return 所有字典类型
   */
  List<Ztree> selectDictTree(DictType dictType);
}