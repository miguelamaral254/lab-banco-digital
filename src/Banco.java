
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Banco {

    private String nome;
    private List<Conta> contas;


}
