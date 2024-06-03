package messaging.kafka.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "scala_scripts")
@Data
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String script;

}
