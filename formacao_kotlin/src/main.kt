fun main() {
    println("Bem vindo ao Bytebank")

    val contaAlex = Conta(titular = "Alex", numero = 1000)
    contaAlex.deposita(-200.0)

    val contaFran = Conta(numero = 1001, titular = "fran")
    contaFran.deposita(300.0)
    println(contaAlex.saldo)
    println(contaFran.saldo)


    println("Depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)
    println("Depositando na conta da Fran")
    contaFran.deposita(70.0)
    println(contaFran.saldo)
    println()

    println("Sacando da conta da fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)
    println()

    if (contaFran.transfere(valor = 100.0, destino = contaAlex)) {
        println("Transferencia bem sucedida")
    } else {
        println("Falha na transferencia")
    }
    println(contaAlex.saldo)
    println(contaFran.saldo)

}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set(valor) {
            field = valor
        }

    fun deposita(valor: Double) {
        if (valor > 0) {
            saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    override fun toString(): String {
        return "Conta(titular='$titular', numero=$numero, saldo=$saldo)"
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

}

fun testaLacos() {
    var i = 0
    while (i <= 5) {
        val titular = "Gabriel $i"
        val numeroConta: Int = 1000 + i
        var saldo = 0.0

        println("titular: $titular")
        println("Número da conta $numeroConta")
        println("Saldo $saldo")
        println()
        i++
    }

//    for (i in 5 downTo 1) {
//        val titular = "Gabriel $i"
//        val numeroConta: Int = 1000 + i
//        var saldo = 0.0
//
//        println("titular: $titular")
//        println("Número da conta $numeroConta")
//        println("Saldo $saldo")
//        println()
//    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("Conta é positiva")
    } else if (saldo == 0.0) {
        println("Conta é neutra")
    } else {
        println("Conta é negativa")
    }

    when {
        saldo > 0.0 -> println("Conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("Conta é negativa")
    }
}

fun testaCopiaEReferencia(): Pair<Conta, Conta> {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++
    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("João", 1002)
    contaJoao.titular = "Joao"
    var contaMaria = Conta("Maria", 1003)

    contaMaria.titular = "Maria"
    contaJoao.titular = "Joao"

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta Maria: ${contaMaria.titular}")
    return Pair(contaJoao, contaMaria)
}
