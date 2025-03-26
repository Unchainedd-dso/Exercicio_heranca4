public class ContaBancaria{
    protected int numeroConta;
    protected String nomeCorrentista;
    protected double saldo;

    public ContaBancaria(int numeroConta, String nomeCorrentista){
        this.numeroConta = numeroConta;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = 0;
    }

    public int getNroConta(){
        return numeroConta;
    }

    public String getNomeCorrentista(){
        return nomeCorrentista;
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean deposito(double valor){
        if(valor > 0){
            saldo += valor;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean retirada(double valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }
        else{
            return false;
        }
    }
}