package ra.bai1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoriesRequest {
    private int id;
    private String name;
    private int priority;
    private String descriptions;
    private boolean status;
}
