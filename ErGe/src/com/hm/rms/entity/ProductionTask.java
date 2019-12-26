package com.hm.rms.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias("ProductionTask")
public class ProductionTask {
    private String id;
    private String parentId;//父ID 多此下派绑定 任务绑定(生产任务 下派父子任务绑定)
    private String singleLoopId;//单回路绑定ID  OLD（绑定已下派生产任务ID） ,NEW 时 赋值0
    private Integer type;//类型-无
    private Integer status;//状态-【废弃】
    private String materielId;//物料主数据ID
    private String measurUnitId;//计量单位ID
    private String vehicleModel;//车型
    private Integer orderQuantity;//订单数量
    private Integer productionQuantity;// 生产数量
    private String proMode;//生产类型（拉动:1、推动：2、改制:3）
    private String afterMode;//后序生产模式：(1:流水线常规，2：流水线自由，3:案板模式）
    private String orderVersion;//订单版本号
    private String craftVersion;//工艺版本号 工艺的ID
    private String version;//工艺版本号 非数据库字段
    private String ebomVersion;//非数据库字段
    private Integer preDistributionQuantity;//前序下派数量
    private Integer preResidueDistributionQuantity;//前序下派剩余数量
    private Integer afterDistributionQuantity;//后序下派数量
    private Integer afterResidueDistributionQuantity;//后序下派剩余数量
    private String preDistributionDate;//前序分配日期
    private String afterDistributionDate;//后序下派日期
    private String orderBatch;//订单批次
    private String productBatch;//生产批次
    private String orderNumber;//订单编号
    private String preStatus;//前序任务状态（1已下派,0未下派，2半成品全部入库完成，3半成品全部出库完成）
    private String afterStatus;//后序任务状态(0未下派，1已下派)
    private String deliverDate;//交货日期
    private String halfProductionAllInWarehouse;//半成品全部入库时间
    private String halfProductionAllOutWarehouse;//半成品全部出库时间
    private String afterTaskStartTime;//后序任务开始时间
    private String afterTaskCompleteTime;//后序任务完成时间
    private String preTaskStartTime;//前序开始时间
    private String preTaskCompleteTime;//前序完成时间
    private String afterCraftProcess;//对应后序任务主表中工艺流程字段--用于json映射bean，不做数据存储
    private String pullVersion;//拉动版本号
    private String ufts;//时间戳 (同步U8字段)
    private String sortId;//订单式混排（记录先选中订单的ID,然后按顺序拼接12345...数组）
    private String updateSortBy;//排序更新人
    private String updateSortDate;//排序更新时间
    /** 行号 **/
    private String irowno;
    /**转配字段，用于显示 不做存储**/
    private String prePlanDistributionDate;//前序计划下派日期
    private String afterPlanDistributionDate;//后序计划下派日期
    private String sendNum;// 配送数量
    private String flowlineNum; // 流水线数量
    private String countMateriel; // 物料合计

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /** 查询开始时间*/
    private String orderTime;

    /** 查询结束时间*/
    private String orderTimeEnd;

    /** 日期区间查询集合*/
    List<String> days;
    List<String> day1;
    private Integer dqty;
    private Integer lqty;

    /** 标签消耗记录总数，非数据库字段*/
    private String labelConsumptionRecordNumber;
    /** 回路总数，非数据库字段*/
    private String prepareDetailCount;
    /** 回路号，非数据库字段*/
    private String wirewayNumber;
    /** 冻结状态，0或空：非冻结状态/非变更状态，1工艺冻结，2质量冻结，3工程变更，非数据库字段*/
    private String freezingStatus;

    private String ebomId;//绑定ebom的id

    /**2019-10-26：huangzhihai 新增订单评审状态**/
    private String reviewStatus;//默认是评审，1：不评审

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSingleLoopId() {
        return singleLoopId;
    }

