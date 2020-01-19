package af.gov.anar.lib.workflow.model;

import java.time.LocalDateTime;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CreationTimestamp;

// @Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
// @ToString
// @EqualsAndHashCode
@Entity(name = "Workflow")
@Table(name = "workflow")
public class Workflow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workflow_generator")
    @SequenceGenerator(name = "workflow_generator", sequenceName = "workflow_seq", allocationSize = 1)
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "env_slug")
    private String envSlug;

    @Column(name = "workflow_json")
    @Type(type = "text")
    private String workflowJson;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Workflow(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Workflow(Long id, String name, String description, String envSlug, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.envSlug = envSlug;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Form [id=" + id + ", name=" + name + ", description=" + description +  ", envSlug=" + envSlug + ", created_at=" + createdAt  + "]";
    }

    /* Workflow JSON Conditions
    * authorizedGroups: This is arry type attribute that intoduce restriction on a step based on group.
                        If this attribute is not defined for any step, that step is visible to everyone means no restriction will be introduced for that step
                    i.e. "authorizedGroups": ["ADMIN_GROUP", "SUPERVISOR_GROUP"]
    * if instance current_step is null or empty then first step of workflow should be initial step to be displayed in transition
    */
}
