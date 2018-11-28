package com.le.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/flow")
@Controller("flowController")
public class FlowController {

	@Resource(name = "repositoryService")
	private RepositoryService repositoryService;

	@Resource(name = "runtimeService")
	private RuntimeService runtimeService;
	
	@Resource(name = "processEngineConfiguration")
	private ProcessEngineConfiguration processEngineConfiguration;

	@RequestMapping("showFlowImg")
	public void showFlowImg(HttpServletResponse response, String processDefinitionId) throws IOException {
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);

		List<String> activeActivityIdList = new ArrayList<>();
		ArrayList<String> highLightedFlowList = new ArrayList<>();

		ProcessDiagramGenerator processDiagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		InputStream imageStream = processDiagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIdList,
				highLightedFlowList, "宋体", "宋体", null, 1.0);

		BufferedInputStream bufferedInputStream = new BufferedInputStream(imageStream);

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
		int a;
		while ((a = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(a);
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();

	}

	@RequestMapping("showActiveTaskInFlowImg")
	public void showActiveTaskInFlowImg(HttpServletResponse response,String processInstanceId) throws IOException {
		
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());

		List<String> activeActivityIdList = runtimeService.getActiveActivityIds(processInstanceId);
		ProcessDiagramGenerator processDiagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		ArrayList<String> highLightedFlowList = new ArrayList<>();
		InputStream imageStream = processDiagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIdList,
				highLightedFlowList, "宋体", "宋体", null, 1.0);

		BufferedInputStream bufferedInputStream = new BufferedInputStream(imageStream);

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
		int a;
		while ((a = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(a);
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}
}