    public void setSingleLoopId(String singleLoopId) {
        this.singleLoopId = singleLoopId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMaterielId() {
        return materielId;
    }

    public void setMaterielId(String materielId) {
        this.materielId = materielId;
    }

    public String getMeasurUnitId() {
        return measurUnitId;
    }

    public void setMeasurUnitId(String measurUnitId) {
        this.measurUnitId = measurUnitId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Integer getProductionQuantity() {
        return productionQuantity;
    }

    public void setProductionQuantity(Integer productionQuantity) {
        this.productionQuantity = productionQuantity;
    }

    public String getProMode() {
        return proMode;
    }

    public void setProMode(String proMode) {
        this.proMode = proMode;
    }

    public String getAfterMode() {
        return afterMode;
    }

    public void setAfterMode(String afterMode) {
        this.afterMode = afterMode;
    }

    public String getOrderVersion() {
        return orderVersion;
    }

    public void setOrderVersion(String orderVersion) {
        this.orderVersion = orderVersion;
    }

    public String getCraftVersion() {
        return craftVersion;
    }

    public void setCraftVersion(String craftVersion) {
        this.craftVersion = craftVersion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEbomVersion() {
        return ebomVersion;
    }

    public void setEbomVersion(String ebomVersion) {
        this.ebomVersion = ebomVersion;
    }

    public Integer getPreDistributionQuantity() {
        return preDistributionQuantity;
    }

    public void setPreDistributionQuantity(Integer preDistributionQuantity) {
        this.preDistributionQuantity = preDistributionQuantity;
    }

    public Integer getPreResidueDistributionQuantity() {
        return preResidueDistributionQuantity;
    }

    public void setPreResidueDistributionQuantity(Integer preResidueDistributionQuantity) {
        this.preResidueDistributionQuantity = preResidueDistributionQuantity;
    }

    public Integer getAfterDistributionQuantity() {
        return afterDistributionQuantity;
    }

    public void setAfterDistributionQuantity(Integer afterDistributionQuantity) {
        this.afterDistributionQuantity = afterDistributionQuantity;
    }

    public Integer getAfterResidueDistributionQuantity() {
        return afterResidueDistributionQuantity;
    }

    public void setAfterResidueDistributionQuantity(Integer afterResidueDistributionQuantity) {
        this.afterResidueDistributionQuantity = afterResidueDistributionQuantity;
    }

    public String getPreDistributionDate() {
        return preDistributionDate;
    }

    public void setPreDistributionDate(String preDistributionDate) {
        this.preDistributionDate = preDistributionDate;
    }

    public String getAfterDistributionDate() {
        return afterDistributionDate;
    }

    public void setAfterDistributionDate(String afterDistributionDate) {
        this.afterDistributionDate = afterDistributionDate;
    }

    public String getOrderBatch() {
        return orderBatch;
    }

    public void setOrderBatch(String orderBatch) {
        this.orderBatch = orderBatch;
    }

    public String getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(String productBatch) {
        this.productBatch = productBatch;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(String preStatus) {
        if("1".equals(preStatus)){
            this.preStatus = "是";
        }else{
            this.preStatus = "否";
        }

    }

    public String getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(String afterStatus) {
        if("1".equals(afterStatus)){
            this.afterStatus = "是";
        }else{
            this.afterStatus = "否";
        }
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getHalfProductionAllInWarehouse() {
        return halfProductionAllInWarehouse;
    }

    public void setHalfProductionAllInWarehouse(String halfProductionAllInWarehouse) {
        this.halfProductionAllInWarehouse = halfProductionAllInWarehouse;
    }

    public String getHalfProductionAllOutWarehouse() {
        return halfProductionAllOutWarehouse;
    }

    public void setHalfProductionAllOutWarehouse(String halfProductionAllOutWarehouse) {
        this.halfProductionAllOutWarehouse = halfProductionAllOutWarehouse;
    }

    public String getAfterTaskStartTime() {
        return afterTaskStartTime;
    }

    public void setAfterTaskStartTime(String afterTaskStartTime) {
        this.afterTaskStartTime = afterTaskStartTime;
    }

    public String getAfterTaskCompleteTime() {
        return afterTaskCompleteTime;
    }

    public void setAfterTaskCompleteTime(String afterTaskCompleteTime) {
        this.afterTaskCompleteTime = afterTaskCompleteTime;
    }

    public String getPreTaskStartTime() {
        return preTaskStartTime;
    }

    public void setPreTaskStartTime(String preTaskStartTime) {
        this.preTaskStartTime = preTaskStartTime;
    }

    public String getPreTaskCompleteTime() {
        return preTaskCompleteTime;
    }

    public void setPreTaskCompleteTime(String preTaskCompleteTime) {
        this.preTaskCompleteTime = preTaskCompleteTime;
    }

    public String getAfterCraftProcess() {
        return afterCraftProcess;
    }

    public void setAfterCraftProcess(String afterCraftProcess) {
        this.afterCraftProcess = afterCraftProcess;
    }

    public String getPullVersion() {
        return pullVersion;
    }

    public void setPullVersion(String pullVersion) {
        this.pullVersion = pullVersion;
    }

    public String getUfts() {
        return ufts;
    }

    public void setUfts(String ufts) {
        this.ufts = ufts;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getUpdateSortBy() {
        return updateSortBy;
    }

    public void setUpdateSortBy(String updateSortBy) {
        this.updateSortBy = updateSortBy;
    }

    public String getUpdateSortDate() {
        return updateSortDate;
    }

    public void setUpdateSortDate(String updateSortDate) {
        this.updateSortDate = updateSortDate;
    }

    public String getIrowno() {
        return irowno;
    }

    public void setIrowno(String irowno) {
        this.irowno = irowno;
    }

    public String getPrePlanDistributionDate() {
        return prePlanDistributionDate;
    }

    public void setPrePlanDistributionDate(String prePlanDistributionDate) {
        this.prePlanDistributionDate = prePlanDistributionDate;
    }

    public String getAfterPlanDistributionDate() {
        return afterPlanDistributionDate;
    }

    public void setAfterPlanDistributionDate(String afterPlanDistributionDate) {
        this.afterPlanDistributionDate = afterPlanDistributionDate;
    }

    public String getSendNum() {
        return sendNum;
    }

    public void setSendNum(String sendNum) {
        this.sendNum = sendNum;
    }

    public String getFlowlineNum() {
        return flowlineNum;
    }

    public void setFlowlineNum(String flowlineNum) {
        this.flowlineNum = flowlineNum;
    }

    public String getCountMateriel() {
        return countMateriel;
    }

    public void setCountMateriel(String countMateriel) {
        this.countMateriel = countMateriel;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeEnd() {
        return orderTimeEnd;
    }

    public void setOrderTimeEnd(String orderTimeEnd) {
        this.orderTimeEnd = orderTimeEnd;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<String> getDay1() {
        return day1;
    }

    public void setDay1(List<String> day1) {
        this.day1 = day1;
    }

    public Integer getDqty() {
        return dqty;
    }

    public void setDqty(Integer dqty) {
        this.dqty = dqty;
    }

    public Integer getLqty() {
        return lqty;
    }

    public void setLqty(Integer lqty) {
        this.lqty = lqty;
    }

    public String getLabelConsumptionRecordNumber() {
        return labelConsumptionRecordNumber;
    }

    public void setLabelConsumptionRecordNumber(String labelConsumptionRecordNumber) {
        this.labelConsumptionRecordNumber = labelConsumptionRecordNumber;
    }

    public String getPrepareDetailCount() {
        return prepareDetailCount;
    }

    public void setPrepareDetailCount(String prepareDetailCount) {
        this.prepareDetailCount = prepareDetailCount;
    }

    public String getWirewayNumber() {
        return wirewayNumber;
    }

    public void setWirewayNumber(String wirewayNumber) {
        this.wirewayNumber = wirewayNumber;
    }

    public String getFreezingStatus() {
        return freezingStatus;
    }

    public void setFreezingStatus(String freezingStatus) {
        this.freezingStatus = freezingStatus;
    }

    public String getEbomId() {
        return ebomId;
    }

    public void setEbomId(String ebomId) {
        this.ebomId = ebomId;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
}
