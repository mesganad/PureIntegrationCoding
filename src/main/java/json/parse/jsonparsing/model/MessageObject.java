package json.parse.jsonparsing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageObject {
    private  Map<String, List<String>> message=new HashMap<>();
    private String status;
}
