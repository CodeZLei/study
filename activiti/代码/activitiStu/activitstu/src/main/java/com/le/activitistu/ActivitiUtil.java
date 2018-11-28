package com.le.activitistu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.junit.Test;

import com.mysql.jdbc.Buffer;

public class ActivitiUtil {
	private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	private static IdentityService identityService = processEngine.getIdentityService();
	private static RuntimeService runtimeService = processEngine.getRuntimeService();
	private static TaskService taskService = processEngine.getTaskService();
	private static RepositoryService repositoryService = processEngine.getRepositoryService();
	private static HistoryService historyService = processEngine.getHistoryService();

	/**
	 * 获取流程引擎
	 */
	@Test
	public void getProcessEngine() {
		// 创建流程引擎 并且没有表的话创建流程表
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
	}

	/**
	 * 部署流程
	 */
	@Test
	public void deploymentFlow() {
		// 部署指定的流程
		RepositoryService repositoryService = processEngine.getRepositoryService();
		DeploymentBuilder builder = repositoryService.createDeployment();
		builder.addClasspathResource("mytest.bpmn");// bpmn文件的名称
		Deployment deploy = builder.deploy();

	}

	/**
	 * 查询部署的流程
	 */
	@Test
	public void selectDeploymentFlow() {
		// 查询流程定义
		ProcessDefinitionQuery processDefinitionQuery = processEngine.getRepositoryService()
				.createProcessDefinitionQuery();
		processDefinitionQuery.processDefinitionKey("mytestflow").latestVersion();
		ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
		System.out.println(
				processDefinition.getId() + "-" + processDefinition.getName() + "-" + processDefinition.getVersion());
	}

	/**
	 * 启动部署的流程
	 */
	@Test
	public void startFlow() {
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("mytestflow");
		System.out.println(processInstance.getId());
	}

	/**
	 * 查询启动的流程实例
	 */
	public void selectFlowInstance() {
		ProcessInstanceQuery query = processEngine.getRuntimeService().createProcessInstanceQuery()
				.processDefinitionKey("mytestflow");
		List<ProcessInstance> instanceList = query.list();

		// 挂起流程实例
		// processEngine.getRuntimeService().suspendProcessInstanceById("111");
		// 激活流程实例
		// processEngine.getRuntimeService().activateProcessInstanceById("17501");
		// 删除流程实例
		// processEngine.getRuntimeService().deleteProcessInstance("17501","删除原因");
	}

	/**
	 * 查询用户未签收
	 */
	@Test
	public void selectUnSign() {
		TaskQuery toClaimQuery = processEngine.getTaskService().createTaskQuery().taskCandidateUser("M001").active();
		List<Task> list = toClaimQuery.list();
		for (Task task : list) {
			System.out.println(task.getId());
		}

	}

	/**
	 * 用户签收任务
	 */
	public void selectSign() {
		// 签收任务
		processEngine.getTaskService().claim("5004", "M003");
		// 查询已签收的任务
		TaskQuery todoTaskQuery = processEngine.getTaskService().createTaskQuery().taskAssignee("user001").active();
		List<Task> list = todoTaskQuery.list();

	}

	/**
	 * 办理任务
	 */
	public void doTask() {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("flag", "Y");
		// //办理任务
		processEngine.getTaskService().complete("10002", hashMap);
	}

	/**
	 * 流程表变量操作
	 */
	public void name() {
		// ProcessInstance processInstance =
		// runtimeService.startProcessInstanceByKey("processDefinitionKey",
		// variables);
		// taskService.complete(taskId, variables);
		// runtimeService.setVariable("503", "price", 10000);
		// runtimeService.setVariable("503", "price", 10000);

		Object value1 = processEngine.getTaskService().getVariable("27502", "key1");
		Map<String, Object> variables = processEngine.getTaskService().getVariables("27502");
		Map<String, Object> variables1 = processEngine.getRuntimeService().getVariables("27501");

	}

	/**
	 * 展示流程图根据流程定义(乱码)
	 * 
	 * @throws IOException
	 */
	@Test
	public void showFlowImg() throws IOException {
		String processDefinitionId = "mytestflow:1:4";
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);

