package com.le.activitistu;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    /**
     * 部署指定的流程
     */
	public static void main(String[] args) {
		
	}
    @Test
    public void creatTable() {
        //创建流程引擎 并且没有表的话创建流程表
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();

        //部署指定的流程
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource("mytest.bpmn");//bpmn文件的名称
        Deployment deploy = builder.deploy();
        
        //查询流程定义
//        ProcessDefinitionQuery processDefinitionQuery = processEngine.getRepositoryService().createProcessDefinitionQuery();
//        processDefinitionQuery.processDefinitionKey("mytestflow").latestVersion();
//
//        List<ProcessDefinition> list = processDefinitionQuery.list();
//        for (ProcessDefinition processDefinition : list) {
//            System.out.println(processDefinition.getId()+"-"+processDefinition.getName()+"-"+processDefinition.getVersion());
//        }

        //启动流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceById("mytestflow:1:4");
        System.out.println(processInstance.getId());
        
        //挂起流程实例
//        processEngine.getRuntimeService().suspendProcessInstanceById("17501");
        //激活流程实例
       // processEngine.getRuntimeService().activateProcessInstanceById("17501");
        //删除流程实例
//        processEngine.getRuntimeService().deleteProcessInstance("17501","删除原因");
        
        
//查询未签收
//        TaskQuery toClaimQuery = processEngine.getTaskService().createTaskQuery().taskCandidateUser("M001").active();
//        List<Task> list = toClaimQuery.list();
//        for (Task task : list) {
//			System.out.println(task.getId());
//		}
        
        //签收任务
//        processEngine.getTaskService().claim("5004","M003");
        
        //办理任务
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("flag","Y");
//        //办理任务
//        processEngine.getTaskService().complete("10002",hashmap);

        //查询已签收的任务
//        TaskQuery todoTaskQuery = processEngine.getTaskService().createTaskQuery().taskAssignee("user001").active();

        //processEngine.getTaskService().setVariables("5003",hashMap);


        //获取流程变量 常用的对象都是可以去设置获取流程变量的依赖于流程 类似 treadlocal
        /*Object value1 = processEngine.getTaskService().getVariable("27502", "key1");
        Map<String, Object> variables = processEngine.getTaskService().getVariables("27502");
        Map<String, Object> variables1 = processEngine.getRuntimeService().getVariables("27501");*/

        //分配任务可以是 指定人去签收任务/指定组签收任务

    }
}
