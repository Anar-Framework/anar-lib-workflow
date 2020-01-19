package af.gov.anar.lib.anarlibworkflow;


import af.gov.anar.lib.workflow.AnarLibWorkflowApplication;
import af.gov.anar.lib.workflow.model.Workflow;
import af.gov.anar.lib.workflow.repository.WorkflowRepository;
import af.gov.anar.lib.workflow.service.WorkflowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnarLibWorkflowApplication.class)
public class WorkflowTest {


    @Autowired
    private WorkflowService workflowService;

    @MockBean
    private WorkflowRepository workflowRepository;

    @Test
    public void corsStoreStoreTest() {

        Mockito.when(workflowRepository.save(ArgumentMatchers.any(Workflow.class))).thenReturn(new Workflow());


        Workflow corsEntity = Workflow.builder()
                .name("Default Workflow")
                .description("Default Workflow Description")
                .workflowJson("{\n" +
                        "   \"steps\":[\n" +
                        "        {\"name\":\"Open\", \"transitions\":[\n" +
                        "                {\"name\":\"Reject\", \"toStep\":\"Rejected\", \"CommentRequired\": true},\n" +
                        "                {\"name\":\"Close\",\"toStep\":\"Closed\",\"resolutions\":[\"Completed\", \"Incomplete\", \"Duplicate\"], \"CommentRequired\": true}\n" +
                        "        ],\n" +
                        "        \"authorizedGroups\": [\"ADMIN_GROUP\"],\n" +
                        "        },\n" +
                        "        {\"name\":\"Reopened\", \"transitions\":[\n" +
                        "                {\"name\":\"Reject\", \"toStep\":\"Rejected\", \"CommentRequired\": true},\n" +
                        "                {\"name\":\"Close\", \"toStep\":\"Closed\", \"resolutions\":[\"Completed\", \"Incomplete\", \"Duplicate\"], \"CommentRequired\": true}\n" +
                        "        ],\n" +
                        "        \"authorizedGroups\": [ \"ADMIN_GROUP\"],\n" +
                        "        },\n" +
                        "        {\"name\":\"Rejected\", \"transitions\":[\n" +
                        "                {\"name\":\"Reopen\", \"toStep\":\"Reopened\", \"CommentRequired\": false},\n" +
                        "                {\"name\":\"Close\", \"toStep\":\"Closed\", \"resolutions\":[\"Completed\", \"Incomplete\", \"Duplicate\"], \"CommentRequired\": true}\n" +
                        "        ],\n" +
                        "        \"authorizedGroups\": [\"ADMIN_GROUP\"],\n" +
                        "        },\n" +
                        "        {\"name\":\"Closed\", \"transitions\":[ ],\n" +
                        "        \"authorizedGroups\": [\"ADMIN_GROUP\"],\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .build();

        Workflow result = workflowService.createOrUpdate(corsEntity);

        assertTrue(result != null);
    }


}
