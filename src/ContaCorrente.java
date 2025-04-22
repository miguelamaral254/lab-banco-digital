public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    public void imprimirLimiteCredito() {
        System.out.println("Limite de crédito da Conta Corrente: R$ 1.000,00");
    }
}