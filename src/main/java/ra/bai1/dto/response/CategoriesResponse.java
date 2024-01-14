package ra.bai1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoriesResponse {
    private int id;
    private String name;
    private int priority;
    private String descriptions;
    private boolean status;

}
