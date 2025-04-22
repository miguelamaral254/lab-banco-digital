import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected double limiteCredito;
    protected List<String> historicoTransacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        historicoTransacoes.add("Saque: R$ " + valor);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        historicoTransacoes.add("Depósito: R$ " + valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (contaDestino != null) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            historicoTransacoes.add("Transferência: R$ " + valor + " para conta " + contaDestino.getNumero());
        } else {
            System.out.println("Conta de destino não pode ser null.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato ===");
        imprimirInfosComuns();
    }

    @Override
    public void aplicarJuros() {
        double juros = saldo * 0.05;
        saldo += juros;
        historicoTransacoes.add("Aplicado juros: R$ " + juros);
        System.out.println("Juros aplicados: R$ " + juros);
    }

    @Override
    public void calcularTaxaManutencao() {
        double taxa = 30.0;
        saldo -= taxa;
        historicoTransacoes.add("Taxa de manutenção: R$ " + taxa);
        System.out.println("Taxa de manutenção: R$ " + taxa);
    }

    @Override
    public void alterarLimiteCredito(double limite) {
        this.limiteCredito = limite;
        historicoTransacoes.add("Limite de crédito alterado para: R$ " + limite);
        System.out.println("Limite de crédito alterado para: R$ " + limite);
    }

    @Override
    public void imprimirHistorico() {
        System.out.println("=== Histórico de Transações ===");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void extratoCompleto() {
        System.out.println("=== Extrato Completo ===");
        imprimirInfosComuns();
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}