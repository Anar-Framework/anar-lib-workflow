### Workflow Library of Anar Framework

#### Usage Guide: 

add the following dependency to pom.xml 


```
		<dependency>
			<ROLEId>af.gov.anar.lib</ROLEId>
			<artifactId>anar-lib-workflow</artifactId>
			<version>${project.version}</version>
		</dependency>
```

### Sample Workflow 

```json

{
   "steps":[
        {"name":"Open", "transitions":[
                {"name":"Reject", "toStep":"Rejected", "CommentRequired": true},
                {"name":"Close","toStep":"Closed","resolutions":["Completed", "Incomplete", "Duplicate"], "CommentRequired": true}
        ],
        "authorizedRoles": ["ADMIN_ROLE"],
        },
        {"name":"Reopened", "transitions":[
                {"name":"Reject", "toStep":"Rejected", "CommentRequired": true},
                {"name":"Close", "toStep":"Closed", "resolutions":["Completed", "Incomplete", "Duplicate"], "CommentRequired": true}
        ],
        "authorizedRoles": [ "ADMIN_ROLE"],
        },
        {"name":"Rejected", "transitions":[
                {"name":"Reopen", "toStep":"Reopened", "CommentRequired": false},
                {"name":"Close", "toStep":"Closed", "resolutions":["Completed", "Incomplete", "Duplicate"], "CommentRequired": true}
        ],
        "authorizedRoles": ["ADMIN_ROLE"],
        },
        {"name":"Closed", "transitions":[ ],
        "authorizedRoles": ["ADMIN_ROLE"],
        }
    ]
}
```
#### Documentation

Refer to this repository **Wiki** section.
https://github.com/Anar-Framework/anar-lib-workflow/wiki