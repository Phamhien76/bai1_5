package ra.bai1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private int id;
    @Column(name = "catalog_name",columnDefinition = "varchar(100)", nullable = false,unique = true)
    private String name;
    private int priority;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private Date created;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "catalog_status")
    private boolean status;
}