		List<String> activeActivityIdList = new ArrayList<>();
		ArrayList<String> highLightedFlowList = new ArrayList<>();

		ProcessEngineConfiguration processEngineConfiguration = processEngine.getProcessEngineConfiguration();
		ProcessDiagramGenerator processDiagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		InputStream imageStream = processDiagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIdList,
				highLightedFlowList, "宋体", "宋体", null, 1.0);

		BufferedInputStream bufferedInputStream = new BufferedInputStream(imageStream);

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				new FileOutputStream(new File("e:/" + "fff.png")));
		int a;
		while ((a = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(a);
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}

	/**
	 * 高亮展示指定流程的活动节点
	 * 
	 * @throws IOException
	 */
	@Test
	public void showActiveTaskInFlowImg() throws IOException {
		String processDefinitionId = "mytestflow:1:4";
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);

		List<String> activeActivityIdList = runtimeService.getActiveActivityIds("5");
		ProcessEngineConfiguration processEngineConfiguration = processEngine.getProcessEngineConfiguration();
		ProcessDiagramGenerator processDiagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		ArrayList<String> highLightedFlowList = new ArrayList<>();
		InputStream imageStream = processDiagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIdList,
				highLightedFlowList, "宋体", "宋体", null, 1.0);

		BufferedInputStream bufferedInputStream = new BufferedInputStream(imageStream);

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				new FileOutputStream(new File("e:/" + "444.png")));
		int a;
		while ((a = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(a);
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}


	/**
	 * 流程回退到上一节点
	 * 
	 * @param taskId
	 */
	public static void TaskRollBack(String taskId) {
		try {
			Map<String, Object> variables;
			// 取得当前任务
			HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(taskId)
					.singleResult();
			// 取得流程实例
			ProcessInstance instance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(currTask.getProcessInstanceId()).singleResult();
			if (instance == null) {

				// 流程结束
			}
			variables = instance.getProcessVariables();
			// 取得流程定义
			ProcessDefinitionEntity definition = (ProcessDefinitionEntity) (processEngine.getRepositoryService()
					.getProcessDefinition(currTask.getProcessDefinitionId()));

			if (definition == null) {
				// log.error("流程定义未找到");
				return;
			}
			// 取得上一步活动
			ActivityImpl currActivity = ((ProcessDefinitionImpl) definition)
					.findActivity(currTask.getTaskDefinitionKey());
			// 可以修改currActivity的值为指定的一个岗位就可以跳转到指定的流程岗位
			// 进入当前节点的进入的线
			List<PvmTransition> nextTransitionList = currActivity.getIncomingTransitions();
			// 清除当前活动的出口
			List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();
			List<PvmTransition> pvmTransitionList = currActivity.getOutgoingTransitions();
			for (PvmTransition pvmTransition : pvmTransitionList) {
				oriPvmTransitionList.add(pvmTransition);
			}
			pvmTransitionList.clear();

			// 建立新出口
			List<TransitionImpl> newTransitions = new ArrayList<TransitionImpl>();
			for (PvmTransition nextTransition : nextTransitionList) {
				PvmActivity nextActivity = nextTransition.getSource();
				ActivityImpl nextActivityImpl = ((ProcessDefinitionImpl) definition).findActivity(nextActivity.getId());
				TransitionImpl newTransition = currActivity.createOutgoingTransition();
				newTransition.setDestination(nextActivityImpl);
				newTransitions.add(newTransition);
			}
			// 完成任务
			List<Task> tasks = taskService.createTaskQuery().processInstanceId(instance.getId())
					.taskDefinitionKey(currTask.getTaskDefinitionKey()).list();
			for (Task task : tasks) {
				taskService.complete(task.getId(), variables);
				// 删除当前节点(还是留痕好一些)
				// historyService.deleteHistoricTaskInstance(task.getId());
			}
			// 恢复方向
			for (TransitionImpl transitionImpl : newTransitions) {
				currActivity.getOutgoingTransitions().remove(transitionImpl);
			}
			for (PvmTransition pvmTransition : oriPvmTransitionList) {
				pvmTransitionList.add(pvmTransition);
			}

			return;
		} catch (Exception e) {

			return;
		}
	}
}
