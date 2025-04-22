
public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();

    void aplicarJuros();

    void calcularTaxaManutencao();

    void alterarLimiteCredito(double limite);

    void imprimirHistorico();

    int getNumero();
}