public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("       Teste das contas");
        System.out.println("-------------------------------");
        System.out.println("       Conta Simples\n");
        ContaBancaria contaSimples = new ContaBancaria(1234, "Paulo");
        boolean resultado = contaSimples.deposito(3000);
        if(resultado){
            System.out.println("Saldo da conta: " + contaSimples.getSaldo());
        }
        resultado = contaSimples.retirada(1500);
        if(resultado){
            System.out.println("Saldo da conta após retirada: " + contaSimples.getSaldo());
        }
        else{
            System.out.println("Erro na retirada. Saldo disponivel: " + contaSimples.getSaldo());
        }
        resultado = contaSimples.retirada(3000);
        if(!resultado){
            System.out.println("Saldo insuficiente. Valor pedido: 3000, Valor disponivel: " + contaSimples.getSaldo());
        }
        else{
            System.out.println("Erro. Não era para o saque ser possivel\n");
        }
        System.out.println("-------------------------------");
        System.out.println("       Conta Remunerada\n");
        
        ContaRemunerada contaRemunerada = new ContaRemunerada(23456, "Pablo");

        contaRemunerada.deposito(3000);
        System.out.println("Saldo da conta: " + contaRemunerada.getSaldo());
        
        contaRemunerada.retirada(1500);
        System.out.println("Saldo da conta após retirada: " + contaRemunerada.getSaldo());

        contaRemunerada.definePercentRemuneracao(15);
        contaRemunerada.deposito(1000);
        System.out.println("Saldo conta Remunerada: " +  contaRemunerada.getSaldo());

        System.out.println("-------------------------------");
        System.out.println("       Conta com Limite\n");
        ContaComLimite contaLimite = new ContaComLimite(23456, "Pablo");

        contaLimite.deposito(3000);
        System.out.println("\nDeposito de 3000 realizado");
        System.out.println("Saldo da conta: " + contaLimite.getSaldo());
        
        contaLimite.retirada(1500);
        System.out.println("\nSaque de 1500 realizad0");
        System.out.println("Saldo da conta após retirada: " + contaLimite.getSaldo());
        System.out.println("Limite da conta: " + contaLimite.getLimite() + "\nLimite consumido: " + contaLimite.getLimiteConsumido());
        
        contaLimite.retirada(2000);
        System.out.println("\nSaque de 2000 realizado");
        System.out.println("Saldo da conta após retirada: " + contaLimite.getSaldo());
        System.out.println("Limite da conta: " + contaLimite.getLimite() + "\nLimite consumido: " + contaLimite.getLimiteConsumido());
        System.out.println("Valor dos juros acumulados em 10%: " + contaLimite.getJuros() + "\n");

        contaLimite.defineLimite(400);
        contaLimite.defineLimite(500);
        contaLimite.defineLimite(2000);
        System.out.println("\nLimite da conta mudado para 2000");
        System.out.println("Limite da conta: " + contaLimite.getLimite() + "\nLimite consumido: " + contaLimite.getLimiteConsumido());

        contaLimite.retirada(1600);
        System.out.println("\nTentativa de saque de 1600");
        System.out.println("Saldo da conta após retirada: " + contaLimite.getSaldo());
        System.out.println("Limite da conta: " + contaLimite.getLimite() + "\nLimite consumido: " + contaLimite.getLimiteConsumido());

        contaLimite.retirada(1000);
        System.out.println("\nSaque de 1000 realizado");
        System.out.println("Limite da conta: " + contaLimite.getLimite() + "\nLimite consumido: " + contaLimite.getLimiteConsumido());
        System.out.println("Valor dos juros acumulados em 10%: " + contaLimite.getJuros());

        contaLimite.deposito(1000);
        System.out.println("\nDeposito de 1000 realizado");
        System.out.println("Limite da conta: " + contaLimite.getLimite() + "\nLimite consumido: " + contaLimite.getLimiteConsumido());

        contaLimite.deposito(1000);
        System.out.println("\nDeposito de 1000 realizado");
        System.out.println("Saldo da conta após deposito: " + contaLimite.getSaldo());
        System.out.println("Limite da conta: " + contaLimite.getLimite() + "\nLimite consumido: " + contaLimite.getLimiteConsumido());

        System.out.println("\nJuros acumulados na conta: " + contaLimite.getJuros());
        System.out.println("Saldo da conta: " + contaLimite.getSaldo());
        contaLimite.quitaJuros();
        System.out.println("Saldo da conta após ter os juros quitados: " + contaLimite.getSaldo());
        System.out.println("Juros acumulados na conta: " + contaLimite.getJuros());
        System.out.println("Garantindo que demais valores não foram afetados");
        System.out.println("Limite da conta: " + contaLimite.getLimite() + "\nLimite consumido: " + contaLimite.getLimiteConsumido());

    }
}
