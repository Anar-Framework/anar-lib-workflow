package af.gov.anar.lib.workflow.parser;


import af.gov.anar.lib.workflow.model.Workflow;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkflowParser {

    public String getAllSteps(Workflow workflow)
    {
        return null;
    }

    public String getInitialStep( Workflow workflow){
        return null;
    }

    public String getNextStep(Workflow workflow, String currentStep)
    {
        return null;
    }

    public boolean isAuthorizedToMoveNextStep(Workflow workflow, String nextStep)
    {
        return false;
    }


    public boolean hasFromAuthorizedRoles(String stepName, String allSteps, List<String> authorizedRoles)
    {
        return false;
    }


}
